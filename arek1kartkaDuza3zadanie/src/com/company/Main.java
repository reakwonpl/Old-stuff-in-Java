package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int ilos = 0, ilos2=0;
        int inl1=0,inl2 = 0,ispr=0;
        int iparz=1;
        int ilicz=0;
        do{
            ilos = r.nextInt(15)-5;
            ilicz ++;
            System.out.print(ilos+" ");
            if((ilos<inl1)&&(inl2<=inl1)){
                if(ilos>inl2)
                    inl2=ilos;
            }
            if(ilos>inl1){
                inl1 = ilos;
            }
            if((ilos % 2==0)&&(ilos>0)){
                iparz*=ilos;
            }
        }while(ilos != 0);
        int ilicz2=0;
        int isuma=0;
        System.out.println();
        for(int i=0;i<ilicz;i++){
            ilos2 = r.nextInt(25)-25;
            System.out.print(ilos2+" ");
            ilicz2++;
            if((ilicz2 %2==0)&& (ilos2!=0)){
                isuma += ilos2;
            }

        }
        System.out.println();
        System.out.println("pierwsza naj "+inl1 + " druga naj: "+inl2);
        System.out.println("iloczyn: "+iparz);
        System.out.println("suma: "+isuma);
    }
}
