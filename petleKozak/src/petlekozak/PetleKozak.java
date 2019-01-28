/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petlekozak;

import java.util.Scanner;

/**
 *
 * @author barto
 */
public class PetleKozak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
      ///zad1 wyswietlanie na ekranie  kolejno wszytskie liczby
      //nieparzyste nie większe od podanej liczby
        System.out.println("Podaj liczbe");
        
        int a = sc.nextInt();
        
        for(int i = 0; i < a;i++)
        {
            if (a > i && i % 2 != 0)
            {
                System.out.println("liczba " + i + " jest mniejsza od " + a);
            }
        } 
        
      //zad2  pobiera dwie liczby a i b ,a < b a następnie
      //wyznacza sumę ciągu liczb od a do b
        System.out.println("Podaj dwie liczby ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int wyn =0;
        if ( x > y )
        {
              System.out.println("X nie mozeby byc wieksze od Y");
              System.exit(0);
        }
        //forem
       for(; x <= y ; x++)
        {
            wyn += x;
            System.out.println(wyn);
        } 
        //whilem
        while( x <= y)
        {
           
            wyn += x;
            x++;
            System.out.println(wyn);
         } 
       do
        {
          wyn += x;
          x++;
          System.out.println(wyn);
        } while(x <= y);
       
      
    
      //zad3 pobiera liczbe n  a następnie wyswietla  
      //wszystkie potęgi liczby 2 nie wieksze niz podana liczba
      System.out.println("podaj liczbe");
      int z = sc.nextInt();
      int lb = 1;
      
      if( z < 0)
      {
          System.out.println("Liczba nie moze byc ujemna");
          System.exit(0);
          
      }
      
      for(;lb < z; lb*=2)
      {
          System.out.println(lb);
      }
      
    
    
    //ZAD5 pobiera liczbe az damy zero ale jej nie wliczamy
  
    int q = 1;
    int suma = 0;
    int najw = 0;
    int najm = 0;
    int licznik = 0;
    while(q != 0)
    {
         q = sc.nextInt();
        suma += q;
        licznik++;
        if( q > najw)
        {
            najw = q;
        }else if(q < najm)
        {
           najm = q;
        }
      }
   double srednia = suma / (licznik - 1);
    System.out.println("Srednia wynosi " + srednia);
    int sm = najm + najw;
        System.out.println("Suma najmniejszej i najwiekszej wynosi  " + sm);

    
   
   //zad 9 oblicza sumę cyft tej liczb,stosunek sredniej cyfr parzystej do cyfr nie parzystych
     int d = sc.nextInt();
   int wynik = 0;
   int parz = 0;
   int licznik1 = 0;
   int licznik2 = 0;
   int nieparz = 0;
   while(d != 0)
   {
       //dzielenie modulo (czyli reszta z dzielenia) - dzieląc x modulo 10 wyłuskamy z liczby x wartość jej ostatniej cyfry,
       wynik += d%10;
       //dzielenie bez reszty (zwane czasem dzieleniem całkowitoliczbowym - div) - dzieląc x bez reszty przez 10, pozbędziemy się z niej ostatniej cyfry.
       d /= 10;
       if ( wynik % 2 == 0)
       {
           parz += wynik;
           licznik1++;
       }
       else 
       {
           nieparz += wynik;
           licznik2++;
       }
       
   }
   System.out.println("suma cyfr podanej liczby wynosi " + wynik);
     System.out.println(parz);
       System.out.println(nieparz);
   double sredniaparz = parz/licznik1;
   double srednianieparz = nieparz/licznik2;
   System.out.println("Stosunek wynosi " + sredniaparz +" : " + srednianieparz);
   
   
   
   //zad10 dzielnik
    int p = sc.nextInt();
    for (int i = 1; i <= p; i++)
    {
        if(p % i == 0)
        {
             System.out.println("Liczba " +i +" jest dzielnikiem liczby " +y);
        }
        
    }
   
   //zad11 liczba pier
    int h = sc.nextInt();
    boolean pierwsza = true;
    for (int i = 2;i*i <= h;i++)
    {
        if (h % i == 0)
        {
            pierwsza = false;
        }
    }
    if (pierwsza)
        System.out.println("TAK");
  else
         System.out.println("NIE");
  
   
   
    
      
      
    
      
      
        
        
        
        
    }
    
}
