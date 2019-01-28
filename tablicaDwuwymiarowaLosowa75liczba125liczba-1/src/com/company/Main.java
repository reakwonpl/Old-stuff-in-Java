package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random los = new Random();
        int wielkosc = 1;
        while (wielkosc % 4 != 0) {
            wielkosc = los.nextInt(3) + 6;
        }
        System.out.println(wielkosc);


        int[][] tab = new int[wielkosc][wielkosc];

        Scanner in = new Scanner(System.in);
        System.out.println("Podaj dolną granice przedziału");
        int a = in.nextInt();
        System.out.println("Podaj górna granice przedziału");
        int b = in.nextInt();

        int licznik = 1;
        int licznik2 = 0;

        for (int i = 0; i < wielkosc; i++) {
            for (int j = 0; j < wielkosc; j++) {
                tab[i][j] = los.nextInt(b - a) + a;

                if (i == j || i + j == (wielkosc - 1)) {
                    licznik++;
                    if (licznik % 4 == 0) {
                        tab[i][j] = -1;
                    } else tab[i][j] = 1;
                }
                System.out.print(tab[i][j] + " | ");
                if ( i * j < tab[i][j])
                {
                    licznik2++;
                }
            }
            System.out.println();
        }
        System.out.println("Liczba komórek wynosi : " + licznik2);

    }
}
