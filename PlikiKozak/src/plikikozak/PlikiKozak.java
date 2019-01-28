/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plikikozak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author barto
 */
public class PlikiKozak {

    
    public static void odczytPlikuTekstowego(String nazwa) throws IOException
    {
        //filereader odczytuje pliki tekstowe
        //konwersja bajtow na znaki unicode
        
        FileReader plikWe = null;
        try
        {
            plikWe = new FileReader(nazwa);
            System.out.println("Odczyt znak po znaku : \n");
            int c;
            
            //odczyt znaku po znaku i wyswietlenie na ekranie;
            while((c = plikWe.read()) != -1)
            {
                //jezeli c = -1 to koniec pliku
                System.out.println((char)c);
            }
      }
        finally 
        {
            //ta klauzyla sluzy do wykonania instrukcji
            
            if(plikWe != null)
            {
                //zamkniecie pliku
              plikWe.close();
            }
        }
               
        //odczyt po wierzu
        
        BufferedReader plik2 = null;
        
        try
        {
            plik2 = new BufferedReader(new FileReader(nazwa));
            System.out.println("\n\nOdczyt Buforowany:\n");
            String l = plik2.readLine();
            
            while(l != null)
            {
                System.out.println(l);
                l = plik2.readLine();
                
            }
            
        }
        finally {
            if(plikWe != null)
            {
                plikWe.close();
            }
        }
        
    }
    
    public static void zapisPliku(String nazwa) throws IOException
    {
        FileWriter plikWy = null;
        try
        {
            //tworzy nowy plik jesli nie istnieje,w innym wypadku nadpisuje
            
            plikWy = new FileWriter(nazwa);
            //zapis łańcucha
            
            String tekst = "Dawaj poprogramujmy sobie here";
            plikWy.write(tekst);
            //zapis po znaku
            
            
            for(char z = 'a'; z <= 'z';z++)
            {
                plikWy.write(z);
                plikWy.write('\n');
            }
        }
        finally 
        {
            if (plikWy != null)
            {
                plikWy.close();
            }
        }
        
        //zapis za pomoca PrintWritera,metody z system.out
        PrintWriter plik2 = null;
        try
        {
            //true w konstruktorze FileWriter otwiera plik  w trybie dopisywania
            //na koncu
            
            plik2 = new PrintWriter(new FileWriter(nazwa,true));
            plik2.println("Potęgi liczby 2 <= 1 mln");
            for(int i = 0; i <= 1000000; i*=2)
            {
                plik2.format("%6d%n", i);
            }
        }
        finally 
        {
            if(plikWy != null)
            {
                plikWy.close();
            }
        }
        
    }
    
    public static void odczytFormatowany(String nazwa) throws FileNotFoundException
    {
        Scanner plikWe = null;
        try
        {
             // "cebulkowy" sposób tworzenia obiektu klasy Scanner
            // BufferedReader zapewnia efektywny odczyt pliku dzięki
            // odczytowi blokowemu a nie znak po znaku
            // sposób mniej efektywny też działa
            // plikWe = new Scanner(new FileReader(nazwa));

            // wczytaj kolejno wszystkie wyrazy (tokeny) z pliku, zsumuj te które
            // są liczbami całkowitymi
            
           plikWe = new Scanner(new BufferedReader(new FileReader(nazwa)));
           int suma = 0;
           while(plikWe.hasNext())
            {
               //czy jest cos do odczytu?
                if(plikWe.hasNextInt())
                {
                    int l = plikWe.nextInt();
                    suma+=l;
                    
                } else 
                {
                    //wczytaj kolejny "wyraz" ale nic z nim nie rób
                    plikWe.next();
                }
                
            }
            System.out.format("Suma wczytanych liczb wynosi: %d\n",suma);
        }
        
        finally{
            if(plikWe != null){
                plikWe.close();
            }
        }
        
    }
    
    public static boolean czyPlikIstnieje(String nazwa)
    {
        
        // Klasa File w Javie służy do reprezentacji i zarządzania ścieżkami do
        // plików i folderów, można jej użyć np. do sprawdzenia, czy dany plik
        // istnieje, jak pokazano poniżej.
        
        File f = new File(nazwa);
        return f.exists() && f.isFile();
        
    }
    
     
    
       
    public static void main(String[] args) throws IOException
    {
        
        String nazwaPliku = "test.txt";
            if(czyPlikIstnieje(nazwaPliku))
            {
                 System.out.println("Plik" + nazwaPliku + " Istnieje");
            } else
            {
                System.out.println("Nie ma pliku o nazwie " + nazwaPliku);
            }
            
            zapisPliku(nazwaPliku);
            odczytPlikuTekstowego(nazwaPliku);
            odczytFormatowany("test.txt");
            
        
        }
    
    }
    

