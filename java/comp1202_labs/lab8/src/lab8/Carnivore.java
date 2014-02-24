/**
 * 
 */
package lab8;

/**
 * @author lcw102
 *
 */
public abstract class Carnivore extends Animal{

	/**
	 * 
	 */
	public Carnivore(String theName, int theAge) {
		// TODO Auto-generated constructor stub
		super (theName, theAge);
	}
	
	public Carnivore() {
		// TODO Auto-generated constructor stub
		super ();
	}
	
	public void eat(Food foodObject) throws Exception {
		
			if (foodObject instanceof Meat){
				System.out.println("This animal is eating " + foodObject.getName());
			}else{
				Exception e = new Exception("wrong type of food");
				throw e;
			}
		
	}
	
	public void eat(Food foodObject, Integer numberOfFeedingTimesPerDay) throws Exception {
		
		if (foodObject instanceof Meat){
			for ( int i=1; i<=numberOfFeedingTimesPerDay; i++ ){
				System.out.println("This animal is eating " + foodObject.getName() + " for the " + i + " time(s) of the day");
			}
		}else{
			Exception e = new Exception("wrong type of food");
			throw e;
		}

	}

}
