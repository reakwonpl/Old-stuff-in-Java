/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseraf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author barto
 */
public class DatabaseRAF {

    
    public static void main(String[] args) 
    {
        //JTable
        JFrame frame = new JFrame("xD");
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Imie");
        model.addColumn("Nazwisko");
        model.addColumn("Wiek");
        
        table.setAutoCreateRowSorter(true);
        table.setCellSelectionEnabled(true);
        table.setSelectionBackground(Color.BLACK);
        table.setSelectionForeground(Color.WHITE);
        
        frame.add(new JScrollPane(table));
        
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
       RandomAccessFile file;
       Scanner sc = new Scanner(System.in);
       
       String name,surname;
       int age;
       System.out.println("Daj imie");
       name = sc.next().toLowerCase();
       System.out.println("Daj nazwisko");
       surname = sc.next().toLowerCase();
       System.out.println("Daj wiek");
       age = sc.nextInt();
       //zmienne do szukania
       String search = sc.next();
       boolean found = true;
       
       ///zapis rafem
       try {
           //sciezka
           file = new RandomAccessFile(new File("xd.txt"),"rw");
           //
           long fileSize = file.length();
           file.seek(fileSize);
           
           
           file.writeUTF(name);
           for (int i = 0; i < 20-name.length();i++){
               file.write(20);
           }
           file.writeUTF(surname);
           
           for (int i = 0; i < 20-surname.length();i++){
               file.write(20);
           }
           file.write(age);
          
           
           file.close();
           
           
       }
       catch(IOException e)
       {
       e.getStackTrace();    
       }
       //odczytRafem
              try 
              {
                  file = new RandomAccessFile(new File("xd.txt"),"rw");
                  long fileSize = file.length();
                  file.seek(0);
                  long NumRecords = fileSize/Record;
                  
                  for(int j = 0; j < NumRecords;j++)
                  {
                      name  = file.readUTF();
                      
                      for (int i = 0; i < 20 - name.length();i++)
                      {
                          file.readByte();
                      }
                      
                      surname  = file.readUTF();
                      
                      for (int i = 0; i < 20 - surname.length();i++)
                      {
                          file.readByte();
                      }
                      
                      age = file.readInt();
                     // System.out.println("Imie : " +name +"  Nazwisko : " + surname + "  Wiek : " + age);
                     
                     //Jtable pamietac o objectu!
                      model.addRow(new Object[]{name,surname,age});
                      
                      
                       //szukanie w rafie
                       if (search.equals(name))
                       {
                           System.out.println("Imie : " +name +"  Nazwisko : " + surname + "  Wiek : " + age);
                           //update,nadpisanie
                           file.seek(Record *j+44);
                           System.out.println("Wprowadz nowy wiek");
                           age = sc.nextInt();
                           file.writeInt(age);
                           
                           //usuwanie 
                           file.seek(j*Record);
                           file.setLength(fileSize -48);
                       }
                       else {
                           found = false;
                       }
                      
                      
                  }
                  file.close();
              }
              catch (IOException ex)
              {
                  ex.getStackTrace();
              }
              
      
       
       
              
    } 
    private static final int Record = 44;
}
