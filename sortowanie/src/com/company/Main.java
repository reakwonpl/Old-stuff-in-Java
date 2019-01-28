package com.company;

import java.util.Arrays;

public class Main {

    public static  void sortuj(String s)
    {
        String[] tekst = s.split(" ");
        int x ;
        float sr = 0;

        for (int i = 0 ; i <tekst.length ; i++)
        {
            for (int j = 0; j < tekst[i].length();j++)
            {
                x = (int)tekst[i].charAt(j);
                if (x >= 65 && x <= 90)
                {
                    int y = x +32;
                    String tekst2 = tekst[i].replace(tekst[i].charAt(j),(char)y);
                    tekst[i] = tekst2;
                }
            }
            sr += tekst[i].length();
        }
        sr /= tekst.length;

        Arrays.sort(tekst);

        for (int i = 0; i < tekst.length;i++){
            System.out.println(tekst[i] + " ");
        }
        System.out.println(", " + sr);

    }


    public static void main(String[] args)
    {
        sortuj("Kiedy rano niespodzianie znów alina włacza pranie");
        sortuj("Tak było nie kłamie xd");
        sortuj("Ala ma kota i trzy psy do tego 14 mrowek i dwa konie");


    }
}
