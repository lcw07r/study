/**
 * 
 */
package lab7;

/**
 * @author lcw102
 *
 */
public abstract class Herbivore extends Animal{

	/**
	 * 
	 */
	public Herbivore(String theName, int theAge) {
		// TODO Auto-generated constructor stub
		super (theName, theAge);
	}
	
	public void eat(Food foodObject) throws Exception{
		System.out.println("This animal is eating " + foodObject.getName());
	}

}

