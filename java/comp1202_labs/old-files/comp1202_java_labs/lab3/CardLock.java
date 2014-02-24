
/**
 * CardLock represent a swipe card lock
 * A CardLock has an instance variable to remember the last smart card seen. 
 * CardLock should have a method called swipeCard() to swipe a smart card, which will be remembered by the lock. It must take a SmartCard as a parameter.
 * The CardLock class should have a method called getLastCardSeen() to return the last smart card that was swiped. 
 * A CardLock has an isUnlocked() method that returns a boolean indicating whether the lock is unlocked or not.
 * A newly created CardLock should only unlock if a staff card was the last card swiped. 
 *
 * @author Lisha
 * @version 2013-10-13
 */
public class CardLock
{
    // instance variables
    protected SmartCard lastSeenSC;
    protected boolean unLock;
    protected boolean studentAccess;

    /**
     * Constructor for objects of class CardLock
     * A newly created CardLock should only unlock if a staff card was the last card swiped.
     */
    public CardLock()
    {
        unLock = false;
        studentAccess = false;       
    }

    /**
     * CardLock should have a method called swipeCard() to swipe a smart card, which will be remembered by the lock. 
     * It must take a SmartCard as a parameter. 
     * A newly created CardLock should only unlock if a staff card was the last card swiped.
     * 
     * @param  smartcard   
     * @return SmartCard
     */
    public SmartCard swipeCard(SmartCard swipedcard)
    {
        //to remembered the last seen card       
        lastSeenSC = swipedcard;
        
        //unlock if a staff card was the last card swiped
        if(lastSeenSC.isStaff()){
            unLock = true;
        } 
        
        return lastSeenSC;
    }
        
    /**
     * The CardLock class should have a method called getLastCardSeen() to return the last smart card that was swiped. 
     * 
     * @param     
     * @return  SmartCard   
     */
    public SmartCard getLastCardSeen()
    {
       
        return lastSeenSC;
    }
            
    /**
     * A CardLock has an isUnlocked() method that returns a boolean indicating whether the lock is unlocked or not. 
     * 
     * @param     
     * @return   boolean  
     */
    public boolean isUnlocked()
    {
       if ((studentAccess == true) ||(lastSeenSC.isStaff() == true)){
           unLock = true;
       }else {
           unLock = false;
       }
        return unLock;
    }
    
    /**
     *  We are now going to improve the card lock so that student access can be turned on or off. 
     * 
     * @param     
     * @return     
     */
    public boolean toggleStudentAccess()
    {
       
        studentAccess = !studentAccess;
        return studentAccess;
    }
    
    public boolean getstudentAccess()
    {
        
        return studentAccess;
    }
}
