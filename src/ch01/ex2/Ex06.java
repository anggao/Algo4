package ch01.ex2;

public class Ex06 {
	public static boolean isCircularRotation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		} else {
			return (-1 != (str1 + str1).indexOf(str2));
		}
	}

	public static void main(String[] args) {
		String str1 = "ACTGACG";
		String str2 = "TGACGAC";
		System.out.println(isCircularRotation(str1, str2));
	}
}
