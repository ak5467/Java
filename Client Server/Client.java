import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;

public class Week10PEClient{
   
   public Week10PEClient(){
      
      try{
      Scanner scan = new Scanner(System.in);
      String input = new String();
      Socket sock = new Socket("localhost", 16789); 
      BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
      PrintWriter pw = new PrintWriter(sock.getOutputStream());
      String strLine = "";
      boolean flag = true;
      String dot = new String(".");
       String d = new String();
      ArrayList<String> output = new ArrayList<>();
      int len;
      
      while(flag){
         
         strLine = scan.next();
         output.add(strLine);
         
          len = strLine.length();
         char p = strLine.charAt(len-1);
         d = Character.toString(p);
         
         if(d.equals(dot)){
              String temp = output.get(output.size() - 1);
              System.out.println(temp);
              temp = temp.substring(0, len-1);
              System.out.println("new String."+temp);
              output.set((output.size() - 1), temp);
              flag = false;
         }
         
      }
      for(int i=0; i<output.size(); i++){
          pw.println(output.get(i));
          pw.flush();
      
      }
      
      flag = true;
      while(flag){
         String inMsg = br.readLine();
         if(input.equals("Done")){
            flag = false;
         }else
            System.out.println("From Server: "+inMsg);
      }
      
      br.close();
      pw.close();
      sock.close();
         
      }catch(ConnectException ce){
         System.out.println("Server not up"+ce);
      }catch(SocketException se){
         System.out.println("Server disconnected. "+se);
      }catch(UnknownHostException ue){
         System.out.println("Host not known"+ue);
      }catch(IOException ie){
         System.out.println("IO error in run");
      }
      
   }
   
   public static void main(String[] args){
      
      new Week10PEClient();      
      
   }

}