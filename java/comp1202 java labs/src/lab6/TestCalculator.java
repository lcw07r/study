/**
 * 
 */
package lab6;

/**
 *
 * @author lcw102
 *
 */
public class TestCalculator {
	
	
	
	/**
	 *  TestCalculator has a method called testParser() which:  
	 *   returns a boolean which is true if the whole test succeeds
	 *   tests that x("12 + 5") returns a Double with the value 17
	 *   tests that x("12 x 5") returns a Double with the value 60
	 *   tests that x("12 [ 3") returns null because [ is not a valid operator 	 *
	 */
	public Boolean testParser(){
		
		Calculator cal = new Calculator();
		Boolean boo1 = false;
		Boolean boo2 = false;
		Boolean boo3 = false;
		Boolean booAll = false;
		
		//test if x("12 + 5") = 17

		if(cal.x("12 + 5").intValue() == 17) {
			System.out.println("[ OK ] Parser adds correctly.");
			boo1 = true;
		}else{
			System.out.println("[FAIL] Basic parsing fails to add");
		}
		
		//test if x("12 x 5") = 60
		if(cal.x("12 x 5").intValue() == 60) {
			System.out.println("[ OK ] Parser multiplies correctly.");
			boo2 = true;
		}else{
			System.out.println("[FAIL] Basic parsing fails to multiply.");
		}

		//test if x("12 [ 3") is not valid
		if(cal.x("12 [ 3").intValue() == 0) {
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
	 *  TestCalculator has a method called testAdd() which:  
	 *    tests that positve numbers can be added together using the appropriate x() method. 
	 *    In your test harness you will have to update your calculator's instance variable x manually in the test method.
	 *    tests that negative numbers can be added together using the appropriate x() method. 
	 *    In your test harness you will have to update your calculator's instance variable x manually in the test method. 
	 */
	public Boolean testAdd(){
		
		Boolean boo1 = false;
		Boolean boo2 = false;
		Boolean booAll = false;

		
		Calculator cal1 = new Calculator();
		Double d2 = new Double("20");	
		Double da1 = new Double("30");
			
		if (cal1.x(d2).equals(da1) ){
			System.out.println("[ OK ] Calculator can add positive numbers");
			boo1 = true;			
		}else{
			System.out.println("[FAIL] Calculator adds incorrectly");
		}
   	 
		Calculator cal2 = new Calculator();
		Double d4 = new Double("-20");	
		Double da2 = new Double("-10");
		
		if (cal2.x(d4).equals(da2) ){
			System.out.println("[ OK ] Calculator can add a negative number");
			boo2 = true;			
		}else{
			System.out.println("[FAIL] Calculator adds with negative numbers incorrectly");
		}

		// return true if pass all tests
		if ((boo1 == true) && (boo2 == true) ){
			booAll = true;
		}
		return booAll;		
	}
	
	/**
	 *  TestCalculator has a method called testMultiply() which: 
	 *     tests that positve numbers can be multiplied together using the appropriate x() method. 
	 *     In your test harness you will have to update your calculator's instance variable x manually in the test method.
	 *     tests that negative numbers can be multiplied together using the appropriate x() method. 
	 *     In your test harness you will have to update your calculator's instance variable x manually in the test method.  
	 */
	public Boolean testMultiply(){

		Boolean boo1 = false;
		Boolean boo2 = false;
		Boolean booAll = false;
		
		
		Calculator cal1 = new Calculator();
		double d2 = new Double("20");	
		Double da1 = new Double("200");

		if (cal1.x(d2).equals(da1) ){
			System.out.println("[ OK ] Calculator can multiply positive numbers");
			boo1 = true;			
		}else{
			System.out.println("[FAIL] Calculator multiplies incorrectly");
		}
		
		
		Calculator cal2 = new Calculator();
		double d4 = new Double("-20");	
		Double da2 = new Double("-200");
			
		if (cal2.x(d4).equals(da2) ){
			System.out.println("[ OK ] Calculator can multiply by a negative number");
			boo2 = true;			
		}else{
			System.out.println("[FAIL] Calculator multiplies by negative incorrectly");
		}
		
		// return true if pass all tests
		if ((boo1 == true) && (boo2 == true) ){
			booAll = true;
		}
		return booAll;	
	}
	

}
