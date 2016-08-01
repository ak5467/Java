import java.util.*;

/**
  * purpose: This program calculates the standard grade point average(GPA) for a student at RIT. 
  *          Prompt will accept credits and grades of all the four subject and calculate sum of credits ad sum of points as below:
  *          Sum of credit = Credit1+Credit2+credit3+Credit4
  *          Sum of points = (Credit1*gradevalue)+(Credit2*gradevalue)+(credit3*gradevalue)+(Credit4*gradevalue)
  *          Grade values are : A = 4, B = 3, C = 2, D = 1, F = 0
  *           
  * date: 02/10/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

public class Gpa{
   
   public static final int NUM_COURSES = 4;

   public static void main(String [] args){
      
     // int a = 4, b = 3, c = 2, d = 1, f = 0, value = 0;
      int[] creditArray = new int[4]; 
      String[] gradeArray = new String[4];
      int[] pointArray = new int[4];
      
      
      float sum_credits = 0;
      float sum_points = 0;
      float gpa = 0;
      
      Scanner scan = new Scanner(System.in);
      
      for(int i = 0; i<NUM_COURSES; i++){
         System.out.println("Enter credits for course "+(i+1));
         creditArray[i] = scan.nextInt();
         System.out.println("Enter grade for course "+(i+1));
         gradeArray[i] = scan.next();

      }
       
      for(int element : creditArray){
           sum_credits += element;
      }
      
      for(int i = 0;i<gradeArray.length;i++){
         switch(gradeArray[i]){
         
            case "A":
            case "a": pointArray[i] = creditArray[i]*4;
                      break;
            case "B":
            case "b": pointArray[i] = creditArray[i]*3;
                      break;
            case "C":
            case "c": pointArray[i] = creditArray[i]*2;
                      break;
            case "D":
            case "d": pointArray[i] = creditArray[i]*1;
                      break;
            default : pointArray[i]=0;     
                      break;              
                    
         }//end of switch
       
      }//end of for loop
      
      for(int element : pointArray){
           sum_points+= element;
      }
      
      gpa = sum_points/sum_credits;
      
      System.out.println();
      System.out.println("Total number of credits: "+(int)sum_credits);
      System.out.println("Total number of points: "+(int)sum_points);
      System.out.printf("%nGPA: %.2f", gpa);
      
   }//end main
}//end class