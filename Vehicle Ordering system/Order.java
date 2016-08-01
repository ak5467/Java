import java.util.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Exceptions
  * Date    : 03/06/2016
  *
  *Purpose: <b><i>The Order class accepts information about the kind of vehicle
  *          the user wants to order using the class vehicle.</b></i>
  *         <br/> Based on the information received the Order class will redirect the user
  *          to enter more information about the chosen vehicle.
  *
  *
  * date: 03/06/2016.
  *@author: Annu Kuriakose
  *@version: 3.0
  **/

public class Order{
   
   public static void main(String [] args){
      
      char vehicleChoice;
      char value;
      boolean flag;
      String[] vehicleArray = 
      {"Truck", "Car", "Boat", "Unicycle", "Motorcycle", "PassengerAircraft"};
      Scanner scan = new Scanner(System.in);
      ArrayList<Object> vehicleList = new ArrayList<>();
      
      System.out.println("Java for programmers ISTE - 200 <2016 - Spring>\nHomework #4\n");
      
      //Entering a loop to retrieve the details of all the vehicles to be ordered.
      do{
         flag = false;
         Vehicle v = new Car(1);
         vehicleChoice = v.showMenu(vehicleArray);
         switch(vehicleChoice){
            
            //Calling Truck class based on input.
            case 'T':
            case 't':  Truck truck = new Truck();  
                       vehicleList.add(truck);
                       break;
            //Calling the Car class based on input                       
            case 'C':
            case 'c':  Car car = new Car();
                       vehicleList.add(car);
                       break;
            
            //Calling the Boat class based on input           
            case 'B':
            case 'b':  Boat boat = new Boat();  
                       vehicleList.add(boat);
                       break;
            
            //Calling the Unicycle class based on input           
            case 'U':
            case 'u':  Unicycle unicycle = new Unicycle();  
                       vehicleList.add(unicycle);
                       break;
            
            //Calling the Motorcycle class based on input           
            case 'M':
            case 'm':  Motorcycle motorcycle = new Motorcycle();  
                       vehicleList.add(motorcycle);
                       break;
            
            //Calling the PassengerAircraft class based on input           
            case 'P':
            case 'p':  PassengerAircraft passengerAircraft = new PassengerAircraft();  
                       vehicleList.add(passengerAircraft);
                       break;
                                  
            default:   flag = true;
                       break;
          
         }//end of switch
         
         if(flag){
         
            System.out.println("The entered value is not valid. Please retry");
         
         }
         else{
         
            System.out.print("Do you want to order another vehicle(Y/N)?");
            value = scan.next().charAt(0);
         
            if(value == 'N' || value =='n'){
               flag = false;
            }
            else{
               flag = true;
            }
         }
      
      }while(flag); // exiting the loop when user's ordering gets over.
      
      
      //reading from ArrayList and differentiating between the different vehicle objects
      for(int i=0; i<vehicleList.size();i++){
         
         if( vehicleList.get(i) instanceof Car ){
            Car c = (Car)vehicleList.get(i);
            System.out.println(""+c.toString());
         }
         else if(vehicleList.get(i) instanceof Truck){
            Truck t = (Truck)vehicleList.get(i);
            System.out.println(""+t.toString());
         }
         else if(vehicleList.get(i) instanceof Boat){
            Boat b = (Boat)vehicleList.get(i);
            System.out.println(""+b.toString());
         }
         else if(vehicleList.get(i) instanceof Unicycle){
            Unicycle u = (Unicycle)vehicleList.get(i);
            System.out.println(""+u.toString());
         }
         else if(vehicleList.get(i) instanceof Motorcycle){
            Motorcycle m = (Motorcycle)vehicleList.get(i);
            System.out.println(""+m.toString());
         }
         else {
            PassengerAircraft p = (PassengerAircraft)vehicleList.get(i);
            System.out.println(""+p.toString());
         }      
         System.out.println(" ");
         
         
      }//end of for loop
   
      System.out.println("Thank you for using Annu's Ordering System.");
   
   }//end of main

}//end of class