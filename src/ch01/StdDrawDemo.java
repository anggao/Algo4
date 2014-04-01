package ch01;

import java.util.Arrays;

import util.StdRandom;
import edu.princeton.cs.introcs.StdDraw;

public class StdDrawDemo {
	
	public static void drawFuncValue(){
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N*N);
		StdDraw.setPenRadius(.01);
		for(int i = 1; i <= N; i++){
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
	}
	
	public static void drawRandomArray(){
		int N = 50;
		double[] a = new double[N];
		for(int i = 0; i < N; i++)
			a[i] = StdRandom.uniform();
		Arrays.sort(a);
		for(int i = 0; i < N; i++){
			double x = 1.0*i/N;
			double y = a[i]/2.0;
			double rw = 0.5/N;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
	public static void main(String[] args) {
		StdDrawDemo.drawRandomArray();
	}

}
