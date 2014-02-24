/**
 * 
 */
package lab8Part3;

/**
 * @author lcw102
 *
 */
public class JetPlane extends Transport implements Refuelable{
	private int numberOfPassenger;
	/**
	 * 
	 */
	public JetPlane(String name, int passenger) {
		// TODO Auto-generated constructor stub
		super(name);
		numberOfPassenger = passenger;
	}
	
	public int getNumberOfPassenger(){
		return numberOfPassenger;
	}
	
	public void fueltype(){
		System.out.println("you can fill a jet plane with JET-A (NOT Avgas!). It's similar to kerosene. JET-B is for extremly cold climates because it has a lower freezing temp");
	}

}
