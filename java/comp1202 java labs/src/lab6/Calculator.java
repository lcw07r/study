/**
 * 
 */
package lab6;

/**
 * this class is provided for lab6 to build the test harness against
 *
 */
public class Calculator {
    Double x4 = new Double(10);
 /*   
    //construtor 
    public Calculator(Double d){
    	x4  = d;
    }
 */   
    /*
    * Chops up input on ' ' then decides whether to add or multiply.
    * If the string does not contain a valid format returns null.
    */
    public Double x(String x1){
    	Double answer = new Double(0);
    	
    	//first operand is: x1.split(" ")[0]
    	//operator is: x1.split(" ")[1]
    	//second operand is: x1.split(" ")[2]
    	
    	// use Double.valueOf(String s) converts the first operand from String to Double
		this.x4 = Double.valueOf(x1.split(" ")[0]);
		
		if (x1.split(" ")[1].equals("+")){
			
			// use Double.valueOf(String s) converts the second operand from String to Double
			answer = x(Double.valueOf(x1.split(" ")[2]));
			//return answer;
		}    		
		if ((x1.split(" ")[1].equals("x"))|| (x1.split(" ")[1].equals("*"))){
			// use Double.parseDouble(String s) converts the second operand from String to double
			answer = x(Double.parseDouble(x1.split(" ")[2]));
			//return answer;
		}
		//System.out.println("answer" + answer);	
        return answer;
    }

    /*
    * Adds the parameter x2 to the instance variable x4 and returns the answer as a Double.
    */
    public Double x(Double x2){
    	System.out.println("== Adding ==");
    	return new Double(this.x4 + x2); 
    }

    /*
    * Multiplies the parameter x3 by instance variable x4 and return the value as a Double.
    */
    public Double x(double x3){
            System.out.println("== Multiplying ==");
            return new Double(this.x4 * x3);
    }

}