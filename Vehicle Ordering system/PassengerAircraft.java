import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Exceptions
  * Date    : 02/25/2016
  *
  * Purpose : <b><i>The Aircraft class accepts and stores information 
  *            about a Aircraft that a user wants to Order.</b></i>
  *
  *
  * @param  capacity      Stores the capacity of aircraft.
  * @param  speed    Stores the speed of aircraft.
  *
  * date: 02/25/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class PassengerAircraft extends Vehicle{

   private String capacity;
   private String speed;
   private double airMileage;
   private final static String[] capacityArray =
    {"386 in two class configuration", "315 in three class configuration",
     "400 in two class configuration"};
   private final static String[] speedArray = {"587 mph", "570 mph", "567 mph"};
   
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of aircraft and 
     *  set values for Model, Color, Cost, Capacity and Speed.
     */
   public PassengerAircraft(){
      
      super.setModel("Passenger Aircraft");
      super.setColor();
      super.setCost();
      setCapacity();
      setSpeed();
                            
   }
  
  
  
   /**
     * setCapacity() retrieves the information about capacity of the aircraft from the user.
     * <br/> Capacity detail is stored to the private variable 'capacity' using constructor.
     *
     *@return: none
     */ 
   public void setCapacity(){
      
      int input;
      boolean flag;
      
      input = showMenu("\nWhat is the capacity of this aircraft?", capacityArray);
      
      this.capacity = capacityArray[input];

   } 
   
  
  
   /**
     * setSpeed() retrieves the information about speed of the aircraft from the user.
     * <br/> Speed detail is stored to the private variable 'speed' using constructor.
     *
     *@return: none
     */ 
   public void setSpeed(){
      
      int input;
      input = showMenu("\nWhat is the speed of the Craft?", speedArray);
      
      this.speed = speedArray[input];
   }       
     
     
  
   /**
     * getCapacity() method gives the information about aircraft model to the calling user.
     * @return: String
     */ 
   public String getCapacity(){
      
      return capacity;
   }
   
   
  
   /**
     * getSpeed() method gives the information about aircraft model to the calling user.
     * @return: String
     */ 
   public String getSpeed(){
      
      return speed;
   }
   
   
  
   /**
     * gasMileage() calculates and returns the gasMileage for any vehicle. 
     * Implementing this from the interface Vinfo
     *@return: double
     */ 
   public double gasMileage(){

       switch(this.speed){
         
            case "587 mph" :  airMileage = AIRCRAFTMILEAGE[0];
                              break;
            case "570 mph" :  airMileage = AIRCRAFTMILEAGE[1];
                              break;
            case "567 mph" :  airMileage = AIRCRAFTMILEAGE[2];
                              break;
            default        :  break;
       }  
       return airMileage;
   }
   
   
   
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */ 
   public String toString(){
      String string = super.toString();
      return "Aircraft: "+string+"\n\tCapacity: "+this.getCapacity()+
      "\n\tMade of: "+this.getSpeed();
   }


}//end of class