package my.lc;

import java.util.Map;

public class Fibonacci {

	public static int climbStairs(int n, int[] aux) {
		if (aux[n] != 0) {
			return aux[n];
		}
		if (n <= 0) {
			return 0;
		}
		if (n <= 2) {
			aux[n] = n;
			return n;
		} else {
			int result = 0;
			result = climbStairs(n - 1, aux) + climbStairs(n - 2, aux);
			aux[n] = result;
			return result;
		}

	}

	public static int fib(int N, Map<Integer, Integer> map) {
		if (map.containsKey(N)) {
			return map.get(N);
		}

		if (N < 2) {
			return N;
		}
		int sum = 0;
		sum = fib(N - 1, map) + fib(N - 2, map);

		map.put(N, sum);
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(6, new int[7]));
	}
}
