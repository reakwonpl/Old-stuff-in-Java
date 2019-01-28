package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void zapisz(String name) throws IOException{
        FileWriter file = null;
        Random r = new Random();
        int sizeN = 5;
        try{
            file = new FileWriter(name,false);
            for (int i = 0; i < sizeN ; i++){
                for (int j = 0; j <sizeN; j++){
                    file.write(r.nextInt(10) + " ");
                }
                file.write("\r\n");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (file != null){
                file.close();
            }
        }

    }

    public static void zad2(String name) throws  IOException{
    Scanner file = null;
    String txt = " ";

    file = new Scanner(new FileReader(name));
     while (file.hasNextInt())
     {
         int i = file.nextInt();
         if (i % 2 == 0){
             txt += i + " ";
         }

        }
        System.out.println("Liczby parzyste:");
        for ( int i = txt.length() -1 ; i >= 0; i--){
            System.out.print(txt.charAt(i));
        }
    }

    public static void main(String[] args) throws IOException{
	// write your code here
        String name = "zad2.txt";

        zapisz(name);
        zad2(name);
    }
}
