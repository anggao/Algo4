package ch01.src1;

public class BasicFunc {

	public static boolean isPrime(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i * i <= N; i++)
			if (N % i == 0)
				return false;
		return true;
	}
	
	public static double H(int N){
		double sum = 0;
		for(int i = 1; i <= N; i++)
			sum += 1.0/i;
		return sum;
	}
}
