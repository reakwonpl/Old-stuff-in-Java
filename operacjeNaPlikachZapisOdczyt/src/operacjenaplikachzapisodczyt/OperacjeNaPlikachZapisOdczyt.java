/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacjenaplikachzapisodczyt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author barto
 */
public class OperacjeNaPlikachZapisOdczyt {

    
    public static void main(String[] args) throws IOException {
        List<Osoba>listaOsob = new ArrayList<Osoba>();
        Osoba osoba = new Osoba();
        osoba.setImie("Jan");
        osoba.setNaziwsko("Andrzejewski");
        osoba.setPlec("Kobieta");
        
        listaOsob.add(osoba);
        
        osoba = new Osoba();
        osoba.setImie("Sylwia");
        osoba.setNaziwsko("Zbuzidoust");
        osoba.setPlec("Kobieta");
        
        listaOsob.add(osoba);
        
        osoba = new Osoba();
        osoba.setImie("Irek");
        osoba.setNaziwsko("Kutaziewicz");
        osoba.setPlec("Mezczyna");
        
        listaOsob.add(osoba);
        
        OperacjeNaPlikachZapisOdczyt xd = new OperacjeNaPlikachZapisOdczyt();
        System.out.println("zapis");
        xd.zapiszObiekt(listaOsob);
       System.out.println("------------------------------");
       
        System.out.println("Odczyt");
       List<Osoba>listaOsobOdczyt = new ArrayList<Osoba>();
       listaOsobOdczyt = (List<Osoba>) xd.odczytObiekt();
       for (int x = 0; x < listaOsobOdczyt.size();x++)
       {
           System.out.println(listaOsobOdczyt.get(x).getImie());
           System.out.println(listaOsobOdczyt.get(x).getNaziwsko());
           System.out.println(listaOsobOdczyt.get(x).getPlec());

       }

        
    }
    
    public void zapiszObiekt(Object obj)
    {
        File file = new File("osoby.txt");
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        
        try 
        {
           fileOut = new FileOutputStream(file);
           out = new ObjectOutputStream(fileOut);
           out.writeObject(obj);
           out.close();
           
        }
        
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public Object odczytObiekt() throws IOException
    {
        Object obj = new Object();
        
        File file = new File("osoby.txt");
        ObjectInputStream in = null;
        try {
           
            in = new ObjectInputStream(new FileInputStream(file));
            
            obj = in.readObject();
            in.close();
        }
        
        //odzielamy dwa wyjątki |
        catch(IOException | ClassNotFoundException ex )
        {
            ex.printStackTrace();
        }
        
        return obj;
    }
    
}
