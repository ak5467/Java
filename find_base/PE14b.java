import java.lang.*;
/*
   A command line argument program, 
   which convert the number entered to a specified base.
   
 */
 
public class PE14b{
   
   static int num;
   static int base;
   
   public static void main(String[] args){
      
      if(args.length<2){
         System.out.println("Enter a number and a base");      
      }else{
         num = Integer.parseInt(args[0]);
         base = Integer.parseInt(args[1]);
      }
      
      new PE14b();
   }
   
   public PE14b(){
      printBase(num, base);
   }
   
   public void printBase(int number, int baseVal){
      
      int n = number;
      int b = baseVal;
      
      if(n/b >0){  
         printBase(n/b, b);
      }
      
      System.out.print(n%b);
   
   }


}