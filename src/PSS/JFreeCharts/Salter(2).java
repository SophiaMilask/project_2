//import statement to use the RandomDataGenerator from Apache Library
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;

public class Salter {
    //reference to the generator will always point to the same object
    private final RandomDataGenerator gen;
    //Salter constructor
    public Salter() {
        gen = new RandomDataGenerator();
    }

    public void saltValues(ArrayList<Integer> yValues, int saltLow, int saltHigh) {
        //adding a random number within the range to every y-value
        yValues.replaceAll(integer -> integer + gen.nextInt(saltLow, saltHigh));
    }
}
