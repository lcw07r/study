import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class ResponseWriter  {
	private String filename;

	public ResponseWriter(String outPutFilename) {
		// TODO Auto-generated constructor stub
		//ArrayList<FlashCard> al = new ArrayList<FlashCard>();
		filename = outPutFilename;
	}
	
	public void saveResponses( ArrayList<Response> ar){
		
		
		int correctQuestionsNo = 0;
		String result = "";
		//count total questions
		int totalQuestionsNo = ar.size(); 
		
		//format the data for CSV 
		Iterator<Response> it = ar.iterator();
		while (it.hasNext()){
			Response res = it.next();
			FlashCard fc = res.getFlashCard();
			String question = fc.getQuestion();
			String answer = fc.getAnswer();
			String response = res.getParticipantAnswer();
			boolean isCorrect = res.isCorrect();
			String correctness = "[Wrong]";
			
			if (isCorrect == true){
				//count correct questions
				correctQuestionsNo++;
				correctness = "[Right]";
			}	
			
			result += "\"" + question + "\",\"" + answer + "\",\"" + response + "\"," + correctness + "\n";
		}	
		
		//get correct percentage
		double correntPercentage = 0;
		if (totalQuestionsNo != 0){			
			correntPercentage = 100.0*correctQuestionsNo/totalQuestionsNo;  //the *1.0 gives a double answer 			
		}
		
		//write to file -- 1. the quiz result (question + answer + user response + correctness & ); 2. the score (total No + correct No + percentage)
		try {
			
		 	PrintStream writeStream = new PrintStream(new File(this.filename));
		  
		 	writeStream.println ("Your answer to the quiz are:\n" + result + "\nResult: \nTotal number of questions, " + totalQuestionsNo + ",Number of correct answers," + correctQuestionsNo + ",percentage," + correntPercentage + "%\n");
		 	writeStream.close();
		}
		catch (Exception e){
			 System.err.println ("Error in writing to file");
		} 
		
	}

	

	
}
