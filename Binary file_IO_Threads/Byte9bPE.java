import java.io.*;
import java.util.*;
public class Byte9bPE{
   
   DataInputStream dis; 
   int totalCount;
   int sum;
   Vector<Integer> countArray = new Vector<>();
  Vector<Integer> numArray = new Vector<>();

   private File aFile = null;
  
  //storing file names
  String[] names = {"integer1.dat", "integer2.dat","integer3.dat","integer4.dat",
         "integer5.dat","integer6.dat", "integer7.dat", "integer8.dat"};
  
   public static void main(String[] args){
      
      new Byte9bPE();
   
   }//end of main
   
   public Byte9bPE(){
      
      try{
         
         for(int i = 0; i<names.length; i++){
            MyThread myTh = new MyThread(new File(names[i]));
            myTh.start();
           // myTh.join();
         }            
      }catch(Exception e ){
         System.out.println("catch4 "+e);
      }

   }
   
   class MyThread extends Thread{
      
      File aFile;
      
      public MyThread(File _theFile){
         aFile = _theFile;      
      }
      
      public void run(){
      
         doTheJob();
      }
      
      public void doTheJob(){
         
         synchronized(numArray){

            sum = 0;
            totalCount = 0;
            numArray.removeAllElements();
            boolean flag = true;
            try{
               dis = new DataInputStream(new BufferedInputStream(new FileInputStream(aFile)));
            }catch(FileNotFoundException ne ){
               flag = false;
               System.out.println("File does not exist: "+aFile);
               return;
            }
            while(flag){
               try{
                    numArray.add(dis.readInt());
               
               }catch(IOException ie ){
                    flag = false;
                    //System.out.println("catch6 "+ie);
               }catch(Exception e ){
                    flag = false;
                    //System.out.println("catch7 "+e);
               }
            }
            if(numArray.size()>0){
               countArray.add(numArray.size());
               for(int i =0; i<numArray.size(); i++){
                  sum = sum+numArray.get(i);
               }
               if(countArray.size()>0){
                  for(int i=0; i<countArray.size(); i++){
                     totalCount = totalCount+countArray.get(i);
                  }
               }
               System.out.printf("FIleName: "+aFile+" Count =  %,7d   Sum = %,12d   In List = %,8d %n" , numArray.size(), sum, totalCount);
            }
            else{
            
               System.out.println("Empty file");
            }
       }  
      }
   }
}