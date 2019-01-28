import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą");
        float stopien = in.nextFloat();
        float zmiana = (stopien * 1.8f) + 32f;
        if (stopien < 0)
        {
            System.out.println(zmiana + "st.F,zimno");
        }
        if ( stopien > 0 && stopien > 10)
        {
            System.out.println(zmiana + "st.F,chłodno");

        }
        if ( stopien > 25 && stopien >= 10)
        {
            System.out.println(zmiana + "st.F,ciepło");

        }
        if (stopien <= 25)
        {
            System.out.println(zmiana + "st.F,gorąco");

        }
        System.out.println((stopien * 1.8) + 32 + " stopni Fahrenheita");



    }
}
