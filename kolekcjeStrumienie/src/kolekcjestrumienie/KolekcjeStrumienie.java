/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcjestrumienie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author barto
 */
public class KolekcjeStrumienie {
    
    
    public static String inputStreamTest(){
        System.out.println("Wprowadz dowolny znak");
        try 
        {
            char c = (char) System.in.read();
            String str = c+"";
            return str;
        }
        catch(Exception e)
        {
           return "error";
        }
        
    }
    
    public static String bufferedReaderTest()
    {
        //to je to samo
        BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));
        //co to 
        //InputStreamReader inp = new InputStreamReader(System.in);
        //BufferedReader buffR = new BufferedReader(inp);
        System.out.println("Wprowadz linie tekstu");
        try 
        {
          return brIn.readLine();
           
        }
        catch (Exception x)
        {
            return "-1";
        }
        
    }
    public static String streamTokenTest()
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("dawaj liczbe");
        try { 
             st.nextToken();
             if (st.ttype == StreamTokenizer.TT_NUMBER)
                 return st.toString();
             else 
                 return "-1";
        }
        catch(Exception e ){
          
            return "-1";
            
        }
    }
    
    
    
    
    //zapis do txt
    public static void saveText(String text){
        try {
            File file = new File("C:\\Users\\barto\\Desktop\\text.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
            
            
        }
        catch(Exception e )
        {
            System.out.println("blond jakis jezd");
        }
    }
    
  
    public static void main(String[] args) {
        
        System.out.println(streamTokenTest());
        System.out.println(bufferedReaderTest());
        System.out.println(inputStreamTest());
        saveText("Ala ma kota");
        
        
        //kolekcje
        
        List<String> aList = new ArrayList<String>(32);
        
        List<String> iList = new LinkedList<String>();
        
        aList.add("kotek");
        iList.add("piesek");
        
    
    }
    
}
