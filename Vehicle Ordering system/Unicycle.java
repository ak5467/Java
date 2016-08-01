import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Exceptions
  * Date    : 02/25/2016
  *
  * Purpose : <b><i>The Unicycle class accepts and stores information about
  *            a Unicycle that a user wants to Order.</b></i>
  *
  *
  * @param  frame      Stores the frame type of the unicycle.
  * @param  brake    Stores the type of brake used in the unicycle.
  *
  * date: 02/29/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class Unicycle extends Vehicle{

   private String frame;
   private String brake;
   
   private final static String[] brakeArray =
    {"Linear Pull Brakes", "Front and Rear Hand Brake"};
   private final static String[] frameArray =
    {"Steel frame", "Aluminum Frame", "6061 Heat Treated Aluminum"};
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of unicycle
     *  and set values for Model, Color, Cost, Frame and Brake.
     * <br/> Model, color and cost will be accepted using the mutators in vehicle class
     */
   public Unicycle(){
      
      super.setModel("Unicycle");
      super.setColor();
      super.setCost();
      setFrame();
      setBrake();
                            
   }
  
  
   /**
     * setFrame() retrieves the information about frame of the unicycle from the user.
     * <br/> Frame detail is stored to the private variable 'frame' using constructor.
     *
     *@return: none
     */ 

   public void setFrame(){
      
      int input;
      boolean flag;
      input = showMenu("\nWhat frame is used in this unicycle?", frameArray);
      
      this.frame = frameArray[input];

   } 
   
  
   /**
     * setBrake() retrieves the information about brake of the unicycle from the user.
     * <br/> Brake detail is stored to the private variable 'brake' using constructor.
     *
     *@return: none
     */ 
   public void setBrake(){
      
      int input;
      boolean flag;
      input = showMenu("\nWhat type of brake is required in the unicycle?", brakeArray);
      
      this.brake = brakeArray[input];

   }       
     
     
   /**
     *getFrame() method gets the information about unicycle model to the calling  the user.
     *@return: String
     */ 
   public String getFrame(){
      
      return frame;
   }
   
   
   /**
     *getBrake() method gets the information about unicycle model to the calling  the user.
     *@return: String
     */ 
   public String getBrake(){
      
      return brake;
   }
   
   /**
     * gasMileage() calculates and returns the gasMileage for any vehicle.
     * Implementing this from the interface Vinfo
     * dummy value is returned as cycle doesn't have any mileage
     *@return: double
     */ 
   public double gasMileage(){
       return 1.0; 
   }
   
   
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */ 

   public String toString(){
      String string = super.toString();
      return "Unicycle: "+string+"\n\tFrame: "+this.getFrame()+"\n\tMade of: "+this.getBrake();
   }

}//end of class