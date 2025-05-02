import java.util.ArrayList;

public class Function {

    // Load x values (0 to 99)
    public void loadXValues(ArrayList<Integer> xValues) {
        for (int i = 0; i < 100; i++) {
            xValues.add(i);
        }
    }

    // for every x-value, make the y-value x^2 to make the function
    public void makeFunction(ArrayList<Integer> xValues, ArrayList<Integer> yValues) {
        for (Integer x : xValues) {
            yValues.add(x * x);
        }
    }
}
