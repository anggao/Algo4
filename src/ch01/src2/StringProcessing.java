package ch01.src2;

public class StringProcessing {
	public static boolean isPalindrome(String s) {
		int N = s.length();
		for (int i = 0; i < N / 2; i++) {
			if (s.charAt(i) != s.charAt(N - 1 - i))
				return false;
		}
		return true;
	}
}
