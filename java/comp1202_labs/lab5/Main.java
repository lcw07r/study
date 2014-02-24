/**
 * Import util
 */
import java.util.*;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    /**
     * main method of class Main, it should 
     * Create two WordGroups 
     * one initialized with "You can discover more about a person in an hour of play than in a year of conversation" 
     * and the other with "When you play play hard when you work dont play at all" 
     * //these are quotes by Plato and Roosevelt respectively with the punctuation removed 
     * Use getWordArray() to make two arrays of Strings. 
     * Write two for loops to loop over the two arrays and print out each word. 
     */
    public static void main(String[] args)
    {
       WordGroup wg1 = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
       WordGroup wg2 = new WordGroup("When you play play hard when you work dont play at all");
       
       ArrayList<String> wa1 = new ArrayList<String>();
       ArrayList<String> wa2 = new ArrayList<String>();
       wa1 = wg1.getWordArray();
       wa2 = wg2.getWordArray();
       
       System.out.println("*** part 1 string 1 ***");
       Iterator<String> it1 = wa1.iterator();
       while (it1.hasNext()){
           System.out.println(it1.next());
       }
      
       System.out.println("*** part 1 string 2  ***");
       
       Iterator<String> it2 = wa2.iterator();
       while (it2.hasNext()){
           System.out.println(it2.next());
       }
       
       System.out.println("*** part 2 ***");
       
       HashSet<String> h = new HashSet<String>();
       h = wg1.getWordSet(wg2);
              
       Iterator<String> it3 = h.iterator();
       while (it3.hasNext()){
           System.out.println(it3.next());
       }
         
       System.out.println("*** part 3 string 1 ***");
       
       HashMap<String, Integer> map1 = new HashMap<String, Integer>();
       map1 = wg1.getWordCounts();
       printMap(map1);
       
       System.out.println("*** part 3 string 2 ***");
       
       HashMap<String, Integer> map2 = new HashMap<String, Integer>();
       map2 = wg2.getWordCounts();
       printMap(map2);
       
       System.out.println("*** part 3 complete set of 2 strings ***");
       // Use the getWordSet() method to make complete set of all the words from both WordGroups.
       // Loop over the new HashSet to print a complete list of all words with the sum counts from each of the hashmaps. 
       
       // use h from part 2
       Iterator<String> it4 = h.iterator();
       while (it4.hasNext()){
           //get the count from 2 HashMaps
           String word = it4.next();
           
           Integer count1 = map1.get(word);
           if (count1 == null) {
               count1 = 0;
           }
           
           Integer count2 = map2.get(word);
           if (count2 == null) {
               count2 = 0;
           }
        
           Integer count =  count1 + count2; //map1.get(word) +  map2.get(word);     
           
           System.out.println( word + " : " + count);
       }  
       
    }
    
    /**
     * output HashMap
     * 
     * @para  HashMap
     */
    public static void printMap(HashMap<String, Integer> map){
        // get keyset value from map
        Set keyset = map.keySet();
     
        // Iterate over the Set to see what it contains.
        Iterator iter = keyset.iterator();
        while (iter.hasNext())
        {
            Object key = iter.next();
            Object val = map.get(key);
            System.out.println(key.toString() + " : " + val.toString());
        }
      
      /*  
       * this is another way to do it, but it is not useing keyset() which the lab5 asked for
       * 
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		System.out.println(entry.getKey() + " : "	+ entry.getValue() );
       }
      */
     
    }
     

}
