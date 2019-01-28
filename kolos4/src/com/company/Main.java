package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int tab2w[][] = new int[40][40];

        for (int i = 0; i < tab2w.length; i++) {
            for (int j = 0; j < tab2w.length; j++) {
                if (i % 2 == 0) {
                    tab2w[i][j] = i + j;
                } else
                    tab2w[i][j] = r.nextInt(101) - 50;
            }
        }
        for (int i = 0; i < tab2w.length; i++) {
            for (int j = 0; j < tab2w.length; j++) {
                tab2w[i] = tab2w[40 - i];

            }
        }
    }
}
