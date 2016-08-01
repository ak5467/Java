import java.io.*;
import java.util.*;
import java.net.*;

/**
  * Name    : Annu Kuriakose <br/>
  * Course  : ISTE 200.01 <br/>
  * Homework: MTCS Server
  * Date    : 05/02/2016
  *
  *Purpose: <b><i>Server for Multithreaded client-server chat</b></i>
  *         <br/> This program accepts the msgs entered by multiple clients 
  *          and sends to other clients thereby facilitating a chat.
  *
  * date: 05/02/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  **/

public class MTCSServer{
   
   Vector<PrintWriter> pwVector = new Vector<>();
   PrintWriter pw;
   BufferedReader br;
   ServerSocket ss;
   Socket sock;
   
   
   public static void main(String[] args){
      new MTCSServer();
   }
   
   //constructor
   public MTCSServer(){

      try{
         
         //initializing all sockets
         ss = new ServerSocket(16789);
         System.out.println("Server started");
         while(true){
   
            sock = ss.accept();                   
            new ThreadClass().start();
            
         }
      }catch(ConnectException ce){
      
         System.out.println("Server not started");
         
      }catch(SocketException se){
      
         se.printStackTrace();
      }catch(UnknownHostException ue){
      
         ue.printStackTrace();
      }catch(IOException ioe){
      
         ioe.printStackTrace();
      }
      
   }
   
   
   
   /*
    * ThreadClass: extends the Thread class
    *              monitors the msgs from the clients
    *
    */
   class ThreadClass extends Thread{
   
      
      public void run(){
                 
         String inMsg;
         try{
            
            //initializing all IO.
            pw = new PrintWriter(sock.getOutputStream());
            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            pwVector.add(pw);
            PrintWriter apw;
            
            while(true){ 
               
               //reading msgs from clients
               inMsg = br.readLine();
               System.out.println(inMsg+"\n");
               for(int i =0; i<pwVector.size(); i++){
                  apw = pwVector.get(i);
                  apw.println(inMsg);
                  apw.flush();
                  
               }
            }
            
         }catch(SocketException se){
            System.out.println("Client disconnected");
         }catch(IOException ie){
            ie.printStackTrace();
               
         }
      }
   }

}