package miasto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author MDLejTeCole
 */
public class Miasto {
     public static int[][] przepiszDoTablicy (String nazwa) throws IOException
    {
        BufferedReader plik = null;
        int [][] tablica = null;
        try
        {
            plik = new BufferedReader(new FileReader(nazwa));
 
            String linia = plik.readLine();
            if(linia != null)
            {
                int wielkoscTab = Integer.parseInt(linia);
                tablica = new int[wielkoscTab][wielkoscTab];
 
                String [] wieszeTablicy = null;
                int odleglosc = 0;
 
                linia = plik.readLine();
 
                for (int i = 0; i< tablica.length; i++)
                {
                    wieszeTablicy = linia.split(" ");
 
                    for (int j = 0; j<wieszeTablicy.length; j++)
                    {
                        odleglosc = Integer.parseInt(wieszeTablicy[j]);
                        tablica[j][i] = odleglosc;
                        tablica[i][j] = odleglosc;
                    }
 
                    linia = plik.readLine();
                }
            }
        }
        finally
        {
            if (plik != null)
            {
                plik.close();
            }
        }
        return tablica;
    }
 
    public static void wyswietlTablice (int [][] tab)
    {
        for (int i = 0; i<tab.length;i++)
        {
            for(int j = 0; j<tab[i].length; j++)
            {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] wylosowaneLiczby (int [][] tab)
    {
        int[][] tablicaOdleglosci = tab;
        int jednaOdleglosc ;
        int sumaOdleglosci;
        int pierwszaZmienna;
        int[] mieszkaniec = new int[tablicaOdleglosci.length];
        int[] wylosowanychMieszkaniecow = new int[tablicaOdleglosci.length + 1];
        Random r = new Random();
       
     
        int a = r.nextInt(tablicaOdleglosci.length -1)+1;
        jednaOdleglosc = tablicaOdleglosci[0][a];
        sumaOdleglosci = jednaOdleglosc;
        pierwszaZmienna=a;
        mieszkaniec[0] = jednaOdleglosc;
        wylosowanychMieszkaniecow[0] = a;
        //System.out.println(jednaOdleglosc);
        int p = a;
        boolean czyTaSama = false;
        int czySieNiePowtarza = 0;
        for (int i = 0; i<tablicaOdleglosci.length - 2;i++)
        {
            czyTaSama = false;
            p = a;
            while(czyTaSama == false)
            {
            czySieNiePowtarza =0;  
            p = r.nextInt(tablicaOdleglosci.length -1)+1;
                for (int j = 0; j<wylosowanychMieszkaniecow.length-1;j++)
                {

                    if (wylosowanychMieszkaniecow[j] != p)
                    {
                        czySieNiePowtarza++;
                    }
                    if (wylosowanychMieszkaniecow.length-1 == czySieNiePowtarza)
                    {
                        czyTaSama = true;
                    }
                }
            }
            jednaOdleglosc = tablicaOdleglosci[pierwszaZmienna][p];
            sumaOdleglosci += jednaOdleglosc;
            pierwszaZmienna=p;
            mieszkaniec[i + 1] = jednaOdleglosc;
            wylosowanychMieszkaniecow[i + 1] = p;
           // System.out.println(jednaOdleglosc);
        }
        jednaOdleglosc = tablicaOdleglosci[0][p];
        sumaOdleglosci += jednaOdleglosc;
        //System.out.println(jednaOdleglosc);
        wylosowanychMieszkaniecow[wylosowanychMieszkaniecow.length -1] = sumaOdleglosci;
        for (int i = 0; i<wylosowanychMieszkaniecow.length;i++)
        {
            //System.out.print(wylosowanychMieszkaniecow[i] + " ");
        }
        //System.out.println(sumaOdleglosci);
        return wylosowanychMieszkaniecow;
    }
    public static void main(String[] args) throws IOException
    {
        int [][] tablicaOdleglosci = null;
        String nazwaPliku = "R:\\berlin52.txt";
 
        tablicaOdleglosci = przepiszDoTablicy(nazwaPliku);
        wyswietlTablice(tablicaOdleglosci);
        int najmniejsza=100000;
        int [] wylosowanyM = null;
        int [] uporzadkowaneOdleglosci = new int[tablicaOdleglosci.length];
        int [] uporzadkowaneOdleglosci1 = new int[tablicaOdleglosci.length];
        Random r = new Random();
        int plus = 0;
        if(tablicaOdleglosci.length%2==1)
        {
            plus =1;
        }
       
        int [][] zbiorDrog = new int[tablicaOdleglosci.length+plus][tablicaOdleglosci.length+1];
        int [][] wygraneDrogi = new int[tablicaOdleglosci.length+plus][tablicaOdleglosci.length+1];
        int [] przepisanaNaChwile = new int[tablicaOdleglosci.length];
        int [] tablica01 = new int[tablicaOdleglosci.length+1];
        Random r01 = new Random();
        int aMutacja =0;
        int bMutacja =0;
        int [] najkrotsza = new int[tablicaOdleglosci.length+1];
        for (int i=0;i<tablicaOdleglosci.length;i++)
        {
            wylosowanyM = wylosowaneLiczby(tablicaOdleglosci);
            for (int j=0;j<tablicaOdleglosci.length+1;j++)
            {
           
            //System.out.print(wylosowanyM[j] + " ");
            zbiorDrog[i][j]=wylosowanyM[j];
            }
            //System.out.println("");
        }
       
        for (int i=0;i<uporzadkowaneOdleglosci.length;i++)
        {
            uporzadkowaneOdleglosci[i]=zbiorDrog[i][tablicaOdleglosci.length];
            uporzadkowaneOdleglosci1[i]=zbiorDrog[i][tablicaOdleglosci.length];
        }
       
        //System.out.println("moze zadziala");
        Arrays.sort(uporzadkowaneOdleglosci);
        Arrays.sort(uporzadkowaneOdleglosci1);
        for (int i=0;i<uporzadkowaneOdleglosci.length;i++)
        {
            uporzadkowaneOdleglosci[i]=uporzadkowaneOdleglosci[tablicaOdleglosci.length-1]-uporzadkowaneOdleglosci[i]+1;
        }
        for (int i=0;i<uporzadkowaneOdleglosci.length;i++)
        {
            if(i>0)
            {  
             uporzadkowaneOdleglosci[i]=uporzadkowaneOdleglosci[i]+uporzadkowaneOdleglosci[i-1];
            }
        }
        for (int i=0;i<uporzadkowaneOdleglosci.length;i++)
        {
            //System.out.println(uporzadkowaneOdleglosci[i]);
        }
        for (int i=0;i<uporzadkowaneOdleglosci.length;i++)
        {
           
            int d = r.nextInt(uporzadkowaneOdleglosci[tablicaOdleglosci.length-1]);
            for(int j=0;j<uporzadkowaneOdleglosci.length;j++)
            {
                if (d>uporzadkowaneOdleglosci[j])
                {
                   
                }
                else
                {
                    //System.out.println(uporzadkowaneOdleglosci[j]);
                    for (int p=0;p<tablicaOdleglosci.length;p++)
                    {
                        //System.out.println(uporzadkowaneOdleglosci1[j] + " " + zbiorDrog[p][tablicaOdleglosci.length]);
                        if(uporzadkowaneOdleglosci1[j] == zbiorDrog[p][tablicaOdleglosci.length])  
                        {
                            //System.out.println("Siema" + zbiorDrog[p][tablicaOdleglosci.length]);
                            for (int q=0;q<tablicaOdleglosci.length+1;q++)
                            {
                                wygraneDrogi[i][q]=zbiorDrog[p][q];
                            }
                        }
                       
                    }
                j=uporzadkowaneOdleglosci.length+1;
                }
            }
        }
 
        long t=0;
        while(t<5000)        
        {
        int ostatniaWygrana =0;  
        int minMin=0;
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        int f=0;
        int f1=0;
        int f2=0;
        int f3=0;
        int f4=0;
        int f5=0;
        int f6=0;
       
        int odlegloscA =0;
        int odlegloscB =0;
        int odlegloscC =0;
        int odlegloscD =0;
        int odlegloscE =0;
        int odlegloscF =0;
        int odlegloscF1 =0;
        int odlegloscF2 =0;
        int odlegloscF3 =0;
        int odlegloscF4 =0;
        int odlegloscF5 =0;
        int odlegloscF6 =0;
       
        for (int i=0;i<tablicaOdleglosci.length+plus;i++)
        {
           
            /*do
            {*/
            a = r.nextInt(tablicaOdleglosci.length);
            b = r.nextInt(tablicaOdleglosci.length);
            c = r.nextInt(tablicaOdleglosci.length);
            d = r.nextInt(tablicaOdleglosci.length);
            e = r.nextInt(tablicaOdleglosci.length);
            f = r.nextInt(tablicaOdleglosci.length);
            f1 = r.nextInt(tablicaOdleglosci.length);
            f2 = r.nextInt(tablicaOdleglosci.length);
            f3 = r.nextInt(tablicaOdleglosci.length);
            f4 = r.nextInt(tablicaOdleglosci.length);
            f5 = r.nextInt(tablicaOdleglosci.length);
            f6 = r.nextInt(tablicaOdleglosci.length);
            odlegloscA = zbiorDrog[a][tablicaOdleglosci.length];
            odlegloscB = zbiorDrog[b][tablicaOdleglosci.length];
            odlegloscC = zbiorDrog[c][tablicaOdleglosci.length];
            odlegloscD = zbiorDrog[d][tablicaOdleglosci.length];
            odlegloscE = zbiorDrog[e][tablicaOdleglosci.length];
            odlegloscF = zbiorDrog[f][tablicaOdleglosci.length];
            odlegloscF1 = zbiorDrog[f1][tablicaOdleglosci.length];
            odlegloscF2 = zbiorDrog[f2][tablicaOdleglosci.length];
            odlegloscF3 = zbiorDrog[f2][tablicaOdleglosci.length];
            odlegloscF4 = zbiorDrog[f2][tablicaOdleglosci.length];
            odlegloscF5 = zbiorDrog[f2][tablicaOdleglosci.length];
            odlegloscF6 = zbiorDrog[f2][tablicaOdleglosci.length];
            int min1 = Math.min(odlegloscA,odlegloscB);
            int min2 = Math.min(odlegloscC,odlegloscD);
            int min4 = Math.min(odlegloscE,odlegloscF);
            int min5 = Math.min(odlegloscF1,odlegloscF2);
            int min7 = Math.min(odlegloscF3,odlegloscF4);
            int min8 = Math.min(odlegloscF6,odlegloscF5);
            int min9 = Math.min(min5,min4);
            int min6 = Math.min(min8,min7);
            int min11 = Math.min(min9,min6);
            int min3 = Math.min(min11,min1);
            int min = Math.min(min3,min2);
            minMin=min;
            /*}while(ostatniaWygrana==minMin);
            ostatniaWygrana = minMin;*/
            if (minMin == odlegloscA)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[a][j];
                }
            }
            if (minMin == odlegloscB)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[b][j];
                }
            }
            if (minMin == odlegloscC)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[c][j];
                }
            }
            if (minMin == odlegloscD)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[d][j];
                }
            }
            if (minMin == odlegloscE)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[e][j];
                }
            }
            if (minMin == odlegloscF)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[f][j];
                }
            }
            if (minMin == odlegloscF1)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[f2][j];
                }
            }
            if (minMin == odlegloscF2)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[f1][j];
                }
            }
            if (minMin == odlegloscF3)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[f1][j];
                }
            }
            if (minMin == odlegloscF4)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[f1][j];
                }
            }
            if (minMin == odlegloscF5)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[f1][j];
                }
            }
            if (minMin == odlegloscF6)
            {
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {
                    wygraneDrogi[i][j]=zbiorDrog[f1][j];
                }
            }
        }
        
        for (int i=0;i<tablicaOdleglosci.length;i++)
        {
            for (int j=0;j<tablicaOdleglosci.length+1;j++)
            {
                zbiorDrog[i][j] = -1;               
            }
            
        }
        for (int i=0;i<tablicaOdleglosci.length+plus;i++)
        {
           
            if(i%2==0)
            {
               
                for (int x=0;x<tablicaOdleglosci.length;x++)
             {
                int h = r01.nextInt(15);
           
                if (h == 0)
                {
                tablica01[x] = 0;
                }
                else
                {
                tablica01[x] = 1;
                }
              }
                
            }
           
           
            for (int j=0;j<tablicaOdleglosci.length+1;j++)
            {
                if(tablica01[j] == 1)
                {
                        zbiorDrog[i][j] = wygraneDrogi[i][j];                      
                }
                
            }
           
            for (int j=0;j<tablicaOdleglosci.length;j++)
            {
                przepisanaNaChwile[j]=zbiorDrog[i][j];               
            }
           
            int dlaKtorejSzukamy = -1;
            boolean czyJuzWszystkie = false;
            while (czyJuzWszystkie == false)
            {
                
                for (int j=0;j<tablicaOdleglosci.length;j++)
                {                      
                    if(zbiorDrog[i][j] == -1)
                    {
                       
                       dlaKtorejSzukamy = j;
                       j = tablicaOdleglosci.length+1;
                       czyJuzWszystkie = false;
                    }
                    else
                    {
                        czyJuzWszystkie = true;
                    }                                       
                }
                
                if(dlaKtorejSzukamy != -1)
                {
                     if(i%2==0)
                    {
                         
                        for(int j=0;j<tablicaOdleglosci.length;j++)
                        {                            
                            int czySieNiePowtarza = 0;
                            int p = wygraneDrogi[i+1][j];
                            for(int k=0;k<tablicaOdleglosci.length;k++)
                            {                                  
                                if (przepisanaNaChwile[k] != p)
                                {
                                   
                                    czySieNiePowtarza++;                                    
                                }
                                if (tablicaOdleglosci.length == czySieNiePowtarza)
                                {    
                                    zbiorDrog[i][dlaKtorejSzukamy] = p;
                                    przepisanaNaChwile[dlaKtorejSzukamy]=p;
                                    j=tablicaOdleglosci.length+1;
                                    k=tablicaOdleglosci.length+1;
                                }
                            }
                        }
                    }
                    if(i%2==1)
                    {
                        for(int j=0;j<tablicaOdleglosci.length;j++)
                        {                            
                            int czySieNiePowtarza = 0;
                            int p = wygraneDrogi[i-1][j];
                            for(int k=0;k<tablicaOdleglosci.length;k++)
                            {                                  
                                if (przepisanaNaChwile[k] != p)
                                {
                                   
                                    czySieNiePowtarza++;                                                                      
                                }
                               
                                if (tablicaOdleglosci.length == czySieNiePowtarza)
                                {                                    
                                    zbiorDrog[i][dlaKtorejSzukamy] = p;
                                    przepisanaNaChwile[dlaKtorejSzukamy]=p;
                                    j=tablicaOdleglosci.length+1;
                                    k=tablicaOdleglosci.length+1;
                                }
                            }
                        }
                    }
                }
            }
        }
      for (int i=0;i<tablicaOdleglosci.length+plus;i++)
        {    
            int snm = r.nextInt(60);
            if (snm ==0)
            {
            aMutacja =0;
            bMutacja =0;
            while (aMutacja == bMutacja)
            {
            aMutacja = r.nextInt(tablicaOdleglosci.length);            
            bMutacja = r.nextInt(tablicaOdleglosci.length);
            if (aMutacja<bMutacja)
            {
                int xx = bMutacja;
                bMutacja=aMutacja;
                aMutacja=xx;
            }          
          
            }
            int temp = 0;
 
            while(bMutacja < aMutacja)
            {
                temp = zbiorDrog[i][bMutacja];
                zbiorDrog[i][bMutacja] = zbiorDrog[i][aMutacja];
                zbiorDrog[i][aMutacja] = temp;
                bMutacja++;
                aMutacja--;
            }
            }                            
        }
       
        for (int i=0;i<tablicaOdleglosci.length+plus;i++)
        {
            int sumaPoMutacji =0;
            int k =0;
           
            for (int j=0;j<tablicaOdleglosci.length;j++)
            {
                if(j == 0)
                {
                k = zbiorDrog[i][tablicaOdleglosci.length-1];  
                }
                else
                {
                k = zbiorDrog[i][j-1];
                }
                int p = zbiorDrog[i][j];
                sumaPoMutacji += tablicaOdleglosci[k][p];
             
            }
            zbiorDrog[i][tablicaOdleglosci.length] = sumaPoMutacji;
           
        }
       
        for (int i=0;i<tablicaOdleglosci.length+plus;i++)
        {
 
                for (int j=0;j<tablicaOdleglosci.length+1;j++)
                {    
                    wygraneDrogi[i][tablicaOdleglosci.length] = zbiorDrog[i][tablicaOdleglosci.length];                    
                }                                
            if (wygraneDrogi[i][tablicaOdleglosci.length] < najmniejsza)
            {
                najmniejsza = wygraneDrogi[i][tablicaOdleglosci.length];
                for (int j=0;j<tablicaOdleglosci.length+1;j++)            
                {
                    najkrotsza[j] = wygraneDrogi[i][j];
                }
            }        
        }
        t++;
        }
        System.out.println("Ostatnie");
        for (int i=0;i<tablicaOdleglosci.length+plus;i++)
        {
            for (int j=0;j<tablicaOdleglosci.length+1;j++)
            {              
             
                wygraneDrogi[i][j] =zbiorDrog[i][j];               
            }
           
          
        }
        PrintWriter zapisz = new PrintWriter("R:\\spr.txt");
        System.out.println("Najkrotsza trasa");
        for (int i=0;i<tablicaOdleglosci.length+1;i++)
        {            
            
          zapisz.print(najkrotsza[i]);

            if(i < tablicaOdleglosci.length-1) 
            {
                 zapisz.print("-");
            }
            else
            {
              zapisz.print(" ");
            }
          System.out.print(najkrotsza[i] + " ");  
        }
        zapisz.close();       
     }
}