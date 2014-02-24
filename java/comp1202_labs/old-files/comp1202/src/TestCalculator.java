/**
 * 
 */

/**
 * @author lcw102
 *
 */
public class TestCalculator {

	/** 
	 * the testParser method:
	 *  returns a boolean which is true if the whole test succeeds
	 *  1. tests that x("12 + 5") returns a Double with the value 17
	 *  2. tests that x("12 x 5") returns a Double with the value 60
	 *  3. tests that x("12 [ 3") returns null because [ is not a valid operator 
	 */
	public boolean testParser() {
		Calculator cal = new Calculator();
		boolean boo1 = false;
		boolean boo2 = false;
		boolean boo3 = false;
		boolean booAll = false;
		
		Double test1 = cal.x("12 + 5");		
		if(test1.intValue() == 17){
			System.out.println("[ OK ] Parser adds correctly.");
			boo1 = true;
		}else{
			System.out.println("[FAIL] Basic parsing fails to add");
		} 
		
		Double test2 = cal.x("12 x 5");	
		if(test2.intValue() == 60){
			System.out.println("[ OK ] Parser multiplies correctly.");
			boo2 = true;
		}else{
			System.out.println("[FAIL] Basic parsing fails to multiply.");
		}
		
		Double test3 = cal.x("12 [ 3");	
		if(test3.intValue() == 0){
			System.out.println("[ OK ] Parser returns null for operators which are not supported.");
			boo3 = true;
		}else{
			System.out.println("[FAIL] Parser does not return null for operators which are not supported.");
		}
		
		// return true if pass all tests
		if ((boo1 == true) && (boo2 == true) && (boo3 == true)){
			booAll = true;
		}		
		
		return booAll;		
	}

	/** 
	 * the testAdd method:
	 *  tests that positive numbers can be added together using the appropriate x() method. 
	 *  - need to update the calculator's instance variable x manually in the test method.
	 *  tests that negative numbers can be added together using the appropriate x() method. 
	 *  - need to update the calculator's instance variable x manually in the test method.  
	 */
	public boolean testAdd() {
		
		Calculator cal = new Calculator();
		
		boolean boo1 = false;
		boolean boo2 = false;
		boolean booAll = false;
		
		Double positiveDouble = new Double("10");		
		Double testPositive = cal.x(positiveDouble);		
		Double positiveTestAnswer = new Double("22");		
		int positiveAddCompareResult = testPositive.compareTo(positiveTestAnswer);
			
		if(positiveAddCompareResult == 0){
			System.out.println("[ OK ] Calculator can add positive numbers");
			boo1 = true;
		}else{
			System.out.println("[FAIL] Calculator adds incorrectly");
		} 
		
		
		Double negativeDouble = new Double("-10");
		Double testNegative = cal.x(negativeDouble);
		Double negativeTestAnswer = new Double("2");		
		int negativeAddCompareResult = testNegative.compareTo(negativeTestAnswer);
		
		if(negativeAddCompareResult == 0){
			System.out.println("[ OK ] Calculator can add a negative number");
			boo2 = true;
		}else{
			System.out.println("[FAIL] Calculator adds with negative numbers incorrectly.");
		}
		
		// return true if pass all tests
		if ((boo1 == true) && (boo2 == true)){
			booAll = true;
		}		
		
		return booAll;
		
	}
	
	
	/** 
	 * the testMultiply method:
	 *  tests that positive numbers can be multiplied together using the appropriate x() method. 
	 *  - need to update the calculator's instance variable x manually in the test method.
	 *  tests that negative numbers can be multiplied together using the appropriate x() method. 
	 *  - need to update the calculator's instance variable x manually in the test method.  
	 */
	public boolean testMultiply() {
		Calculator cal = new Calculator();
		boolean boo1 = false;
		boolean boo2 = false;
		boolean booAll = false;
		
		double positivedouble = 10;

		
		double testPositive = cal.x(positivedouble);

		
		double positiveTestAnswer = 120;

		
		int positiveMultipyCompareResult = Double.compare(testPositive,positiveTestAnswer);
			
		if(positiveMultipyCompareResult == 0){
			System.out.println("[ OK ] Calculator can multiply positive numbers");
			boo1 = true;
		}else{
			System.out.println("[FAIL] Calculator multiplies incorrectly");
		} 
		
		double negativedouble = -10;
		double testNegative = cal.x(negativedouble);
		double negativeTestAnswer = -120;		
		int negativeMultipyCompareResult = Double.compare(testNegative,negativeTestAnswer);
		
		if(negativeMultipyCompareResult == 0){
			System.out.println("[ OK ] Calculator can multiply by a negative number");
			boo2 = true;
		}else{
			System.out.println("[FAIL] Calculator multiplies by negative numbers incorrectly.");
		}
		
		// return true if pass all tests
		if ((boo1 == true) && (boo2 == true)){
			booAll = true;
		}		
		
		return booAll;
		
	}

}
