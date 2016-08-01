import java.io.*;
import java.net.*;

/*
 * Author: Annu Kuriakose
 * Exam 3. Client Server
 * ISTE 200-1
 *
 */

public class ClientMsg{
   
   private static int msgLen = 0;
   private static String inMsg[];
   
   public static void main(String [] args){
      
      inMsg = args;
      msgLen = args.length;
      
      new ClientMsg();
   }
   
   public ClientMsg(){
     
      
      try{
         
         // open I/O
         Socket sock = new Socket("localhost", 16789);
         BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
         PrintWriter pw = new PrintWriter(sock.getOutputStream());
         
         //sending message length to server
         pw.println(msgLen);
         pw.flush();
         
         //sending rest of the message
         for(int i= 0; i<msgLen; i++){
            
            pw.println(inMsg[i]);
            pw.flush();
            
         }
         
         //reading from the server
         String line;
         while((line = br.readLine())!=null){
            System.out.println(line);
         
         }
         
         //close IO and socket
         br.close();
         pw.close();
         sock.close();
      
      }catch(ConnectException ce){
         System.out.println("Server Not Started Yet.. Try after starting the server.");
      
      }catch(SocketException se){
         System.out.println("Terminating client."+se);
      
      }catch(UnknownHostException se){
         System.out.println("Host not known. Trace follows: "+se);
      
      }catch(IOException se){
         System.out.println("I/O Error in execution"+se);
      
      }

   }//end of constructor

}//end clas