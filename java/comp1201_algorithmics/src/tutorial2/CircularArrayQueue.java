package tutorial2;

import java.util.NoSuchElementException;


public class CircularArrayQueue implements MyQueue{

	private int headKey;
	private int tailKey;
	private Integer[] intArray;
	private Integer[] newArray;
	
	public CircularArrayQueue() {
		// TODO Auto-generated constructor stub
		intArray = new Integer[10];
		headKey = intArray.length-1;
		tailKey = intArray.length-1;
	}
	
	// implements MyQueue
	public void enqueue(int in){
		
		//check if has space for adding new value
		if (this.getCapacityLeft() > 0){
			
			if (intArray[headKey]== null){ 	//if adding to an empty array
				intArray[headKey] = in;
			}else if (intArray[headKey] != null && headKey == 0 ){ 	//if head is array[0] and has value, add to end of array;
				headKey = intArray.length - 1;
				intArray[headKey] = in;
			}else {
				headKey--;
				intArray[headKey] = in;
			}
		}else {
			//System.out.println("Sorry, can't add any, the queue is full.");
			

			//resize array, set new head and tail keys and insert new value to the head of new array
			// - new headKey to be inserted is the end of new array and tailKey is the length of old array
			headKey = intArray.length-1;
			intArray = this.resizeArray();	
			tailKey = intArray.length - 1;
			
			intArray[headKey] = in;			
		}
	}
	
	// implements MyQueue
	// throw exception if isEmpty() is true
	public int dequeue() throws NoSuchElementException{
		//return the value from the tail of the array
		int tailValue;
		
		// check if there has an item to delete
		if (this.isEmpty()){
			throw new NoSuchElementException();
		}else {
			//return the value from the tail of the array
			tailValue = intArray[tailKey];
			//set the tail to null afterward
			intArray[tailKey] = null;
			
			//if the queue is no empty, reset the new tailKey pointer
			if (this.noItems() != 0){				
				if (tailKey == 0){
					tailKey = intArray.length-1;
				}else{
					tailKey--;
				}
			}
		}
		return tailValue; // why need a return value for a deletion? what is expected?
	}
	
	// implements MyQueue
	// returns the number of items in the array
	public int noItems(){		
		int numberOfItems = 0;
		
		for (int i = 0; i < intArray.length; i++){
			if(intArray[i] != null){
	    		numberOfItems++;
	        }
		}
		
		return numberOfItems;
	} 
	
	// implements MyQueue
	// true if queue is empty
	public boolean isEmpty(){
		if (this.noItems() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	// getCapacityLeft() method tells the user how many items can be added to the array before the array needs to be resized.
	public int getCapacityLeft(){
		int capacityLeft = intArray.length - this.noItems() ;
		return capacityLeft;
	}
	
	public Integer[] resizeArray(){
		int oldArrayLength = intArray.length;
		newArray = new Integer[oldArrayLength*2];
		
		//copy the value from the old array to the end of the new array
		for (int i=0; i<oldArrayLength; i++) {
			newArray[i+oldArrayLength] = intArray[i];
		} 
		return newArray;
	} 
	
	public int getTailKey(){
		return tailKey;
	}

	public int getHeadKey(){
		return headKey;
	}
	
	public int getTailValue(){
		return intArray[tailKey];
	}

	public int getHeadValue(){
		return intArray[headKey];
	}
}
