package com.company;

public class Main {

    public static String[] split2(String s,char zn,char zn2)
    {
    int l = 0;
    for(int i = 0; i < s.length();i++)
        {
            if (s.charAt(i) == zn || s.charAt(i) == zn2)
            {
                l++;
            }
        }
        String[] tStr2 = new String[l+1];
        for (int i = 0; i < tStr2.length;tStr2[i++] ="")
        {
            l = 0;
        }
            for (int i = 0;i < s.length(); i++) {
                if (s.charAt(i) == zn || s.charAt(i) == zn2) {
                    l++;
                } else {
                    tStr2[l] += s.charAt(i);
                }
            }
        return  tStr2;

    }


    public static void main(String[] args)
    {
            String andrzej ="Ala ma kota dwa pistolety i 2 andrzeje";
            String[] andrzej2 = split2(andrzej,' ','_')      ;
            for ( int i = 0; i < andrzej2.length;i++)
            {
                System.out.println(andrzej2[i]);
            }
    }
}
