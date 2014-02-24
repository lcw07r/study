/**
 * 
 */
package lab8;

/**
 * @author lcw102
 *
 */
public abstract class Omnivore extends Animal{
	
	private int age;
	/**
	 * 
	 */
	public Omnivore(String theName, int theAge) {
		// TODO Auto-generated constructor stub
		super (theName, theAge);
	}
	
	/**
	 * a second Parrot constructor which takes an Integer as its only argument.
	 * - Method overloading is a way of providing default values for certain parameters to the method. The name for other constructors in the same class is this()
	 */
	public Omnivore(int theAge) {
		// TODO Auto-generated constructor stub
		super (theAge);
	}
	
	public void eat(Food foodObject) throws Exception{
		if ((foodObject instanceof Meat) || (foodObject instanceof Plant)){
			System.out.println("This animal is eating " + foodObject.getName());			
		}else{
			Exception e = new Exception("wrong type of food");
			throw e;
		}
	}
	
	public void eat(Food foodObject, Integer numberOfFeedingTimesPerDay) throws Exception {
		
		if ((foodObject instanceof Meat) || (foodObject instanceof Plant)){
			for ( int i=1; i<=numberOfFeedingTimesPerDay; i++ ){
				System.out.println("This animal is eating " + foodObject.getName() + " for the " + i + " time(s) of the day");
			}
		}else{
			Exception e = new Exception("wrong type of food");
			throw e;
		}

	}

}
