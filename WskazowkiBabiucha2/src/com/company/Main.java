package com.company;

import java.io.*;

public class Main {

    public static void zapisz(String nazwa) throws IOException{ // Nazwa funkcji, której jak nazwa wskazuje ma zapisać do pliku o nazwie NAZWA (zmienna) dane.
        DataOutputStream plik = null;   // Tworzymy zmienną, która będzie obsługiwała nasz plik (w którym zapiszemy dane)
        try{    // Obsługę plików wykonujemy w try/catch/finally
            plik = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nazwa)));//,true)));  // Tworzymy nasz plik
            plik.writeInt(66);          // Dopisujemy do pliku liczbę całkowitą
            //plik.writeInt(23);        // tutaj to samo
        } finally{
            if(plik!=null){ // Finalnie, jeżeli plik zozstał utworzony/otwary, to go zamykamy
                plik.close();
            }
        }
    }

    public static void odczyt(String nazwa) throws IOException{ // Tutaj w drugą stronę - odczytujemy zawartość z pliku
        DataInputStream plik = null;            // zmienna, która będzie obsługiwać nasz plik
        int suma = 0;                           // tutaj jest zmienna, która w ramach "zadania" ma zliczać
        // sumę liczb jakie podalismy w pliku - czyli podczas zapisu
        try{
            plik = new DataInputStream(new BufferedInputStream(new FileInputStream(nazwa)));        // Odwołujemy się do pliku

            while(true){                        // W pętli WHILE pobieramy (czytamy) każdego kolejnego inta, tak długo aż nie wywali nam błędu - stąd mamy
                // CATCH - jeżeli plik się skończy, to pętla while spróbuje wczytać kolejną danę i wywali błąd - tak to się
                // po prostu tutaj robi. W CATCH zostanie wyświetlona suma
                int tmp = plik.readInt();       // tutaj do zmiennej pomocniczej czytamy inta (po wczytaniu wskaźnik w pliku się przesunie tak jakby za tą liczbę)
                // przez co w kolejnym wykonaniu pętli wczytamy już kolejnego inta.
                System.out.println(tmp);        // wyswietlamy naszego inta
                suma += tmp;
            }
        } catch (java.io.EOFException ex){      // jeżeli plik się skończy, to nadal będziemy próbowali wykonać instrukcję readInt() - która powie nam :
            // "słuchaj, to już koniec pliku, więc jest Błąd" i wrzuci nas w to miejsce.
            System.out.println(suma);
        }
        finally{                                // Na samym końcu (niezależnie czy jest błąd czy nie) wrzuci nas do sekcji finally i zamknie plik
            // (o ile zsotał on wcześniej otwarty)
            if(plik!=null){
                plik.close();
            }
        }
    }

    public static void zapiszRAF(String nazwa) throws IOException{      // Podobnie jak powyżej - zapis działa w taki sam sposób, tylko na plikach RAF
        // RAF (random acces file) - czyli pliki z dostepem swobodnym
        // w normalnych plikach wskaźnik można ustawić na początku, albo na końcu pliku
        // a w plikach RAF możemy go ustawić gdzie tylko chcemy.
        RandomAccessFile plik = null;
        try{
            plik = new RandomAccessFile(nazwa,"rw");                    // tworzymy sobie plik RAF o nazwie NAZWA z typem dostepu "rw" - czyli read write
            plik.writeChar('K');                                        // Poniżej dopisujemy raz znak (char), a raz liczbę (int)
            plik.writeInt(23);
            plik.writeChar('M');
            plik.writeInt(23);
            plik.writeChar('K');
            plik.writeInt(34);
            plik.writeChar('M');
            plik.writeInt(64);
        } finally{                                                      // na końcu zamykamy plik
            if(plik!=null){
                plik.close();
            }
        }
    }

    public static void odczytRAF(String nazwa) throws IOException{       // Odczyta wygląda jak w normalnych plikach, z tym, że tutja mamy RAF
        //  Także nie ma sensu drugi raz opisywać dokładnie tej samej funkcji
        RandomAccessFile plik = null;
        int suma = 0;
        try{
            plik = new RandomAccessFile(nazwa,"rw");

            while(true){
                char tmpC = plik.readChar();
                int tmp = plik.readInt();
                System.out.println(tmpC +" " + tmp);
                suma += tmp;
            }
        } catch (java.io.EOFException ex){
            System.out.println(suma);
        }
        finally{
            if(plik!=null){
                plik.close();
            }
        }
    }


    /*Ta funkcja ma za zadanie pokazać możliwości operacji na plikach RAF.
    W tym zadaniu w pliku mamy takie wartości: K 23 M 23 K 34 M 64
    i chcemy, aby K - kobieta co odpalenie funkcji miała o rok więcej (dopóki nie osiągnie wieku 32 lat
    Natomiast M - mężczyzna co odpalenie funkcji zawsze się starzeje*/
    public static void zmienRAF(String nazwa) throws IOException {   // Odczytanie danych wygląda jak w funkcji odczytaRAF
        RandomAccessFile plik = null;
        try{
            plik = new RandomAccessFile(nazwa,"rw");

            while(true){
                char tmpC = plik.readChar();        // Czytamy pierszy znak (K albo M) - po wczytaniu wskaźnik ustawia się za tym znakiem
                long poz = plik.getFilePointer();   // Zapisujemy aktualną pozycję wskaźnika
                int tmp = plik.readInt();           // Czytamy inta (czyli wiek)

                if(tmpC=='M' || tmpC=='K' && tmp <32){  // Proste logiczne zdanie: jeżeli tmpC to M lub K i K jest młodsza niż 32 lata, to...
                    tmp++;                              // Zwiększ tmp o jeden

                    plik.seek(poz);                     // ustawiamy wskaźnik we wcześniej zapisanej pozycji - wskaźnik po wczytaniu INTA przesunął się
                    plik.writeInt(tmp);

                }
            }
        } catch (java.io.EOFException ex){
        }
        finally{
            if(plik!=null){                             // oraz zamykamy plik
                plik.close();
            }
        }
    }


    public static void main(String[] args) throws IOException{
	// write your code here

        //zapisz("test.txt");
        //odczyt("test.txt");
        //zapiszRAF("test.txt");
        odczytRAF("test.txt");                  // wywołujemy funkcje z parametrem (nazwą pliku) "test.txt"
        zmienRAF("test.txt");
        odczytRAF("test.txt");

    }
}
