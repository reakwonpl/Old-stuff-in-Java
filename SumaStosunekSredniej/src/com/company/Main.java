package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x, suma;
        System.out.println("Podaj liczbe");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        suma = 0;
        while (x != 0)
        {
            suma += x%10;
            x /= 10;
        }
        System.out.println("Suma wynosi:" + suma);
    }
}
