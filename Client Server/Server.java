import java.io.*;
import java.util.*;
import java.net.*;

public class Week10PEServer{
   
   boolean flag = true;
   
   public Week10PEServer(){
      while(true) {
      try{
      
      ServerSocket ss = new ServerSocket(16789);
      System.out.println("Waiting...");
      Socket sock = ss.accept();
      System.out.println("Client connected: "+sock);
      
      PrintWriter pw = new PrintWriter(sock.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

      String strLine = "";
      
      
      do{   
         strLine = br.readLine();
         if(strLine.equals(null)){
            pw.println("Done");
            pw.flush();
            flag = false;
         }else{
            pw.println(strLine);
            System.out.println("sent msg: "+strLine);
            pw.flush();
         }
      }while(flag);    
      
      br.close();
      pw.close();
      sock.close();
      ss.close();
      
      }catch(IOException ie){
         System.out.println("IO error in run"+ie);
      }
    }
      
   }
   
   public static void main(String[] args){
      
      new Week10PEServer();
   
   }
}