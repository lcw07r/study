/**
 * 
 */
package lab9;

/**
 * @author lcw102
 *
 */
public class FlashCard {
	private String question;
	private String answer;

	/**
	 * a FlashCard class takes 2 Strings in it's constructor, one for the question and one for the answer
	 */
	public FlashCard(String theQuestion, String theAnswer) {
		// TODO Auto-generated constructor stub
		question = theQuestion;
		answer = theAnswer;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public String getAnswer(){
		return answer;
	}
	
	public String toString(){
		return question + " : " + answer;
	}

}
