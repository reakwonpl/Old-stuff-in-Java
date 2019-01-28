import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Random r = new Random();
        int a = r.nextInt(151)-50;
        int b;
        int liczba1 = 0;
        int liczba2 = 0;
        int sumaParz = 1;
        int ilicz = 0;
        int ilicz2 = 0;
        int suma = 0;
        while ( a!= 0)
        {
          a = r.nextInt(151)-50;
          ilicz++;

          if ( a < liczba1 && liczba2 <= liczba1)
          {
              if (a > liczba2)
              {
                  liczba2 = a;
              }

          }
          if (a > liczba1){
              liczba1 = a;
          }

           if (a % 2 == 0 &&  a > 0 )
           {
               sumaParz *= a;
           }

        }
        System.out.println();
        for (int i = 0; i < ilicz;i++){
            b = r.nextInt(25)-25;
            System.out.println(b + " ");
            ilicz2++;
            if ((ilicz2 % 2 == 0)&& (ilicz2 != 0)){
                suma += b;
            }
        }





        System.out.println("Iloczyn parzystych dodatnich " + sumaParz);
        System.out.println("Najwieksza " + liczba1);
        System.out.println("Druga najwieksza " + liczba2);
        System.out.println("Suma " + suma);


    }
}
