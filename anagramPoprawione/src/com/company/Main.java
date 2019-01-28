package com.company;

import java.util.Arrays;

public class Main {

    public static boolean anagram(String a ,String b)
    {
        char[] aa = a.replaceAll("\\s+","").toCharArray();
        char[] bb = b.replaceAll("\\s+","").toCharArray();

        for (int i = 0;i < aa.length;i++)
        {
                int znak = aa[i];
                if (znak >= 60 && znak <= 90)
                {
                    aa[i] += 32;
                }
        }

        for (int j = 0; j < bb.length;j++)
        {
            int znak = bb[j];
            if (znak >= 60 && znak <= 90)
            {
                bb[j] += 32;
            }
        }

        if (aa.length != aa.length)
        {
            System.out.print("");
        }
        else
        {
            Arrays.sort(aa);
            Arrays.sort(bb);
        }

        boolean x = Arrays.equals(aa,bb);
            System.out.println(x);
                return x;

    }

    public static void main(String[] args)
    {
        anagram("trawa","warta");
    }
}
