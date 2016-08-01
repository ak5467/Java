import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ThreadPePart2 extends JFrame implements ActionListener{
   
   private JPanel jGrid;
   private JButton newB;
   boolean keepGoing = true;
   boolean indeterminate;
   
   public static void main(String[] args){
      
      new ThreadPePart2().setVisible(true);
   
   }
   
   public ThreadPePart2(){
      
      setTitle("Lab 2");
      jGrid = new JPanel(new GridLayout(0,2));
      newB = new JButton("Let's start the show");
      add(newB, BorderLayout.NORTH);
      add(jGrid, BorderLayout.CENTER);
      
      JProgressBar jpb1 = new JProgressBar();
      JProgressBar jpb2 = new JProgressBar();
      JProgressBar jpb3 = new JProgressBar();
      
      InnerProgress iProg1 = new InnerProgress("Progress#1", jpb1);
      InnerProgress iProg2 = new InnerProgress("Progress#2", jpb2);
      InnerProgress iProg3 = new InnerProgress("Progress#3", jpb3);
      
      newB.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            Thread th1 = new Thread(iProg1);
            Thread th2 = new Thread(iProg2);
            Thread th3 = new Thread(iProg3);
            
            th1.start();
            th2.start();
            th3.start();
            
            newB.setEnabled( false );
            Thread extra = new Thread(){
               public void run() {
                  try{
                     th1.join();
                     th2.join();
                     th3.join();
                  }catch(InterruptedException ie){
                     System.out.println("interrupt");
                  }
                  newB.setEnabled( true );
               }
            };
            extra.start();
         }
      });
      
      
      jGrid.add(iProg1);
      jGrid.add(new JLabel(""));
      jGrid.add(iProg2);
      jGrid.add(new JLabel(""));
      jGrid.add(iProg3);
      
      pack();
      //setSize(300,400);
      setLocationRelativeTo( null );
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   
   public void actionPerformed(ActionEvent e){
   
   
   }
   
   class InnerProgress extends JPanel implements Runnable{
      
      private String progress;
      private JProgressBar jpBar;
      
      public InnerProgress(String _progress, JProgressBar _jpBar){
         
         progress = _progress;
         jpBar = _jpBar;
         
         indeterminate = true;
         
         jpBar.setMinimum(0);
         jpBar.setMaximum(80);
         jpBar.setStringPainted( true );
         
         add( new JLabel(progress,JLabel.RIGHT) );
         add(jpBar);
      }
      
      public void run(){
         try{
            indeterminate = false;
            int i;
            for( i = 0; i<=80 & keepGoing; i++){
               
               Thread.sleep((long)((Math.random())*100));
               jpBar.setValue(i);
               System.out.println("Thread running: "+progress+", Time eveolved: "+System.currentTimeMillis());
            }
            keepGoing = false;
            synchronized(jpBar){
               if(i<80){
                  System.out.println("The Thread "+progress+" did not finish first");
               }else if(!keepGoing){
                  System.out.println("The Thread "+progress+" finished first");
               }
            }
            
         }catch(InterruptedException ie){
            System.out.println("Interrupted: "+ie);
         }
      
      }
   
   
   }

}