import java.lang.*;

public class BowlingBall extends Ball{

   
   private double price = 10.5;
   public void area(){
      
      double area;
      System.out.println("Running the BowlingBall class area method");
      area = Math.PI*(10)*(10);
      System.out.println("Area: "+area);
   }
   
   public void displayPrice(){
      
      System.out.println("Price of the ball: "+price);
   }

}