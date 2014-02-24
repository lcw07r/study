
public class ATM {

    int accountBalance = 0;  
    Toolbox myToolbox = new Toolbox();
    String newLine = System.getProperty("line.separator"); //This will retrieve line separator dependent on OS.
          
    //create an ATM object and then call a method called go()
    public static void main(String[] args){
    
        ATM myATM = new ATM();
        myATM.go();
     
        //loop for input option after preform the action 
        myATM.actionLoop();
    }
     
    //When go() is called the program should prompt the user to enter the balance that they would like in their account 
    public void go(){
     
        System.out.println("Welcome to online ATM banking.");
        
        while (accountBalance <= 0){
            System.out.println("How much do you want in your account?");
             
            //use Toolbox to get user input of balance
            accountBalance = myToolbox.readIntegerFromCmd();
             
            //don't allow the starting balance to be negative 
            if (accountBalance > 0){
                System.out.println("*****************************");
                System.out.println("Your balance is: " + accountBalance);
                System.out.println("*****************************");
                System.out.println(newLine);
                 
            } else {
                System.out.println("Sorry, account need to be bigger than 0, please try again.");
            }
           
        }
    }
     
    public void actionLoop(){
        int inputOption = 0;  
        
        while (inputOption != 4){
            menuOptions();
            inputOption = myToolbox.readIntegerFromCmd();
            System.out.println("*****************************");
            
            switch(inputOption)
            {   
                  case 1: handleOption1();
                        break;
                  case 2: handleOption2();
                        break;
                  case 3: handleOption3();
                        break;
                  case 4:  // in the case of quit, end to problem
                        System.out.println("   GoodBye!   ");
                        break;
                  default: // values not in range
                        System.out.println("Sorry, please select a number from the option list");
                        System.out.println("*****************************");
                        break;
            }
        }
         
    }
     
    public void handleOption1() 
    { 
          // in the case of withdraw, get user input of withdraw value, check if it is smaller than balance, display new balance, and loop for new action
        int withdraw;
        System.out.println("  Withdraw  ");
        System.out.println("*****************************");
        System.out.println("How much would you like to withdraw?");
        withdraw = myToolbox.readIntegerFromCmd();
        if (withdraw > accountBalance){
            System.out.println("Sorry, withdraw value is over your balance, please try again with a small value");
        } else {
            accountBalance = accountBalance - withdraw;
            System.out.println("Your new balance is: " + accountBalance);
        }
        System.out.println("*****************************");
       
    }
     
    public void handleOption2()
    { 
        // in the case of deposit: get user input of deposit value, check if greater than 0, display new balance and loop for new action
        int deposit;
        System.out.println("  Deposit  ");
        System.out.println("*****************************");
        System.out.println("How much would you like to deposit?");
        deposit = myToolbox.readIntegerFromCmd();
        if (deposit > 0){
            accountBalance = accountBalance + deposit;
            System.out.println("Your balance new balance is: " + accountBalance);
        } else {
            System.out.println("Sorry, deposit need to be bigger than 0");
        }
        System.out.println("*****************************");
                
    }
     
    public void handleOption3() 
    { 
        // in the case of inquire, display balance, and loop for new action
        System.out.println("   Your balance is: " + accountBalance);
        System.out.println("*****************************");
                
    }

    //prompt the user to select an option
    public void menuOptions(){
        //get user selected option
         
        System.out.println("What do you want to do?");
        System.out.println("1 : Withdraw");
        System.out.println("2 : Deposit");
        System.out.println("3 : Inquire");
        System.out.println("4 : Quit");
         
        System.out.println(newLine);
    
    }

}
