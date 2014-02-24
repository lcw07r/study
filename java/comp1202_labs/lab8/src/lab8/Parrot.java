/**
 * 
 */
package lab8;

/**
 * @author lcw102
 *
 */
public class Parrot extends Omnivore{
	//private int age;

	/**
	 * 
	 */
	public Parrot(String theName, int theAge) {
		// TODO Auto-generated constructor stub
		super (theName, theAge);
	}
	
	/**
	 * a second Parrot constructor which takes an Integer as its only argument.
	 * - Method overloading is a way of providing default values for certain parameters to the method. The name for other constructors in the same class is this()
	 */
	public Parrot(int theAge) {
		// TODO Auto-generated constructor stub
		super (theAge);
	}
	
	
	public void makeNoise(){
		System.out.println("squawk");
	}
}
