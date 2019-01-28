package com.company;

/**
 * Created by barto on 17.06.2017.
 */
public class Pracownik extends PensjaMinimalna {

    private String imie;
    private String nazwisko;
    private int wiek;
    private  byte stazPracy;
    private  String prac;
    private  double pensja;

    public Pracownik() //konstruktor bezargumentowy domyslny
    {
        this.pensjaMinimalna += 50.d;
        this.pensja = pensjaMinimalna;
    }

    //konstruktor domyslny 4 parametory
    public  Pracownik (String Imie,String Nazwisko,int Wiek,Byte StazPracy)
    {
        this.imie = Imie;
        this.nazwisko = Nazwisko;
        this.wiek = Wiek;
        this.stazPracy = StazPracy;
        this.pensjaMinimalna += 50.d;
        this.pensja = pensjaMinimalna;
    }

    //konstruktor kopiujacy
    public Pracownik ( Pracownik pracownik){
        imie = pracownik.imie;
        nazwisko = pracownik.nazwisko;
        wiek = pracownik.wiek;
        stazPracy = pracownik.stazPracy;
        this.pensjaMinimalna += 50.d;
        this.pensja = pensjaMinimalna;
    }

    public  String getImie(){
        return this.imie;
    }
    public String getNazwisko(){
        return  this.nazwisko;
    }
    public int getWiek(){
        return  this.wiek;
    }
    public byte getStazPracy(){
        return  this.stazPracy;
    }
    public double getPensja(){
        return this.pensja;
    }
}
