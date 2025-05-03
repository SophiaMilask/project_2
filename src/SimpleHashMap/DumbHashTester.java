/*
 * Sophia Milask
 * 5/3/25
 * Tester Class for dumb hash to test methods and run experiments using dumb hash.
 */
public class DumbHashTester {

	public static void main(String[] args) {
	    SimpleHashMap x = new SimpleHashMap();
	    //adding words
	   x.addWords("hello");
	   x.addWords("banana");
	   x.addWords("hi");
	   x.addWords("apple");
	   x.addWords("mango");
	   //seeing if there is at least 1 5-letter word
	   x.contains(5);
	   //resizing the array to 10
	   x.resize(10);
	   //seeing how many collisions are in each index
	   x.trackCollisions();
	}


}
