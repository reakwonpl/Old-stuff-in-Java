package com.company;

public class Main {

    static Pracownik[] pracownicy = new Pracownik[5];

    public static void main(String[] args) {
	// write your code here

        pracownicy[0] = new Pracownik("Jan", "Kowol", 35, (byte)2);
        pracownicy[1] = new Pracownik(pracownicy[0]);
        pracownicy[2] = new Pracownik("Mateusz", "Robak", 37, (byte)27);
        pracownicy[3] = new Pracownik("Janóż", "Tyłyżka", 12, (byte)9);
        pracownicy[4] = new Pracownik("Anna", "Wanna", 23, (byte)8);

        System.out.println(pracownicy[0].getPensja());
        System.out.println(pracownicy[1].getPensja());
        System.out.println(pracownicy[2].getPensja());
        System.out.println(pracownicy[3].getPensja());
        System.out.println(pracownicy[4].getPensja());

        System.out.println("Średnia: " + Pracownik.sredniaPensja(pracownicy));
    }
}
