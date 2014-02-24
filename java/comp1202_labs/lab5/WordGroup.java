/**
 * Import 
 */
import java.util.*;

/**
 * description of class WordGroup
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordGroup
{
    // instance variables - 
    protected String words;
   
    /**
     * Constructor for objects of class WordGroup
     */
    public WordGroup(String s)
    {
        //takes a String, which is converted into lower case and stored in words. 
        words = s.toLowerCase();
    }

    /**
     * Use the String class split() method to separate words on " "
     * 
     * @return  wordArray   an ArrayList<String>
     */
    public ArrayList<String> getWordArray()
    {
      ArrayList<String> wordArray = new ArrayList<String>();
      for (String returnedWord: words.split(" ")){
         wordArray.add(new String(returnedWord));
      }
        return wordArray;
    }
    
    /**
     * Takes another WordGroup object as a parameter
     * Creates a HashSet<String>
     * Uses two for loops to put all the words from this and the parameter WordGroup into the HashSet
     * returns the HashSet<String>
     * 
     * @para wp a WordGroup object
     * @return hs a HashSet<String> 
     */
    public HashSet<String> getWordSet(WordGroup wp)
    {
      HashSet<String> hs = new HashSet<String>();
        
      ArrayList<String> al1 = new ArrayList<String>();
      al1 = this.getWordArray();
      
      Iterator<String> it1 = al1.iterator();
       while (it1.hasNext()){
          hs.add(new String (it1.next()));
       } 
       
      ArrayList<String> al2 = new ArrayList<String>();
      al2 = wp.getWordArray();
      
      Iterator<String> it2 = al2.iterator();
       while (it2.hasNext()){
          hs.add(new String (it2.next()));
       }     
       
        return hs;
    }
    
      
    /**
     *  Loops over all the words returned by getWordArray() 
     *  and puts each word into the HashMap with the number of times it occurs
     * 
     * @return  HashMap<String, Integer> 
     */
    public HashMap<String, Integer> getWordCounts()
    {
           
     ArrayList<String> wordArray = new ArrayList<String>();
     wordArray = this.getWordArray();
      
     HashMap<String, Integer> map = new HashMap<String, Integer>();
      
     for (String temp : wordArray) {
        Integer count = map.get(temp);
        map.put(temp, (count == null) ? 1 : count + 1);
     }

     return map;
    }
}
