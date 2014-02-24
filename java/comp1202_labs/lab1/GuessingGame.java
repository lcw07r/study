public class GuessingGame {

	public static void main(String[] args){
	
		//use Toolbox to get user input 
		Toolbox myToolbox = new Toolbox();
		
		// set the max number for the guessing game
		Integer max = (10);
		Integer numberToGuess = myToolbox.getRandomInteger(max);
		
		Integer guessedNumber;		
		int lownumber = 1;
		int highnumber = 10;			
		int inumberToGuess = numberToGuess;
		int iguessedNumber;
		int quit = 99;
				
		System.out.println("Welcome to Guessing Game, enter a number no bigger than " + max + "to play or enter " + quit +" to quit the game");

		// provide warning/clue
		if (inumberToGuess==lownumber){
			System.out.println("warning: number is low");
		}else if (inumberToGuess==highnumber){
			System.out.println("warning: number is high");
		}	
		
		//take user input and autoboxing integer to int
		iguessedNumber = myToolbox.readIntegerFromCmd();		

		//out put message if correct
		if (inumberToGuess == iguessedNumber){ 		
			System.err.println("correct");	
		}
		
		//loop for taking input if not correct
		while (inumberToGuess != iguessedNumber){
		
			//check if user want to quit the game
			if (quit == iguessedNumber){
					System.out.println("thanks for playing");	
					break;
			}
			//take input 
			System.err.println("please try again");
			iguessedNumber = myToolbox.readIntegerFromCmd();
		}
		

	
	}

}