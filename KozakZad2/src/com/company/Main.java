package com.company;



/*
Napisać funkcję:
void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawierają szukane słowo.
Wszystkie wiersze, które zawierają słowo powinny zostać zapisane w pliku wynikowym wraz z nr
wiersza (z pierwszego pliku). Nazwa pierwszego pliku zapamiętana jest w parametrze
nazwaPlikWe, nazwa pliku wynikowego podana jest w parametrze nazwaPlikWy, natomiast szukane
słowo w parametrze slowo.
 */


import com.sun.scenario.animation.shared.FiniteClipEnvelope;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void szukaj(String nazwaPlikWe,String nazwaPlikWy,String slowo) throws IOException,FileNotFoundException{
        try {
            BufferedWriter zapis  = new BufferedWriter(new FileWriter(nazwaPlikWy,false));
            BufferedReader odczyt = new BufferedReader(new FileReader(nazwaPlikWe));
            String linia = null;
            int licznik = 0;

            while ((linia = odczyt.readLine()) !=null){
                Scanner skaner = new Scanner(linia);
                licznik++;

                while(skaner.hasNext()){
                    if (skaner.next().replace(".","").equals(slowo));
                    {
                        zapis.write(licznik+":"+linia);
                        zapis.newLine();
                    }
                }
            }
            zapis.close();
        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        }




    public static void main(String[] args)throws IOException,FileNotFoundException{
	// write your code here
        szukaj("C://Users//Grandek//Desktop//plik.txt","C://Users//Grandek//Desktop//plik2.txt","egzamin");

    }
}
