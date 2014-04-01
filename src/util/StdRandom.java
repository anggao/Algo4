package util;

import java.util.Random;

/**
 * <i>Standard random</i>. This class provides methods for generating random
 * number from various distributions.
 * <p>
 * 
 * @author Ang Gao
 * 
 */
public final class StdRandom {
	private static Random random; // pseudo-random number generator
	private static long seed;     // pseudo-random number generator seed
	
	// static initializer
	static {
		// this is how the seed was set in Java 1.4
		seed = System.currentTimeMillis();
		random = new Random(seed);
	}
	
	// don't instantiate
	private StdRandom(){}
	
	/**
	 * Sets the seed of the pseudo-random number generator.
	 */
	public static void setSeed(long s){
		seed = s;
		random = new Random(seed);
	}
	
	/**
	 * Returns the seed of the pseudo-random number generator.
	 */
	public static long getSeed(){
		return seed;
	}
	
	/**
	 * Return real number uniformly in [0,1)
	 */
	public static double uniform(){
		return random.nextDouble();
	}
	
	/**
	 * Return an integer uniformly between 0(inclusive)  and N(exclusive)
	 * @throws IllegalArgumentException if <tt>N<=0</tt>
	 */
	public static int uniform(int N){
		if(N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
		return random.nextInt(N);
	}

	////////////////////////////////////////////////////////////	
	// STATIC METHOD BELOW RELY ON JAVA.UTIL.RANDOM ONLY 
	// INDIRECTLY VIA THE STATIC METHODS ABOVE.
	////////////////////////////////////////////////////////////
	
	/**
	 * Returns an integer uniformly in [a,b)
	 * @throws IllegalArgumentException if <tt>b <= a</tt>
	 * @throws IllegalArgumentException if <tt> b - a >= Integer.MAX_VALUE</tt>
	 */
	public static int uniform(int a, int b){
		if(b <= a) throw new IllegalArgumentException("Invalid range");
		if((long)b - a >= Integer.MAX_VALUE) throw new IllegalArgumentException("Invalid range");
		return a + uniform(b-a);
	}
	
	/**
	 * Return a real number uniformly in [a,b) 
	 * @throws IllegalArgumentException if <tt>b <= a</tt>
	 */
	public static double uniform(double a, double b){
		if(b <= a) throw new IllegalArgumentException("Invalid range");
		return a + uniform()*(b-a);
	}
	
	/**
	 * Return a boolean, which is true with probability p, and false otherwise.
	 * @throws IllegalArgumentException if either <tt>p < 0.0</tt> or <tt>p > 1.0</tt>
	 */
	public static boolean bernoulli(double p){
		if(p < 0.0 || p > 1.0)
			throw new IllegalArgumentException("Probability must between 0.0 and 1.0");
		return uniform() < p;
	}
	
	/**
	 * Return a boolean, which is true with probability 0.5, and false otherwise.
	 */
	public static boolean bernoulli(){
		return bernoulli(0.5);
	}
	
	/**
	 * Returns a number from a discrete distribution: i with probability a[i].
	 * @throws IllegalArgumentException if sum of the array entires is not (very nearly) equal to <tt>1.0</tt>
	 * @throws IllegalArgumentException if <tt>a[i] < 0.0 </tt> for any index <tt>i</tt>.
	 */
	public static int discrete(int[] a){
		double EPSILON = 1E-14;
		double sum = 0.0;
		for(int i = 0; i < a.length; i++){
			if(a[i] < 0.0)
				throw new IllegalArgumentException("array entry " + i + " is negative: " + a[i]);
			sum += a[i];
		}
		if(sum > 1.0 + EPSILON || sum < 1.0 - EPSILON){
			throw new IllegalArgumentException("sum of array entries not equal to one: " + sum);
		}
		
		// the for loop may not return a value when both r is (nearly) 1.0 and when the 
		// cumulative sum is less than 1.0 (as a result of floating-point roundoff error)
		while(true){
			double r = uniform();
			sum = 0.0;
			for(int i = 0; i < a.length; i++){
				sum = sum + a[i];
				if(sum > r) return i;
			}
		}
	}
	
	/**
	 * Rearrange the elements of an int array in random order.
	 */
	public static void shuffle(int[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			int r = i + uniform(N-i);        // between i and N - 1;
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
}
