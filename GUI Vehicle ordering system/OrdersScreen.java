import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: HW8 - GUI Events<br/>
  * Date    : 04/04/2016<br/>
  *
  * Purpose : <b><i>The OrderScreen class displays the GUI to the user where details of the vehicle
  *            that a user wants to Order can be entered.</b></i></br>
  *            This class is a JFrame as it extends JFrame and ActionListeners are implemented for GUI as well.
  *
  *
  * @param  jtfVehicle  Text field parameter.
  * @param  jcVehicle   Combo box to display vehicle options.
  * @param  jbQuit      Button to exit from the GUI.
  * @param  about       menuitem  from menu bar of menu 'help' to display about the program and author
  *
  * date: 04/02/2016.
  *@author: Annu Kuriakose
  *@version:8.0
  *
  */
  
class OrdersScreen extends JFrame implements ActionListener{
   
   private JMenuBar jmb;
   private JMenu file;
   private JMenu help;
   private JMenuItem load;
   private JMenuItem exit;
   private JMenuItem about;
   
   private JPanel jpGrid;
   private JPanel jpName;
   private JPanel jpBn;
   private JLabel jlName;
   
   private DefaultComboBoxModel<String> defaultCombo;
   private JComboBox<String> jcVehicle;
   static JComboBox<String> jcAtt1;
   static JComboBox<String> jcAtt2;
   
   static JTextField jtfModel;
   static JTextField jtfColor;
   static JTextField jtfCost;
   
   private JButton jbSave;
   private JButton jbFirst;
   private JButton jbPrev;
   private JButton jbNext;
   private JButton jbLast;
   private JButton jbQuit;
   
   FileInputStream fis;
   File outputFile;
   FileOutputStream fout;
   ObjectOutputStream oos;
   
   int navigator = 0;
         
   ArrayList<Object> vehicleList = new ArrayList<>();
   String[] vehicleArray = 
         {"Truck", "Car", "Boat", "Unicycle", "Motorcycle", "PassengerAircraft"};
   String defaultValue = new String("Select Vehicle..");
   
   public static void main(String[] args){
   
      new OrdersScreen().setVisible(true);
   
   }//end of main
   
   
   
   /**
     * OrdersScreen(): default constructor.
     * Purpose:        initializes all file IO operations, Handles GUI objects and events
     *
     */
   public OrdersScreen(){
   
     //file Stream
     try{
         outputFile = new File("VehicleOrderss.dat");
         new File("VehicleOrders.txt").delete();
     }catch(Exception e){
         System.out.println("OutPutFile Eception: "+e);
     }
     
     //create overall GUI layout
     setTitle("Part2 Using getSource");
      
     //adding menu bar to GUI
      
     jmb = new JMenuBar();
     file = new JMenu("File");
     load = new JMenuItem("Load");
     exit = new JMenuItem("Exit");
       
     help = new JMenu("Help");
     about = new JMenuItem("About");
       
     file.add(load);
     file.add(exit);
     help.add(about);
     
     setJMenuBar(jmb);
     jmb.add(file);
     jmb.add(help);
     
     //adding title for the GUI
     jpName = new JPanel();
     jlName = new JLabel("ANNU's Ordering System", JLabel.CENTER);
     jlName.setFont(new Font("Serif", Font.BOLD, 38));
     jlName.setForeground(Color.RED);
     jpName.add(jlName);
     add(jpName, BorderLayout.NORTH);
      
      
     //following code handles grid work
     jpGrid = new JPanel(new GridLayout(0,2));
       
     jpGrid.add(new JLabel("Vehicle Type: ", JLabel.RIGHT));
     defaultCombo = new DefaultComboBoxModel<String>(vehicleArray);
     jcVehicle = new JComboBox<String> (defaultCombo);
     defaultCombo.setSelectedItem(defaultValue);
     jpGrid.add(jcVehicle);
       
     jpGrid.add(new JLabel("Model ", JLabel.RIGHT));
     jtfModel = new JTextField(10);
     jpGrid.add(jtfModel);
      
     jpGrid.add(new JLabel("Color ", JLabel.RIGHT));
     jtfColor = new JTextField(10);
     jpGrid.add(jtfColor);
       
     jpGrid.add(new JLabel("Cost ", JLabel.RIGHT));
     jtfCost = new JTextField(10);
     jpGrid.add(jtfCost);
       
     jpGrid.add(new JLabel(" ", JLabel.RIGHT));
     jcAtt1 = new JComboBox();
     jpGrid.add(jcAtt1);
       
     jpGrid.add(new JLabel(" ", JLabel.RIGHT));
     jcAtt2 = new JComboBox();
     jpGrid.add(jcAtt2);
           
     add(jpGrid, BorderLayout.CENTER);
      
     //adding buttons to south of Border layout
     jpBn = new JPanel();
     jbSave = new JButton("SAVE");
     jbFirst = new JButton("FIRST");
     jbPrev = new JButton("PREV");
     jbNext = new JButton("NEXT");
     jbLast = new JButton("LAST");
     jbQuit = new JButton("Exit");
      
     jpBn.add(jbSave);
     jpBn.add(jbFirst);
     jpBn.add(jbPrev);
     jpBn.add(jbNext);
     jpBn.add(jbLast);
     jpBn.add(jbQuit);
     add(jpBn, BorderLayout.SOUTH);
     
     //Implementing GUI events using addActionListener Method      
     jcVehicle.addActionListener(
         new ActionListener()	{
            public void	actionPerformed(ActionEvent ae)
            {
               JComboBox cb = (JComboBox)ae.getSource();
               String[] array;
               String vehicleSelected = (String)cb.getSelectedItem();
               
               switch(vehicleSelected){
               
                  case "Truck"            : Truck.changeDropdown();
                                            resetTextField();
                                            break;
                                         
                  case "Car"              : Car.changeDropdown();
                                            resetTextField();
                                            break;
                                         
                  case "Boat"             : Boat.changeDropdown();
                                            resetTextField();
                                            break;
                                                                                  
                  case "Unicycle"         : Unicycle.changeDropdown();
                                            resetTextField();
                                            break;
                                         
                  case "Motorcycle"       : Motorcycle.changeDropdown();
                                            resetTextField();
                                            break;
                                         
                  case "PassengerAircraft": PassengerAircraft.changeDropdown();
                                            resetTextField();
                                            break;
                                         
                  default                 : break;
               }
            }
         });
      
      about.addActionListener(this);
      load.addActionListener(this);
      exit.addActionListener(this);
      jbSave.addActionListener(this);
      jbFirst.addActionListener(this);
      jbPrev.addActionListener(this);
      jbNext.addActionListener(this);
      jbLast.addActionListener(this);
      jbQuit.addActionListener(this);
      
      //setting general properties of the JFrame
      pack();
      setLocation(500,300);
      setSize(700,400);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   
   }//end of constructor
   
   
   
   /**
     * actionPerformed(): Method overridden from ActionListener interface
     * Purpose:           implements the events that follows from GUI objects.
     *
     */
   public void actionPerformed(ActionEvent ae){
      
      int value = 0; 
      Object choice = ae.getSource();
      
      if(choice == about){
            
         JOptionPane.showMessageDialog(null, "A programm by Annu Kuriakose\n for Homework 7 GUI!!","About",
         JOptionPane.INFORMATION_MESSAGE);
         
      }else if(choice == load){
            
         int loadedOrNot = loadOrder();
         if(loadedOrNot>0){
            JOptionPane.showMessageDialog(null, "Previous data has been loaded","Data",JOptionPane.INFORMATION_MESSAGE);
         }else{
            JOptionPane.showMessageDialog(null, "No previous data available.\n This is the first run","Data",
               JOptionPane.WARNING_MESSAGE);
         }
      }else if(choice == jbQuit || choice == exit){
         
         writeOrders();
         try{
             oos.close();
         }catch(IOException io){
            System.out.println("exit: "+io);
         }
         System.exit(0);
            
      }
      else if(choice == jbSave){
         
         saveOrder(); 
         JOptionPane.showMessageDialog(null, "Order has been saved!\n Please proceed.. ","Order",JOptionPane.INFORMATION_MESSAGE);
         resetTextField();
         
      }else if(choice == jbFirst){
         
         JOptionPane.showMessageDialog(null, ""+firstOrder(),"First Order",JOptionPane.INFORMATION_MESSAGE);
         resetTextField();
         
      }else if(choice == jbLast){
         
         JOptionPane.showMessageDialog(null, ""+lastOrder(),"Last Order",JOptionPane.INFORMATION_MESSAGE);
         resetTextField();
         
      }else if(choice == jbPrev){
         
         JOptionPane.showMessageDialog(null, ""+prevOrder(),"Order",JOptionPane.INFORMATION_MESSAGE);
         resetTextField();
         
      }else if(choice == jbNext){
         
         JOptionPane.showMessageDialog(null, ""+nextOrder(),"Order",JOptionPane.INFORMATION_MESSAGE);
         resetTextField();
      
      }
         
   }//end of actionPerformed
   
   
   
   
   /**
     * resetTextField() method resets the TextFields when invoked
     *
     * return: none
     */
   public void resetTextField(){
   
      jtfModel.setText("");
      jtfColor.setText("");
      jtfCost.setText("");
   }
   
   /**
     *loadOrder() loads the data from previous execution to the array list.
     *
     *return: int
     */
   public int loadOrder(){
      
      boolean fileFlag = true;
      int count = 0;
      try{
         
         if(outputFile.exists()){
            fis = new FileInputStream("VehicleOrderss.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(fileFlag){
               try{
                  
                  vehicleList.add(ois.readObject());  //reading data from file to arrayList
                  count++;
               }
               catch(EOFException ee){
                  fileFlag = false;
               }
            }
         }
      }
      catch(FileNotFoundException e){
         System.out.println("Catch2");
      }
      catch(Exception e){
         System.out.println("Catch3"+e);
      }
      
      return count;   
   }
   
   
   /**
     *saveOrder() saves the data retrieved from GUI.
     *
     *return: none
     */
   public void saveOrder(){
      
      //Saving the data entered to the binary as well as txt file according to the vehicle ordered.
         String[] array;
         String vehicleSelected = (String)jcVehicle.getSelectedItem();
               
         switch(vehicleSelected){
               
               case "Truck"            : Truck truck = new Truck();
                                         vehicleList.add(truck);
                                         break;
                                         
               case "Car"              : Car car = new Car();
                                         vehicleList.add(car);
                                         break;
                                         
               case "Boat"             : Boat boat = new Boat();
                                         vehicleList.add(boat);
                                         break;
                                       
                                                                                  
               case "Unicycle"         : Unicycle unicycle = new Unicycle();
                                         vehicleList.add(unicycle);
                                         break;
                                         
               case "Motorcycle"       : Motorcycle motorcycle = new Motorcycle();
                                         vehicleList.add(motorcycle);
                                         break;
                                         
               case "PassengerAircraft": PassengerAircraft aircraft = new PassengerAircraft();
                                         vehicleList.add(aircraft);
                                         break;
                                         
               default                 : break;
               
        }
   }
   
   /**
     * firstOrder() displays first order from arrayList.
     *
     * return: none
     */
   public String firstOrder(){
      
      String outputString;
      int listSize = vehicleList.size();
      if(listSize>0){
            if( vehicleList.get(0) instanceof Car ){
               Car c = (Car)vehicleList.get(0);
               outputString = c.toString();

            }
            else if(vehicleList.get(0) instanceof Truck){
               Truck t = (Truck)vehicleList.get(0);
               outputString = t.toString();

            }
            else if(vehicleList.get(0) instanceof Boat){
               Boat b = (Boat)vehicleList.get(0);
               outputString = b.toString();

            }
            else if(vehicleList.get(0) instanceof Unicycle){
               Unicycle u = (Unicycle)vehicleList.get(0);
               outputString = u.toString();

            }
            else if(vehicleList.get(0) instanceof Motorcycle){
               Motorcycle m = (Motorcycle)vehicleList.get(0);
               outputString = m.toString();

            }
            else {
               PassengerAircraft p = (PassengerAircraft)vehicleList.get(0);
               outputString = p.toString();

            }
        }else{
        
            outputString = "List is Empty";
        }
        navigator = 0;
        return outputString;
   }
   
   
   
   /**
     * lastOrder() displays first order from arrayList.
     *
     * return: none
     */
   public String lastOrder(){
      
      String outputString;
      int listSize = vehicleList.size();
      if(listSize>0){
         if( vehicleList.get(listSize - 1) instanceof Car ){
                  Car c = (Car)vehicleList.get(listSize - 1);
                  outputString = c.toString();
   
               }
               else if(vehicleList.get(listSize - 1) instanceof Truck){
                  Truck t = (Truck)vehicleList.get(listSize - 1);
                  outputString = t.toString();
   
               }
               else if(vehicleList.get(listSize - 1) instanceof Boat){
                  Boat b = (Boat)vehicleList.get(listSize - 1);
                  outputString = b.toString();
   
               }
               else if(vehicleList.get(listSize - 1) instanceof Unicycle){
                  Unicycle u = (Unicycle)vehicleList.get(listSize - 1);
                  outputString = u.toString();
   
               }
               else if(vehicleList.get(listSize - 1) instanceof Motorcycle){
                  Motorcycle m = (Motorcycle)vehicleList.get(listSize - 1);
                  outputString = m.toString();
   
               }
               else {
                  PassengerAircraft p = (PassengerAircraft)vehicleList.get(listSize - 1);
                  outputString = p.toString();
   
               }
            }else{
            
                  outputString = "List is Empty";
            }
            navigator = listSize - 1;
            return outputString;
   }
   
   
    /**
     * writeOrders() displays first order from arrayList.
     *
     * return: none
     */
   public void writeOrders(){
      
      try{   
         fout = new FileOutputStream(outputFile);
         oos = new ObjectOutputStream(fout);
         
         for(int i=0; i<vehicleList.size();i++){
         
            oos.writeObject(vehicleList.get(i));
         
            if( vehicleList.get(i) instanceof Car ){
               Car car = (Car)vehicleList.get(i);
               car.carFileWrite();

            }
            else if(vehicleList.get(i) instanceof Truck){
               Truck truck = (Truck)vehicleList.get(i);
               truck.truckFileWrite();

            }
            else if(vehicleList.get(i) instanceof Boat){
               Boat boat = (Boat)vehicleList.get(i);
               boat.boatFileWrite();

            }
            else if(vehicleList.get(i) instanceof Unicycle){
               Unicycle unicle = (Unicycle)vehicleList.get(i);
               unicle.unicleFileWrite();

            }
            else if(vehicleList.get(i) instanceof Motorcycle){
               Motorcycle motor = (Motorcycle)vehicleList.get(i);
               motor.motorcycleFileWrite();

            }
            else {
               PassengerAircraft craft = (PassengerAircraft)vehicleList.get(i);
               craft.passengerAircraftFileWrite();

            } 
         }   
      }catch(IOException ie){
            System.out.println("Writing files"+ie);
      }catch(Exception e){
            System.out.println(""+e);
      }
   }
   
   
   /**
     * prevOrder() displays previous order from arrayList.
     *
     * return: String
     */

   public String prevOrder(){
      
      String outputString = "List is Empty";
      int listSize = vehicleList.size();
      if(listSize>0){
         
         if(navigator > 0){
            
            navigator--;
            if( vehicleList.get(navigator) instanceof Car ){
                  Car c = (Car)vehicleList.get(navigator);
                  outputString = c.toString();
   
            }
            else if(vehicleList.get(navigator) instanceof Truck){
                  Truck t = (Truck)vehicleList.get(navigator);
                  outputString = t.toString();
   
            }else if(vehicleList.get(navigator) instanceof Boat){
                  Boat b = (Boat)vehicleList.get(navigator);
                  outputString = b.toString();
   
            }else if(vehicleList.get(navigator) instanceof Unicycle){
                  Unicycle u = (Unicycle)vehicleList.get(navigator);
                  outputString = u.toString();
   
            }else if(vehicleList.get(navigator) instanceof Motorcycle){
                  Motorcycle m = (Motorcycle)vehicleList.get(navigator);
                  outputString = m.toString();
   
            }else {
                  PassengerAircraft p = (PassengerAircraft)vehicleList.get(navigator);
                  outputString = p.toString();
   
            }
         }else{
         
            outputString = "This is the first order in the List!";
         }
      
      }
      return outputString;
   }
   
   
   
   /**
     * nextOrder() displays next order from arrayList.
     *
     * return: String
     */

   public String nextOrder(){
      
      String outputString = "List is Empty";
      int listSize = vehicleList.size();
      if(listSize>0){
         
         if(navigator < (listSize-1)){
            
            navigator++;
            if( vehicleList.get(navigator) instanceof Car ){
                  Car c = (Car)vehicleList.get(navigator);
                  outputString = c.toString();
   
            }
            else if(vehicleList.get(navigator) instanceof Truck){
                  Truck t = (Truck)vehicleList.get(navigator);
                  outputString = t.toString();
   
            }else if(vehicleList.get(navigator) instanceof Boat){
                  Boat b = (Boat)vehicleList.get(navigator);
                  outputString = b.toString();
   
            }else if(vehicleList.get(navigator) instanceof Unicycle){
                  Unicycle u = (Unicycle)vehicleList.get(navigator);
                  outputString = u.toString();
   
            }else if(vehicleList.get(navigator) instanceof Motorcycle){
                  Motorcycle m = (Motorcycle)vehicleList.get(navigator);
                  outputString = m.toString();
   
            }else {
                  PassengerAircraft p = (PassengerAircraft)vehicleList.get(navigator);
                  outputString = p.toString();
   
            }
         }else{
         
            outputString = "This is the last order in the List!";
         }
      
      }
      return outputString;
   }
}//end of class OrderScreen