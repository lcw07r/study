/**
 * 
 */
package lab7;

/**
 * @author lcw102
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Wolf wolf1 = new Wolf("Wills", 2); 
		Parrot parrot1 = new Parrot("Pat", 4);
		
		System.out.println(wolf1.getName() + " is a " + wolf1.getAge() + " year old wolf, and it makes noise: ");
		wolf1.makeNoise();
		
		System.out.println(parrot1.getName() + " is a " + parrot1.getAge() + " year old parrot, and it makes noise: " );
		parrot1.makeNoise();
		
		Plant plant1 = new Plant("grass");
		Meat meat1 = new Meat("rabbit");
		
		try {
			wolf1.eat(plant1);
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		try {		
			wolf1.eat(meat1);
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
	}

}
