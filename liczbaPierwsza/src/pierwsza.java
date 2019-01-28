/**
 * Created by barto on 22.03.2017.
 */
public class pierwsza {

    public static  boolean czyPierwsza(int liczba)
    {
        for (int i = 2; i <= liczba/2 ; i++){
            if (liczba % i == 0){
                return  false;
            }
        }
        return true;
    }
}
