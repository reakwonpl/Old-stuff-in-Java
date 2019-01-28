package com.company;


import java.util.Scanner;

public class Main {



    public static void main(String[] args)
    {
        System.out.println("Napisz cos a następnie podaj klucz");
        Scanner in = new Scanner(System.in);

        String tekst = in.nextLine();
        int klucz = in.nextInt();
        char x[] = tekst.toCharArray();
        for (int i = 0; i < x.length;i++)
        {
            if (x[i] >= 65 && x[i] <= 90)
            {
                int n = x[i];
                n += klucz;
                x[i] = (char) n;
            }

            if (x[i] >= 97 && x[i] <= 122)
            {
                int n = x[i];
                n += klucz;
                x[i] = (char) n;
            }


        }
        System.out.println(x);









    }
}
