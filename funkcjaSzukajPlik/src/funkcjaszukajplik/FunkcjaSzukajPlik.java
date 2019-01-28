/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funkcjaszukajplik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author barto
 */

/*
Napisać funkcję:
void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawierają szukane słowo.
Wszystkie wiersze, które zawierają słowo powinny zostać zapisane w pliku wynikowym wraz z nr
wiersza (z pierwszego pliku). Nazwa pierwszego pliku zapamiętana jest w parametrze
nazwaPlikWe, nazwa pliku wynikowego podana jest w parametrze nazwaPlikWy, natomiast szukane
słowo w parametrze slowo.
 */



public class FunkcjaSzukajPlik {

    public static void szukaj(String nazwaPlikWe,String nazwaPlikWy,String slowo)
    {
        try
        {
        BufferedWriter zapis = new BufferedWriter(new FileWriter(nazwaPlikWy,false));
        BufferedReader odczyt = new BufferedReader(new FileReader(nazwaPlikWe));
        String linia = null;
        int  licznik = 0;
        
        while((linia = odczyt.readLine()) != null)
            {
               Scanner sc = new Scanner(linia);
               licznik++;
               
               while(sc.hasNext())
               {
                   if(sc.next().replace(".","").equals(slowo));
                   {
                       zapis.write(licznik+":"+linia);
                       zapis.newLine();
                   }
               }
               
            }
        zapis.close();
        }
            catch( FileNotFoundException ex)
                {
                    ex.getStackTrace();
                }
            catch(IOException e)
                {
                    e.getStackTrace();
                }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        szukaj("jakastamsciezka","jakastamsciezka","szukaneslowo");
        
    }
    
}
