import java.io.*;
import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: HW 8 - GUI Events<br/>
  * Date    : 02/25/2016<br/>
  *
  * Purpose : <b><i>The Aircraft class accepts and stores information 
  *            about a Aircraft that a user wants to Order.</b></i>
  *
  *
  * @param  capacity      Stores the capacity of aircraft.
  * @param  speed    Stores the speed of aircraft.
  *
  * date: 04/06/2016.
  *@author: Annu Kuriakose
  *@version: 8.0
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
   final static String VEHICLE_IS = "PassengerAirCraft";
   
   private static final long serialVersionUID = 11L;
   
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of aircraft and 
     *  set values for Model, Color, Cost, Capacity and Speed.
     */
   public PassengerAircraft(){
      
      super(VEHICLE_IS);
      setCapacity();
      setSpeed();
                            
   }
   
   /**
    * changeDropdown() changes the dropdowns Att1 & Att2 as per the selected value
    *
    * return: none
    *
    */
   public static void changeDropdown(){
   
      OrdersScreen.jcAtt1.removeAllItems();
      for(int i=0; i<capacityArray.length;i++){
         OrdersScreen.jcAtt1.addItem(capacityArray[i]);
      }
      OrdersScreen.jcAtt1.setSelectedItem(capacityArray[0]);
      OrdersScreen.jcAtt2.removeAllItems();
      for(int i=0; i<speedArray.length;i++){
         OrdersScreen.jcAtt2.addItem(speedArray[i]);
      }
      OrdersScreen.jcAtt2.setSelectedItem(speedArray[0]);

  }
  
  
  
   /**
     * setCapacity() retrieves the information about capacity of the aircraft from the user.
     * <br/> Capacity detail is stored to the private variable 'capacity' using constructor.
     *
     *@return: none
     */ 
   public void setCapacity(){
      
      String input;
      boolean flag;
      
      input = (String)OrdersScreen.jcAtt1.getSelectedItem();
      
      this.capacity = input;

   } 
   
  
  
   /**
     * setSpeed() retrieves the information about speed of the aircraft from the user.
     * <br/> Speed detail is stored to the private variable 'speed' using constructor.
     *
     *@return: none
     */ 
   public void setSpeed(){
      
      String input;
      input = (String)OrdersScreen.jcAtt2.getSelectedItem();
      
      this.speed = input;
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
      "\n\tSpeed: "+this.getSpeed();
   }
   
    
   /**
     * passengerAircraftFileWrite() method writes the car details to VehicleOrders.txt file.
     * return: nothing
     *
     */
    
   public void passengerAircraftFileWrite(){
      
      try{
         
         BufferedWriter bfw = new BufferedWriter(new FileWriter("VehicleOrders.txt", true));
         writeToFile(VEHICLE_IS);
         bfw.write("\tCapacity: "+this.getCapacity());
         bfw.newLine();
         bfw.write("\tSpeed: "+this.getSpeed()); 
         bfw.newLine();
         bfw.close();              

      }catch(Exception e){
         System.out.println("Caught");
      }
   }//end of passengerAircraftFileWrite


}//end of class