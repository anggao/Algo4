package ch02.src1;

public abstract class Sort {
	protected static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	protected static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
}
