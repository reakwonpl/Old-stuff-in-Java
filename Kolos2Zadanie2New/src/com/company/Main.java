package com.company;

/*
Napisać funkcję przepisz(String nazwaWe, String nazwaWy, string fraza) która przepisuje dane z pliku tekstowego według zasad:
w parzystych wierszach pierwsze wystąpienie frazy (podanej jako trzeci parametr) zamienia na frazę pisaną dużymi literami
np fraza na FRAZA
w nieparzystych wierszach wszystkie wielkie litery zamienia na znak 'm'
na końcu pliku należy dopisać wartość odpowiadającą średniej długości lini. jeśli plk wejsciowy nie istnieje należy w pliku
wyjsciowym wpisac infomracje brak pliku wejsciowego
 */

import java.io.*;

public class Main {

    private static void przepisz(String nazwaWe, String nazwaWy, String fraza) throws IOException {
        boolean fileExist = new File(nazwaWe).isFile();
        String line;
        char[] lineChars;
        int sumCharacters = 0;
        int lineCounter = 0;
        LineNumberReader file = null;
        FileWriter writer = new FileWriter(nazwaWy);

            if (fileExist) {
            file = new LineNumberReader(new FileReader(nazwaWe));

            try {

                while ((line = file.readLine()) != null) {
                    lineCounter++;
                    lineChars = line.toCharArray();
                    sumCharacters += lineChars.length;
                    if (file.getLineNumber() % 2 == 0) {
                        line = line.replaceFirst(fraza, fraza.toUpperCase());
                        writer.write(line);

                    } else {
                        for (int i = 0; i <= lineChars.length - 1; i++) {
                            if (Character.isUpperCase(lineChars[i])) {
                                lineChars[i] = 'm';
                            }
                        }
                        writer.write(String.valueOf(lineChars));
                    }
                    writer.write("\n");
                }
            } catch (IOException exception) {
                writer.write(Float.toString((float) sumCharacters / lineCounter));
                file.close();
            }
        } else {
            writer.write("brak pliku wejsciowego");
        }
        writer.close();
    }



    public static void main(String[] args) throws IOException {
        try {

            przepisz("R:\\rkw.txt", "R:\\rkw.txt", "dom");
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
