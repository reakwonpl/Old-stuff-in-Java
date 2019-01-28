package com.company;

public class Main {

    public static int liczenie (String[][] tNapis,String napis ,int a)
    {
        int licznik = 0;
        int srednia = 0;
        String tekst = "";

        for (int i = 0; i < tNapis.length;i++){
            for (int j = 0;j < tNapis.length;j++){
                  if((i*j)%5 == 0 && (i*j)%a!= 0)
                {
                   tekst += tNapis[i][j].substring(0,3);
                   System.out.println(tekst);
                }
                String tekst2[] = tNapis[i][j].split(" ");

                  for (int k= 0;k < tekst2.length;k++){
                      if (tekst2[k].equals(napis)){
                          licznik++;
                      }
                  }
                  srednia += tNapis[i][j].length();
            }
        }
        srednia /= 2*tNapis.length;
        System.out.println(licznik);
        System.out.println(srednia);
        return licznik;
    }

    public static void main(String[] args)
    {
        String[][] tab = new String[2][2];
        String slowo = "Andrzeju";
        String slowo1 = "nie denerwuj sie ";
        String slowo2 = "Andrzeju";
        String slowo3 = "xDDDDDDDDDDDDDDDDDDDDDDDD";

        tab[0][0] = slowo;
        tab[0][1] = slowo1;
        tab[1][0] = slowo2;
        tab[1][1] = slowo3;

        liczenie(tab, "Andrzeju", 2);
    }
}
