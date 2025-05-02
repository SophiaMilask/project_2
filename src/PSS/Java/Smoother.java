/*
 * Sophia Milask
 * 4/28/25
 * Smoothes the y-values from the salted function and creates another CVS file with the new values
 */

import java.util.ArrayList;

public class Smoother {
	//make an Exporter object
	private Exporter x;
    public Smoother() {
        x = new Exporter();
    }
    //method to alter the y-values with the smoothed values and create the new file
    public void createSmoothedCSVFile(ArrayList<Integer> xValues, ArrayList<Integer> yValues, int windowValue) {
        
        for (int i = 0; i < yValues.size(); i++) {
        	//keeping track of the sum of the numbers from the window and the number of values to compute average later
            int count = 0;
            int sum = 0;
            //making sure we stay in bounds and don't get an error by going over/under when there are fewer than 5 values
            for (int j = Math.max(0, i - windowValue); j <= Math.min(xValues.size() - 1, i + windowValue); j++) {
            	//adding the values of the surrounding numbers
                sum += yValues.get(j);
                count++;
            }
            //the smoothed value is the average
            int smoothedValue = sum / count;
            //making the salted y-value the new, smoothed one
            yValues.set(i, smoothedValue);
        }
        //create the CSV file by called the method from Exporter Class
        x.createCSVFile(xValues, yValues);
        
    }
}
