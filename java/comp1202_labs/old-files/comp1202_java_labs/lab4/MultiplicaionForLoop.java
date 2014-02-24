import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * description of class MultiplicaionForLoop.
 * 
 * Uses a traditional for loop to output a multiplication table up to 20. 
 * The user will specify the multiplication table to calculate, 
 * which you should obtain from the command line using ToolBox or otherwise. 
 * For example if the user specifies 2, you would output 2, 4, 6, 8...
 * 
 * Uses a while loop to sum consecutive integers starting from 1 (eg. 1+2+3...), 
 * until the sum of those integers is greater than 500. 
 * Your code should print how many iterations were required to do this.
 * 
 * Create a second UserGroup called administrators, then loop through the existing users User and add any users whose userType is "admin" to the administrators group. 
 * Use the .printUsernames() method to print out all the users in the administrators list 
 * set the user type of the last user in the administrators ArrayList back to "user". 

 */

public class MultiplicaionForLoop
{
    // instance variables 
    protected Toolbox myToolbox = new Toolbox();
    protected int calculateTable = 0;
    protected String newLine = System.getProperty("line.separator"); //This will retrieve line separator dependent on OS.
 
     
    
    /**
     * Constructor for objects of class MultiplicaionForLoop
     */
    public MultiplicaionForLoop()
    {
        // initialise instance variables
        //x = 0;
    }
   
       public static void main(String[] args)
    {
        System.out.println("**** part 1 *****");
        MultiplicaionForLoop multipleTable = new MultiplicaionForLoop();
        multipleTable.calMulitpleTable();
        multipleTable.sumInt();
        
        System.out.println("**** part 2 *****");         
        UserGroup ug = new UserGroup();
        ug.addSampleData();
        ug.printUsernames(); 
        
        System.out.println("**** part 3 *****"); 
        System.out.println("*** initial admin group ***"); 
        UserGroup administrators = new UserGroup();
        administrators.addSelectedUsersByType(ug.getAllUsers(), "admin");
        administrators.printUsernames();
       
        //set the user type of the last user in the administrators ArrayList back to "user". 
        //1. get the last user from admin group
        int lastIndex = administrators.getAllUsers().size() - 1;        
        User u = administrators.getUser(lastIndex);
        //2. find this user in the initial user's list
        ArrayList<User> al = ug.getAllUsers();
        User selectedUser = multipleTable.getSelectedUser(al, u.getUsername());
        //3. set type to user
        selectedUser.setUserType("user");  
        //4. remove this user from the admin group
        administrators.removeLastUser();
        
        System.out.println("*** modified admin group ***"); 
        administrators.printUsernames();
        System.out.println("*** the all users list again ***"); 
        ug.printUsernames(); 
        
        
    }
    
    public User getSelectedUser(ArrayList<User> al, String un){
        User selected = new User("", "", "");
        for (User u : al) {          
          if(u.getUsername() == un){
              selected = u;
          }         
        }
        return selected;
    }
    
    public void calMulitpleTable(){
        //use Toolbox to get user input 
        calculateTable = myToolbox.readIntegerFromCmd();
        for (int i=1; i<21; i++){
            System.out.println(calculateTable + " * " + i  +" = " + calculateTable*i + newLine);
        }
    }
    
    public void sumInt(){
        int total=1;
        int a=2;
        int count = 0;  
        while(total < 500){
            total = a + total;
            a++;
            count++;
        }
        System.out.println(" a is:  " + a  +" total is:  " + total +" count is:  " + count );
    }
}
