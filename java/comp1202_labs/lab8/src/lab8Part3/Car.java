/**
 * 
 */
package lab8Part3;

/**
 * @author lcw102
 *
 */
public class Car extends RoadVehicle implements Refuelable{

	/**
	 * 
	 */
	public Car(String name, int speed) {
		// TODO Auto-generated constructor stub
		super(name, speed);
	}
	
	public void makeNoise(){
		System.out.println("tu-tu");
	}
	
	public void fueltype(){
		System.out.println("you can fill a car with petrol or diesel ");
		
	}

}
