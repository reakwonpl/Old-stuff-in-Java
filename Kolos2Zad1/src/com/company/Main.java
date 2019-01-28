package com.company;

/*
Dany jest plik, w którym zapisano (w postaci wewnętrnej) kolejne trójki danych tworzące informacje o przedmiotach
String nazwa;
int semestr;
int ects;
float ocena;
napisać funkcję zwiększającą (bezpośrednio w pliku, bez wczytywania całego pliku do pamięci)
liczbę punktów ects o liczbę odpowiadającą semestrowi,ale tylko w przypadku jeśli ocena jes mniejsza niż 3.0 Dodatkowo funkcja ma
 zwracać średnią ocen wszystkich przedmiotów zapisanych w pliku
 */


import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
        saveExample("R:\\rkw.txt");
        System.out.println(countAverage("R:\\rkw.txt"));
    }

    private static float countAverage(String filePath) throws IOException {
        int semestr;
        int ects;
        float ocena;
        long filePointer;
        long filePointer2;
        float sum = 0;
        int counter = 0;
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(filePath, "rw");

            while (true) {
                file.readUTF();
                semestr = file.readInt();
                filePointer = file.getFilePointer();
                ects = file.readInt();
                ocena = file.readFloat();
                filePointer2 = file.getFilePointer();
                if (ocena < 3.0f) {
                    file.seek(filePointer);
                    file.writeInt(ects + semestr);
                    file.seek(filePointer2);
                }
                counter++;
                sum += ocena;
            }


        } catch (IOException exception) {
            file.close();
            return sum / counter;

        }


    }


    private static void saveExample(String filePath) throws IOException {
        RandomAccessFile write = new RandomAccessFile(filePath, "rw");

        write.writeUTF("Przedmiot1");
        write.writeInt(1);
        write.writeInt(3);
        write.writeFloat(3.0f);

        write.writeUTF("Przedmiot2");
        write.writeInt(2);
        write.writeInt(1);
        write.writeFloat(2.0f);

        write.writeUTF("Przedmiot4");
        write.writeInt(3);
        write.writeInt(4);
        write.writeFloat(4.2f);

        write.writeUTF("Przedmiot3");
        write.writeInt(3);
        write.writeInt(2);
        write.writeFloat(4.5f);

        write.writeUTF("Przedmiot5");
        write.writeInt(5);
        write.writeInt(3);
        write.writeFloat(2.9f);

    }
}
