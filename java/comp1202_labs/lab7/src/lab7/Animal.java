/**
 * 
 */
package lab7;

/**
 * @author lcw102
 *
 */
public abstract class Animal {
	private String name;
	private int age;
	
	public Animal(String theName, int theAge){
		name = theName;
		age = theAge; 
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public abstract void makeNoise();
	public abstract void eat(Food foodObject) throws Exception;
	


}
