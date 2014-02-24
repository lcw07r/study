
/**
 * description of class User .
 * 
 */
public class User
{
    // instance variables 
    protected String username;
    protected String userType;
    protected String name;

    /**
     * Constructor for objects of class User
     */
    public User(String un, String ut, String n)
    {
        // initialise instance variables
        username = un;
        userType = ut;
        name = n;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setUserType(String type)
    {
        userType = type;
    }
    
}
