package com.company;

/**
 * Created by barto on 17.06.2017.
 */
public class PensjaMinimalna {
    public static  double pensjaMinimalna = 2000.0;
    public static double sredniaPensja(Pracownik[] osoby){
        double srednia = 0.0d;
        int ileOs = osoby.length;
        for (Pracownik p : osoby){
            srednia += p.getPensja();
        }
        srednia /= ileOs;
        return  srednia;
    }
}
