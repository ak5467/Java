/**
  * Interface Vinfo: Stores Constants and abstract method related to mileage
  * 
  * @param: CRUISER           stores gas mileage of cruiser
  * @param: SPORTBIKE         stores gas mileage of sportbike
  * @param: DIRTBIKE          stores gas mileage of dirtbike
  * @param: CARMILEAGE        array that stores gas mileage of all types of cars
  * @param: BOATMILEAGE       stores gas mileage of all types of boats
  * @param: AIRCRAFTMILEAGE   stores gas mileage of all types of aircrafts
  *
  */

public interface Vinfo{
   
   //Constants declaration
   final static double CRUISER = 10.5;
   final static double SPORTBIKE = 11.5;
   final static double DIRTBIKE = 14.5;
   final static double[] CARMILEAGE = {23.7, 28.2, 19.5};
   final static double[] BOATMILEAGE = {3.5,2.2,0};
   final static double[] AIRCRAFTMILEAGE = {405.2,300.3,200.4};
   
   
   /**
     *Method gasMileage(): abstract method for gas mileage calculation
     *
     */
   public double gasMileage();
}