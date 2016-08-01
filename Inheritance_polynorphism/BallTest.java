

public class BallTest{

   public static void main(String[] args){
   
      Ball b;
      b = new Football();
      
      b.move("right");
      
      b = new BowlingBall();
      b.area();
      
      b.changeColor("Blue");
      
      b = new Ball();
      b.area();
   }

}