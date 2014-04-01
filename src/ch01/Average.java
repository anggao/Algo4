package ch01;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Average {
	public static void main(String[] args) {
		// Average the numbers on StdIn
		double sum = 0.0;
		int cnt = 0;
		while (!StdIn.isEmpty()) {
			// Read a number and cumulate the sum.
			sum += StdIn.readDouble();
			cnt++;
		}
		double avg = sum / cnt;
		StdOut.printf("Average is %.5f\n", avg);
	}

}
