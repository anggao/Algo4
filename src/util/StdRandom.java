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
}
