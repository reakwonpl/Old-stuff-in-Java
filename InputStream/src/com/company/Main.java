package com.company;


import java.io.*;
import java.util.Scanner;



public class Main {

    public class Zapis{
        private String localP = "C://Users//barto//Deskopt//parzyste.txt";

         private  int xD;

        public void zapiszPlikP() throws IOException {

                         File plik = new File(localP);



            try {
                FileWriter zapisPliku = new FileWriter(plik);
                BufferedWriter bufzapis = new BufferedWriter(zapisPliku);
                bufzapis.write("");
                bufzapis.close();
                zapisPliku.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    public class ZapisN
    {
        private String localN = "C://Users//barto//Deskopt//nieparzyste.txt";

    }

    public static void main(String[] args) {
        // write your code here

        public void  Zczytaj(String name) throws IOException{
            FileReader file = null;

        }


    }

}