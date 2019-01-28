/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proba;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 *
 * @author barto
 */
public class Proba {
    
  static Random los = new Random();
  
  public static void zad1()
  {
      int liczba;
      
      int sumEven = 0;
      int countEven = 0;
      
      int sumOdds = 0;
      int countOdds = 0;
      
      int naj1 = 0;
      int naj2 = 0;
      int naj3 = 0;
      
      for(int i = 0; i < 100;i++ )
      {
          liczba = los.nextInt(201)-100;
          
          if(liczba % 2 == 0){
              sumEven += liczba;
              countEven++;
          } else {
              sumOdds += liczba;
              countOdds++;
          }
          
          if(liczba > 0 && liczba > naj1)
          {
              naj3 = naj2;
              naj2 = naj1;
              naj1 = liczba;
          }
          else if(liczba > 0 && liczba > naj2)
          {
              naj3 = naj2;
              naj2 = liczba;
          } else if(liczba > 0 && liczba > naj3)
          {
              naj3 = liczba;
          }
          
          
          
      }
          if(naj1 < 0 || naj2 < 0 || naj3 <0){
              System.out.println("Nie wszystkie z trzech najwiekszych są większe od zera");
          }
          System.out.format("\nNajwieksza liczba to %s ,druga najwieksza to %s ,trzecia najwieksza to %s",naj1,naj2,naj3);
          
          try
          {
          double srEven = sumEven/countEven;
          double srOdds = sumOdds/countOdds;
          System.out.format("\nStosunek sredniej liczb parzystych do nie parzystych to :%.1f ",(srEven/srOdds));
          }
          catch(ArithmeticException ae)
          {
              System.out.println("Dzielenie przez 0");
              System.exit(0);
          }
  }
  
  public static void akronim(String s)
  {
      String akr="";
      if(s.length() != 0){
          akr+=Character.toUpperCase(s.charAt(0));
      }
      for(int i = 1;i < s.length();i++)
      {
          if(s.charAt(i) ==' ')
          {
              akr+=Character.toUpperCase(s.charAt(i+1));
          }
      }
     System.out.println(akr);
  }
    
//  public static void tworzPlik(String plikWy) throws IOException
//  {
//      RandomAccessFile ac = null;
//      
//      try
//      {
//          ac = new RandomAccessFile(plikWy,"rw");
//        
//          ac.writeUTF("Anna Mazur");
//           ac.writeUTF("Andrzejek Parykcz");
//          ac.writeUTF("Raroslaw Psikutas");
//         ac.writeUTF("Anna Mazur");
//         ac.writeUTF("Anna Mazur");
//         
//      }
//      catch(IOException ex)
//      {
//          ex.getStackTrace();
//      }
//      finally{
//          if(ac != null) ac.close();
//      }
//  }
  
   public static void tworzPlik(String nazwa) throws IOException {
        FileWriter plik = new FileWriter(nazwa);
        plik.write("ewa XKopiec\n");
        plik.write("ala Opopiec\n");
        plik.write("Tomek DssKopiec\n");
        plik.write("Asia DssKopiec\n");
        plik.write("Krysia Koasdpiec\n");
        plik.write("Wojtek DSaec");
        plik.close();
    }
  public static void przepisz(String plikWe,String plikWy) throws FileNotFoundException, IOException
  {
      boolean czyIstnieje = new File(plikWe).isFile();
      RandomAccessFile ac = null;
      RandomAccessFile acc = null;
      
      if(!czyIstnieje){
          System.out.println("Nie ma takiego pliku");
          System.exit(0);
      } else  {
          ac = new RandomAccessFile(plikWe,"rw");
          acc = new RandomAccessFile(plikWy,"rw");
         try  {
              String s = ac.readLine();
              int a = 0;
              while(s != null)
              {   acc.writeChar(Character.toUpperCase(s.charAt(0)));
                  acc.writeChar(' ');
                  a = s.indexOf(' ');
                  acc.writeChar(s.charAt(a+1));
                  s = ac.readLine();
                  if(s != null)
                  {acc.writeChar('\n');}
              }
          }
          catch(IOException ex)
          {
              ex.getStackTrace();
          }
         finally {
             if(ac != null){
                 ac.close();
             }
             if(acc != null){
                 acc.close();
             }
         }
      }
  }
  public static void czytaj(String plikWe) throws IOException
  {
      RandomAccessFile ac = null;
      try{
          ac = new RandomAccessFile(plikWe,"rw");
          String s = ac.readLine();
          while(s !=null)
          {
              System.out.println(s);
              s = ac.readLine();
          }
      }
      catch(IOException ex)
      {
          ex.getStackTrace();
    }
      finally{
          if(ac !=null){
              ac.close();
          }
      }
  }

    public static void main(String[] args) throws IOException
    {
            //zad1();
            akronim("Andrzej Kowalczyk Walaszek");
            tworzPlik("akr.txt");
            przepisz("akr.txt","prz.txt");
            czytaj("prz.txt");
    }
    
    public static float pogoda(String we) throws Exception
    {
        RandomAccessFile re= null;
        float temp;
        float tempO;
        int wilg;
        float predW;
        long poz1;
        long poz2;
        float sumW=0;
        float sumT=0;
        try
                {
                    re = new RandomAccessFile(we,"rw");
                    while(true)
                    {
                        re.readUTF();
                        temp=re.readFloat();
                        poz1=re.getFilePointer();
                        tempO=re.readFloat();
                        wilg=re.readInt();
                        predW=re.readFloat();
                        poz2=re.getFilePointer();
                    sumT+=temp;
                    sumW+=wilg;
                        if(predW>10)
                        {
                            tempO=(float) (predW*0.1*wilg*temp);
                            re.seek(poz1);
                            re.writeFloat(tempO);
                            re.seek(poz2);
                        }
                    }
                                       
                }
        catch(EOFException ex)
                {re.close();}
        
        return (sumT/sumW);
    }
    public static void przyklad1(String we) throws Exception
    {
        RandomAccessFile re = new RandomAccessFile(we,"rw");
        re.writeUTF("Sloneczna ");
        re.writeFloat(23.6f);
      //  re.writeUTF(" ");
        re.writeFloat(22.6f);
    //    re.writeUTF(" ");
        re.writeInt(22);
  //      re.writeUTF(" ");
        re.writeFloat(12.0f);
//re.writeUTF(System.lineSeparator());
        
        re.writeUTF("Deszczowa ");
        re.writeFloat(13.6f);
      //  re.writeUTF(" ");
        re.writeFloat(12.6f);
    //    re.writeUTF(" ");
        re.writeInt(35);
  //      re.writeUTF(" ");
        re.writeFloat(15.0f);
//re.writeUTF(System.lineSeparator());
        
        re.writeUTF("Lekkie opady ");
        re.writeFloat(20.3f);
      //  re.writeUTF(" ");
        re.writeFloat(17.2f);
    //    re.writeUTF(" ");
        re.writeInt(67);
  //      re.writeUTF(" ");
        re.writeFloat(8.0f);
//re.writeUTF(System.lineSeparator());
        
        re.writeUTF("Deszczowa ");
        re.writeFloat(3.6f);
      //  re.writeUTF(" ");
        re.writeFloat(2.4f);
    //    re.writeUTF(" ");
        re.writeInt(45);
  //      re.writeUTF(" ");
        re.writeFloat(3.0f);
//re.writeUTF(System.lineSeparator());
        
        re.writeUTF("Mgla ");
        re.writeFloat(7.6f);
        //re.writeUTF(" ");
        re.writeFloat(5.3f);
        //re.writeUTF(" ");
        re.writeInt(67);
        //re.writeUTF(" ");
        re.writeFloat(3.0f);
        //re.writeUTF(System.lineSeparator());

    }
    public static void odczyt(String we) throws Exception
    {
        RandomAccessFile re= null;
        
        try{
            re = new RandomAccessFile(we,"r");
            
            while(true)
           
                    {
                         System.out.println(re.readUTF());
                         System.out.println(re.readFloat());
                         System.out.println(re.readFloat());
                         System.out.println(re.readInt());
                         System.out.println(re.readFloat());
                    }
        }
        catch(EOFException ex)
        {re.close();}
    }
    
    
}
    

