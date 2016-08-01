import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.io.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: Timer Fun
  * Date    : 05/02/2016
  *
  *Purpose: <b><i>This program includes: Changing label fonts via Java classes, File I/O,
  *               Color class, JProgressBar, anonymous inner classes, 
  *               SimpleDateFormat class, Thread’s sleep() method and arrays lists.</b></i>
  *
  *
  * date: 05/02/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  **/

public class TimerFun extends JFrame{
   
   private JMenuBar jmb;
   private JMenu file;
   private JMenu help;
   private JMenuItem exit;
   private JMenuItem about;
   private JPanel jpClock;
   private JLabel jClock;
   
   private JPanel jpColor;
   private JPanel jpColor1;
   private JPanel jpColor2;
   private JPanel jpColor3;
   private JPanel jpColor4;
   private JPanel jpColor5;
   private JPanel jpColor6;
   private JPanel jpColor7;
   
   private JProgressBar jpb1;
   private JProgressBar jpb2;
   private JPanel jProg;
   private boolean flag = true;
   private boolean keepGoing = true;
   
   BufferedReader br;
   
   ArrayList<Color> colorArray = new ArrayList<>();
   
   File firstFile = new File("words.txt");
   File secondFile = new File("UnabridgedDictionary.txt");
   
   
   //static main class
   public static void main(String[] args){
      new TimerFun().setVisible(true);
   }
   
   //constructor
   public TimerFun(){
      
      //set the title
      setTitle("Fun with Timers");
      
      //set the menubar
      jmb = new JMenuBar();
      file = new JMenu("File");
      help = new JMenu("Help");
      exit = new JMenuItem("Exit");
      about = new JMenuItem("About");
      setJMenuBar(jmb);
      jmb.add(file);
      jmb.add(help);
      file.add(exit);
      help.add(about);
      
      //setup for clock
      jpClock = new JPanel();
      jClock = new JLabel(new SimpleDateFormat("EEE, dd MMM YYYY HH:mm:ss").format(System.currentTimeMillis()));
      jClock.setFont(new Font("Serif", Font.BOLD, 25));
      jClock.setForeground(Color.BLUE);
      jpClock.add(jClock);
      
      add(jpClock, BorderLayout.NORTH);
      
      //using timer to set clock
      javax.swing.Timer t1 = new javax.swing.Timer(1000, new ActionListener(){
         public void actionPerformed(ActionEvent e){
            jClock.setText(new SimpleDateFormat("EEE, dd MMM YYYY HH:mm:ss").format(System.currentTimeMillis()));
         }
      });
      t1.start();
      
      //defining colors on the array
      colorArray.add(Color.ORANGE);
      colorArray.add(Color.YELLOW);
      colorArray.add(Color.GREEN);
      colorArray.add(Color.BLUE);
      colorArray.add(new Color(75,0,130));
      colorArray.add(new Color(128,0,128));
      colorArray.add(Color.RED);
      
      //adding panels and corresponding colors
      jpColor1 = new JPanel();
      jpColor1.setBackground(colorArray.get(0));
      jpColor2 = new JPanel();
      jpColor2.setBackground(colorArray.get(1));
      jpColor3 = new JPanel();
      jpColor3.setBackground(colorArray.get(2));
      jpColor4 = new JPanel();
      jpColor4.setBackground(Color.BLUE);
      jpColor5 = new JPanel();
      jpColor5.setBackground(colorArray.get(4));
      jpColor6 = new JPanel();
      jpColor6.setBackground(colorArray.get(5));
      jpColor7 = new JPanel();
      jpColor7.setBackground(colorArray.get(6));
      
      jpColor = new JPanel(new GridLayout(0,1));
      
      //adding all color panels to a common panel
      jpColor.add(jpColor1);
      jpColor.add(jpColor2);
      jpColor.add(jpColor3);
      jpColor.add(jpColor4);
      jpColor.add(jpColor5);
      jpColor.add(jpColor6);
      jpColor.add(jpColor7);
      
      add(jpColor, BorderLayout.CENTER);
      
      //adding progress bars
      jpb1 = new JProgressBar();
      jpb2 = new JProgressBar();
      
      jProg = new JPanel(new GridLayout(0,2));
      jProg.add(new JLabel("Words Progress"));
      jProg.add(jpb1);
      jProg.add(new JLabel("Unabridged Progress"));
      jProg.add(jpb2);
      
      
      add(jProg, BorderLayout.SOUTH);
      
      //starting progressBars
      new MyThread(jpb1, firstFile).start();
      new MyThread(jpb2, secondFile).start();
      
      
      //starting color thread
      new MyThread(5).start();
   
      //adding actionlisteners
      exit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            new MyThread(-1).start();
         }
      });

      about.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "A programm by Annu Kuriakose\n for Homework 9!! Fun with Timers and Threads!!","About",
            JOptionPane.INFORMATION_MESSAGE);
         }
      });
      
      //JFrame settings
      pack();
      setLocation(500,300);
      setSize(350,350);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   /*
    * The thread class
    *
    *
    */
   class MyThread extends Thread{
      
      private int ex = 0;
      private JProgressBar pbo;
      private File afile;
      
      public MyThread(int _ex){
          ex = _ex;
      }
      
      public MyThread(JProgressBar _pbo, File _afile){
          pbo = _pbo;
          afile = _afile;
          pbo.setMinimum(0);
          pbo.setMaximum(80);
          pbo.setString("Opening File...");
          pbo.setStringPainted( true );
      }
   
      public void run(){
      
         if(ex == -1){
         
            try{
               Thread.sleep(2000);
               System.exit(0);
            }catch(InterruptedException ie){
               ie.printStackTrace();
            }
         }else if(ex ==5){
            startRainbow();
         }else{
            startProgressBar();
         }
         
      
      }
      
      /*
       * startRainbow(): method to start the colors rotating
       * after 2 seconds of pgm initiation
       *
       */
      public void startRainbow(){
         try{

               Thread.sleep(2000);               
               javax.swing.Timer t2 = new javax.swing.Timer(500, new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                     int i = 0;
                     Color temp;
                     if(flag){
                        temp = colorArray.get(i);
                        colorArray.set(i, colorArray.get(i+1));
                        colorArray.set(i+1, colorArray.get(i+2));
                        colorArray.set(i+2, colorArray.get(i+3));
                        colorArray.set(i+3, colorArray.get(i+4));
                        colorArray.set(i+4, colorArray.get(i+5));
                        colorArray.set(i+5, colorArray.get(i+6));
                        colorArray.set(i+6, temp);
                        
                        jpColor1.setBackground(colorArray.get(i));
                        jpColor2.setBackground(colorArray.get(i+1));
                        jpColor3.setBackground(colorArray.get(i+2));
                        jpColor4.setBackground(colorArray.get(i+3));
                        jpColor5.setBackground(colorArray.get(i+4));
                        jpColor6.setBackground(colorArray.get(i+5));
                        jpColor7.setBackground(colorArray.get(i+6));
                     }
                  }
               });
               while(flag){
                  t2.start();
               }
               Thread.sleep(2000);
               System.exit(0);
            }catch(InterruptedException ie){
               ie.printStackTrace();
            }
      
      }
      
      
      /*
       * startProgressBar(): method to start the file reading and progress bar
       *
       */
      public void startProgressBar(){
      
         try{

            int i;
            double fileLen = afile.length();
            double stringLen = 0.0;
            int percent = 0;
            String input = "";
            String line = "";
            pbo.setStringPainted(true);
            //pbo.setForeground(Color.blue);
            Thread.sleep(2000);
                        
            br = new BufferedReader(new FileReader(afile));            
            while( ( line = br.readLine())!=null & keepGoing){
               

               while(percent<100 & keepGoing){
                  input = input + line;
                  stringLen+= line.length();
                  percent = (int) (stringLen*100f/fileLen);
                  pbo.setValue(percent);
                  pbo.setString(percent+"%");
                  
                  
               }
               if(percent == 100){
                  pbo.setString("Finished Reading");
                  keepGoing = false;
                  flag  = false;
                  
               }else{
                  pbo.setString("Halting at "+percent+"%");
               }
            }
            
            br.close();
            
            Thread.sleep(2000);

         }catch(InterruptedException ie){
            System.out.println("Interrupted: "+ie);
         }catch(FileNotFoundException fe){
            System.out.println("FileNotFound: "+fe);
         }catch(IOException io){
            System.out.println("Exiting pgm");
         }
      }
   }

}