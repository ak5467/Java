import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Name    : Annu Kuriakose <br/>
 * Course  : ISTE 200.01 <br/>
 * Homework: Exceptions<br/>
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
   
   public Vehicle(String vehicleName){
   
      setModel(vehicleName);
      setColor();
      setCost();
   }
    
   public Vehicle(){
      new File("VehicleOrders.txt").delete();
   }
    
   /**
     * showMenu() retrieves the information about each features of a vehicle
     *            using menu choices from the user.
     * 
     *
     *@return: int
     */
   public int showMenu(String prompt, String[] choices) {
   
      int input = 0;
      int length = choices.length;
      boolean flag;
      do{
         flag = false;
         System.out.print(prompt+"\n\t"); 
         try {
            for (int i = 0; i < length; i++) {
               System.out.print((i + 1) + ". " + choices[i]+"\n\t");
            }         
            System.out.print("Choice: ");
            input = scanVehicle.nextInt();
            if(input>length || input <=0){
               input = 0;
            }
         
         } 
         catch (InputMismatchException ie) {
            System.out.println("Wrong input format!");
            input = 0;
            scanVehicle.nextLine();
         } 
         catch (Exception e) {
            System.out.println("Inappropriate value!");
            input = 0;
            scanVehicle.nextLine();
         }
         if(input<=0){
            flag = true;
            System.out.println("Please re-enter a number from 1 to "+length);
         }
      }while(flag);
      return (input-1);
   
   } // end of showMenu method
   
   
   /**
     * showMenu() retrieves the information from user 
     *            regarding vehicles to be ordered.
     * 
     *
     *@return: char
     */ 
   public char showMenu(String[] vehicles){
   
      char input = ' ';
      System.out.print("Do you want to order a"); 
      try {
         int i;
         for (i = 0; i < NUMBEROFVEHICLES; i++) {
            char u = vehicles[i].charAt(0);
            char l = Character.toLowerCase(u);
            System.out.print(" "+vehicles[i]+"("+u+"/"+l+")");
            if(i<(NUMBEROFVEHICLES-2)){
               System.out.print(",");
            }
            else if(i==(NUMBEROFVEHICLES-2)){
               System.out.print(" or");
            }
         }         
         
         System.out.print("? ");
         input = scanVehicle.next().charAt(0);
         
      } 
      catch (Exception e) {
         System.out.println("Inappropriate value");
         input = ' ';
         scanVehicle.nextLine();
      }
     
      return input;
   
   }
   
   
   /**
     * setModel() retrieves the information about vehicleModel of the vehicle from the user.
     * <br/> vehicleModel detail is stored to the private variable 'vehicleModel'.
     *
     *@return: String
     */
   public String setModel(String vehicle) {
    
      System.out.print("Entering " + vehicle + " order:\n\tModel: ");
      vehicleModel = scanVehicle.nextLine();
        
      return vehicleModel;
    
   }
   
    
   /**
     * setColor() retrieves the information about vehicleColor of the vehicle from the user.
     * <br/> Color detail is stored to the private variable 'vehicleColor'.
     *
     *@return: String
     */
   public String setColor() {
    
      System.out.print("\tColor: ");
      vehicleColor = scanVehicle.nextLine();
        
      return vehicleColor;
   }
    
   
   /**
     * setCost() retrieves the information about vehicleCost of the vehicle from the user.
     * <br/> Cost detail is stored to the private variable 'vehicleCost' using constructor.
     *
     *@return: Double
     */
   public double setCost() {
      
      boolean value;
      do{    
      value = false;
      System.out.print("\tCost: ");
      try{
         vehicleCost = Double.parseDouble(scanVehicle.nextLine());
      }catch(Exception e){
         value = true;
         System.out.print("Invalid dollar amount, do not use $ or , in the entered cost.");
         System.out.println(" Try again.");
      }
      }while(value);
      return vehicleCost;
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