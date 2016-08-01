import java.util.*;

/**
  * purpose: This program will read three whole numbers and sort them without using array.
  *          After sorting, it will print the numbers in acending order:
  *          
  * 
  * date: 02/13/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class OrderNumbers{
   
   public static void main(String [] args){
      
      int number1, number2, number3;
      int first=0, second=0, third=0;
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Ordering 3 whole numbers, by Annu Kuriakose.\nEnter the first number:");
      number1 = scan.nextInt();
      System.out.println("Enter the second number:");
      number2 = scan.nextInt();
      System.out.println("Enter the third number:");
      number3 = scan.nextInt();
      
      
      //The below if - else section compare all the 3 input whole numbers and sort them out.
      
      if(number1>number2){
         
         if(number1>number3){
            if(number2>number3){
               first = number1;
               second = number2;
               third = number3;
            }else{
               first = number1;
               second = number3;
               third = number2;
            }
         }else{
            first = number3;
            second = number1;
            third = number2;
         }
      
      }else if(number2>number3){
            if(number1>number3){
               first = number2;
               second = number1;
               third = number3;
            }else{
               first = number2;
               second = number3;
               third = number1;
            }
           
       }else{     
         first = number3;
         second = number2;
         third = number1;
      }
      
      //printing the values in ascending order
      System.out.println("Ordered numbers are: "+third+", "+second+", "+first);
      
   }//end of main
}