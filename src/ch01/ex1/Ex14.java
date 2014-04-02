package ch01.ex1;

public class Ex14 {
	public static int log(int N) {
		int n = 2;
		int cnt = 0;
		while (n <= N) {
			cnt++;
			n = n << 1;
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(Ex14.log(33));
	}
}
