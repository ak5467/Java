import java.lang.*;

public class Ball{

   private double diameter = 10;
   private double area;
   private String color = "Red";
   private String location = new String();
   
   public void changeColor(String _color){
   
      System.out.println("Running the Ball class ChangeColor method");
      color = _color;
      System.out.println("color: "+color);
   }
   
   public void area(){
   
      System.out.println("Running the Ball class area method");
      area = Math.PI*(10/2)*(10/2);
      System.out.println("Area: "+area);
   }
   
   public void move(String _location){
   
      System.out.println("Running the Ball class move method");
      location = _location;
      System.out.println("Location: "+location);
   }

}