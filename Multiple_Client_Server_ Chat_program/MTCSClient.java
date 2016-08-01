import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: MTCS Client
  * Date    : 05/02/2016
  *
  *Purpose: <b><i>A GUI to the user as a client</b></i>
  *         <br/> This program sends the msgs entered by multiple clients over to the server
  *          and thus to other clients thereby facilitating a chat
  *
  * date: 05/02/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  **/


public class MTCSClient extends JFrame{
   
   private JPanel jGrid;
   private JPanel jText;
   private JMenu menu;
   private JMenuBar jmb;
   private JMenuItem exit;
   private JTextArea jta;
   private JScrollPane jsp;
   private JTextField jtf;
   private JButton jb;
   PrintWriter pw;
   BufferedReader br;
   boolean flag = true;
   
   public static void main(String[] args){
      
      new MTCSClient().setVisible(true); 
      
   }
   
   //constructor
   public MTCSClient(){
      
      try{
         
         //initializing all IO and sockets
         Socket sock = new Socket("localhost", 16789);
         br = new BufferedReader(new InputStreamReader(sock.getInputStream()));   
         pw = new PrintWriter(sock.getOutputStream());
      
      }catch(ConnectException ce){
         System.out.println("Server not started yet");
         flag = false;
      }catch(SocketException se){
            
         se.printStackTrace();
         System.out.println("Server terminated. Terminating client as well");
         System.exit(1);
      
      }catch(UnknownHostException ie){
         ie.printStackTrace();      
      
      }catch(IOException ue){
         ue.printStackTrace();      
      
      }
      
      //start the threads
      if(flag){
         ThreadClass t1 = new ThreadClass();
         t1.start();
      }
      setTitle("MTCS Client");
      
      //menu to have file -> exit
      jGrid = new JPanel(new GridLayout(0,1));
      jmb = new JMenuBar();
      menu = new JMenu("File");
         exit = new JMenuItem("Exit");
         menu.add(exit);  
      setJMenuBar(jmb);
      jmb.add(menu);
      
      //adding textArea and scorlling pane
      jta = new JTextArea(20,15);
      jta.setEditable(false);
      jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      jGrid.add(jsp);      
      add(jGrid,BorderLayout.CENTER);
      
      //adding textField and send button
      jText = new JPanel(new GridLayout(0,2));
      jtf = new JTextField(20);
      jb = new JButton("Send");
      jText.add(jtf);
      jText.add(jb);
      add(jText,BorderLayout.SOUTH);
      
      //adding action listeners
      exit.addActionListener(new ActionListener(){
			public void	actionPerformed(ActionEvent ae){
					System.exit(0);
		   }
		});
      
      jb.addActionListener(new ActionListener()	{
			public void	actionPerformed(ActionEvent ae){
					if(flag){
                  sendMessage();
               }
			}
		});
      
      //JFrame settings
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(400,200);

   }
   
   /* sendMessage(): to send the msg over to the server
    *
    */
   public void sendMessage(){
      
      String msg = jtf.getText();
      System.out.println(msg+"\n");
      pw.println(msg);
      pw.flush();
      jtf.setText("");
   }
   
   /*
    * ThreadClass: extends the Thread class
    *              monitors the replies from server
    *
    */
   class ThreadClass extends Thread{
   
      
      public void run(){
         
         String inputMsg;
         try{
            while(true){ 
               inputMsg = br.readLine();
               jta.append(inputMsg+"\n");
            }
         }catch(SocketException se){
            System.out.println("Server terminated. Terminating client as well");
            System.exit(1);
         }catch(IOException ie){
            ie.printStackTrace();
         
         }
      }
   }

}