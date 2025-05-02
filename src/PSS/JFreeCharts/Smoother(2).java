//import statements to use the statistics functions from the Apache Library
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;

public class Smoother {

    public void smoothValues(ArrayList<Integer> yValues, int windowSize) {
        ArrayList<Integer> smoothed = new ArrayList<>();
        //outer loop makes a new ds for each y-value
        for (int i = 0; i < yValues.size(); i++) {
            //constructing a new ds (from Apache)
            DescriptiveStatistics ds = new DescriptiveStatistics();


            //ensuring the window range does not take from below or above the range of the y-values
            for (int j = Math.max(0, i - windowSize); j <= Math.min(yValues.size() - 1, i + windowSize); j++) {
                //inner loop takes the average of the window and replaces the y-value
                ds.addValue(yValues.get(j));
            }

            // Round the mean so it is an integer
            int smoothedValue = (int) Math.round(ds.getMean());
            smoothed.add(smoothedValue);
        }

        // Take all the smoothed values and put them back in the original yValues ArrayList
        for (int i = 0; i < yValues.size(); i++) {
            yValues.set(i, smoothed.get(i));
        }
    }
}
