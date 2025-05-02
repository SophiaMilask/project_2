/* 
 * Sophia Milask
 * 4/28/25
 * Exporter for the original function. Exports a CSV file to Excel.
 */


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exporter {
	 
	//empty constructor to call in the other classes
	public Exporter() {
		
	}
	
	
	public void createCSVFile(ArrayList<Integer> xValues, ArrayList<Integer> yValues) {
		//try catch block
		try (PrintWriter p = new PrintWriter("function.csv")) {
			//label for the x-values and y-values
			p.println("x, y");

			//printing x-value, and comma, and the respective y-value
			for (int i = 0; i < xValues.size(); i++) {
				p.println(xValues.get(i) + "," + yValues.get(i));
			}
			//message to confirm the file was successful
			System.out.println("CSV file has been made successfully");

		} catch (FileNotFoundException e) {
			//error message if the file was not successfully created
			System.err.println("An error occurred while writing to the file.");
			e.printStackTrace();
		}
	}
}
