import java.io.*;
import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: HW 8<br/>
  * Date    : 03/06/2016<br/>
  *
  * Purpose : <b><i>The Truck class accepts and stores information about a Truck
  *            that a user wants to Order.</b></i>
  *
  *
  * @param  load      Stores the load of truck.
  * @param  engine    Stores the engine of truck.
  *
  * date: 03/06/2016.
  *@author: Annu Kuriakose
  *@version:8.0
  *
  */

public class Truck extends Vehicle{

   private String load  = new String();
   private String engine= new String();
   private double truckMileage = 0;
   public final static String[] loadArray = {"Half-ton", "Full-ton"};
   final static String[] engineArray = {"V6 Engine", "V8 Engine"};
   final static String VEHICLE_IS = "Truck";
   
   private static final long serialVersionUID = 11L;
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of truck  and 
     *  set values for Model, Color, Cost, Load and Enigne.
     */
   public Truck(){
      
      super(VEHICLE_IS);
      setLoad();
      setEngine();
               
  }
  
    
  /**
    *changeDropdown() changes the dropdow in GUI according to the vehicle chosen
    * return: none
    */
  public static void changeDropdown(){
   
      OrdersScreen.jcAtt1.removeAllItems();
      for(int i=0; i<loadArray.length;i++){
         OrdersScreen.jcAtt1.addItem(loadArray[i]);
      }
      OrdersScreen.jcAtt1.setSelectedItem(loadArray[0]);
      OrdersScreen.jcAtt2.removeAllItems();
      for(int i=0; i<engineArray.length;i++){
         OrdersScreen.jcAtt2.addItem(engineArray[i]);
      }
      OrdersScreen.jcAtt2.setSelectedItem(engineArray[0]);

  }
  
   /**
     * setLoad() retrieves the information about load of the truck from the user.
     * <br/> Load detail is stored to the private variable 'load'.
     *
     *@return: none
     */ 

   public void setLoad(){
      
      String input;
      input = (String) OrdersScreen.jcAtt1.getSelectedItem();
      
      this.load = input;
   } 
   
  
   /**
     * setEngine() retrieves the information about engine of the truck from the user.
     * <br/> Engine detail is stored to the private variable 'engine'.
     *
     *@return: none
     */ 

   public void setEngine(){
      
      String input;
      input = (String) OrdersScreen.jcAtt2.getSelectedItem();
      
      this.engine = input;
      
   }       
     
     
   /**
     *getLoad() method gives  the information about truck model to the calling  the user.
     *@return: String
     */ 

   public String getLoad(){
      
      return load;
   }
   
   
   /**
     *getEnigne() method gives  the information about truck model to the calling  the user.
     *@return: String
     */ 

   public String getEnigne(){
      
      return engine;
   }
   
   
   /**
     *gasMileage() method gives  the information about car model to the calling  the user.
     *@return: double
     */
   public double gasMileage(){
      
       double truckCost = super.getCost();
       truckMileage = 50 - (Math.sqrt(truckCost)/10.0);      
       return truckMileage;
   }
   
   
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */ 

   public String toString(){
   
      String string = super.toString();
      return "Truck: "+string+"\n\tLoad: "+this.getLoad()+"\n\tEnigne: "+this.getEnigne();
   }
   
   
   /**
     * truckFileWrite() method writes the car details to VehicleOrders.txt file.
     * return: nothing
     *
     */
    
   public void truckFileWrite(){
      
      try{
         
         BufferedWriter bfw = new BufferedWriter(new FileWriter("VehicleOrders.txt", true));
         writeToFile(VEHICLE_IS);
         bfw.write("\tLoad: "+this.getLoad());
         bfw.newLine();
         bfw.write("\tEngine: "+this.getEnigne());
         bfw.newLine();
         bfw.close();              

      }catch(Exception e){
         System.out.println("Caught");
      }
   }//end of truckFileWrite

}//end of class