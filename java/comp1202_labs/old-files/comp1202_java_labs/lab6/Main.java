/**
 * 
 */
package lab6;

/**
 * @author lcw102
 * the Main class which: 
 *   creates a new TestCalculator object and calls its testParser(), testAdd() and testMultiplication() methods.
 *   if all the tests pass successfully prints the message "Congratulations, your Calculator appears to be working." 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestCalculator testCal = new TestCalculator();
		testCal.testParser();
		testCal.testAdd();
		testCal.testMultiply();
		
	}

}
