import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Siemanko!");

        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbe ziomek");
        int a = in.nextInt();
        if (pierwsza.czyPierwsza(a)){
            System.out.println("Jest to liczba pierwsza");
        } else System.out.println("Nie jest to liczba pierwsza");

/*
2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, itd.
 */
    }
}
