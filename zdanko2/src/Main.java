import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int liczba = 1;
        int suma = 0;
        int sumaParz = 0;
        int sumaNiepar = 0;
        int licznik1 = 0;
        int licznik2 = 0;
        while ( liczba != 0){
            liczba = in.nextInt();
            suma +=liczba;

            if(liczba % 2 == 0 && liczba != 0){
                sumaParz += liczba;
                licznik1++;
            } else
            if (liczba % 2 != 0 )
            {
                sumaNiepar += liczba;
                licznik2++;
            }

        }
        int sredniaParz = sumaParz / licznik1;
        int sredniaNieparz = sumaNiepar / licznik2;

        System.out.println("Stosunek liczb parzystych do nieparzystych wynosi : " + sredniaParz + ":" +sredniaNieparz );

    }
}
