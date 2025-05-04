/*
 * Sophia Milask
 * 5/3/25
 * Tester class for stats library 2 to test all methods
 */
import java.text.DecimalFormat;
public class StatsTester {

	public static void main(String[] args) {
		//format to 3 decimal places
		DecimalFormat format = new DecimalFormat("#.###");
		StatsFunctions s = new StatsFunctions();
		//taking in a lambda and y value to calculate a Poisson Distribution
		System.out.println(format.format(s.doPoissonDistribution(6, 5)));
		//Using Tchebysheff's Theorem and passing through lower limit, upper limit, mean, and standard deviation
		System.out.println(s.findPercentOfData(123, 179, 151, 14));
		//passing through the known upper and lower bounds, then the upper and lower bounds from the question we want to answer
		//to find the uniform distribution
		System.out.println(format.format(s.doUniformDistribution(40, 0, 15, 0)));
		//giving the upper and lower bounds to find expected value of a uniform distribution
		System.out.println(format.format(s.findUniformExpected(40, 0)));
		//giving upper and lower bounds to find the variance of a uniform distribution
		System.out.println(format.format(s.findUniformVariance(40, 0)));

	}

}
