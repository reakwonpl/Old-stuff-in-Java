package com.company;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.ArrayList;

public class Main {

    public static String[] split2(String str, String[] tStr)
    {
        ArrayList<String> results = new ArrayList<>();

        String temp = str;

        if(tStr.length == 1) {
            return str.split(tStr[0]);
        }
        else {

            for(int i = 0; i < tStr.length; i++)
            {
                int begin = 0;
                int end;

                while( (end = temp.indexOf(tStr[i], begin)) != -1)
                {
                    results.add(temp.substring(begin, end));
                    temp = temp.substring(end + tStr[i].length(), temp.length() - 1);
                    //begin = end + tStr[i].length();

                }
                results.add(temp);
                temp = str;
            }

            String[] endResult = new String[results.size()];

            for(int i = 0; i < endResult.length; i++)
            {
                endResult[i] = results.get(i);
            }

            return endResult;
        }
    }

    public static void main(String[] args) {

        String test[] = split2("alicja ma kota o imieniu Bartek. Kot ten nie nawidził slonca, alica za to uwielka slonce.",new String[] {"kot", "al", "Bartek"});
        //String test[] = split2("alicja ma kota o imieniu Bartek. Kot ten nie nawidził slonca, alica za to uwielka slonce.",new String[] {"al"});

        for (String tekst: test) {
            System.out.println(tekst);
        }

    }
}