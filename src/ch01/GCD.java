package ch01;

import edu.princeton.cs.introcs.StdOut;

public class GCD {

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args) {
		int a = 10, b = 7;
		StdOut.print(gcd(a, b));
	}
}
