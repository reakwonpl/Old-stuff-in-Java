/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brajanusz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author barto
 */
public class Brajanusz {

    public static int[][] odczytPliku(String nazwaPliku) throws FileNotFoundException, IOException
    {
        int [][] tablica = null;
        BufferedReader odczyt = null;
       
        try
        {
            odczyt = new BufferedReader(new FileReader(nazwaPliku));
            String wiersz = odczyt.readLine();
            if (wiersz != null)
            {
                int wielkoscTablicy = Integer.parseInt(wiersz);
                tablica = new int[wielkoscTablicy][wielkoscTablicy];
                String [] wierszTablicy = null;
                wiersz = odczyt.readLine();
                int wartosc = 0;
               
                while (wiersz != null)
                {
                    for (int i = 0; i < tablica.length; i++)
                    {
                        wierszTablicy = wiersz.split(" ");
                       
                        for (int j = 0; j < wierszTablicy.length; j++)
                        {
                            wartosc = Integer.parseInt(wierszTablicy[j]);
                           
                            tablica[i][j] = wartosc;
                            tablica[j][i] = wartosc;
                        }
                        wiersz = odczyt.readLine();
                    }
                }
            }
       
        }
        finally
        {
            if (odczyt != null)
            {
                odczyt.close();
            }
        }
        return tablica;
    }
   
    //metoda sprawdza czy plik o podanej nazwie istnieje
    public static boolean czyPlikIstnieje(String nazwa) throws IOException
    {
       File plik = new File(nazwa);
       return plik.exists() && plik.isFile();
    }
   
    //metoda wyswietla zawartosc tablicy
    public static void wyswietlZawartoscTablicy(int [][] table)
    {
        for (int i = 0; i < table.length; i++)
        {
            for(int j = 0; j < table[i].length; j++)
            {
                System.out.print(table[i][j] + "; ");
            }
            System.out.println();
        }
    }
    public static int[] stworzOsobnika(int [][] tabOdleglosci)
    {
        int[] tabMieszkaniec = new int[tabOdleglosci.length + 1];
        int[] tabPomocnicza = new int[tabOdleglosci.length + 1];
        for (int i = 0; i < tabPomocnicza.length ; i++)
        {
            tabPomocnicza[i] = -1;
        }
        
        int sumaOdleglosci = 0;
        Random rnd = new Random();
        
        int losuj1 = rnd.nextInt(tabOdleglosci.length);
        int losuj2 = rnd.nextInt(tabOdleglosci.length);
        int licznik = 0;
        boolean stop = false;
        
        for (int i = 0; i < tabPomocnicza.length - 1; i++)
        {   
            if (stop == false)
            {
                if (losuj1 == tabPomocnicza[i] || losuj2 == losuj1)
                {   
                    losuj1 = rnd.nextInt(tabOdleglosci.length);
                    losuj2 = rnd.nextInt(tabOdleglosci.length);
                    i = -1;
                }
            
                else if (losuj1 != tabPomocnicza[i] && tabPomocnicza[i] == -1)
                {
                    tabPomocnicza[i] = losuj1;
                    losuj1 = rnd.nextInt(tabOdleglosci.length);
                    losuj2 = rnd.nextInt(tabOdleglosci.length);
                    i = -1;
                    licznik++;
                    if (licznik == tabPomocnicza.length - 1)
                    {
                        stop = true;
                    }
                }   
            }
        }
        
        for (int i = 0; i < tabPomocnicza.length - 1; i++)
        {
            if (i == 0)
            {
                sumaOdleglosci += tabOdleglosci[tabPomocnicza[tabPomocnicza.length - 2]][tabPomocnicza[i]];
                tabMieszkaniec[i] = tabOdleglosci[tabPomocnicza[tabPomocnicza.length - 2]][tabPomocnicza[i]];
            }
            else
            {
                sumaOdleglosci += tabOdleglosci[tabPomocnicza[i-1]][tabPomocnicza[i]];
                tabMieszkaniec[i] = tabOdleglosci[tabPomocnicza[i-1]][tabPomocnicza[i]];
            }
        }
        
        tabPomocnicza[tabPomocnicza.length - 1] = sumaOdleglosci;
        tabMieszkaniec[tabMieszkaniec.length - 1] = sumaOdleglosci;
        
        for (int i = 0; i<tabPomocnicza.length;i++)
        {
            System.out.print(tabPomocnicza[i] + " ");
        }
        System.out.println("");

        /*for (int i = 0; i<tabMieszkaniec.length;i++)
        {
            System.out.print(tabMieszkaniec[i] + " ");
        }     
        System.out.println("");*/
        
        return tabPomocnicza;
    }
    
    public static int[][] stworzPopulacje(int [][] tabOdleglosci, int wielkoscPopulacji)
    {
        int [][] tabPopulacji = new int[wielkoscPopulacji][tabOdleglosci.length + 1];
        int [] mieszkaniec = null;
        
        for (int i = 0; i < wielkoscPopulacji; i++)
        {   
            mieszkaniec = stworzOsobnika(tabOdleglosci);
            
            for (int j = 0; j < tabOdleglosci.length+1; j++)
            {
                tabPopulacji[i][j] = mieszkaniec[j];
            }
        }
        return tabPopulacji;
    }
    
    public static int[][] selekcjaKolaRuletki (int [][] tabPopulacji, int [][] tabOdleglosci)
    {
        int [][] tabKolaRuletki = new int [tabPopulacji.length][tabOdleglosci.length + 1];
        int [][] tabPomocnicza = new int [tabPopulacji.length][tabOdleglosci.length + 1];
        int najgorszyOsobnik = 0;
        int mieszkaniec = 0;
        int ocena = 0;
        int sumaOcen = 0;
        Random rnd = new Random();
        
        for (int i = 0; i < tabPopulacji.length; i++)
        {
            mieszkaniec = tabPopulacji[i][tabOdleglosci.length];
            if (najgorszyOsobnik < mieszkaniec)
            {
                najgorszyOsobnik = mieszkaniec;
            }
        }
        
        for (int i = 0; i < tabPopulacji.length; i++)
        {
            mieszkaniec = tabPopulacji[i][tabOdleglosci.length];
            ocena = najgorszyOsobnik + 1 - mieszkaniec; 
            
            for (int j = 0; j < tabOdleglosci.length+1; j++)
            {
                tabPomocnicza[i][j] = tabPopulacji[i][j];
            }
            
            if (i == 0)
            {
                tabPomocnicza[i][tabOdleglosci.length] = ocena;
            }
            else 
            {
                tabPomocnicza[i][tabOdleglosci.length] = ocena + tabPomocnicza[i - 1][tabOdleglosci.length];
            }
            sumaOcen += ocena;
        }
        
        for (int i = 0; i < tabPopulacji.length; i++)
        {  
            int losuj1 = rnd.nextInt(sumaOcen) + 1;
            
            for (int j = 0; j < tabPopulacji.length; j++)
            {
                if (losuj1 <= tabPomocnicza[j][tabOdleglosci.length] && j == 0)
                {
                    for (int k = 0; k < tabOdleglosci.length + 1; k++)
                    {
                        tabKolaRuletki[i][k] = tabPopulacji[j][k];
                    }
                }
                else if (losuj1 <= tabPomocnicza[j][tabOdleglosci.length] && losuj1 >= tabPomocnicza[j - 1][tabOdleglosci.length])
                {
                    for (int k = 0; k < tabOdleglosci.length + 1; k++)
                    {
                        tabKolaRuletki[i][k] = tabPopulacji[j][k];
                    }
                }
                else if (losuj1 == sumaOcen)
                {
                    for (int k = 0; k < tabOdleglosci.length + 1; k++)
                    {
                        tabKolaRuletki[i][k] = tabPopulacji[j][k];
                    }
                }
            }
        }
        
        System.out.println("Zwycięskie drogi w selekcji koła ruletki");
        
        /*for (int i = 0; i < tabKolaRuletki.length; i++)
        {
            for (int j = 0; j < tabOdleglosci.length; j++)
            {
                System.out.print(tabPomocnicza[i][j] + " ");
            }
            System.out.println("");
        }*/

        for (int i = 0; i < tabKolaRuletki.length; i++)
        {
            for (int j = 0; j < tabOdleglosci.length + 1; j++)
            {
                System.out.print(tabKolaRuletki[i][j] + " ");
            }
            System.out.println("");
        }
        
        return tabKolaRuletki;
    }
    
    public static int[][] selekcjaTurniejowa (int [][] tabPopulacji, int [][] tabOdleglosci)
    {
        int [][] tabTurniejowa = new int [tabPopulacji.length][tabOdleglosci.length + 1];
        Random rnd = new Random();
        int los1, los2, los3, los4, los5, los6 = 0;
        int ocena1, ocena2, ocena3, ocena4, ocena5, ocena6 = 0;
        int min1, min2, min3, min4, min5, minimalna = 0;
         
        for (int i = 0; i < tabPopulacji.length; i++)
        {
            los1 = rnd.nextInt(tabPopulacji.length - 1);
            los2 = rnd.nextInt(tabPopulacji.length - 1);
            los3 = rnd.nextInt(tabPopulacji.length - 1);
            los4 = rnd.nextInt(tabPopulacji.length - 1);
            los5 = rnd.nextInt(tabPopulacji.length - 1);
            los6 = rnd.nextInt(tabPopulacji.length - 1);
            ocena1 = tabPopulacji[los1][tabOdleglosci.length];
            ocena2 = tabPopulacji[los2][tabOdleglosci.length];
            ocena3 = tabPopulacji[los3][tabOdleglosci.length];
            ocena4 = tabPopulacji[los4][tabOdleglosci.length];
            ocena5 = tabPopulacji[los5][tabOdleglosci.length];
            ocena6 = tabPopulacji[los6][tabOdleglosci.length];
            min1 = Math.min(ocena1, ocena2);
            min2 = Math.min(ocena3, ocena4);
            min3 = Math.min(ocena5, ocena6);
            min4 = Math.min(min1, min2);
            min5 = Math.min(min3, min4);
            minimalna = min5;
            
            if (ocena1 == minimalna)
            {
                for (int j = 0; j < tabOdleglosci.length + 1; j++)
                {
                    tabTurniejowa[i][j] = tabPopulacji[los1][j];
                }
            }
            else if (ocena2 == minimalna)
            {
                for (int j = 0; j < tabOdleglosci.length + 1; j++)
                {
                    tabTurniejowa[i][j] = tabPopulacji[los2][j];
                }
            }
            else if (ocena3 == minimalna)
            {
                for (int j = 0; j < tabOdleglosci.length + 1; j++)
                {
                    tabTurniejowa[i][j] = tabPopulacji[los3][j];
                }
            }
            else if (ocena4 == minimalna)
            {
                for (int j = 0; j < tabOdleglosci.length + 1; j++)
                {
                    tabTurniejowa[i][j] = tabPopulacji[los4][j];
                }
            }
            else if (ocena5 == minimalna)
            {
                for (int j = 0; j < tabOdleglosci.length + 1; j++)
                {
                    tabTurniejowa[i][j] = tabPopulacji[los5][j];
                }
            }
            else 
            {
                for (int j = 0; j < tabOdleglosci.length + 1; j++)
                {
                    tabTurniejowa[i][j] = tabPopulacji[los6][j];
                }
            }
        }
         
        /*System.out.println("Zwycięskie drogi w selekcji turniejowej");
        
        for (int i = 0; i<tabPopulacji.length;i++)
        {
            for(int j = 0; j<tabOdleglosci.length + 1; j++)
            {
                System.out.print(tabTurniejowa[i][j] + " ");
            }
           System.out.println("");
        }*/
         return tabTurniejowa;
     }
    
    public static int [][] Krzyzowanie (int [][] tabSelekcji, int [][] tabOdleglosci)
    {
        int [][] tabPotomkow = new int [tabSelekcji.length][tabOdleglosci.length + 1];
        int [] tabKrzyzowania1 = new int [tabOdleglosci.length];
        int [] tabKrzyzowania2 = new int [tabOdleglosci.length];
        
        for (int a = 0; a < tabSelekcji.length; a += 2)
        {
            for (int i = 0; i < tabKrzyzowania1.length ; i++)
            {
                tabKrzyzowania1[i] = -1;
            }
            for (int i = 0; i < tabKrzyzowania2.length ; i++)
            {
                tabKrzyzowania2[i] = -1;
            }
            Random rnd = new Random();
            int losujRodzica1 = rnd.nextInt(tabSelekcji.length);
            int losujRodzica2 = rnd.nextInt(tabSelekcji.length);
            int liczba = 0;
            boolean czySiePowtarza = false;
            boolean czyWyjsc = false;

            int losuj1 = rnd.nextInt(tabOdleglosci.length);
            int losuj2 = rnd.nextInt(tabOdleglosci.length);
            
            while (losuj2 < losuj1)
            {
            losuj1 = rnd.nextInt(tabOdleglosci.length);
            losuj2 = rnd.nextInt(tabOdleglosci.length);
            }

            //--------------//////////--------------//
            for (int i = losuj1; i < losuj2; i++)
            {
                tabKrzyzowania1[i] = tabSelekcji[losujRodzica1][i];
            }
            //------------///////////////////------//
            for (int i = losuj2; i < tabOdleglosci.length; i++)
            {
                liczba = tabSelekcji[losujRodzica2][i];
                for (int j = losuj1; j < tabOdleglosci.length; j++)
                {
                    if (liczba == tabKrzyzowania1[j])
                    {
                        czySiePowtarza = true;
                    }
                }
                if (czySiePowtarza == false)
                {
                    czyWyjsc = false;
                    for (int j = losuj1; j < tabOdleglosci.length; j++)
                    {
                        if (tabKrzyzowania1[j] == -1 && czyWyjsc == false)
                        {
                           tabKrzyzowania1[j] = liczba; 
                           czyWyjsc = true;
                        } 
                    }
                }
                else
                {
                    czySiePowtarza = false;
                }
            }
            //---------/////////////////////////////
            for (int i = 0; i < losuj2; i++)
            {
                liczba = tabSelekcji[losujRodzica2][i];
                for (int j = losuj1; j < tabOdleglosci.length; j++)
                {
                    if (liczba == tabKrzyzowania1[j])
                    {
                        czySiePowtarza = true;
                    }
                }
                if (czySiePowtarza == false)
                {
                    czyWyjsc = false;
                    for (int j = losuj1; j < tabOdleglosci.length; j++)
                    {
                        if (tabKrzyzowania1[j] == -1 && czyWyjsc == false)
                        {
                           tabKrzyzowania1[j] = liczba; 
                           czyWyjsc = true;
                        } 
                    }
                }
                else
                {
                    czySiePowtarza = false;
                }
            }
            ///////////////////////////////////////
            for (int i = 0; i < losuj2; i++)
            {
                liczba = tabSelekcji[losujRodzica2][i];
                for (int j = losuj1; j < tabOdleglosci.length; j++)
                {
                    if (liczba == tabKrzyzowania1[j])
                    {
                        czySiePowtarza = true;
                    }
                }
                if (czySiePowtarza == false)
                {
                    czyWyjsc = false;
                    for (int j = 0; j < tabOdleglosci.length; j++)
                    {
                        if (tabKrzyzowania1[j] == -1 && czyWyjsc == false)
                        {
                           tabKrzyzowania1[j] = liczba; 
                           czyWyjsc = true;
                        } 
                    }
                }
                else
                {
                    czySiePowtarza = false;
                }
            }

            //--------------//////////--------------//
            for (int i = losuj1; i < losuj2; i++)
            {
                tabKrzyzowania2[i] = tabSelekcji[losujRodzica2][i];
            }
            //------------///////////////////------//
            for (int i = losuj2; i < tabOdleglosci.length; i++)
            {
                liczba = tabSelekcji[losujRodzica1][i];
                for (int j = losuj1; j < tabOdleglosci.length; j++)
                {
                    if (liczba == tabKrzyzowania2[j])
                    {
                        czySiePowtarza = true;
                    }
                }
                if (czySiePowtarza == false)
                {
                    czyWyjsc = false;
                    for (int j = losuj1; j < tabOdleglosci.length; j++)
                    {
                        if (tabKrzyzowania2[j] == -1 && czyWyjsc == false)
                        {
                           tabKrzyzowania2[j] = liczba; 
                           czyWyjsc = true;
                        } 
                    }
                }
                else
                {
                    czySiePowtarza = false;
                }
            }
            //---------/////////////////////////////
            for (int i = 0; i < losuj2; i++)
            {
                liczba = tabSelekcji[losujRodzica1][i];
                for (int j = losuj1; j < tabOdleglosci.length; j++)
                {
                    if (liczba == tabKrzyzowania2[j])
                    {
                        czySiePowtarza = true;
                    }
                }
                if (czySiePowtarza == false)
                {
                    czyWyjsc = false;
                    for (int j = losuj1; j < tabOdleglosci.length; j++)
                    {
                        if (tabKrzyzowania2[j] == -1 && czyWyjsc == false)
                        {
                           tabKrzyzowania2[j] = liczba; 
                           czyWyjsc = true;
                        } 
                    }
                }
                else
                {
                    czySiePowtarza = false;
                }
            }
            ///////////////////////////////////////
            for (int i = 0; i < losuj2; i++)
            {
                liczba = tabSelekcji[losujRodzica1][i];
                for (int j = losuj1; j < tabOdleglosci.length; j++)
                {
                    if (liczba == tabKrzyzowania2[j])
                    {
                        czySiePowtarza = true;
                    }
                }
                if (czySiePowtarza == false)
                {
                    czyWyjsc = false;
                    for (int j = 0; j < tabOdleglosci.length; j++)
                    {
                        if (tabKrzyzowania2[j] == -1 && czyWyjsc == false)
                        {
                           tabKrzyzowania2[j] = liczba; 
                           czyWyjsc = true;
                        } 
                    }
                }
                else
                {
                    czySiePowtarza = false;
                }
            }
            
            //przepisanie potomków do tablicy nowopowstałej populacji
            for (int i = 0; i < tabOdleglosci.length; i++)
            {
                tabPotomkow[a][i] = tabKrzyzowania1[i];
                tabPotomkow[a+1][i] = tabKrzyzowania2[i];
            }
            
        } 
            //obliczenie wartości nowo powstałej populacji 
            int sumaOdleglosci = 0;
            for (int i = 0; i < tabPotomkow.length; i++)
            {
                for (int j = 0; j < tabOdleglosci.length; j++)
                {
                    if (j == 0)
                    {
                        sumaOdleglosci += tabOdleglosci[tabPotomkow[i][tabOdleglosci.length-2]][tabPotomkow[i][j]];
                    }
                    else
                    {
                        sumaOdleglosci += tabOdleglosci[tabPotomkow[i][j-1]][tabPotomkow[i][j]];
                    }
                }
                tabPotomkow[i][tabOdleglosci.length] = sumaOdleglosci;
                sumaOdleglosci = 0;
            }
            
        /*for (int i = 0; i < tabPotomkow.length; i++)
        {
            for (int j = 0; j < tabOdleglosci.length + 1; j++)
            {
                System.out.print(tabPotomkow[i][j] + " ");
            }
            System.out.println("");
        }*/
        return tabPotomkow;
    }
    
    public static int [][] Mutacje (int [][] tabSelekcji, int [][] tabOdleglosci)
    {
        int wspMutacji = 1;
        Random rnd = new Random();
        int losuj, przedzial1, przedzial2 = 0;
        
         
        for (int i = 0; i < tabSelekcji.length; i++)
        {
            losuj = rnd.nextInt(101);
            if (losuj < wspMutacji)
            {
                przedzial1 = rnd.nextInt(tabOdleglosci.length);
                przedzial2 = rnd.nextInt(tabOdleglosci.length);
                while (przedzial1 > przedzial2)
                {
                    przedzial1 = rnd.nextInt(tabOdleglosci.length);
                    przedzial2 = rnd.nextInt(tabOdleglosci.length);
                }
                
                while (przedzial1 < przedzial2)
                {
                    int kontener = tabSelekcji[i][przedzial1];
                    tabSelekcji[i][przedzial1] = tabSelekcji[i][przedzial2];
                    tabSelekcji[i][przedzial2] = kontener;
                    przedzial1++;
                    przedzial2--;
                }
                
                if (przedzial1 < przedzial2)
                {   
                    int sumaOdleglosci = 0;
                
                        for (int k = 0; k < tabOdleglosci.length; k++)
                        {
                            if (k == 0)
                            {
                                sumaOdleglosci += tabOdleglosci[tabSelekcji[i][tabOdleglosci.length-2]][tabSelekcji[i][k]];
                            }
                            else
                            {
                                sumaOdleglosci += tabOdleglosci[tabSelekcji[i][k-1]][tabSelekcji[i][k]];
                            }
                        
                        tabSelekcji[i][tabOdleglosci.length] = sumaOdleglosci;
                        sumaOdleglosci = 0;
                    }
                }
            }
        }
        
        /*for (int i = 0; i < tabSelekcji.length; i++)
        {
            for (int j = 0; j < tabOdleglosci.length + 1; j++)
            {
                System.out.print(tabSelekcji[i][j] + " ");
            }
            System.out.println("");
        }*/
         return tabSelekcji;
     }
    
    public static int [] Najlepszy (int [][] tabSelekcji, int[][] tabOdleglosci)
    {
        int najmniejszy = 50000;
        int[] tabNajlepszy = new int[tabOdleglosci.length + 1]; 
        for (int i = 0; i < tabSelekcji.length; i++)
            {
                while (tabSelekcji[i][tabOdleglosci.length] < najmniejszy)
                {
                    najmniejszy = tabSelekcji[i][tabOdleglosci.length];
                    for (int j = 0; j < tabOdleglosci.length + 1; j++ )
                    {
                        tabNajlepszy[j] = tabSelekcji[i][j];
                    }
                    tabNajlepszy[tabOdleglosci.length] = najmniejszy;
                }
            }
        
        return tabNajlepszy;
    }
    public static void main(String[] args) throws IOException
    {
        int [][] tabOdleglosci = null;
        int [][] tabPopulacji = null;
        String nazwa = "R:\\berlin52.txt";
        int wielkoscPopulacji = 20;
        int liczbaPowtorzen = 500000;
        int [] tabNajlepszy = null;
       tabOdleglosci = odczytPliku(nazwa);
        tabPopulacji = stworzPopulacje(tabOdleglosci, wielkoscPopulacji);
        System.out.println("Populacja ->");
        wyswietlZawartoscTablicy(tabPopulacji);
        System.out.println("selekcja ->");
        tabPopulacji = selekcjaTurniejowa(tabPopulacji, tabOdleglosci);
        wyswietlZawartoscTablicy(tabPopulacji);
        System.out.println("Krzyzowanie ->");
        tabPopulacji = Krzyzowanie(tabPopulacji, tabOdleglosci);
        wyswietlZawartoscTablicy(tabPopulacji);
        /*
        if (czyPlikIstnieje(nazwa))
        {
            tabOdleglosci = odczytPliku(nazwa);
            System.out.println("tablica: ");
            wyswietlZawartoscTablicy(tabOdleglosci);
            System.out.println("");
            System.out.println("Populacja: ");
            tabPopulacji = stworzPopulacje(tabOdleglosci, wielkoscPopulacji);
            System.out.println("");
            System.out.println("");
            System.out.println("Krzyżowanie");
            Krzyzowanie(tabPopulacji, tabOdleglosci);
            
            for (int i = 0; i < liczbaPowtorzen; i++)
            {
                tabPopulacji = selekcjaTurniejowa(tabPopulacji, tabOdleglosci);
                tabPopulacji = Krzyzowanie(tabPopulacji, tabOdleglosci);
                tabPopulacji = Mutacje(tabPopulacji, tabOdleglosci);
                tabNajlepszy = Najlepszy(tabPopulacji, tabOdleglosci);
            }
            
            for (int i = 0; i < tabPopulacji.length; i++)
            {
                for (int j = 0; j < tabOdleglosci.length + 1; j++)
                {
                    System.out.print(tabPopulacji[i][j] + " ");
                }
                System.out.println(" ");
            }
            
            for (int i = 0; i < tabNajlepszy.length; i++)
            {
                System.out.print(tabNajlepszy[i] + " ");
            }
            System.out.println(" ");
            
            PrintWriter zapisz = new PrintWriter("G:\\zwyciezca.txt");
            System.out.println("Najlepsza trasa");
            
            for (int i=0;i<tabOdleglosci.length + 1;i++)
            {
                zapisz.print(tabNajlepszy[i]);

                if(i < tabOdleglosci.length - 1) 
                {
                    zapisz.print("-");
                }
                else
                {
                zapisz.print(" ");
                }
                
            System.out.print(tabNajlepszy[i] + " ");
            
            }
            
        zapisz.close();
        
        }
        else
        {
            System.out.println("Nie można odnaleźć pliku.");
        } */
    }
    
}
