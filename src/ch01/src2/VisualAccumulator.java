package ch01.src2;

import util.StdRandom;
import edu.princeton.cs.introcs.StdDraw;

public class VisualAccumulator {
	private double total;
	private int N;

	public VisualAccumulator(int trials, double max) {
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(0.005);
	}

	public void addDataValue(double val) {
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total / N);
	}

	public static void main(String[] args) {
		int T = 2000;
		VisualAccumulator a = new VisualAccumulator(T, 1.0);
		for(int t = 0; t < T; t++){
			a.addDataValue(StdRandom.uniform());
		}
	}
}
