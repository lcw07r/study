/**
 * 
 */
package lab8Part3;

/**
 * @author lcw102
 *
 */
public abstract class Cycle extends RoadVehicle{

	/**
	 * 
	 */
	public Cycle(String name, int speed) {
		// TODO Auto-generated constructor stub
		super(name, speed);
	}
	
	public void makeNoise(){
		System.out.println("Ding-ding");
	}
	
	public abstract int getNumberOfWheels();

}
