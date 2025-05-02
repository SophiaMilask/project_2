/*
 * Sophia Milask
 * 4/28/25
 * Methods to call to fill ArrayLists with the function y = x^2	
 */
import java.util.ArrayList;

public class Function {
	
	//make an Exporter object
	private Exporter x;
	public Function() {
		x = new Exporter();
	}
	//takes in an ArrayList and loads x-values in, all non-negative integers until the limit
	public void loadXValues(ArrayList<Integer> xValues) {
		for (int i = 0; i < 100; i ++) {
			xValues.add(i);
		}
	}
	//takes in the x-values from above and another ArrayList to fill with y-values
	public void makeFunction(ArrayList<Integer> xValues, ArrayList<Integer> yValues) {
		for(int i = 0; i < xValues.size(); i ++) {
			//takes the current/respective x-value, squares it, and puts it in the same spot for the y-value list
			yValues.add(xValues.get(i) * xValues.get(i));
		}
		x.createCSVFile(xValues, yValues);
	}
	
	
}
