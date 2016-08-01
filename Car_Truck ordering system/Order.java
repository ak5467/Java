import java.util.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Truck Car
  * Date    : 02/21/2016
  *
  *Purpose: <b><i>The Order class accepts information about the kind of vehicle the user wants to order.</b></i>
  *         <br/> Based on the information received the Order class will redirect the user to enter more information about the chosen vehicle.
  *
  *
  * date: 02/21/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  **/

public class Order{
   
   public static void main(String [] args){
      
      char input;
      char value;
      boolean flag = true;
      Scanner scan = new Scanner(System.in);
      ArrayList<Object> vehicleList = new ArrayList<>();
      
      System.out.println("Annu's Ordering System (218-HW2)");
      
      //Entering a loop to ask the user about the details of all the vehicles which are going to be ordered.
      do{
      
         System.out.print("Do you want to order a Truck (T/t) or Car (C/c)?");
         input = scan.next().charAt(0);
         
         switch(input){
         
            case 'T':
            case 't':  Truck truck = new Truck();  //Calling Truck class based on input.
                       vehicleList.add(truck);
                       break;
                                   
            case 'C':
            case 'c':  Car car = new Car();  //Calling the Car class based on input
                       vehicleList.add(car);
                       break;
            
            default:   break;
          
         }//end of switch
         
         System.out.print("Do you want to order another vehicle(Y/N)?");
         value = scan.next().charAt(0);
         
         if(value == 'N' || value =='n'){
            flag = false;
         }
      
      }while(flag); // exiting the loop when user's oredring gets over.
      
      
      //reading objects from ArrayList and differentiating Car and truck objects
      for(int i=0; i<vehicleList.size();i++){
         
         String output = " ";
         if( vehicleList.get(i) instanceof Car ){
            Car c = (Car)vehicleList.get(i);
            System.out.println(""+c.toString());
         }
         else{
            Truck t = (Truck)vehicleList.get(i);
            System.out.println(""+t.toString());
         }
         System.out.println(output);
         
      }//end of for loop

      System.out.println("Thank you for using Annu's Ordering System.");
   
   }//end of main

}//end of class