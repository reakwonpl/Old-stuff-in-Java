package com.company;


/*dany jest plik w którym zapisano w postaci wewn kolejne trójki tworzące informacje o przedmiotach
 -string nazwa, int semestr, int ects, float ocena.
Napisz funkcję zwiększającą (bezpośr w pliku bez wczytania całego plliku do pamięci)
liczbę punkt ect o liczbe odpowiadajaca semestrowi,
 ale tylko w przypadku jesli ocena jest mniejsza niz 3. dodatkowo funkcja zwraca srednia ocen wszystkich przedmiotow w pliku
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import jdk.nashorn.internal.ir.CatchNode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {


    //tworzenie pliku w ktorym mamy nazwe,semsetry,ects,ocene
    static void zad1Stworz(String nazwaWe) throws FileNotFoundException,IOException{
        RandomAccessFile dostep = null;
        try{
            dostep = new RandomAccessFile(nazwaWe,"rw");
            dostep.writeUTF("Java");
            dostep.writeInt(4);
            dostep.writeInt(3);
            dostep.writeFloat(3);

            dostep.writeUTF("Grafika3D");
            dostep.writeInt(4);
            dostep.writeInt(5);
            dostep.writeFloat(4);

            dostep.writeUTF("Interfejsy");
            dostep.writeInt(4);
            dostep.writeInt(4);
            dostep.writeFloat(5);

        } catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            //zamkniecie
            if (dostep != null){
                dostep.close();
            }
        }
    }
    //funkcja zwiekszajaca
    static double zad1Zwieksz(String nazwaWe) throws IOException{

        RandomAccessFile dostep2 = null;
        String nazwa;
        int semestr;
        int ects;
        float ocena;
        long wskaznik;
        int liczbaOcen = 0;
        int licznik = 0;
        double srednia;

        try{
            dostep2 = new RandomAccessFile(nazwaWe,"rw");
            while(true) {
                nazwa = dostep2.readUTF();
                semestr = dostep2.readInt();
                ects = dostep2.readInt();
                wskaznik = dostep2.getFilePointer();
                ocena = dostep2.readFloat();
                    //jesli ocena jest mniejsza niz 3 ,szukamy wskaznika  i dodajemy ects do semestru
                if (ocena < 3) {
                    dostep2.seek(wskaznik);
                    ects += semestr;
                }
                //ocena rozna od zera,dodajmey oceny i zwiekszamy licznik
                if (ocena != 0) {
                    liczbaOcen += ocena;
                    licznik++;
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if (dostep2 != null){
                dostep2.close();
            }
        }
        //zwracamy srednie
        return  srednia = liczbaOcen / licznik;
    }
                                                    //nie zapomnij o throws
    public static void main(String[] args) throws  IOException {
	// write your code here

        zad1Stworz("R:\\rkw.txt");
        //zad1Zwieksz("R:\\rkw.txt");
    }
}
