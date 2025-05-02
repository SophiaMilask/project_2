import java.util.ArrayList;

public class PlotterTester {
    public static void main(String[] args) {
        // Initialize the ArrayLists for x and y to pass through to methods
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();
        ArrayList<Integer> saltedYValues;
        ArrayList<Integer> smoothedYValues;

        //Load the x-values into the ArrayList and make the function y = x^2
        Function f = new Function();
        f.loadXValues(xValues);
        f.makeFunction(xValues, yValues);

        // New ArrayLists for the salted values
        saltedYValues = new ArrayList<>(yValues);  // Copy original values to saltedYValues
        Salter salter = new Salter();
        //pass through the ArrayList, and the high and low bounds for the salting range
        salter.saltValues(saltedYValues, -500, 500);

        // New ArrayList for the smoothed values
        smoothedYValues = new ArrayList<>(saltedYValues);  // Copy salted values to smoothedYValues
        Smoother smoother = new Smoother();
        //pass through the ArrayList and the window value for the smoother
        smoother.smoothValues(smoothedYValues, 5);

        //Display 3 graphs at same time
        Plotter plotter = new Plotter();
        //x-values are the same so they only need to be asked for once
        plotter.showAllGraphs(xValues, yValues, saltedYValues, smoothedYValues);
    }
}
