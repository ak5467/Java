import java.io.*;
import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Vehicle<br/>
  * Date    : 03/06/2016<br/>
  *
  * Purpose : <b><i>The Car class accepts and stores information about a Car
  *            that a user wants to Order.</b></i>
  *
  *
  * @param  carType      Stores the type of car.
  * @param  towing       Stores the towing of car.
  *
  * date: 03/06/2016.
  *@author: Annu Kuriakose
  *@version: 3.0
  *
  */

public class Car extends Vehicle{

   private String carType  = new String();
   private String towing= new String();
   private double carMileage = 0.0;
   final static String VEHICLE_IS = "Car";
   
   private static final long serialVersionUID = 11L;
   
   
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of car and set values for 
     *  Model, Color, Cost, Type and Towing.
     */
   public Car(){
      
      super(VEHICLE_IS);
      setType();
      setTowing();
                            
   }
   
   /**
     * Dummy Constructor definition
     */
   public Car(int aNumber){
      //Dummy Constructor
      super();
   }
  
  
  
   /**
     * setType() retrieves the information about carType of the car from the user.
     * <br/> Type detail is stored to the private variable 'carType'.
     *
     *@return: none
     */ 
   public void setType(){
      
      int input;
      boolean flag;
      String[] carTypeArray = {"Sedan", "Coupe", "Wagon"};
      input = showMenu("\nWhat carType of car is this?", carTypeArray);
      
      this.carType = carTypeArray[input];
      
    } 
   
  
  
   /**
     * setTowing() retrieves the information about towing of the car from the user.
     * <br/> Towing detail is stored to the private variable 'towing'.
     *
     *@return: none
     */ 

   public void setTowing(){
      
      int input;
      boolean flag;
      String[] towingArray = {"Towing package", "No towing package"};
      input = showMenu("\nDoes this car have a towing package?", towingArray);
      
      this.towing = towingArray[input];
      
   }       
     
  
  
   /**
     *gasMileage() method gives  the information about car model to the calling  the user.
     *@return: double
     */
   public double gasMileage(){
      
      boolean towingStatus = towing.equals("No towing package");
      if(towingStatus){
         
         switch(this.carType){
         
            case "Sedan":  carMileage = CARMILEAGE[0];
                           break;
            case "Coupe":  carMileage = CARMILEAGE[1];
                           break;
            case "Wagon":  carMileage = CARMILEAGE[2];
                           break;
            default     :  break;
         }
      }else{
         
         switch(this.carType){
         
            case "Sedan":  carMileage = CARMILEAGE[0]-3;
                           break;
            case "Coupe":  carMileage = CARMILEAGE[1]-3;
                           break;
            case "Wagon":  carMileage = CARMILEAGE[2]-3;
                           break;
            default     :  break;
         }
      }
      return carMileage;
   }  
     
  
  
   /**
     *getType() method gives  the information about car model to the calling  the user.
     *@return: String
     */ 

   public String getType(){
      
      return carType;
   }
   
  
  
   /**
     *getTowing() method gives  the information about car model to the calling  the user.
     *@return: String
     */ 

   public String getTowing(){
      
      return towing;
   }
   
  
  
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */ 

   public String toString(){
   
      carFileWrite();
      String string = super.toString();
      return "Car: "+string+"\n\tType: "+this.getType()+"\n\tTowing: "+this.getTowing();
   }
   
   
   /**
     * carFileWrite() method writes the car details to VehicleOrders.txt file.
     * return: nothing
     *
     */
    
   public void carFileWrite(){
      
      try{
         
         BufferedWriter bfw = new BufferedWriter(new FileWriter("VehicleOrders.txt", true));
         writeToFile(VEHICLE_IS);
         bfw.write("\tType: "+this.getType());
         bfw.newLine();
         bfw.write("\tTowing: "+this.getTowing());
         bfw.newLine();
         bfw.close();              

      }catch(Exception e){
         System.out.println("Caught");
      }
   }//end of carFileWrite

}//end of the class