/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chechit;

/**
 *
 * @author barto
 */

public class ChechIt {
    
    

    
    public static void main(String[] args) {
        
        int tab[] = new int [5];
        tab [0] = 8;
        tab [1] = 4;
        tab [2] = 8;
        tab [3] = 1;
        tab [4] = 7;
       
        
        for (int i : tab )
        {
            System.out.println("" + i);
            System.out.print("");
        }
        
         for (int j = 0 ; j < tab.length ; j++)
        {
            System.out.println("" + tab[j]);
            System.out.print("");
        }
        
         int table[][] = {{2,3,4},{1,2,3}};
         
         for (int i = 0; i < table.length; i ++)
         {
             for (int j = 0 ; j < table[i].length ; j ++)
             {
                 System.out.println( table[i][j]);
             }
         }
           
         for (int a = 5; a>0 ; a--){
             for (int b = 5; b<10;b++){
                 System.out.println("Zmienna a = " +a + "  a zmenna b = " +b);
             }
         }
         
         int c = 10;
         int d;
         d = c <10 ? -1 :1;
         System.out.println(d);
         
         
         
        // TODO code application logic here
    }
    
}
