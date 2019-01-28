package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void TworzenieRAF(String url) throws IOException
    {
        RandomAccessFile raf = null;

        try {
            // próbuje utorzyć plik o ścieżce url i parametrze read write
            raf = new RandomAccessFile(url,"rw");
            // tworze sobie porcje danych STRING - INT - DOUBLE
            // writeUTF - zapis stringa
            raf.writeUTF("Karol");
            raf.writeInt(18);
            raf.writeDouble(32.5);

            raf.writeUTF("Bogdun");
            raf.writeInt(20);
            raf.writeDouble(10.2);

            raf.writeUTF("Kazek");
            raf.writeInt(30);
            raf.writeDouble(3);

            raf.writeUTF("John");
            raf.writeInt(50);
            raf.writeDouble(32.5);

            // O CHUJ PLIKU NIE ZNALAZLO oO
        } catch (FileNotFoundException ex) {
            System.out.print("Nie dla psa kiełbasa! Nie ma pliku");
        }
        // blok kodu przy instrukcji try-catch który ZAWSZE sie wykona
        finally{
            // zamykasz strumien jesli istnieje
            if(raf != null) raf.close();
        }


    }
    public static void OdczytRAF(String url) throws IOException
    {
        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(url,"rw");
            // pętla nieskonczonosci, wyjscie z niej następuje jak plik sie skonczy tworzac blad EOF (end o file)
            // blad ten obslugujemy w catch IOException
            while(true){ // odczytuje stringa inta doubla
                System.out.println(raf.readUTF() + " " + raf.readInt() + " " + raf.readDouble());
            }
        } catch (FileNotFoundException ex) {
            System.out.print("Nie dla psa kiełbasa! Nie ma pliku");
        } catch (IOException ex) {
            // Plik sie skonczyl i wygenerowal blad EOF i tu obslugujemy wyjatek :D
            //tzn w sumie nic nie musimy robic bo dotarlismy do konca pliku a o to nam chodzilo :D
            // nie pytaj czy to aby na pewno profesjonalny sposob ale taki byl na wykladzie
        }finally{
            if(raf != null) raf.close();
        }
    }

    public static void ZadanieWlasciweRAF(String url) throws IOException
    {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(url,"rw");
            while(true)
            {
                // czytam stringa
                String imie = raf.readUTF();
                // zapisuje pozycje wskaznika ktory jest przed intem ktorego byc moze bede chcial zmienic
                long pozycja_wskaznika_do_zmiany_inta= raf.getFilePointer();
                int wiek = raf.readInt();
                double waga = raf.readDouble();
                // zapisuje aktualna pozycje tak aby po cofnieciu sie do inta wrocic tam gdzie bylem i nie sprawdzac na nowo tych samych danych

                long pozycja_aktualna_wskaznika = raf.getFilePointer();
                if(imie.contains("a"))
                {
                    // imie zawiera "a" wiec cofam sie przed inta i zapisuje tam wartosc wiek+waga
                    raf.seek(pozycja_wskaznika_do_zmiany_inta);
                    raf.writeInt(wiek + (int)waga);
                    // wracam tam gdzie bylbym gdybym nie wracał aby zmienic plik
                    raf.seek(pozycja_aktualna_wskaznika);
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.print("Nie dla psa kiełbasa! Nie ma pliku");

        }
        catch(IOException ex){}
        finally{
            if(raf != null) raf.close();
        }

    }

    public static void main(String[] args) throws IOException {
	// write your code here
        TworzenieRAF("R:\\rkw.txt");
        OdczytRAF("R:\\rkw.txt");
        ZadanieWlasciweRAF("R:\\rkw.txt");
        System.out.println();
        OdczytRAF("R:\\rkw.txt");

    }
}
