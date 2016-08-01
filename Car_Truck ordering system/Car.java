import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Truck Car
  * Date    : 02/21/2016
  *
  * Purpose : <b><i>The Car class accepts and stores information about a Car that a user wants to Order.</b></i>
  *
  * @param  model     Stores the model of car.
  * @param  color     Stores the color of car.
  * @param  cost      Stores the cost of car.
  * @param  type      Stores the type of car.
  * @param  towing    Stores the towing of car.
  *
  * date: 02/21/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class Car{

   private String model = new String();
   private String color = new String();
   private double cost  = 0;
   private String type  = new String();
   private String towing= new String();

   String[] inputArray  = new String[5];
   
   Scanner scanCar      = new Scanner(System.in);
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of car  and set values for Model, Color, Cost, Type and Towing.
     */
   public Car(){
      
      this.model  = setModel();
      this.color  = setColor();
      this.cost   = setCost();
      this.type   = setType();
      this.towing = setTowing();
                            
   }
   /**
     * setModel() retrieves the information about car model from the user.
     * <br/> Model detail is stored to the private variable 'model' using constructor.
     *
     *@return: String
     */   

   String setModel(){
      
      System.out.print("Entering Car order:\n\tModel: ");
      inputArray[0] = scanCar.nextLine();
      return inputArray[0];
      
   }
   
   /**
     * setColor() retrieves the information about color of the car from the user.
     * <br/> Color detail is stored to the private variable 'color' using constructor.
     *
     *@return: String
     */ 
   String setColor(){
      
      System.out.print("\tColor: ");
      inputArray[1] = scanCar.nextLine();
      return inputArray[1];
   }
   
   /**
     * setCost() retrieves the information about cost of the car from the user.
     * <br/> Cost detail is stored to the private variable 'cost' using constructor.
     *
     *@return: Double
     */ 
   double setCost(){
      
      System.out.print("\tCost: ");
      inputArray[2] = scanCar.nextLine();
      return Double.parseDouble(inputArray[2]);
   }
   
   /**
     * setType() retrieves the information about type of the car from the user.
     * <br/> Type detail is stored to the private variable 'type' using constructor.
     *
     *@return: String
     */ 
   String setType(){
      
      int input;
      boolean flag;
      do{
         flag = false;
         System.out.print("\nWhat type of car is this?\n\t1. Sedan\n\t2. Coupe\n\t3. Wagon\n\tChoice: ");
         inputArray[3] = scanCar.nextLine();

         input = Integer.parseInt(inputArray[3]);
         
         try{
            switch(input){
            
               case 1:  inputArray[3] = "Sedan";
                        break;
               case 2:  inputArray[3] = "Coupe";
                        break;
               case 3:  inputArray[3] = "Wagon";
                        break;
               default: inputArray[3] = "Value not selected";
                        flag = true;
                        System.out.println("You should select either 1 2 or 3 as given!!\n Please enter the right choice");
                        break;
            }
         }catch(InputMismatchException e){
            System.out.println("Arguments need to be numbers.");
         }//end of try - catch clause checking the format of number entered as only numbers can be entered.
      
      }while(flag);
      
      return inputArray[3];
   } 
   
   /**
     * setTowing() retrieves the information about towing of the car from the user.
     * <br/> Towing detail is stored to the private variable 'towing' using constructor.
     *
     *@return: String
     */ 
   String setTowing(){
      
      int input;
      boolean flag;
      do{
         flag = false;
         System.out.print("\nDoes this car have a towing package?\n\t1. Yes\n\t2. No\n\tChoice: ");
         inputArray[4] = scanCar.nextLine();

         input = Integer.parseInt(inputArray[4]);
         
         try{
            switch(input){
               
               case 1:  inputArray[4] = "Included";
                        break;
               case 2:  inputArray[4] = "Not Included";
                        break;
               default: inputArray[4] = "Value not selected";
                        flag = true;
                        System.out.println("You should select either 1 or 2 as given!!\n Please enter the right choice");
                        break;
            }
         }catch(InputMismatchException e){
            System.out.println("Arguments need to be numbers.");
         }//end of try - catch clause checking the format of number entered as only numbers can be entered.
     
     }while(flag);
     
     return inputArray[4];
   }       
   
   /**
     *getModel() gives  the information about car model to the calling  the user.
     *@return: String
     */ 
   String getModel(){
      
      return model;
   }
   
   /**
     *getColor() gives  the information about car model to the calling  the user.
     *@return: String
     */ 
   String getColor(){
      
      return color;
   }
   
   /**
     *getCost() gives  the information about car model to the calling  the user.
     *@return: String
     */ 
   Double getCost(){
      
      return cost;
   }
   
   /**
     *getType() method gives  the information about car model to the calling  the user.
     *@return: String
     */ 
   String getType(){
      
      return type;
   }
   
   /**
     *getTowing() method gives  the information about car model to the calling  the user.
     *@return: String
     */ 
   String getTowing(){
      
      return towing;
   }
   
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */ 
   public String toString(){
      
      return "Car:\n\tModel: "+this.getModel()+"\n\tColor:"+this.getColor()+"\n\tCost: $"+this.getCost()+"\n\tType: "+this.getType()+"\n\tTowing: "+this.getTowing();
   }
   public static void main(String [] args){
      
   }
}