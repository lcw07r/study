package lab8;

import java.util.ArrayList;
import java.util.Collections;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Animal> animalArrayList = new ArrayList<Animal>();
		animalArrayList.add(new Wolf("wo1", 4));
		animalArrayList.add(new Wolf("wo2", 6));
		animalArrayList.add(new Parrot("Pa1", 1));
		animalArrayList.add(new Parrot("Pa2", 7));
		
		System.out.println(animalArrayList);
		Collections.sort(animalArrayList);
		System.out.println(animalArrayList);
	}
	
	/**
	 * What is an interface:
	 * like an abstract class, it has a group of related methods with empty bodies which guarantee to be implemented
	 * a class can implement many interface but only extend one abstract class
	 * 
	 */
	
}
