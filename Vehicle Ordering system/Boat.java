import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Exception
  * Date    : 03/06/2016
  *
  * Purpose : <b><i>The Boat class accepts and stores information 
  *            about a Boat that a user wants to Order.</b></i>
  *
  *
  * @param  boatType      Stores the type of boat.
  * @param  make          Stores the make of boat.
  *
  * date: 02/25/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class Boat extends Vehicle{

   private String boatType  = new String();
   private String make  = new String();
   private double boatMileage = 0;
   private final static String[] makeArray = {"Wood", "Fiberglass", "Steel"};   
   private final static String[] boatTypeArray = {"Pontoon", "PWC", "Sailboat"};
   Scanner scanBoat     = new Scanner(System.in);
   
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of boat and 
     *  set values for Model, Color, Cost, Type and Make.
     */
   public Boat(){
      
      super.setModel("Boat");       //mutator from super class being called
      super.setColor();             //mutator from super class being called
      super.setCost();
      setType();
      setMake();
                            
   }
  
  
   /**
     * setType() retrieves the information about boatType of the boat from the user.
     * <br/> Type detail is stored to the private variable 'boatType'.
     *
     *@return: none
     */ 

   public void setType(){
      
      int input;
      boolean flag;
      input = showMenu("\nWhat boatType of boat is this?", boatTypeArray);
      
      this.boatType = boatTypeArray[input];

   } 
  
   
   /**
     * setMake() retrieves the information about make of the boat from the user.
     * <br/> Make detail is stored to the private variable 'make'.
     *
     *@return: none
     */ 

   public void setMake(){
      
      int input;
      boolean flag;
      input = showMenu("\nWhat is the boat's construction?", makeArray);
      
      this.make = makeArray[input];

   }       
     
     
   /**
     *getType() method gives  the information about boat model to the calling  the user.
     *@return: String
     */ 

   public String getType(){
      
      return boatType;
   }
   
   
   /**
     *getMake() method gives  the information about boat model to the calling  the user.
     *@return: String
     */ 

   public String getMake(){
      
      return make;
   }
   
   
   /**
     *gasMileage() method gives  the information about car model to the calling  the user.
     *@return: double
     */
   public double gasMileage(){
      
       switch(this.boatType){
         
            case "Pontoon" :  boatMileage = BOATMILEAGE[0];
                              break;
            case "PWC"     :  boatMileage = BOATMILEAGE[1];
                              break;
            case "Sailboat":  boatMileage = BOATMILEAGE[2];
                              break;
            default        :  break;
       }      
        
       return boatMileage;
   }
   
   
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */ 
     
   public String toString(){
      String string = super.toString();
      return "Boat: "+string+"\n\tType: "+this.getType()+"\n\tMade of: "+this.getMake();
   }


}//end of the class boat