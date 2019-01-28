package com.company;

/*napisac funkcje przypisz(string nazwawe, stringwe, wy, string fraza) która przepisuje
dane z pliku  tekstowego (nazwy plków sa parametrami funkcji) :
-w parzystych wierszach pierwsze wystapienie frazy podanej jako 3 parametr, zamienia na fraze pisana duzymi literami(np fraza na FRAZA)
- W NIEPARZYstych wierszach wszystkie wielkie litery  zamienia na znak'm'
w koncu pliku nalezy dopisac wartosć odpowiadającą sredniej dlugosci linii, jesli plik wejsciowy nie
 istnieje nalezy w pliku wyjsciowym wpisac 	informacje brak pliku */


import java.io.*;


public class Main {

    //funkcja która tworzy nam plik
    static void stworz(String nazwaWe,String nazwaWy) throws IOException{
       // FileWriter fileIn = null;
       // FileWriter fileOut = null;

        BufferedWriter bw = null;
        BufferedWriter bww = null;


        try {
            //tworzymy nowego FW i zapisujemy frazy
            //fileIn = new FileWriter(nazwaWe);
           // fileOut = new FileWriter(nazwaWy);

            bw = new BufferedWriter(new FileWriter(nazwaWe));
            bww = new BufferedWriter(new FileWriter(nazwaWy));

            bw.write("Whose eyes are those eyes? \n");
            bw.write("Andrzej To Jebnie \n");
            bw.write("Cuj Ci Cirku \n");
            bw.write("O ty Chuju bobrze \n");
            bw.write("XDDDDDDDDDDDDD \n");
            bw.write("xDDDDDDD\n");

           /* fileIn.write("Whose eyes are those eyes? \n");
            fileIn.write("Andrzej To Jebnie \n");
            fileIn.write("Cuj Ci Cirku \n");
            fileIn.write("O ty Chuju bobrze \n");
            fileIn.write("XDDDDDDDDDDDDD \n");
            fileIn.write("xDDDDDDD\n"); */
        } catch (Exception e){
        System.out.println("hihihi");
        } finally {
            /*if (fileIn != null){
                fileIn.close();

            }
            if (fileOut != null){
                fileOut.close();
            } */

            if (bw != null){
                bw.close();
            }
            if (bww!= null){
                bww.close();
            }

        }
    }

    static void przepisz(String nazwaWe,String nazwaWy,String fraza) throws  IOException{

        BufferedReader br = null;
        BufferedWriter bw = null;

        int liczbaLini = 0;
        int dlugoscLini = 0;

        try {
            br = new BufferedReader(new FileReader(nazwaWy));
            bw = new BufferedWriter(new FileWriter(nazwaWe));


            String linia = "";
            boolean parzysta = false;
            while ((linia = br.readLine()) != null) {
                liczbaLini++;
                dlugoscLini += linia.length();
                parzysta = !parzysta;

                if (parzysta){
                    linia = linia.replace(fraza,fraza.toUpperCase());
                }
                else{
                    String tmp="";
                    for(int i=0;i<linia.length();i++)
                    {
                        if(linia.charAt(i) >= 'A' && linia.charAt(i) < 'Z')
                        {
                            tmp+="m";
                        }
                        else tmp+=linia.charAt(i);
                    }
                    linia = tmp;
                }

                bw.write(linia);
                bw.newLine();

            }
           bw.write(Float.toString((float) dlugoscLini/liczbaLini));


        }


        catch (FileNotFoundException e){
            bw.write("Brak pliku wejsciowego");
        }

        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            if (br!= null){
                br.close();
            }
            if (bw != null ){
                bw.close();
            }
        }
    }

                                                //pamietaj o throws
    public static void main(String[] args) throws IOException{
	// write your code here
        stworz("R:\\rkw.txt","R:\\rkw.txt");
        //przepisz("R:\\rkw.txt","R:\\rkw.txt","O kurwa Ja Pierdole");

    }
}
