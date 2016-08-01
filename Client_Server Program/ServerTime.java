import java.io.*;
import java.net.*;

public class ServerTime{
   private int count = 0;
   private long serverStart = 0;
	
   public static void main(String [] args){
      new ServerTime( args );
   }
	
	// ServerTime constructor (args)
   public ServerTime( String [] args ){
      serverStart = System.currentTimeMillis();
   
      try{
         ServerSocket ss = new ServerSocket( 16789 );
         System.out.println("Server started...");
      
         while( true ){
            Socket cs = ss.accept();				
            new ClientHandler( cs ).start();
         }
      }
      catch(IOException ioe){
         System.out.println("Error in Socket usage");
         ioe.printStackTrace();
         System.exit(4);
      }
   
   }	//  end of ServerTime constructor
	
	/////////////////////////////////////
	
	/**  ClientHandler handles the multi-threading processing on the server */
   public class ClientHandler extends Thread {
   	// Socket cs attribute
      private Socket cs;
   	
   	// ClientHandler constructor ( Socket cs)
      public ClientHandler( Socket cs ){
      	// save cs as attribute
         this.cs = cs;
      }
   
   	// run()
      public void run(){
         try{
            count++;
         	// open I/O
            PrintWriter send = new PrintWriter( cs.getOutputStream() );
            BufferedReader receive = new BufferedReader( new InputStreamReader( cs.getInputStream() ));
            String msg="";
            String bigMsg = "";
         					
         	// The first read is the number of words being sent.
            int max = Integer.parseInt( receive.readLine() );
         
         	// loop the number of items being sent
            for( int i=0; i< max; i++){
            	// print the items received
               msg = receive.readLine();
               System.out.println("Received:  "+msg );
               bigMsg += msg + " ";	
            } // end loop
            
            send.println(bigMsg);
            send.println( "You are client # "+count+" to connect. ");
            send.print("This server has been running for ");
            send.println(String.format("%.2f",(System.currentTimeMillis()-serverStart)/1000.0)+" seconds.");
            send.flush();
                        
            System.out.println("Finished with client "+count);
         	// close I/O & socket
            send.close();
            receive.close();
            cs.close();
         }
         catch( IOException ioe ){
            System.out.println("I/O Error in run()");
            ioe.printStackTrace();
         }
      		
      } // end run()
   		
   } // end ClientHandler

}	// end ServerTime Class