package ch02.src1;

public class Shell extends Sort {
	public static void sort(Comparable[] a) {
		// Sort a[] into increasing order.
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = h * 3 + 1;
		while (h >= 1) {
			// h-sort the array.
			for (int i = h; i < N; i++) {
				// insert a[i] among a[i-h], a[i-2*h], a[i-3*h]...
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
	}
}
