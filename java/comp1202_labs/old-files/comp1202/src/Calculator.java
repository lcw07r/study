/**
 * 
 */

/**
 * @author lcw102
 *
 */
public class Calculator {
	
    Double x = new Double("12");
    /*
    * Chops up input on ' ' then decides whether to add or multiply.
    * If the string does not contain a valid format returns null.
    */
    public Double x(String x){
    	
    	this.x = Double.valueOf(x.split(" ")[0]);
    	
    	//operator is: x.split(" ")[1]
    	if (x.split(" ")[1].equals("+")){ 
    		//  Double.valueOf(String s) converts String to Double
    		return new Double(x(Double.valueOf(x.split(" ")[2])));
    	}else if (x.split(" ")[1].equals("*") || x.split(" ")[1].equals("x") ){    		
    		//  Double.parseDouble(String s) converts String to double
    		return new Double(x(Double.parseDouble(x.split(" ")[2])));
    	}else{
    		return new Double(0);
    	}
    	
    	
    	
    }

    /*
    * Adds the parameter x to the instance variable x and returns the answer as a Double.
    */
    public Double x(Double x){
        System.out.println("== Adding ==");
        return new Double(this.x + x);
    }

    /*
    * Multiplies the parameter x by instance variable x and return the value as a Double.
    */
    public Double x(double x){
    	System.out.println("== Multiplying ==");
        return new Double(this.x * x);
    }

}
