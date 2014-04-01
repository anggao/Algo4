package ch01;

public class GCD {

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args) {
		int a = 10, b = 7;
		System.out.println(gcd(a, b));
	}
}
