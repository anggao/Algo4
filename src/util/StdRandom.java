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
}
