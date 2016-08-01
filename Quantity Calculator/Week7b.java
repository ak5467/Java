import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Week7b extends JFrame implements ActionListener {
   
   private JTextField jtfPrice;
   private JTextField jtfQty;
   private JTextField jtfTotal;
   
   private JButton jbCalc;
   private JButton jbExit;

   public static void main(String [] args){
      new Week7b();
   } // end main

   public Week7b(){
      
      setTitle("Week 7b");
      
      // create overall GUI layout
      
      
      // create North title
      add( new JLabel("Some title",JLabel.CENTER), BorderLayout.NORTH );
      
      // Create center grid work
      JPanel jpGrid = new JPanel( new GridLayout(0,2) );
         jpGrid.add( new JLabel("Price: ",JLabel.RIGHT) );
         jtfPrice = new JTextField(10);
         jpGrid.add( jtfPrice );
         
         jpGrid.add( new JLabel("Qty: ",JLabel.RIGHT) );
         jtfQty = new JTextField(10);
         jpGrid.add( jtfQty );
         
         jpGrid.add( new JLabel("Total: ",JLabel.RIGHT) );
         jtfTotal = new JTextField(10);
         jpGrid.add( jtfTotal );

      add(jpGrid, BorderLayout.CENTER );               
      
      // create south buttons
      JPanel jpBtns = new JPanel();
         jbCalc = new JButton("Calc");
         jbExit = new JButton("Exit");
         
         jbCalc.addActionListener( this );   // register the listener
         jbExit.addActionListener( this );
         
         jpBtns.add( jbCalc );
         jpBtns.add( jbExit );
      add( jpBtns, BorderLayout.SOUTH );
      
      // admin - "Make it so!"
      pack();
      setLocationRelativeTo( null );
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);      
      setVisible( true );
   
   } // end week7b constructor

   public void actionPerformed(ActionEvent ae){
      Object choice = ae.getSource();
      
      if( choice == jbCalc ){
         System.out.println("Caclulating");
         double price = Double.parseDouble(jtfPrice.getText());
         double qty   = Double.parseDouble(jtfQty.getText());
         double total = price * qty;
         jtfTotal.setText( String.format("$%,.2f",total) );
      }
      else if(choice == jbExit ){
         System.out.println("Exiting");
         System.exit(0);
      }
      else
         System.out.println("Don't know how we got here with:\n"+choice);
   
   } // end actionPerformed


} // end class