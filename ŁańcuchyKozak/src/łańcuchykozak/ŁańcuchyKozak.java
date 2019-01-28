/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package łańcuchykozak;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author barto
 */
public class ŁańcuchyKozak {
         
    
     public static boolean anagram(String a ,String b)
    {
        char[] aa = a.replaceAll("\\s+","").toCharArray();
        char[] bb = b.replaceAll("\\s+","").toCharArray();

        for (int i = 0;i < aa.length;i++)
        {
                int znak = aa[i];
                if (znak >= 60 && znak <= 90)
                {
                    aa[i] += 32;
                }
        }
        for (int j = 0; j < bb.length;j++)
        {
            int znak = bb[j];
            if (znak >= 60 && znak <= 90)
            {
                bb[j] += 32;
            }
        }
        if (aa.length != aa.length)
        {
            System.out.print("");
        }
        else
        {
            Arrays.sort(aa);
            Arrays.sort(bb);
        }
        boolean x = Arrays.equals(aa,bb);
            System.out.println(x);
                return x;

    }        
      public static void akronim(String s )
    {
    String[] tekst = s.split(" ");

    String akr = "";
    String kom = "";

        for (int i = 0;i <tekst.length;i++)
            {
                akr += tekst[i].charAt(0);
            }

        for (int j = 0; j < akr.length(); j++)
        {
            int znak = akr.charAt(j);
            if (znak >= 97 && znak <= 122)
            {
                znak -= 32;
            }
            kom += (char)znak;
        }
        System.out.println(kom);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        //zad1 wyswietlenie informacji ile razy w tym ciągu
         //powtarza sie jego ostatni znak        
        int x = 0;
        int y = 0;
       Scanner sc = new Scanner(System.in); 
       
       String s = sc.nextLine();
       
       char o = s.charAt(s.length() - 1);
       for(int i = 0; i < s.length();i++)
       {           
           if (o == s.charAt(i))
           {   x++; }
       }
       System.out.println( o + " : " + x);
     
       //zad2 odwrócenie stringa 
       String g = sc.nextLine();
       //pierwzy sposob
       String res = new StringBuffer(g).reverse().toString();
       System.out.println(g +" " + res);
       //drugi sposob
       for(int i = g.length() -1; i>= 0;i--)
       {
           System.out.print(g.charAt(i));
       }
       System.out.println("\n"); 
       
      //palindrom
      String a = sc.nextLine();
      StringBuffer str = new StringBuffer(a);
      StringBuffer str2 = new StringBuffer(str.reverse());
      String a2 = new String(str2);
      if(a.equals(a2))
      {
          System.out.println("Jest palindromem");
        }
      else
      {
         System.out.println("Nie jest palindromem"); 
      }
      
      ///zad4 zlicza liczby w tekscie
       System.out.println("\n"); 
     
      String ex = sc.nextLine();
     int sum = 0;
    for (int i = 0; i < ex.length();i++)
    {
        if(Character.isDigit(ex.charAt(i)))
        {
            sum += Character.getNumericValue(ex.charAt(i));
        }
    }
    System.out.println(sum); 
    
    
       //Szyfr Cezara
       String r = sc.nextLine();
       System.out.println("dawaj liczbe"); 
       int m = sc.nextInt();
       char[] z = r.toCharArray();
       for(int i = 0;i != z.length;i++)
       {
          int n = z[i];
           n+=m;
           z[i] =(char)n;
       }
       System.out.println(z); 
      }
 
    
}
