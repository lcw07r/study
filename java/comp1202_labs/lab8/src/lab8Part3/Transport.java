/**
 * 
 */
package lab8Part3;

/**
 * @author lcw102
 *
 */
public abstract class Transport {
	private String nameOrID;

	/**
	 * 
	 */
	public Transport(String name) {
		// TODO Auto-generated constructor stub
		nameOrID = name;
	}
	
	public String getName(){
		return nameOrID;
	}
}
