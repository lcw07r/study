
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * description of class UserGroup here.
 * 
 * The UserGroup class must have an ArrayList of Users.
 * - Write a constructor for the UserGroup class. It should instantiate the ArrayList<Users>. 
 * - In UserGroup write a method called .addSampleData() which creates 10 Users and using the ArrayList's add() method put the 10 new User objects into the ArrayList. 
 * - In UserGroup write a getUser method which returns the 3rd User in the list.
 * - Change the method to so it takes an int as a parameter and returns the User in that slot of the ArrayList. 
 * - In UserGroup write a printUsernames() method in UserGroup:
 * - Using an enhanced for loop (see above), loop through the ArrayList and print the username and userType of each user in the ArrayList. 
 */

public class UserGroup
{
    // instance variables - replace the example below with your own
    protected ArrayList<User> userList;
   // protected ArrayList<User> selectedUsersByType;
    protected Iterator<User> user;
    //protected UserGroup selectedGroup;
    /**
     * Constructor for objects of class UserGroup
     */
    public UserGroup()
    {
        // initialise instance variables
       userList = new ArrayList<User>();
      // selectedUsersByType = new ArrayList<User>();
       //selectedGroup = new UserGroup();
       //UserGroup selectedGroup = new UserGroup();
    }

    public void addSampleData() 
    {
        userList.add(new User("u01", "user", "user01"));
        userList.add(new User("u02", "admin", "user02"));
        userList.add(new User("u03", "editor", "user03"));
        userList.add(new User("u04", "user", "user04"));        
        userList.add(new User("u05", "admin", "user05"));
        userList.add(new User("u06", "editor", "user06"));
        userList.add(new User("u07", "user", "user07"));
        userList.add(new User("u08", "admin", "user08"));
        userList.add(new User("u09", "editor", "user09"));
        userList.add(new User("u10", "user", "user10"));
    }
    
    
         /*
    public void addSelectedUsersByType(UserGroup ug, String type)
    {
         System.out.println("=========");
        for (User u : userList) {
            System.out.println("aaaaaaa");
           if(u.getUserType() == type){
              selectedUsersByType.add(new User(u.getUsername(), type, u.getName()));
              System.out.println(u.getUsername()+" "+type+" "+u.getName());
              System.out.println("bbbbbb");
           }        
        }
       
    }
    */
   
    public void addSelectedUsersByType(ArrayList<User> uglist, String type)
    {
        
        for (User u : uglist) {
           if(u.getUserType() == type){
              userList.add(new User(u.getUsername(), type, u.getName()));
           }        
        }
      
    }
    
    public ArrayList<User> getAllUsers()
    {
         return userList;
    }    
      
    public User getUser(int i)
    {
         return userList.get(i);
    }
            
    /**
     * In UserGroup write a printUsernames() method in UserGroup:
     * Using an enhanced for loop, 
     * loop through the ArrayList and print the username and userType of each user in the ArrayList. 
     */
    public void printUsernames()
    {
        /*for (int i=0; i<userList.size(); i++){
           System.out.println(userList.get(i).getUsername());
        }*/
               
        for (User u : userList) {
          System.out.println(u.getUsername() + " " + u.getUserType());
        }
        
    }
    
    
    /**
     * Write a method called removeUser() which takes a String as a parameter which is the username you want to remove. 
     * Using an Iterator, iterate over the list until you find the user with that username and remove them. 
     * 
     * @param      String   
     */
    public void removeUser(String un){
        user = userList.iterator();
        String selectedName = "";
        while(user.hasNext()){
            selectedName = user.next().getUsername();
            if (selectedName == un){
                userList.remove(selectedName);
            }
            
        }
      
    }
    
    /**
     * Write a method called .removeFirstUser() in UserGroup that 
     * removes the first user (index position 0) from the list. 
     */
    public void removeFirstUser(){
        userList.remove(0);
    }
    
    /**
     * Write a method called .removeLastUser() in UserGroup that removes the last user from the list. 
     * Tip: the .size() method gives you the number of users in the ArrayList. 
     */
    public void removeLastUser(){
        int lastIndex = userList.size();
        userList.remove(lastIndex-1);
    }
}
