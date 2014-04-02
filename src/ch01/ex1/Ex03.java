package ch01.ex1;

public class Ex03 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[1]);
		int b = Integer.parseInt(args[2]);
		int c = Integer.parseInt(args[2]);
		if (a == b && b == c)
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
}
