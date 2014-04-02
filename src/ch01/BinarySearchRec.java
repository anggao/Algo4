package ch01;

public class BinarySearchRec {
	public static int rank(int k, int[] a) {
		return rank(k, a, 0, a.length - 1);
	}

	private static int rank(int key, int[] a, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid])      return rank(key, a, lo, mid - -1);
		else if(key > a[mid]) return rank(key, a, mid + 1, hi);
		else 				  return mid;

	}
	
	public static void main(String[] args) {
		int[] a = {1,2,5,7,9,13,16,18,189};
		System.out.println(rank(9,a));
	}
}
