package lab9;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FlashCardReader {
	
	//Declare a BufferedReader instance variable called reader.
	private BufferedReader reader;
	private ArrayList<FlashCard> flashCardsArrayList;

	/**
	 * In the FlashCardReader constructor, create a BufferedReader which reads from a file called "Questions.txt".
	 */
	public FlashCardReader() {
		
		try{
			reader = new BufferedReader(new FileReader("Questions.txt"));
			//this.getLine(reader);
			
			flashCardsArrayList = new ArrayList<FlashCard>();
			
			
			try {	
				if(checkIfReady(reader) != false){
					String currentLine;				
					while ((currentLine = reader.readLine()) != null) {
						String[] str = currentLine.split(":");
						
						flashCardsArrayList.add(new FlashCard(str[0], str[1]));
					} 
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}catch (FileNotFoundException e){
			System.out.println("Could not find file!");
			e.printStackTrace();
		}finally {
			try {
				if (reader != null){
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * Write a method called getLine in the class. Have it print out the top line of the contents of the file. 
	 * Write a boolean method to find out whether the file is ready to be read. Use a method from the BufferedReader class  
	 */
	public void getLine(BufferedReader reader){
		try {	
			if(checkIfReady(reader) != false){
				String currentLine;				
				if ((currentLine = reader.readLine()) != null) {
					System.out.println(currentLine);
				} 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	public boolean checkIfReady(BufferedReader reader){
		boolean isReady = false;
		try
		{
			isReady = reader.ready();
		}
		catch (IOException e)
		{
			System.out.println("Could not read file!");
			e.printStackTrace();
		}
		return isReady;
	}
	
	/**
	 * In the FlashCardReader class create a method called getFlashCards which returns an ArrayList of FlashCards. 
	 */
	public ArrayList<FlashCard> getFlashCards(){
		
		return flashCardsArrayList;
	}
	

}
