package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int[] tab = new int[100];
        int licznikParz = 0;
        int licznikNieparz = 0;
        int sumaParz  = 0;
        int sumaNieparz = 0;
        int najwieksza1 = 0;
        int najwieksza2 = 0;
        int najwieksza3 = 0;
        for (int i = 0; i < tab.length; i++) {
            tab[i] = r.nextInt(201) - 100;

            if((tab[i]<najwieksza1)&&(najwieksza2<=najwieksza1)){
                if(tab[i]>najwieksza2)
                   najwieksza2=tab[i];
            }
            if(tab[i]>najwieksza1){
                najwieksza1 = tab[i];
            }
            if((tab[i]<najwieksza2)&&(najwieksza3<=najwieksza2)){
                if(tab[i]>najwieksza3)
                    najwieksza3=tab[i];
            }


            if ( tab[i] % 2 == 0 && tab[i] > 0)
            {
                licznikParz++;
                sumaParz += tab[i];
            }
            else if ( tab[i] % 2 != 0 && tab[i] > 0)
            {
                licznikNieparz++;
                sumaNieparz += tab[i];
            }

        }

        System.out.println("Stosunek liczb parzystych do nieparzystych wynosi : " + (sumaParz/licznikParz) +":"+ (sumaNieparz/licznikNieparz));
        System.out.println("Najwieksza wylosowana liczba to :" + najwieksza1);
        System.out.println("2ga Najwieksza wylosowana liczba to :" + najwieksza2);
        System.out.println("3cia Najwieksza wylosowana liczba to :" + najwieksza3);


        }
    }

