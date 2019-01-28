/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berlinga;

import java.io.*;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Random;

/**
 *
 * @author barto
 */
public class BerlinGA 
{

    //Displays    
    public static void displayArray(int [][] tab){
        for(int i = 0; i <tab.length;i++){
            for(int j = 0; j < tab.length;j++)
            {
              System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void displayArrays(int [][] tab){
        for(int i = 0; i <tab.length;i++){
            for(int j = 0; j < tab[i].length;j++)
            {
              System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void displayOneDimensionArray(int[] tab)
    {
        for(int i = 0; i < tab.length;i++)
        {
         System.out.print(tab[i] + " ");    
        }
        System.out.println();
    }
    
    //ReadFile    
    public static int[][] writeToArray(String name) throws FileNotFoundException, IOException
    {
        BufferedReader file = null;
        int[][] array = null;
        
        try
        {
            file= new BufferedReader(new FileReader(name));
            String line = file.readLine();
            if(line != null){
                int size = Integer.parseInt(line);
                array = new int[size][size];
                
                String [] rowArray = null;
                int value = 0;
                line = file.readLine();
                
                for(int i = 0; i < array.length;i++){
                    rowArray = line.split(" ");
                    for(int j = 0;j < rowArray.length;j++)
                    {
                        value = Integer.parseInt(rowArray[j]);
                        array[j][i] = value;
                        array[i][j] = value;
                    }
                    line = file.readLine();
                }
            }
        }
        finally {
            if(file != null){
                file.close();
            }
        }
        return array;
    }
    //GA
    
    public static int[] makeSpecies(int[][] array)
    {
        int distance;
        int sumDistance;
        int variable;
        int nReapater = 0;
        int[][] distanceArray = array;
        int[] specimen = new int[distanceArray.length];
        int[] chosenSpecimens = new int[distanceArray.length +1];
        
        Random rnd = new Random();
        int x = rnd.nextInt(distanceArray.length - 1)+1;
        
        distance = distanceArray[0][x];
        sumDistance = distance;
        variable = x;
        specimen[0] = distance;
        chosenSpecimens[0] = x;       
        int y = x;
        boolean theSame = false;
        for(int i = 0; i < distanceArray.length - 2;i++)
        {
            theSame = false;
            y = x;
            while(theSame == false)
            {
                nReapater = 0;
                y = rnd.nextInt(distanceArray.length - 1)+1;
                
                for(int j = 0; j < chosenSpecimens.length -1;j++)
                {
                        
                    if(chosenSpecimens[j] != y)
                    {
                          nReapater++;
                    }
                    if(chosenSpecimens.length -1 == nReapater)
                    {
                        theSame = true;
                    }
                }
            }
            distance = distanceArray[variable][y];
            sumDistance += distance;
            variable = y;
            specimen[i+1] = distance;
            chosenSpecimens[i + 1] = y;
        }
          distance = distanceArray[0][y];
          sumDistance += distance;
          chosenSpecimens[chosenSpecimens.length -1] = sumDistance;
          
       return chosenSpecimens;
    }
    
    
    
    public static int[][] tournamentSelection(int[][] roads,int[][] arr,int[][] selectedRoads)
    {
       
        Random rnd = new Random();
        for(int i = 0; i < arr.length;i++)
       {
           
           int x = rnd.nextInt(arr.length);
           int y = rnd.nextInt(arr.length);
           int z = rnd.nextInt(arr.length);
           int w = rnd.nextInt(arr.length);
           int v = rnd.nextInt(arr.length);
           
           int distanceX = roads[x][arr.length];
           int distanceY = roads[y][arr.length];
           int distanceZ = roads[z][arr.length];
           int distanceW = roads[w][arr.length];
           int distanceV = roads[v][arr.length];
           
           int alleyOne = Math.min(distanceX,distanceY);
           int alleyTwo = Math.min(distanceZ,distanceW);
           int alleyThree = Math.min(distanceV,alleyOne);
           
           int alley = Math.min(alleyThree, alleyTwo);
           
           if(alley == distanceX)
           {
               for(int j = 0;j < arr.length +1;j++)
               {
                   selectedRoads[i][j] = roads[x][j];
               }
           }
           
           if(alley == distanceY)
           {
               for(int j = 0;j < arr.length +1;j++)
               {
                   selectedRoads[i][j] = roads[y][j];
               }
           }
           
           if(alley == distanceZ)
           {
               for(int j = 0;j < arr.length +1;j++)
               {
                   selectedRoads[i][j] = roads[z][j];
               }
           }
           
           if(alley == distanceW)
           {
               for(int j = 0;j < arr.length +1;j++)
               {
                   selectedRoads[i][j] = roads[w][j];
               }
           }
           
           if(alley == distanceV)
           {
               for(int j = 0;j < arr.length +1;j++)
               {
                   selectedRoads[i][j] = roads[v][j];
               }
           }
       }
       
       //System.out.println("Wybrane drogi po przez selekcje turniejową");
       //displayArrays(selectedRoads);
       //System.out.println();
       return selectedRoads;
    }
    
    public static int[][] rouletteWheel(int[][] arr,int[][] roads,int[][] selectedRoads)
    {
       int[] sortedArray = new int[arr.length];
       int[] anotherSortedArray = new int[arr.length];
       Random rnd = new Random();
           
        for (int i=0;i<sortedArray.length;i++)
        {
            sortedArray[i]=roads[i][arr.length];
            anotherSortedArray[i]=roads[i][arr.length];
        }
       
        //System.out.println("moze zadziala");
        Arrays.sort(sortedArray);
        Arrays.sort(anotherSortedArray);
        for (int i=0;i<sortedArray.length;i++)
        {
            sortedArray[i]=sortedArray[arr.length-1]-sortedArray[i]+1;
        }
        for (int i=0;i<sortedArray.length;i++)
        {
            if(i>0)
            {  
             sortedArray[i]=sortedArray[i]+sortedArray[i-1];
            }
        }
        for (int i=0;i<sortedArray.length;i++)
        {
            //System.out.println(sortedArray[i]);
        }
        for (int i=0;i<sortedArray.length;i++)
        {
           
            int x = rnd.nextInt(sortedArray[arr.length-1]);
            for(int j=0;j<sortedArray.length;j++)
            {
                if (x>sortedArray[j])
                {
                   
                }
                else
                {
                    //System.out.println(sortedArray[j]);
                    for (int p=0;p<arr.length;p++)
                    {
                        //System.out.println(anotherSortedArray[j] + " " + roads[p][arr.length]);
                        if(anotherSortedArray[j] == roads[p][arr.length])  
                        {
                            //System.out.println("Siema" + roads[p][arr.length]);
                            for (int q=0;q<arr.length+1;q++)
                            {
                                selectedRoads[i][q]=roads[p][q];
                            }
                        }
                       
                    }
                j=sortedArray.length+1;
                }
            }
        }
        return selectedRoads;
    }
    
    public static int[][] crossover(int[][] roads,int[][] arr,int[][] selectedRoads)
    {
        int[] temporaryArray = new int[arr.length];
       int[] zerone = new int[arr.length+1];
       Random rZerone = new Random();
       
       for(int i =0;i < arr.length;i++)
       {
           for(int j = 0; j < arr.length +1;j++)
           {
               roads[i][j] = -1;
               
           }
       }
      
       for(int i = 0; i < arr.length;i++)
       {
           //draw an array
           if(i % 2 == 0)
           { 
               for(int x = 0; x < arr.length;x++)
               {
                  
                   int number = rZerone.nextInt(25);
                   
                   if(number == 0)
                   {
                       zerone[x] = 0;
                   }
                   else 
                   {
                       zerone[x] = 1;
                   }
               }                               
           }
           
           for(int j = 0;j < arr.length+1;j++)
           {
               if(zerone[j] == 1)
               {
                   roads[i][j] = selectedRoads[i][j];
                }
               
           }
        
           
         for (int j=0;j<arr.length;j++)
            {
                temporaryArray[j]=roads[i][j];
            }
           
            int searched = -1;
            boolean all = false;
            while (!all)
            {                
                for (int j=0;j<arr.length;j++)
                {
                    
                    if(roads[i][j] == -1)
                    {                       
                       searched = j;
                       j = arr.length+1;
                       all = false;
                    }
                    else
                    {
                        all = true;
                    }                                    
                }
              
                if(searched != -1)
                {
                  if(i%2==0)
                    {                   
                        for(int x=0;x<arr.length;x++)
                        {                            
                            int repeater = 0;
                            int select = selectedRoads[i+1][x];
                            for(int y=0;y<arr.length;y++)
                            {                                  
                                if (temporaryArray[y] != select)
                                {                                   
                                    repeater++;                                    
                                }
                                if (temporaryArray.length == repeater)
                                {    
                                    roads[i][searched] = select;
                                    temporaryArray[searched]= select;
                                    x=arr.length+1;
                                    y=arr.length+1;
                                }
                            }
                        }
                    }
                    if(i%2==1)
                    {
                        for(int x=0;x<arr.length;x++)
                        {                            
                            int repeater = 0;
                            int select = selectedRoads[i-1][x];
                            for(int y=0;y<arr.length;y++)
                            {                                  
                                if (temporaryArray[y] != select)
                                {                                   
                                    repeater++;                                                                      
                                }
                               
                                if (arr.length == repeater)
                                {                                   
                                    roads[i][searched] = select;
                                    temporaryArray[searched]= select;
                                    x=arr.length+1;
                                    y=arr.length+1;
                                }
                            }
                        }
                    }
                }
            }
        }
       //System.out.println("Crossover COMPLETED");
      //displayArrays(roads);
       return roads;
    }
    public static  int[][] mutation(int[][] roads,int [][]arr)
    {
        Random rnd = new Random();
        for(int i = 0; i < arr.length;i++)
     {
         int mutationX = 1;
         int mutationY = 1;
         while(mutationX == mutationY)
         {
             mutationX = rnd.nextInt(arr.length);
             mutationY = rnd.nextInt(arr.length);
             if(mutationX < mutationY)
             {
                 int changer = mutationY;
                 mutationY = mutationX;
                 mutationX = changer;
             }
        }
         int temporary = 0;
         while(mutationY < mutationX)
         {
             temporary = roads[i][mutationY];
             roads[i][mutationY] = roads[i][mutationX];
             roads[i][mutationY] = temporary;
             mutationY++;
             mutationX--;
         }
     }
     int total  = 0;
     for(int i = 0; i < arr.length;i++)
     {
         total = 0;
         int x = 0;
         //int x = roads[i][arr.length -1];
         for(int j = 0;j<arr.length;j++)
         {
             
             if(j == 0)
             {
                 x = roads[i][arr.length -1];
             }
             else
             {
                x =roads[i][j-1]; 
             }
             int y = roads[i][j];
             total += arr[x][y];
         }
         roads[i][arr.length] = total;
     }
     //System.out.println("Mutation COMPLETED");
     //displayArrays(roads);
     return roads;
    }
    
    public static int[][] crossoverXmutation(int[][] arr,int[][] roads,int[][] selectedRoads,int optimal,int[] optimalArray)
    {
       int[] temporaryoraryArray = new int[arr.length];
       int[] zerone = new int[arr.length+1];
       Random rZerone = new Random();
       Random rnd = new Random();
       
        int checker = 0;
        if(arr.length % 2 == 1)
        {
            checker = 1;            
        }
       
       for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr.length+1;j++)
            {
                roads[i][j] = -1;               
            }
            
        }
        for (int i=0;i<arr.length+checker;i++)
        {
           
            if(i%2==0)
            {
               
                for (int x=0;x<arr.length;x++)
             {
                int randomPos = rZerone.nextInt(50);
           
                if (randomPos == 0)
                {
                zerone[x] = 0;
                }
                else
                {
                zerone[x] = 1;
                }
              }
                
            }
           
           
            for (int j=0;j<arr.length+1;j++)
            {
                if(zerone[j] == 1)
                {
                        roads[i][j] = selectedRoads[i][j];                      
                }
                
            }
           
            for (int j=0;j<arr.length;j++)
            {
                temporaryoraryArray[j]=roads[i][j];               
            }
           
            int searched = -1;
            boolean all = false;
            while (!all)
            {
                
                for (int j=0;j<arr.length;j++)
                {                      
                    if(roads[i][j] == -1)
                    {
                       
                       searched = j;
                       j = arr.length+1;
                       all = false;
                    }
                    else
                    {
                        all = true;
                    }                                       
                }
                
                if(searched != -1)
                {
                     if(i%2==0)
                    {
                         
                        for(int j=0;j<arr.length;j++)
                        {                            
                            int nRepeater = 0;
                            int p = selectedRoads[i+1][j];
                            for(int k=0;k<arr.length;k++)
                            {                                  
                                if (temporaryoraryArray[k] != p)
                                {
                                   
                                    nRepeater++;                                    
                                }
                                if (arr.length == nRepeater)
                                {    
                                    roads[i][searched] = p;
                                    temporaryoraryArray[searched]=p;
                                    j=arr.length+1;
                                    k=arr.length+1;
                                }
                            }
                        }
                    }
                    if(i%2==1)
                    {
                        for(int j=0;j<arr.length;j++)
                        {                            
                            int nRepeater = 0;
                            int p = selectedRoads[i-1][j];
                            for(int k=0;k<arr.length;k++)
                            {                                  
                                if (temporaryoraryArray[k] != p)
                                {
                                   
                                    nRepeater++;                                                                      
                                }
                               
                                if (arr.length == nRepeater)
                                {                                    
                                    roads[i][searched] = p;
                                    temporaryoraryArray[searched]=p;
                                    j=arr.length+1;
                                    k=arr.length+1;
                                }
                            }
                        }
                    }
                }
            }
        }
     
      for (int i=0;i<arr.length+checker;i++)
        {    
            int snm = rnd.nextInt(55);
            if (snm ==0)
            {
          int  mutationX =0;
           int mutationY =0;
            while (mutationX == mutationY)
            {
            mutationX = rnd.nextInt(arr.length);            
            mutationY = rnd.nextInt(arr.length);
            if (mutationX<mutationY)
            {
                int changer = mutationY;
                mutationY=mutationX;
                mutationX=changer;
            }          
          
            }
            int temporary = 0;
 
            while(mutationY < mutationX)
            {
                temporary = roads[i][mutationY];
                roads[i][mutationY] = roads[i][mutationX];
                roads[i][mutationX] = temporary;
                mutationY++;
                mutationX--;
            }
            }                            
        }
       
        for (int i=0;i<arr.length+checker;i++)
        {
            int total =0;
            int x =0;
           
            for (int j=0;j<arr.length;j++)
            {
                if(j == 0)
                {
                x = roads[i][arr.length-1];  
                }
                else
                {
                x = roads[i][j-1];
                }
                int y = roads[i][j];
                total += arr[x][y];
             
            }
            roads[i][arr.length] = total;
           
        }
       
        for (int i=0;i<arr.length+checker;i++)
        {
 
                for (int j=0;j<arr.length+1;j++)
                {    
                    selectedRoads[i][arr.length] = roads[i][arr.length];                    
                }                                
            if (selectedRoads[i][arr.length] < optimal)
            {
                optimal = selectedRoads[i][arr.length];
                for (int j=0;j<arr.length+1;j++)            
                {
                    optimalArray[j] = selectedRoads[i][j];
                }
            }        
        }
        return selectedRoads;
    }
    
    public static void main(String[] args) throws IOException 
    {
       int[][] arr = null;
       String fileName   = "R:\\berlin52.txt";
       arr = writeToArray(fileName);
       displayArrays(arr);
       
         int checker = 0;
        if(arr.length % 2 == 1)
        {
            checker = 1;            
        }
       
       int optimal = 500000;
        int[] chosenSpecimen = new int[arr.length];               
        int[][] roads = new int[arr.length][arr.length+1];
        int[][] selectedRoads = new int[arr.length][arr.length+1];
        int[] optimalArray = new int[arr.length+1];
        
         int iterationCount= 5000;
       
        for(int i =  0; i < arr.length;i++)
        {
            chosenSpecimen = makeSpecies(arr);
            
            for(int j = 0;j < arr.length +1;j++)
            {
                roads[i][j] = chosenSpecimen[j];
            }
        }
        displayOneDimensionArray(chosenSpecimen);
        //displayArrays(roads);
        /*
        
          while(iterationCount> 0)
         {
        //displayArrays(roads);
        tournamentSelection(roads,arr,selectedRoads);
        crossoverXmutation(arr,roads,selectedRoads,optimal,optimalArray);
        for (int i=0;i<arr.length;i++)
        {
             for(int j = 0; j < arr.length+1;j++)
             {
                 selectedRoads[i][arr.length] = roads[i][arr.length];
              }
             if(selectedRoads[i][arr.length]< optimal)
             {
                 optimal = selectedRoads[i][arr.length];
                 for(int j = 0; j < arr.length+1;j++)
                 { 
                     optimalArray[j] = selectedRoads[i][j];
                 }
             }
        }
       iterationCount--;
      }
        
        PrintWriter writeText = new PrintWriter("R:\\spr.txt");
        System.out.println("The most optimal solution : ");
        for (int i=0;i<arr.length+1;i++)
        {            
            
          writeText.print(optimalArray[i]);

            if(i < arr.length-1) 
            {
                 writeText.print("-");
            }
            else
            {
              writeText.print(" ");
            }
          System.out.print(optimalArray[i] + " ");  
        }
        writeText.close(); 
*/
    }
    
}
