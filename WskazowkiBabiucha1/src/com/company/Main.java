package com.company;
import java.io.*;

class Test implements Serializable

{ // słowo implements mówi: klasa TEST 'dziedziczy po interfejsie'  Serializable
    // Jeżeli chcemy daną klasę zapisać do pliku, to musimy ją serializować - właśnie za pomocą tej klasy Serializable
    int pole;
    static int numer = 0;
    public Test(int n){             // Konstruktor dla klasy
        pole = n;
        numer++;                    // jako iż jest to zmienna statyczna, to w każdym obiekcie ta wartość się zwiększy - w tym pliku jest to pokazane gdzieś poniżej.
    }
    public void metoda(Test t){     // Publiczna metoda dla klasy
        t.pole = 25;
    }
    public void metoda(int x){      // Druga publiczna metoda, z przykładem działania polimorfizmu
        //...
    }

    public int getPole(){           // tak się tworzy właściwości dla zmiennych - czyli klasy, które zwracają wartość zmiennej (prywatnej w tym wypadku)
        return pole;
    }
    public void setPole(int _pole){ // Podobnie jak powyżej, tylko tutaj nie pobieramy, a przypisujemy wartość do zmiennej (prywatnej), dzięki temu mamy kontrolę
        // nad wartościami jakie przypisujemy do zmiennej
        pole = _pole;
    }
    public static int getNumer(){   // tutaj mamy statyczną właściwość (taka zmienna statyczna ma tą samą wartość dla KAŻDEGO obiektu jaki stworzymy)
        return numer;
    }

    @Override
    public String toString(){       // za pomocą atrybutu Override możemy przyciążyć daną już wcześniej zmienną (którą dziedziczymy niejawnie po klasie OBJECT)
        return "abc";
    }
}

class Test2 extends Test{           // słowo extends mówi:  że klasa TEST2 'dziedziczy po klasie' TEST
    public Test2(){                 // Konstruktor dla klasy TEST2
        super(10);                  // Który za pomocą słówka 'super' (odowłanie się do klasy bazowej - czyli TEST) robi instancję tej klasy
        super.metoda(4);            // tutaj za pomocą słówka 'super' odwołujemy się do metody z klasy bazowej
    }
}

class Plik{                         // kolejna klasa... która potrafi czytać słowo lub linię z pliku
    private FileReader pl;          // zmienna do czytania pliku

    public Plik(FileReader pl){     // konstruktor.
        this.pl = pl;
    }


    public Plik(String nazwa){      // drugi konstruktor - tutaj ładujemy plik po jego nazwie (ścieżce), a powyżej po obiekcie 'pl'
        try {
            pl = new FileReader(nazwa);
        } catch (FileNotFoundException ex) {
        }
    }

    public String czytajLinie() throws IOException{     // jak nazwa mówi "czytaj linijkę" - operacje na plikach wymagają dodania "throws IOEXCEPTION"
        String linia = "";
        char znak = (char)pl.read();                    // czytamy znak (każde wczytanie znaku przesuwa wskaźnik do przodu, więc za każdym razem wczytamy inny znak)
        // kiedy plik się skończy, to wystem zwróci wartość '-1'
        while(znak!=-1 && znak!='\n'){                  // plik będzie czytany dopóki się nie skończy (czyli właśnie to -1), bądź dopóki nie będziemy mieli znaku końca linii (\n)
            linia+=znak;
            znak = (char)pl.read();                     // tutaj czytamy kolejny znak
        }
        return linia;
    }

    public String czytajSlowo() throws IOException{     // podobnie jak z linijką, tylko tutaj czytamy słowo i warunkiem skończenia czytania jest...
        // albo koniec pliku, albo kiedy wczytany znak będzie znakiem białym (spacja, tab, enter, etc)
        String linia = "";
        char znak = (char)pl.read();
        while(znak!=-1 && !Character.isWhitespace(znak)){
            linia+=znak;
            znak = (char)pl.read();
        }
        return linia;
    }


    public static void zapisDoPliku(String nazwa, Test t) throws IOException{   // tutaj zapisujemy do pliku za pomocą klasy ObjectOutputStream - czyli takiej, która zapisuje wartości obiektów do pliku
        ObjectOutputStream pl = null;           // Poniżej mamy standardowy schemat ładowania takiegp pliku
        try{
            pl = new ObjectOutputStream(new FileOutputStream(nazwa, true));

            pl.writeObject(t);          // Za pomocą tej metody możemy zapisać właśnie cały obiekt.
        } finally{
            if(pl!=null){
                pl.close();
            }
        }
    }

    public static void odczytZPliku(String nazwa) throws IOException, ClassNotFoundException{       // tutaj w drugą strone... czytamy teraz cały obiekt...
        ObjectInputStream pl = null;
        try{
            pl = new ObjectInputStream(new FileInputStream(nazwa));

            Test t = (Test)pl.readObject();
            System.out.println(t.getPole());
            t = (Test)pl.readObject();
            System.out.println(t.getPole());
        } finally{
            if(pl!=null){
                pl.close();
            }
        }
    }





public class Main {  // główna klasa aplikacji

    public static void main(String[] args) throws IOException{
	// write your code here

          /*
        Test t = new Test(10);
        System.out.printf("%d %d\n", t.getPole(), Test.getNumer());
        Test t2 = new Test(100);
        System.out.printf("%d %d\n", t.getPole(), Test.getNumer());
        System.out.printf("%d %d\n", t2.getPole(), Test.getNumer());

        System.out.println(t.getPole());
        System.out.println(t2.getPole());

        t.metoda(t2);

        t2.setPole(99);

        System.out.println(t.getPole());
        System.out.println(t2.getPole());


        Plik p = new Plik("/home/michal/NetBeansProjects/JavaApplication12/src/javaapplication12/JavaApplication12.java");
        System.out.println(p.czytajLinie());
        System.out.println(p.czytajSlowo());
        System.out.println(p.czytajSlowo());
        */
        Test t = new Test(5);
        //System.out.println(t.toString());
        //zapisDoPliku("test.dat", t);
        odczytZPliku("test.dat");
    }
}
