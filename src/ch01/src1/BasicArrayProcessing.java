package ch01.src1;

public class BasicArrayProcessing {

	public static double maxValue(double[] a) {
		double max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	public static double averageValue(double[] a) {
		int N = a.length;
		double sum = 0.0;
		for (int i = 0; i < N; i++)
			sum += a[i];
		return sum / N;
	}

	public static double[] cloneArray(double[] a) {
		double[] b = new double[a.length];
		for (int i = 0; i < a.length; i++)
			b[i] = a[i];
		return b;
	}

	public static void reverse(double[] a) {
		int N = a.length;
		for (int i = 0; i < N / 2; i++) {
			double temp = a[i];
			a[i] = a[N - i - 1];
			a[N - i - 1] = temp;
		}
	}

	public static double[][] matrixMulti(double[][] a, double[][] b) {
		int N = a.length;
		int N1 = a[0].length;
		int M = b[0].length;
		double[][] c = new double[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N1; k++) {
					// dot-product
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		return c;
	}

	public static void main(String[] args) {
		double[][] a = { { 1, 2 }, { 3, 4 } };
		double[][] b = { { 2 }, { 1 } };
		double[][] c = matrixMulti(a, b);
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++)
				System.out.print(c[i][j] + " ");
			System.out.println();
		}

	}
}
