package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int x = in.nextInt();

        System.out.println("Dzielniki liczby: "+ x + " to: ");
        for (int i = 1;i <= x ; i++){
            if(x % i == 0){
                System.out.println(i);
            }
        }

    }
}
