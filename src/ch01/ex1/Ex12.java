package ch01.ex1;

public class Ex12 {

	public static void t() {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = 9 - i;
		for (int i = 0; i < 10; i++)
			a[i] = a[a[i]];
		for (int i = 0; i < 10; i++)
			System.out.println(a[i]);
	}

	public static void main(String[] args) {
		Ex12.t();
	}
}
