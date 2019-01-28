package com.company;

public class Main {

    public static void firtstlast(String s,char c){
        int a = 0;
        int b = 0;
        String tekst ="";

        for (int i = 0; i < s.length();i++)
        {
            if (s.charAt(i) == c){
                a = i + 1;
                break;
            }
        }

        for (int j = s.length() - 1; j > 0;j--)
        {
            if(s.charAt(j)== c){
                b = j +1;
                break;
            }
        }

        for (int k = a; k < b - 1;k++){
            tekst += s.charAt(k);
        }

        System.out.println("Odleglosc wynosi :" + ( b - a - 1));
        System.out.println("Tekst : " + tekst);

    }

    public static void main(String[] args)
    {
            String napis  = "jasdjabsdubaasduasudbjjauj";
            char c = 'j';

            firtstlast(napis,c);
            firtstlast("andrzejuaaaa",'a');

    }
}
