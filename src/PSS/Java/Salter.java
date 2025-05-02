/*
 * Sophia Milask
 * 4/28/25
 * Salts the y-values from the original function and creates another CVS file with the new values
 */

import java.util.ArrayList;
import java.util.Random;

public class Salter {
	//make an Exporter object
	private Exporter x;
	public Salter() {
		x = new Exporter();
	}
	//method to salt the data points and create the CSV file
	public void createSaltedCSVFile(ArrayList<Integer> xValues, ArrayList<Integer> yValues, int saltLow, int saltHigh) {
		//using random for the salt value
		Random rand = new Random();
		for (int i = 0; i < yValues.size(); i++) {
			//salt range
            int saltNum = rand.nextInt(saltHigh  - saltLow + 1) + saltLow;  
            //making the new y-value the original y-value plus the random salt value
            yValues.set(i, yValues.get(i) + saltNum);
        }
		x.createCSVFile(xValues, yValues);
		
	}
}
