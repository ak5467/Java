import java.util.*;
import java.lang.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Truck Car
  * Date    : 02/21/2016
  *
  * Purpose : <b><i>The Truck class accepts and stores information about a Truck that a user wants to Order.</b></i>
  *
  * @param   model     Stores the model of truck
  * @param   color     Stores the color of truck
  * @param   cost      Stores the cost of truck
  * @param   load      Stores the load of truck
  * @param   engine    Stores the engine of truck
  *
  * date: 02/21/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class Truck{

   private String model = new String();
   private String color = new String();
   private double cost  = 0;
   private String load  = new String();
   private String engine= new String();
   
   String[] inputArray  = new String[5];
   
   Scanner scanTruck    = new Scanner(System.in);
   
   /**
     * Defalut constructor for the class.
     * <br/> This method calls the mutators for attributes of truck  and set values for Model, Color, Cost, Load and Engine.
     */
   public Truck(){
      
      this.model  = setModel();
      this.color  = setColor();
      this.cost   = setCost();
      this.load   = setLoad();
      this.engine = setEngine();
                            
   }
   
   /**
     * setModel() retrieves the information about truck model from the user.
     * <br/> Model detail is stored to the private variable 'model' using constructor.
     *
     *@return: String
     */   
   String setModel(){
      
      System.out.print("Entering Truck order:\n\tModel: ");
      inputArray[0] = scanTruck.nextLine();
      return inputArray[0];
   }
   
   /**
     * setColor() retrieves the information about color of the truck from the user.
     * <br/> Color detail is stored to the private variable 'color' using constructor.
     *
     *@return: String
     */ 
   String setColor(){
      
      System.out.print("\tColor: ");
      inputArray[1] = scanTruck.nextLine();
      return inputArray[1];
   }
   
   /**
     * setCost() retrieves the information about cost of the truck from the user.
     * <br/> Cost detail is stored to the private variable 'cost' using constructor.
     *
     *@return: Double
     */ 
   double setCost(){
      
      System.out.print("\tCost: ");
      inputArray[2] = scanTruck.nextLine();
      return Double.parseDouble(inputArray[2]);
   }
   
   /**
     * setLoad() retrieves the information about load of the truck from the user.
     * <br/> Load detail is stored to the private variable 'load' using constructor.
     *
     *@return: String
     */ 
   String setLoad(){
      
      int input;
      boolean flag;
      do{
         flag = false;
         System.out.print("\nWhat load truck is this?\n\t1. Half-ton\n\t2. Full-ton\n\tChoice: ");
         inputArray[3] = scanTruck.nextLine();

         input = Integer.parseInt(inputArray[3]);
         try{
            switch(input){
               
               case 1:  inputArray[3] = "Half-ton";
                        break;
               case 2:  inputArray[3] = "Half-ton";
                        break;
               default: inputArray[3] = "Value not selected";
                        flag = true;
                        System.out.println("You should select either 1 or 2 as given!!\n Please enter the right choice");
                        break;
            }
        }catch(InputMismatchException e){
            System.out.println("Arguments need to be numbers.");
        }//end of try - catch clause checking the format of number entered as only numbers can be entered.
              
      }while(flag);
      
      return inputArray[3];
      
   } 
   
   /**
     * setEngine() retrieves the information about engine of the truck from the user.
     * <br/> Engine detail is stored to the private variable 'engine' using constructor.
     *
     *@return: String
     */ 
   String setEngine(){
      
      int input;
      boolean flag;
      do{
         flag = false;
         System.out.print("\nWhat is the engine size of the truck?\n\t1. V6 Engine\n\t2. V8 Engine\n\tChoice: ");
         inputArray[4] = scanTruck.nextLine();

         input = Integer.parseInt(inputArray[4]);
         
         try{
           switch(input){
              
              case 1:  inputArray[4] = "V6 Engine";
                       break;
              case 2:  inputArray[4] = "V8 Engine";
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
     *getModel() gives  the information about truck model to the calling  the user.
     *@return: String
     */ 
   String getModel(){
      
      return model;
   }
   
   /**
     *getColor() gives  the information about truck model to the calling  the user.
     *@return: String
     */ 
   String getColor(){
      
      return color;
   }
   
   /**
     *getCost() gives  the information about truck model to the calling  the user.
     *@return: String
     */ 
   Double getCost(){
      
      return cost;
   }
   
   /**
     *getLoad() method gives  the information about truck model to the calling  the user.
     *@return: String
     */ 
   String getLoad(){
      
      return load;
   }
   
   /**
     *getEngine() method gives  the information about truck model to the calling  the user.
     *@return: String
     */ 
   String getEngine(){
      
      return engine;
   }
   
   /**
     *toString() gives a string which hold all the attributes to be printed.
     *@return: String
     */ 
   public String toString(){
      
      return "Truck:\n\tModel: "+this.getModel()+"\n\tColor:"+this.getColor()+"\n\tCost: $"+this.getCost()+"\n\tLoad: "+this.getLoad()+"\n\tEngine: "+this.getEngine();
   }
   public static void main(String [] args){
      
   }
}