/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebinarystreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author barto
 */
public class ReadWriteBinaryStreams {

       public static void main(String[] args) 
       {
           Customer[] customers = getCustomers();
           DataOutputStream custOutput = createFile("R:\\rkw.dat");
           
           for (Customer person : customers){
               createCustomers(person,custOutput);
           }
           
           try
           {
               custOutput.close();
           }
           catch(IOException e){
               System.out.println("Cos nie pyklo kajs");
               System.exit(0);
           }
           getFileInfo();
        
    }

    
       private static class Customer
       {
           public String custName;
           public int custAge;
           public double custDeb;
           public boolean oweMoney;
           public char custSex;
           
           public Customer(String custName, int custAge,double custDeb,boolean oweMoney,char custSex)
           {
               this.custName = custName;
               this.custAge = custAge;
               this.custDeb = custDeb;
               this.oweMoney = oweMoney;
               this.custSex = custSex;
           }
       }
       private static Customer[] getCustomers()
       {
           Customer[] customers = new Customer[3];
           customers[0] = new Customer("Balakie",21,2000,true,'M');
           customers[0] = new Customer("Jayqualin",24,70000,true,'K');
           customers[0] = new Customer("Teykwanda",19,0,false,'K');
           return customers;
       }
       
       private static DataOutputStream createFile(String fileName)
       {
           try
           {
               File listOfNames = new File(fileName);
               DataOutputStream infoToWrite = new DataOutputStream(
               new BufferedOutputStream(new FileOutputStream(listOfNames)));
               return infoToWrite;
           }
           catch(IOException ex)
           {
               ex.getStackTrace();
           }
           return null;
       }
       
       private static void createCustomers(Customer customer,DataOutputStream custOutput)
       {
           try{
               custOutput.writeUTF(customer.custName);
               custOutput.write(customer.custAge);
               custOutput.writeDouble(customer.custDeb);
               custOutput.writeBoolean(customer.oweMoney);
               custOutput.writeChar(customer.custSex);
                            
           }
           catch(FileNotFoundException e)
           {
               System.out.println("File Not Found xD");
           }
           catch(IOException e)
           {
               System.out.println("Panie cos sie odjebalo i njedziala");
               e.getStackTrace();
           }
       }
    private static void getFileInfo()
    {
        System.out.println("Czytam pliczek");
        File listOfNames = new File("R:\\rkw.dat");
        boolean eof = false;
        
        try{
            DataInputStream getInfo = new DataInputStream(
            new BufferedInputStream(new FileInputStream(listOfNames)));
            
            while(!eof)
            {
                String custName = getInfo.readUTF();
                int custAge = getInfo.readInt();
                double custDebt = getInfo.readDouble();
                boolean oweMoney = getInfo.readBoolean();
                char custSex = getInfo.readChar();
                
                System.out.println(custName);
              System.out.println(custAge);
             System.out.println(custDebt);
            System.out.println(oweMoney);                
          System.out.println(custSex);


            }
    }
        catch(EOFException ex)
        {
            eof = true;
            System.out.println("Koniec pliku here");
        }
        catch(FileNotFoundException ex)
            {
                System.out.println("kaj je ten plik??");
                ex.getStackTrace();
            }
            catch(IOException ex)
            {
                System.out.println("Znowu jakies blendy loool");
                ex.getStackTrace();
            }
        }
    
}
