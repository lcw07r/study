
/**
 * A SmartCard has the owner's name written on it. 
 * The constructor should set the owner's name. 
 * The class must be able to return the owner's name.
 * 
 * @Lisha
 * @2013-10-13
 */
public class SmartCard
{
    // instance variables 
    protected String owner;
    protected boolean status;

    /**
     * The constructor should take a String parameter to set the owner of the card.
     * A SmartCard can belong either to a member of staff or to a student. 
     * A newly created SmartCard should be a student card. 
     */
    public SmartCard(String o)
    {
        // initialise instance variables
        owner = o;
        status = false;
    }
    
    /**
     * method that returns the owner of the SmartCard
     * 
     * @param     
     * @return     owner
     */
    public String getOwner()
    {
        
        return owner;
    }
    
    /**
     * method that returns the owner status of the SmartCard
     * 
     * @param     
     * @return     boolean
     */
    public boolean isStaff()
    {
        if (status == true){
            return true;
        }else {
            return false;
        }
    }
        
    /**
     * method that set the owner status of the SmartCard
     * 
     * @param     
     * @return     boolean
     */
    public boolean setStaff(boolean s)
    {
        status = s;
        return status;
    }
}
