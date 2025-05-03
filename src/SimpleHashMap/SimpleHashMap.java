/*
 * Sophia Milask
 * 5/3/25
 * Implement a simplified dumb hash that will take in a String and return an int by the number of letters in the String
 * contains() method, a method to track the number of collisions in each index, and a method to dynamically resize the array.
 */
import java.util.HashMap;
import java.util.LinkedList;

public class SimpleHashMap {
	//Array of LinkedLists of type String
    private LinkedList<String>[] words;
    //String key, Integer value
    private HashMap<String, Integer> dumbHash;
    

    public SimpleHashMap() {
        dumbHash = new HashMap<>();
        words = new LinkedList[5];
        //each index initialized as a new LinkedList
        for (int i = 0; i < words.length; i++) {
            words[i] = new LinkedList<>();
        }
    }

    public void addWords(String word) {
        //words.hashCode computes a key for the word, which is the length
        int index = Math.abs(word.hashCode()) % words.length; //index will always be in the range from 0 - 4
        //add the word to the correct LinkedList
        words[index].add(word);
        //update dumbHash after adding a new word
        makeDumbHash();
    }

    public void contains(int value) {
    	//checking if the value is inside of the dumbHash using containsValue method
        if (dumbHash.containsValue(value)) {
            System.out.println("Yes, our map contains " + value);
        } else {
            System.out.println("No, our map does not contain " + value);
        }
    }
    //method to dynamically resize the array
    public void resize(int newSize) {
    	//making a new Array of LinkedLists with the size from the user input
        LinkedList<String>[] newWords = new LinkedList[newSize];
        //adding the original words from the original Array to the new one
        for (int i = 0; i < words.length; i++) {
            newWords[i] = words[i];
        }
        //for the remaining indices from the new length, creating a new LinkedList
        for (int i = words.length; i < newWords.length; i++) {
            newWords[i] = new LinkedList<>();
        }
        //putting the new Array in the original
        words = newWords;
        //updating dumbHash
        makeDumbHash();
        //success output
        System.out.println("The new size is " + newSize);
    }
    //method to update dumbHash in other methods
    public void makeDumbHash() {
        dumbHash.clear();
        for (LinkedList<String> l : words) {
            for (String s : l) {
                dumbHash.put(s, s.length());
            }
        }
    }
    //method to track the number of collisions in each index
    public void trackCollisions() {
        for (int i = 0; i < words.length; i++) {
        	//count is equal to the number of words in the index
            int count = words[i].size();
            //if there is more than 1 words, then there is a collision
            if (count > 1) {
            	//number of collisions is the number of words - 1, since the first word has nothing to collide with
                System.out.println("Index " + i + " has " + (count - 1) + " collisions");
            }
        }
    }
}
