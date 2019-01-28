package com.company;

public class Main {

    public static void akronim(String s )
    {
    String[] tekst = s.split(" ");

    String akr = "";
    String kom = "";

        for (int i = 0;i <tekst.length;i++)
            {
                akr += tekst[i].charAt(0);
            }

        for (int j = 0; j < akr.length(); j++)
        {
            int znak = akr.charAt(j);
            if (znak >= 97 && znak <= 122)
            {
                znak -= 32;
            }
            kom += (char)znak;
        }
        System.out.println(kom);
    }


    public static void main(String[] args)
    {
        akronim("Rzeczpospolita Polska");
    }
}
