/**
 * 
 */
package lab8;

/**
 * @author lcw102
 *
 */
public abstract class Animal implements Comparable<Animal>{
	private String name;
	private int age;
	
	public Animal(String theName, int theAge){
		name = theName;
		age = theAge; 
		
	}
	
	public Animal() {
		this("newborn", 0);		
	}
	
	/**
	 * a second Parrot constructor which takes an Integer as its only argument.
	 * - Method overloading is a way of providing default values for certain parameters to the method. The name for other constructors in the same class is this()
	 */
	public Animal(int theAge) {
		// TODO Auto-generated constructor stub
		age = theAge;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String toString(){
		return "I am a " + this.getClass().getName() + " called " + getName() + ". I am " + getAge();
	}
	
	public int compareTo (Animal a){
		int age1 = this.age;
		int age2 = a.getAge();
		int compareResult = 0;
		
		if (age1 > age2){
			compareResult = -1;
		}else if (age1 < age2){
			compareResult = 1;
		}
		return compareResult;
	}
	
	public abstract void makeNoise();
	public abstract void eat(Food foodObject) throws Exception;
	public abstract void eat(Food foodObject, Integer numberOfFeedingTimesPerDay) throws Exception;

}
