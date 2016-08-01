import java.util.*;
import java.lang.*;

/**
  * purpose: This program will read a count and the respective set of values to generate standard deviation.
  *          formula used is Standard Deviation = sqrt[(1/N)* sumof(Xi-µ)^2)] 
  *          where N = count, Xi = each number, µ = mean of the numbers
  *          
  * 
  * date: 02/13/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class Stdev{
   
   public static void main(String []  args){
   
      int count = 0;
      float mean = 0, standardDeviation = 0;
      float sum = 0, sumOfSquares = 0;

      
      //read the count or number of values from the user
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter a count for the numbers: ");
      count = scan.nextInt();
      
      // initializing arrays with length 'count'
      float numberArray[] = new float[count];
      float diffSquareArray[] = new float[count];      
      
      //reading the 'count' number of input values 
      System.out.println("Enter all the "+count+" numbers. \n PS: only the first "+count+" values will be taken under consideration.");
      for(int i = 0; i<numberArray.length; i++){
          numberArray[i] = scan.nextFloat();
      }
      
      //Calculating mean, µ
      for(int i = 0; i<count; i++){
         sum+=numberArray[i];
      }     
      mean = sum/count;
      
      //calculating (Xi-µ)^2 for each input value
      for(int i = 0; i<count; i++){
         float difference = 0;
         difference = (numberArray[i]-mean); //each Xi-µ
         difference = difference*difference; //each (Xi-µ)^2
         
         diffSquareArray[i] = difference;
      }
      
      //calculation sum of [(Xi-µ)^2]
      for(int i = 0; i<count; i++){
         sumOfSquares+=diffSquareArray[i];
      }
      
      //Calculating Standard deviation of the numbers
      standardDeviation = (float)Math.sqrt(sumOfSquares/count);
     
      System.out.println("Standard Deviation of the inputs: "+standardDeviation); 

   }//end of main
   
}