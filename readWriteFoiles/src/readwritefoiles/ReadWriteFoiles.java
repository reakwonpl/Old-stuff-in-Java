/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritefoiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author barto
 */
public class ReadWriteFoiles {

        private static class Customer
        {
            public String firtstName,lastName;
            public int age;
            public Customer(String firstName,String lastName,int age)
            {
               this.firtstName = firstName;
               this.lastName = lastName;
               this.age = age;
            }
            
            
        }
        private static Customer[] getCustomers()
        {
            Customer[] customers = new Customer[5];
            customers[0] = new Customer("Jake","Gown",21);
            customers[1] = new Customer("Andrew","Werdna",23);
            customers[2] = new Customer("Blake","Klyrchs",41);
            customers[3] = new Customer("Balaki","Rewroewn",22);
            customers[4] = new Customer("Jeyqualin","Bisztanda",20);
            return customers;
        }
        
        private static PrintWriter createFile(String fileName)
        {
            try
            {
                File listOfnames = new File(fileName);
                PrintWriter infoToWrite = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(listOfnames)));
            }
            catch(NullPointerException e)
            {
                e.getStackTrace();
            }
            catch (IOException e)
            {
                System.out.println("Error");
                System.exit(0);
            e.getStackTrace();
            }
            return null;
         }
    private static void createCustomers(Customer customer,PrintWriter custOutput)
    {
        String custInfo = customer.firtstName + " " + customer.lastName + " ";
        custInfo += Integer.toString(customer.age);
        custOutput.println(custInfo);
    }
    
    private static void getFileInfo()
    {
        System.out.println("Zapisano");
        File listOfnames = new File("R:\\rkw.txt");
        try
        {
            BufferedReader getInfo = new BufferedReader(
            new FileReader(listOfnames));
            
            String custInfo = getInfo.readLine();
            
            while(custInfo != null)
            {
                System.out.println(custInfo);
                custInfo = getInfo.readLine();
            }
            
        }
        catch(NullPointerException e)
            {
                e.getStackTrace();
            }
        catch(FileNotFoundException ex){
           System.out.println("nie ma pliku ");
            ex.getStackTrace();
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
   
    public static void main(String[] args) 
    
    {
        Customer[] customers = getCustomers();
        //characters to file
        PrintWriter custOutput = createFile("R:\\rkw.txt");
        
        for (Customer person : customers){
            createCustomers(person,custOutput);
            
        }
        custOutput.close();
        getFileInfo();
        
        
    }
    
}
