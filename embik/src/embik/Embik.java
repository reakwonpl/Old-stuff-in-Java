/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embik;

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
public class Embik {
public static void tworzPlik(String nazwa) throws IOException
     {
        FileWriter plik = new FileWriter(nazwa);
       
        plik.write("Ewa XKopiec\n");
        plik.write("Ala Opopiec\n");
        plik.write("Tomek DssKopiec\n");
        plik.write("Asia DssKopiec\n");
        plik.write("Krysia Koasdpiec\n");
        plik.write("Wojtek DSaec");
       
        plik.close();
    }
   
     public static void przepisz(String plikWE, String plikWY) throws IOException
     {
         
         boolean czyIstnieje = new File(plikWE).isFile();
         RandomAccessFile plik2 = new RandomAccessFile(plikWY,"rw"); // tworzenie pliku wyjsciowego automatycznie bez koniecznosci robienia metody
         
         int b = 0;
         
         try
         {
             
             if(czyIstnieje == false)
             {
                 System.out.println(" ");
                 System.out.println("BRAK PLIKU !!!");
             }
             else
             {
                 System.out.println(" ");
                 System.out.println("PLIK ISTNIEJE !!!");
                 System.out.println(" ");
                 
                 BufferedReader plik = null;
                 plik = new BufferedReader(new FileReader(plikWE));
                 
                 String linia = plik.readLine();
                 while (linia != null)
                 {
                     plik2.writeChar(linia.charAt(0));    // pisze znak pierwszy o ideksie 0
                     plik2.writeChar(' ');                // pisze przerwe
                     int i = linia.indexOf(' ');          // zaznacza jaki index posiada przerwa
                     plik2.writeChar(linia.charAt(i+1));  // pisze znak po przerwie
                     linia = plik.readLine();            
                     if (linia != null)
                     {
                         plik2.writeChar('\n');// przechodzi do nastepnej lini
                     }
                 }
             }
         
         }
         catch (EOFException ex)
         {
 
         }
         finally
         {
                if(plik2 != null)
                    plik2.close();
         }
     }
     
     public static void wypisaniezpliku(String nazwa) throws IOException
     {
         
         FileReader plikWe = null;
         BufferedReader plik = null;
       
         int a = 0;
         
         try
         {
             plik = new BufferedReader(new FileReader(nazwa));
             String linia = plik.readLine();
             
             while(linia != null && a < 3)
            {
                System.out.println(linia);
                linia = plik.readLine();    // bez tego bd caly czas wypisywal tylko pierwsza linie
                //a++;
            }
         }
         
         finally
         {
             if(plikWe != null)
            {
                plikWe.close();
            }
             
         }
     }
    public static void main(String[] args) throws IOException {
       tworzPlik("test.txt");
      wypisaniezpliku("test.txt");
       przepisz("test.txt","test2.txt");
       wypisaniezpliku("test2.txt");
    }
    
}
