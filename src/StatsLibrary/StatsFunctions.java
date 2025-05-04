/*
 * Sophia Milask
 * 5/3/25
 * Stats Library for Project 2 with formulas for Poisson distribution, Tchebysheff's Theorem, and Uniform Distribution
 */
import java.math.BigInteger;

public class StatsFunctions {
	public StatsFunctions() {
		
	}
	
	private BigInteger doFactorial(int num) {
    	//check to make sure the input is non-negative
        if (num < 0) {
            System.out.println("Invalid input: Factorial is undefined for negative numbers.");
            return BigInteger.ZERO;
        }
        //starting off with a factor of 1
        BigInteger answer = BigInteger.ONE;
        //starting at the input number, and then every decreasing integer until 1, multiplying that integer by the answer
        for (int i = num; i > 0; i--) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        return answer;
    }
	
	
	
	
	//method to find Poisson distribution with arguments for lambda and y
	public double doPoissonDistribution(double lambda, int y) {
		//validating that lambda is positive and y is nonnegative
		if(lambda > 0 && y >= 0) {
			//poisson formula. Calling doFactorial to help, changing to a double to return
			return (Math.pow(Math.E, -lambda) * Math.pow(lambda, y)) / doFactorial(y).doubleValue();
		}
		else {
			//printed statement if the lambda and y-value don't meet the requirements
			System.out.println("Lambda must be positive and y must be nonnegative");
			//returning not a number if invalid
			return Double.NaN;
		}
	}
	
	
	//method which takes arguments for the upper and lower bound around the mean, the mean, and standard deviation to find the 
	//percent of data which lies between the bounds by applying Tchebysheff's Theorem
	public String findPercentOfData(double lower, double upper, double mean, double stdDev) {
		//ensuring the lower and upper bounds are symmetric about the mean so we can apply the theorem
		if((mean - lower) == (upper - mean)) {
			//formula and logic statement
			return ((1 - 1 / Math.pow((mean - lower) / stdDev, 2)) * 100) + "% of the data falls between " + lower + " and " + upper;
		} else {
			//print statement if the bounds are not symmetric about the mean
			return "The interval must be symmetric around the mean to directly apply Tchebycheff's Theorem";
		}
	}
	
	
	//method which takes arguments for the given upper and lower bounds, and the upper and lower bounds in question to find the 
	//uniform distribution
	public double doUniformDistribution(double knownUpper, double knownLower, double chanceUpper, double chanceLower) {
		//formula
		return (chanceUpper - chanceLower) / (knownUpper - knownLower);
	}
	
	//method which takes in the upper and lower bounds of a uniform distribution to find the expected value
	public double findUniformExpected(double upper, double lower) {
		//formula
		return (upper + lower) / 2;
	}
	
	//method which takes in the upper and lower bounds of a uniform distribution to find the variance
	public double findUniformVariance(double upper, double lower) {
		//formula
		return (Math.pow((upper - lower), 2)) / 12;
	}
		
}

