package my.lc;

import java.util.HashMap;
import java.util.Map;

public class PowerOfNumber {

	public static double myPow(double x, int n) {
		if (n < 0) {
			double result = myPow(x, -1 * n, new HashMap<>());
			if (result == 0.0) {
				return result;
			} else {
				result = 1 / result;
				return result;
			}
		} else {
			return myPow(x, n, new HashMap<>());
		}
	}

	public static double myPow(double x, int n, Map<Integer, Double> aux) {
		if (n == 0) {
			return 1;
		}

		if (aux.containsKey(n)) {
			return aux.get(n);
		} else {
			double result = n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
			aux.put(n, result);
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(myPow(2.0, -2147483648));
	}

}
