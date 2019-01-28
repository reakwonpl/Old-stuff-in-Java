/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pierwszapoprawaakronimtworzprzepisz;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author barto
 */
public class PierwszaPoprawaAkronimTworzPrzepisz {

    
        // ZADANIE 1
    public static String akronim(String zdanie){
        String akr = "";
        if (zdanie.length() != 0)
            akr += Character.toUpperCase(zdanie.charAt(0));
        for(int i=1;i<zdanie.length();i++)
        {
            if (zdanie.charAt(i) == ' ' && (i + 1 < zdanie.length()))
            {
                akr += Character.toUpperCase(zdanie.charAt(i+1));
                
            }
        }
        return akr;
    }
 
    //ZADANIE 2
 
    public static void tworzPlik(String nazwa) throws IOException {
        FileWriter plik = new FileWriter(nazwa);
        plik.write("Ewa XKopiec\n");
        plik.write("Ala Opopiec\n");
        plik.write("Tomek DssKopiec\n");
        plik.write("Asia DssKopiec\n");
        plik.write("Krysia Koasdpiec\n");
        plik.write("Wojtek DSaec");
        plik.close();
    }
 
    public static void przepisz(String nazwaWe, String nazwaWy) throws IOException{
 
        boolean czyIstnieje = new File(nazwaWe).isFile();
        RandomAccessFile plikWy = new RandomAccessFile(nazwaWy,"rw");
        if(!czyIstnieje)
        {
            plikWy.writeUTF("Błąd pliku źródłowego");
        }
        else
        {
            BufferedReader plikWe = null;
            try {
                plikWe = new BufferedReader(new FileReader(nazwaWe));
                int i = 0;
                String line = plikWe.readLine();
                while(line != null)
                {
                    plikWy.writeChar(line.charAt(0));
                    plikWy.writeChar(' ');
                    i = line.indexOf(' ');
                    plikWy.writeChar(line.charAt(i+1));
                    line = plikWe.readLine();
                    if (line != null) plikWy.writeChar('\n');
                }
            } catch (EOFException ex) {
 
            } finally {
                if(plikWe != null)
                    plikWe.close();
                if(plikWy != null)
                    plikWy.close();
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
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
          //ZADANIE 1
        String tekst = "Ala ma kota. Siema wiele kotow.";
        System.out.printf(akronim(tekst));
 
        //ZADANIE 2
        tworzPlik("test.txt");
        przepisz("test.txt","wynik.txt");
        czytaj("wynik.txt");
    }
    
}
