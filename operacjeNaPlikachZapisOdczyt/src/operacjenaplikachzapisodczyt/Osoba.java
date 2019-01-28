package operacjenaplikachzapisodczyt;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barto
 */
public class Osoba implements Serializable{

    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @return the naziwsko
     */
    public String getNaziwsko() {
        return naziwsko;
    }

    /**
     * @param naziwsko the naziwsko to set
     */
    public void setNaziwsko(String naziwsko) {
        this.naziwsko = naziwsko;
    }

    /**
     * @return the plec
     */
    public String getPlec() {
        return plec;
    }

    /**
     * @param plec the plec to set
     */
    public void setPlec(String plec) {
        this.plec = plec;
    }
    
    private String imie;
    private String naziwsko;
    private String plec;
    
}
