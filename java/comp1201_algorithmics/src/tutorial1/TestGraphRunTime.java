package tutorial1;

import java.util.Arrays;

public class TestGraphRunTime {

    public static void main(String[] args) {
    
    //get start time
    long time_prev = System.nanoTime();	
    
    //run the colouring program
    Graph graph = new Graph(10, 0.5);
    Colouring colouring = graph.bestColouring(3);
    graph.show(colouring);
	
    //get the end time
	double time = (System.nanoTime()-time_prev)/1000000000.0;
	
	System.out.printf("Graph Colouring\nTime= %.8f\n", time);
	
	//System.out.println("\tPresorted\tInsertion\t\t Shell\t\t Quick");
	//for (int i=0; i<data.length; i++)
	 //   System.out.println(data[i] + " " + data1[i] + " " + data2[i] + " " + data3[i]);
    }

   


}


