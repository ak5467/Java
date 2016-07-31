/**
  * purpose: This program will read two sides of a right angled triangle and compute the hypotenuse using the Pythagorean theorem:
  *          Formula used is (a*a) + (b*b) = (c*c)
  *          where a, b are the two shorter sides of the triangle and c is the longest side.
  * 
  * date: 01/31/2016.
  *@author: Annu Kuriakose
  *@version: 1.0
  *
  */

import java.lang.*;
public class Hypot {
 
   public static void main(String [] args) {
      double hypotenuse;
      double d1 = 0;
      double d2 = 0;
      
      //Two sides of the triangle are given as command line inputs.
      if (args.length != 2) {
          System.out.println("You need to enter two args.");
          System.exit(1);
      }

      //convert the values given from string to double type and store them.
      try {
         d1 = Double.parseDouble(args[0]);
         d2 = Double.parseDouble(args[1]);
      } //Any non number input format exceptions will be caught and program will be terminated.
      catch(NumberFormatException nfe) {
         System.out.println("Arguments need to be numbers.");
         System.exit(2);
      }

      //The below segment varifies if the values entered justifies to be a side of a triangle.
      if( d1<=0 || d2<=0) {
         System.out.println("Both arguments need to be greater than zero");
         System.exit(3);
      }

      //Calculates hypotenuse using pythagoras theorem.
      hypotenuse = Math.sqrt((d1*d1)+(d2*d2));
      System.out.print("The hypotenuse of a right triangle with sides of ");
      System.out.println(d1 + " and " + d2);
      System.out.println(" is " + hypotenuse);
   }
}