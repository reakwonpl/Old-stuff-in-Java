package com.company;

public class Main {



    public static void main(String[] args) {
	// write your code here

        int a = 15;
        int b = 3;
       // int c = a+b++;
        //System.out.println(c);
        //System.out.println(b);
        int c = (a++)+b;
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
    }
}
