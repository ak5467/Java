import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Name    : Annu Kuriakose <br/>
 * Course  : ISTE 200.01 <br/>
 * Homework: HW 8 - GUI Events<br/>
 * Date    : 02/21/2016<br/>
 *
 * Purpose : <br/><b><i>The Vehicle class accepts and stores information 
 *            about a Vehicle that a user wants to Order.</b></i>
 *           <br/> This class implements Polymorphism/Overloading of method, showMenu
 *           <br/>--> [int showMenu(String string, String[] stringArray)] and 
 *           [char showMenu(String[] stringArray)]
 *
 * @param: NUMBEROFVEHICLES   stores the number of type of vehicles available for ordering
 *
 * @param:  vehicleModel     Stores the vehicleModel of vehicle.
 * @param:  vehicleColor     Stores the vehicleColor of vehicle.
 * @param:  vehicleCost      Stores the vehicleCost of vehicle.
 *
 * date: 03/06/2016.
 *@author: Annu Kuriakose
 *@version: 3.0
 *
 */

abstract public class Vehicle implements Vinfo, Serializable{

   public final static int NUMBEROFVEHICLES = 6;
   
   private String vehicleModel = new String();
   private String vehicleColor = new String();
   private double vehicleCost = 0;
   private static final long serialVersionUID = 11L;
        
   transient Scanner scanVehicle = new Scanner(System.in);
   
   //Parameterized constructor follows
   public Vehicle(String vehicleName){
   
      setModel(vehicleName);
      setColor();
      setCost();
   }
   
   //default constructor follows
   public Vehicle(){
      new File("VehicleOrders.txt").delete();
   }


   
   /**
     * setModel() retrieves the information about vehicleModel of the vehicle from the user.
     * <br/> vehicleModel detail is stored to the private variable 'vehicleModel'.
     *
     *@return: none
     */
   public void setModel(String vehicle) {
    
      vehicleModel = OrdersScreen.jtfModel.getText();
            
   }
   
    
   /**
     * setColor() retrieves the information about vehicleColor of the vehicle from the user.
     * <br/> Color detail is stored to the private variable 'vehicleColor'.
     *
     *@return: none
     */
   public void setColor() {
    
      vehicleColor = OrdersScreen.jtfColor.getText();
        
   }
    
   
   /**
     * setCost() retrieves the information about vehicleCost of the vehicle from the user.
     * <br/> Cost detail is stored to the private variable 'vehicleCost' using constructor.
     *
     *@return: none
     */
   public void setCost() {
      
      boolean value;  
      value = false;
      try{
         vehicleCost = Double.parseDouble(OrdersScreen.jtfCost.getText());
      }catch(Exception e){
         value = true;
         System.out.print("Invalid dollar amount, do not use $ , in the entered cost.");
         System.out.println(" Restart the program and Try again. ");
         System.exit(1);
      }

   }
    
   
   /**
     *getModel() gives  the information about vehicle vehicleModel to the calling  the user.
     *@return: String
     */
   public String getModel() {
    
      return vehicleModel;
   }
    
   
   /**
     *getColor() gives  the information about vehicle vehicleModel to the calling  the user.
     *@return: String
     */
   public String getColor() {
    
      return vehicleColor;
   }
    
   
   /**
     *getCost() gives  the information about vehicle vehicleModel to the calling  the user.
     *@return: String
     */
   public double getCost() {
    
      return vehicleCost;
   }
    
   
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */
   public String toString() {
      
      double mileageValue = calcMileage();
      String returnValue = "\n\tModel: " + this.getModel();
      returnValue = returnValue+ "\n\tColor:" + this.getColor();
      String costString = String.format("\n\tCost: $%,.2f",this.getCost());
      return returnValue+costString+"\n\tMPG/GPH: "+mileageValue;
   }
   
   
   /**
     * calcMileage() method calculates the mileage of a vehicle
     *  @return: double
     *
     */
     public double calcMileage(){
      
      return (double)(Math.round(gasMileage()*10))/10;
     }
   
   
   /**
     * writeToFile() method writes model, color, cost and mileage of a vehicle
     * to VehicleOrders.txt file
     * @return: nothing
     *
     */
     public void writeToFile(String vehicleString){
     
     try{
      
      BufferedWriter bfw = new BufferedWriter(new FileWriter("VehicleOrders.txt", true));
         bfw.write(vehicleString+": ");
         bfw.newLine();
         bfw.write("\tModel: "+getModel());
         bfw.newLine();
         bfw.write("\tColor: "+getColor());
         bfw.newLine();
         bfw.write("\tCost: "+getCost());
         bfw.newLine();
         bfw.write("\tMPG/GPH: "+calcMileage());
         bfw.newLine();    
         bfw.close();     
         }catch(Exception e){
            System.out.println("Caught");
         }
     }
   
}//end of class