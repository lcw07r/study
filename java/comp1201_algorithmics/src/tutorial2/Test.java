package tutorial2;


public class Test {

	public static void main(String[] args) {
		CircularArrayQueue caq = new CircularArrayQueue();
		
		int ni = caq.noItems();
		System.out.println("noItems: " + ni + "\n");

		int cl = caq.getCapacityLeft();
		System.out.println("CapacityLeft: " + cl + "\n");
		

		
		caq.enqueue(3);
		System.out.println("head is : " + caq.getHeadKey() + " -- value is: "+ caq.getHeadValue() + "\n"); 
		System.out.println("tail is : " + caq.getTailKey() + " -- value is: "+ caq.getTailValue() + "\n");  
		caq.enqueue(8);
		caq.enqueue(3);
		caq.enqueue(0);
		caq.enqueue(2);
		caq.enqueue(8);
		caq.enqueue(6); //test circular : headkey 0 -> 9
		caq.enqueue(9);
		caq.enqueue(8);
		caq.enqueue(2);
	//	caq.enqueue(6); //test add to no of 11
		
		int tail = caq.getTailKey();
		System.out.println("tail key: " + tail + "\n");

		int tailValue = caq.getTailValue();
		System.out.println("tail value: " + tailValue + "\n");
		
		int ni2 = caq.noItems();
		System.out.println("noItems: " + ni2 + "\n");
		
		int cl2 = caq.getCapacityLeft();
		System.out.println("CapacityLeft: " + cl2 + "\n");
		
		System.out.println("head is : " + caq.getHeadKey() + " -- value is: "+ caq.getHeadValue() + "\n"); 
		System.out.println("tail is : " + caq.getTailKey() + " -- value is: "+ caq.getTailValue() + "\n");  
		
		System.out.println("value 1 is : " + caq.dequeue() + "\n"); 		
		System.out.println("value 2 is : " + caq.dequeue() + "\n");  
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		System.out.println("value 9 is : " + caq.dequeue() + "\n");  //after  deleted 9 times
		
		System.out.println("**head is : " + caq.getHeadKey() + " -- value is: "+ caq.getHeadValue() + "\n"); 
		System.out.println("**tail is : " + caq.getTailKey() + " -- value is: "+ caq.getTailValue() + "\n");  
		
		System.out.println("value 10 is : " + caq.dequeue() + "\n");  //after  deleted 10 times
		
		//////////////
		caq.enqueue(3);
		System.out.println("second time enqueue \n head is : " + caq.getHeadKey() + " -- value is: "+ caq.getHeadValue() + "\n"); 
		System.out.println("tail is : " + caq.getTailKey() + " -- value is: "+ caq.getTailValue() + "\n");  
		caq.enqueue(8);
		caq.enqueue(3);
		caq.enqueue(0);
		caq.enqueue(2);
		caq.enqueue(8);
		caq.enqueue(6); //test circular : headkey 0 -> 9
		caq.enqueue(9);
		caq.enqueue(8);
		caq.enqueue(2);
		
		System.out.println("head is : " + caq.getHeadKey() + " -- value is: "+ caq.getHeadValue() + "\n"); 
		System.out.println("tail is : " + caq.getTailKey() + " -- value is: "+ caq.getTailValue() + "\n");  
		
		System.out.println("second time: \n value 1 is : " + caq.dequeue() + "\n");  		
		System.out.println("value 2 is : " + caq.dequeue() + "\n");  
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		System.out.println("value 9 is : " + caq.dequeue() + "\n");  //after  deleted 9 times
		System.out.println("value 10 is : " + caq.dequeue() + "\n");  //after  deleted 10 times
		
		
		
		
		int ni3 = caq.noItems();
		System.out.println("noItems: " + ni3 + "\n");
		
		int cl3 = caq.getCapacityLeft();
		System.out.println("CapacityLeft: " + cl3 + "\n");
	
	}	
	
}
