package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void odczytPlikuTekstowego(String nazwa ) throws IOException
    {
        //filereader odczytuje pliki tekstowe
        //konwersja bajtow na znaki unicode 16 bit
        FileReader plikiWe = null;
        try
        {
         plikiWe = new FileReader(nazwa);
         System.out.println("Odczyt znak po znaku:\n");
         int c;
         //odczyt znaku po znaku i wyswietlenie na ekranie
            while ((c = plikiWe.read()) != -1)
            { //jezeli c = -1 to koniec pliku
                System.out.println((char)c);
            }
        }
        finally {
            //klauzula finally sluzy do wykonania instrukcji
            if ( plikiWe != null)
            {
                plikiWe.close(); //zamkniecie pliku
            }
        }

        //odczyt wiersz po wierzu
        BufferedReader plik2 = null;
        try
        {
            plik2 = new BufferedReader(new FileReader(nazwa));
            System.out.println("\n\nOdczyt buforowany:\n");
            String l = plik2.readLine();
            while ( l != null)
            {
                System.out.println(l);
                l = plik2.readLine();
            }

        }
        finally {
            if (plik2 != null)
            {
                plik2.close();
            }
        }
    }

    public static void zapisPliku (String nazwa) throws IOException
    {
        FileWriter plikWy = null;
        try {
            //tworzy nowy plik jesli nie istnieje w przeciwym wypadku nadpisuje od początku
            plikWy = new FileWriter(nazwa);
            //zapis łańcucha
            String tekst = "Dzis jest fajny dzien \n aby co poprogramowac xD.\n";
            plikWy.write(tekst);
            //zapis po znaku
            for (char z = 'a';z<= 'z';z++)
            {
                plikWy.write(z);
                plikWy.write('\n');

            }
        }
        finally {
            if (plikWy != null)
            {

                plikWy.close();
            }
        }

        //zapis za pomoaca PrintWriter,metody z System.out
        PrintWriter plik2 = null;
        try {
            // true w konstruktorze FileWriter otwiera plik w trybie dopisywania
            // na końcu
            plik2 = new PrintWriter(new FileWriter(nazwa,true));
            plik2.println("Potęgi liczby 2 <= 1 mln");
            for(int i = 0 ; i <= 1000000; i *=2 ){
                plik2.format("%6d%n",i);
            }
        }
        finally {
            if (plik2 != null)
            {
                plik2.close();
            }
        }
    }

    public static void  odczytFormatowany(String nazwa) throws IOException
    {
        Scanner plikWe = null;
        try {
            // "cebulkowy" sposób tworzenia obiektu klasy Scanner
            // BufferedReader zapewnia efektywny odczyt pliku dzięki
            // odczytowi blokowemu a nie znak po znaku
            // sposób mniej efektywny też działa
            // plikWe = new Scanner(new FileReader(nazwa));

            // wczytaj kolejno wszystkie wyrazy (tokeny) z pliku, zsumuj te które
            // są liczbami całkowitymi
            plikWe = new Scanner(new BufferedReader(new FileReader(nazwa)));

            int suma = 0;
            while (plikWe.hasNext()) { // czy jest coś do odczytu?
                if (plikWe.hasNextInt()){
                    int l = plikWe.nextInt();
                    suma += 1;
                } else  {
                    plikWe.next();// wczytaj kolejny "wyraz", ale nie rób z nim nic
                }

            }
            System.out.format("Suma wczytanych liczb wynosi: %d\n",suma);
        }
        finally
        {
            if (plikWe != null){
                plikWe.close();
            }
        }
    }
    public static boolean czyPlikIstnieje (String nazwa)
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
        if (czyPlikIstnieje(nazwaPliku)){
            System.out.println("Plik" + nazwaPliku + " Istnieje");
        } else
        {
            System.out.println("Nie ma pliku o nazwie " + nazwaPliku);
        }
        zapisPliku(nazwaPliku);
        odczytPlikuTekstowego(nazwaPliku);
        odczytFormatowany(nazwaPliku);
    }
}
