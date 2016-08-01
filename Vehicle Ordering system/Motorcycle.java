import java.util.Scanner;
import java.io.*;

/**
* Name: Motorcycle 
*
* Purpose: This Class takes care of ordering Motorcycles and 
* recieving information about the Motorcycles through 
* user input. <br>
* <br>
* Caveats: Invalid input type will result in an 
* exception. (i.e. a letter for a number 
* input). <br>
* <br>
* Date : 03/06/2016
* @author Mike N. Valentin
* @version 1.0
*/

public class Motorcycle extends Vehicle
{
   private final String [] BIKETYPE = {"Cruiser", "SportBike","DirtBike"}; //Declare in Vehicle
   private final String [] TORQUE = {"Broad and Flat", "From Below"}; //Declare in Vehicle
   private String bikeType; // type of Motorcycle 
   private String torque; // torque type for the Motorcycle
   Scanner scan = new Scanner(System.in); // allows user input


   /**
   Constructor uses user input through the scanner class to 
   fill in the necessary information for the vehicle.
   
   @param no parameters are pass into this constructor 
   */
   public Motorcycle(){
      
      super.setModel("Motorcycle");
      super.setColor();
      super.setCost();
      setBikeType();
      setTorque();
   
   }
      
      
   /**
   This method returns the Motorcycle type
   */
   public String getBikeType(){

      return bikeType;

   }// end of getBikeType()
   
   
   /**
   This method determines the type of the vehicle 
   is (sedan/ coupe/ wagon) depending on pass 
   value.
   
   @param number of the type the vehicle is 
   */
   public void setBikeType(){
   
      int num = showMenu("BIKETYPE",BIKETYPE);
      bikeType = BIKETYPE[num]; 
   
   }// end of setType()
   
   
   /**
   This method returns the type of torque for the Motorcycle
   */
   public String getTorque(){
     return torque;
   }//end of getTorque()

   
   /**
   This method determines if towing is included 
   or not included for the vehicle depending 
   on user value.
   
   @param number of the choice for the towing 
      */
   public void setTorque(){ 
      int num = showMenu("TORQUE",TORQUE);
      torque = TORQUE[num]; 
   }// end of setTorque()

   /**
   This method determines what material the Motorcycle
   gas mileage is depending on what type of Motorcycle
   the boat is.
   
   @param no input parameters
   */ 
   @Override 
   public double gasMileage() {
      
      if(this.getBikeType().equals("Cruiser")){
            return CRUISER;
      }
      else if(this.getBikeType().equals("SportBike")){
            return SPORTBIKE;
      }
      else if(this.getBikeType().equals("DirtBike")){
            return DIRTBIKE;
      }else{
            return 0.0;
      }
   
   }//end of gasMileage()

   /**
   toString method for the Motorcycle class that displays to 
   screen the attributes inputted for the vehicle.
   
   @param not parameters pass into this method
   */
   public String toString()
      {
   String result = "";
   result = "\nMotorcycle: \n"+
   super.toString() +
   String.format("\n%13s %s ","Type: ", getBikeType()) +
   String.format("\n%13s %s ","Torque: ", getTorque()) +
   "\n";
   return result;
   }// end of toString()
   
}//end of class Motorcycle