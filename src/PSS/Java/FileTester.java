/*
 * Sophia Milask
 * 4/28/25
 * Tester class with main method to create CSV files in Excel for the original, salted, and smoothed function.
 */
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileTester {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//making new ArrayLists for x-values and y-values to pass in as arguments to the methods
		ArrayList<Integer> xValues = new ArrayList<>();
		ArrayList<Integer> yValues = new ArrayList<>();
		//calling the Function constructor
		Function f = new Function();
		
		//Calling the Salter constructor
		Salter s = new Salter();
		//calling the Smoother constructor
		Smoother sm = new Smoother();
		//passing through the empty ArrayList of x-values to be filled
		f.loadXValues(xValues);
		//filling in the empty ArrayList of y-values from their x-values
		f.makeFunction(xValues, yValues);
		//creating the file for the original function
		
		//creating the file for the salted function
		s.createSaltedCSVFile(xValues, yValues, -500, 500);
		//creating the file for the smoothed function
		sm.createSmoothedCSVFile(xValues, yValues, 5);
		
		
		
		

	}

}
