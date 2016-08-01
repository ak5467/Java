
public class Football extends Ball {
   
   private double price = 20.5;
   
   public void move(String _location){
      
      System.out.println("Running the Football class move method");
      System.out.println("Location: "+_location);
   }
   public void displayPrice(){
      
      System.out.println("Price of the ball: "+price);
   }
}