/**
 * 
 */
package lab7;

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
	
	public void eat(Food foodObject) throws Exception {
		
			if (foodObject instanceof Meat){
				System.out.println("This animal is eating " + foodObject.getName());
			}else{
				Exception e = new Exception("wrong type of food");
				throw e;
			}
		
	}

}
