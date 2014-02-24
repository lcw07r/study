/**
 * 
 */
package lab8Part3;

/**
 * @author lcw102
 *
 */
public abstract class RoadVehicle extends Transport{
	private int maxSpeed;

	public RoadVehicle(String name, int speed) {
		// TODO Auto-generated constructor stub
		super(name);
		maxSpeed = speed;		
	}
	
	public int getMaxSpeed(){
		return maxSpeed;
	}

	public abstract void makeNoise();
}
