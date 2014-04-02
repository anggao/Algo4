package ch01.ex1;

import edu.princeton.cs.introcs.StdOut;

public class Ex07 {
	public static void t1() {
		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > 0.001)
			t = (9.0 / t + t) / 2.0;
		StdOut.printf("%.5f\n", t);
	}

	public static void t2() {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Ex07.t1();
		Ex07.t2();
		System.out.println('b' + 'c');
		System.out.println((char) ('a' + 4));
	}

}
