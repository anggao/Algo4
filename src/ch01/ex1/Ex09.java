package ch01.ex1;

public class Ex09 {

	public static String toBinaryString(int N) {
		String s = "";
		for (int n = N; n > 0; n = n >> 1) {
			s = (n & 1) + s;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(Ex09.toBinaryString(10));
	}

}
