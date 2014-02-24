/**
 * 
 */
package lab9;
import java.util.*;
import java.io.*;

/**
 * @author lcw102
 *
 */
public class Quiz {
	private FlashCardReader fcReader = new FlashCardReader();
	private ArrayList<FlashCard> aList = new ArrayList<FlashCard>();
	private Toolbox myToolbox = new Toolbox(); //use Toolbox to get user input 
	String result = "";  

	/**
	 * This class will handle the interaction with the user. 
	 * It should have a FlashCardReader and an instance variable that will hold the ArrayList of FlashCards. 
	 * The constructor use the FlashCardReader to create and fill the ArrayList with FlashCards. 
	 * 
	 *	    Add a call to play() on the bottom of the constructor of the Quiz.
	 *	    Add a main() method to Quiz that makes a new Quiz object. 
	 */
	public Quiz() {
		// TODO Auto-generated constructor stub
		aList = fcReader.getFlashCards();
		this.play();
	
	}
	
	/**
	 * The Quiz class needs a play() method that:
	 *
	 *	    Display each question
	 *	    Takes input from the user (you can use ToolBox for this)
	 *	    Checks the user input against the answer.
	 *	    Tells the user whether they are right or wrong. If they are wrong, print out the correct answer 		
	 *
	 */
	public void play(){
		
		Iterator<FlashCard> it = aList.iterator();
		String correctness ="";
		
		int totalQuestionsNo = 0;
		int correctQuestionsNo = 0;
		
		
		while (it.hasNext()){
			// Display each question
			FlashCard fc = it.next();			
			String question = fc.getQuestion();
			System.out.println(question);
			totalQuestionsNo ++;
	
			//Takes input from the user
			String inputAnswer = myToolbox.readStringFromCmd();
			
			//Checks the user input against the answer
			//Tells the user whether they are right or wrong. If they are wrong, print out the correct answer
			String correctAnswer = fc.getAnswer();
			if (inputAnswer.equals(correctAnswer)){
				System.out.println("Correct.");
				correctness = "right";
				correctQuestionsNo ++;
			}else{
				System.out.println("No, the correct answer is " + correctAnswer);
				correctness = "wrong";
			}
			
			result += question + "," + inputAnswer + "," + correctness + "\n";
			
		}
		
		//ask the user if they would like to save their results when the quiz finishes. 
		System.out.println("Would you like to save your answers to a file? - yes/no");
		String isSave = myToolbox.readStringFromCmd();
		
		do {
			System.out.println("please enter either yes or no");
			isSave = myToolbox.readStringFromCmd();
		}while (!isSave.equals("yes") && !isSave.equals("no"));
		
		if (isSave.equals("yes")){
			save(result, correctQuestionsNo, totalQuestionsNo);
			System.out.println("Your answers have been saved in file output.csv");
		}	
		
	}
	
	/**
	 * Part 3 - Writing Files 
	 *
	 *	    Add a save() method to the Quiz class which writes the question, the answer the user gave and whether the answer is right or wrong seperated by commas on a line. 
	 *		You may find the PrintStream class useful for this.
	 * 		On the last line of the file write the user's score, the number of questions which they were asked and the percentage of questions the user got correct.
	 *				
	 *
	 */
	public void save(String result, int correctQuestionsNo, int totalQuestionsNo){
				
		double correntPercentage = 0;
		if (totalQuestionsNo != 0){
			
			correntPercentage = 100.0*correctQuestionsNo/totalQuestionsNo;  //the *1.0 gives a double answer 
			
		}
		
		try {
			
		 	PrintStream writeStream = new PrintStream(new File("output.csv"));
		  
		 	writeStream.println ("Your answer to the quiz are:\n" + result + "\nResult: \nTotal number of questions, " + totalQuestionsNo + ",correntness," + correntPercentage + "%\n");
		 	writeStream.close();
		}
		catch (Exception e){
			 System.err.println ("Error in writing to file");
		} 
	}
	

	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		//System.out.println(quiz.aList);
		//quiz.play();
		//quiz.save();
	}

}
