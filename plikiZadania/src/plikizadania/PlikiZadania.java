/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plikizadania;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;


/**
 *
 * @author barto
 */
public class PlikiZadania {

    /**
     * . Zadanie1 polega na stworzeniu dwóch funkcji:
    void szyfruj(String nazwaWe, int przesun)
    void deszyfruj(String nazwaWe, int przesun)
   Funkcja szyfruj dokonuje szyfrowania pliku, którego nazwa podana została jako pierwszy parametr.
   Szyfrowanie polega na zamianie każdej litery na znak przesunięty o wartość podaną drugim
   parametrem np. dla przesunięcia równego 2 literka 'a' powinna zostać zastąpiona literką 'c', literka
   'z' literką 'b' itp.
   Wynikiem działania funkcji ma być plik o nazwie utworzonej na podstawie nazwy pliku
   wejściowego poprzez dołączenie znaku '_' np. dla pliku dane.txt zaszyfrowana postać powinna mieć
   nazwę _dane.txt. Funkcja deszyfruj powinna deszyfrować plik (niekoniecznie ten sam)
     */
    public static void zapiszZad1(String plikWy) throws IOException
    {
       RandomAccessFile ac = null;
       
       try
       {
         ac = new RandomAccessFile(plikWy,"rw");
          
         ac.writeUTF("1.AZkies tam zdanie ");
         ac.writeUTF("2.Ptaki lataja kluczem ");
         ac.writeUTF("3.Szyfruj nam to ");
         ac.writeUTF("4.Prosze ,zdajmy ta jave ");
                
        }
       catch(IOException ex)
       {
           ex.getStackTrace();
       }
       finally{
           if( ac != null){
               ac.close();
           }
       }
       
    }
    public static void szyfruj(String plikWe,int przesun) throws IOException
    {
        RandomAccessFile ac = null;
     
        String s ="";
        int temp;
        
        String returnStr ="";
        long wskaznik;
        
        try{
            ac = new RandomAccessFile(plikWe,"r");
          
           
            while(true)
            {
                wskaznik  = ac.getFilePointer();
                s = ac.readUTF();                                
                for(int i = 0; i < s.length();i++)
                {
                  temp = s.charAt(i);
                    if((temp > 64 && temp < 91) || (temp > 96 && temp < 123))
                    {                                                
                      temp+= przesun;
                        if(!((temp > 64 && temp < 91) || (temp > 96 && temp < 123)))
                        {
                            temp -= 26;
                        }
                    }
                   
                 returnStr +=(char)temp;   
                 
                }
                returnStr += System.lineSeparator();
               System.out.println(returnStr); 
              ac.writeUTF(returnStr);
                ac.readLine();
                
            }
            
        }
        catch(IOException ex){
            ex.getStackTrace();
            
        }
        finally{
            if(ac != null){
                ac.close();
            }
        }
    }
    public static RandomAccessFile szyfr(String we,int przesun) throws Exception
    {
        RandomAccessFile read = new RandomAccessFile(we,"r");
       
        RandomAccessFile zapis = new RandomAccessFile("_"+we,"rw");
       
        String line=read.readLine();
        char c;
        String linez="";
        while(line!=null)
        {                        
            for(int i=0;i<line.length()-1;i++)
            {
               c=line.charAt(i);
                if((c > 64 && c < 91) || (c > 96 && c < 123))
                    {                                                
                       c+=przesun;
                        if(!((c > 64 && c < 91) || (c > 96 && c< 123)))
                        {
                            c -= 26;
                        }
                    }
              
               linez+=c;
                             
            }
           linez+=System.lineSeparator();
           zapis.writeUTF(linez);
            line=read.readLine();
        }
        
        return zapis;
    }
    
    public static void czytaj(String plikWe) throws IOException{
        BufferedReader ac = null;
        
        try{
            ac = new BufferedReader(new FileReader(plikWe));
            System.out.println("Czytam\n");
            String s = ac.readLine();
            while(s != null){
                System.out.println(s);
                s = ac.readLine();
            }
            
        }
        catch(IOException ex){
            ex.getStackTrace();
        }
        finally{
            if(ac != null){
                ac.close();
            }
        }
    }
    
   /*
    zad2
    Napisać funkcję emerytura(String nazwaPliku), która wczyta z pliku o podanej nazwie dane
    pracowników zapisane w kolejnych wierszach w następujący sposób:
     Imię Nazwisko Płeć Wiek
    Przykład:     Tomasz Nowak M 45     Marta Ziobro K 42
     Jan Kowalski M 27     Ewelina Tusk K 59
    Następnie funkcja dla każdego pracownika powinna wyznaczyć ile lat pozostało do jego emerytury.
    Wyniki należy zapisać w następujący sposób:
     Nazwisko Imię "Lata do emerytury"
    Przykład:     Nowak Tomasz 20     Kowalski Jan 38
    Wyniki dla kobiet należy zapisać w pliku o nazwie "kobiety.txt", natomiast wyniki dla mężczyzn
    należy zapisać w pliku "mezczyzni.txt".
    */
    
    public static void zapiszZad2(String plikWe) throws IOException{
        RandomAccessFile ac = null;
        try{
            ac = new RandomAccessFile(plikWe,"rw");
            
           ac.writeUTF("\n");
            
            ac.writeUTF("Andrzej");
            ac.writeUTF("Paleta");
            ac.writeChar('M');
            ac.writeInt(35);
            
          ac.writeUTF("\n");
            
            ac.writeUTF("Magda");
            ac.writeUTF("Telepala");
            ac.writeChar('K');
            ac.writeInt(24);
            
           ac.writeUTF("\n");
        
            ac.writeUTF("Mateusz");
            ac.writeUTF("Renczyszczywieczkiewicz");
            ac.writeChar('M');
            ac.writeInt(25);
            
           ac.writeUTF("\n");
            
            ac.writeUTF("Oksana");
            ac.writeUTF("Kurwinek");
            ac.writeChar('K');
            ac.writeInt(21);
            
           ac.writeUTF("\n");
            
           ac.writeUTF("Kerol");
            ac.writeUTF("xDDDDDD");
            ac.writeChar('M');
            ac.writeInt(25);
        }
        catch(IOException ex)
        {
            ex.getStackTrace();
        }
        finally{
            if(ac != null)
            {
                ac.close();
            }
        }
    }
    
    public static void emerytura(String plikWe) throws IOException
    {
        RandomAccessFile ac = null;
        RandomAccessFile acM = null;
        RandomAccessFile acK = null;
        String imie ="";
        String nazwisko ="";
        char plec =' ';
       int wiek = 0;
       String l ="";
       int emeryturaM = 77;
       int emeryturaK = 70;
       long wskaznik;             
       try{
           ac = new RandomAccessFile(plikWe,"rw");
           acM = new RandomAccessFile("Mezczyna.txt","rw");
           acK = new RandomAccessFile("Kobieta.txt","rw");
           l = ac.readLine();
           while(l != null)
           {               
              imie = ac.readUTF();
              nazwisko = ac.readUTF();
              plec = ac.readChar();
             wskaznik = ac.getFilePointer();
              wiek = ac.readInt();                          
              if(plec == 'M')
              {   int d = emeryturaM - wiek;
                  ac.seek(wskaznik);
                  acM.writeUTF(nazwisko);
                  acM.writeUTF(imie);
                  acM.writeInt(d);
                   System.out.println(nazwisko +" " + imie + " " + d);
              } else if(plec == 'K')
              { 
                  int z= emeryturaK-wiek;
                  ac.seek(wskaznik);
                  acK.writeUTF(nazwisko);
                  acK.writeUTF(imie);
                  acK.writeInt(z);
                  System.out.println(nazwisko +" " + imie + " " + z);
              }
              l = ac.readLine();                        
           }
       }
       catch(IOException ex){
           ex.getStackTrace();
       }
       finally{
           if(ac != null)
           {
               ac.close();
           }       
       }                       
    }
    
    /* zad3
    Napisać funkcję:
    void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
    której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawierają szukane słowo.
    Wszystkie wiersze, które zawierają słowo powinny zostać zapisane w pliku wynikowym wraz z nr
    wiersza (z pierwszego pliku). Nazwa pierwszego pliku zapamiętana jest w parametrze
    nazwaPlikWe, nazwa pliku wynikowego podana jest w parametrze nazwaPlikWy, natomiast szukane
    słowo w parametrze slowo.
    Przykład - plik wejściowy:
    Ala ma jutro egzamin z biologii.
    Jan myje auto.
    Eh, jutro kolejny egzamin.
    Nie lubie polityki.
    Jeżeli szukanym słowem byłoby "egzamin", to plik wynikowy powinien wyglądać następująco:
    1: Ala ma jutro egzamin z biologii.
    3: Eh, jutro kolejny egzamin. 
    */
    public static void zapiszZad3(String plikWe) throws IOException
    {
        RandomAccessFile ac = null;
        try{
            ac = new RandomAccessFile(plikWe,"rw");
            ac.writeUTF("\n");
            ac.writeUTF(" Andrzej poszedl na ryby ");
            ac.writeUTF("\n");
            ac.writeUTF(" Ireneusz to spoko pijak ");
            ac.writeUTF("\n");
            ac.writeUTF(" Ktos szukal Andrzej ");
           ac.writeUTF("\n");
            ac.writeUTF(" Alkoholik Andrzelina here dawac wode ");
            
        }
        catch(IOException ex)
        {
           
        }
        finally{
           if (ac != null) ac.close();
        }
    }
    static Random los = new Random();
    
    public static void szukaj(String plikWe,String plikWy,String slowo) throws IOException
    {
        RandomAccessFile ac = null;
        RandomAccessFile acW = null;
         String s="";
         int licznik = -1;
         String o ="";
        
        try
        {
          
         ac = new RandomAccessFile(plikWe,"rw");
         acW = new RandomAccessFile(plikWy,"rw");
         
        s = ac.readLine();
        while(s!= null)
        {
            licznik++;
            
                if(s.contains(slowo))
                {
                    licznik++;
                    o = s;
                    acW.writeInt(licznik);
                    acW.writeUTF(" "+o);
                    
                    s=ac.readLine(); 
                    System.out.println("Numer wiersza : " +licznik +" " +o);
                }
            
           
            s = ac.readLine();
        }
         
         
        }
        catch(IOException ex)
        {
            ex.getStackTrace();
        }
        finally{
            if(ac != null) 
                ac.close();
                 acW.close();
            
        }
    }
    
    public static void main(String[] args) throws IOException, Exception 
    {
        //zapiszZad1("zad1.txt");
       //szyfruj("zad1.txt",2);
      // szyfr("zad1.txt",2);
     //czytaj("_zad1.txt");
       // zapiszZad2("zad2.txt");
        //emerytura("zad2.txt");
            zapiszZad3("zad3.txt");
            szukaj("zad3.txt","zad3X.txt","Andrzej");
            czytaj("zad3X.txt");
       
    }
    
}
