/*
 * You will be given an array of integers and a target value. 
 * Determine the number of pairs of array elements that have a difference equal to a target value.
 * For example, given an array of [1, 2, 3, 4] and a target value of 1, 
 * we have three values meeting the condition: , , and .
 * 
 */

package my.hkr;

import java.util.HashSet;
import java.util.Set;

public class Pairs {

	public static int pairsArrayImpl(int k, int[] arr) {

		int count = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		boolean aux[] = new boolean[max + 1];
		for (int i = 0; i < arr.length; i++) {
			aux[arr[i]] = true;
		}

		for (int i = k + 1; i < aux.length; i++) {
			if (aux[i - k] == true) {
				count++;
			}
		}
		return count;
	}

	static int pairs(int k, int[] arr) {

		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - k > 0) {
				if (set.contains(arr[i] - k)) {
					count++;
				}
			}
			if (set.contains(arr[i] + k)) {
				count++;
			}
			set.add(arr[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(pairs(1, arr));
	}
}
