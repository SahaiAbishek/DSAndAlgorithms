/*
 * You are given an array and you need to find number of tripets of indices  such that 
 * the elements at those indices are in geometric progression for a given common ratio
	Example : 
	6 3
	1 3 9 9 27 81
	
	Ans:
	6 
 */

package my.hkr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

	// Complete the countTriplets function below.
	static long countTripletsMyApproach(List<Long> arr, long r) {
		Map<Long, Integer> map = new HashMap<>();
		for (long num : arr) {
			if (map.containsKey(num)) {
				int val = map.get(num);
				map.put(num, val + 1);
			} else {
				map.put(num, 1);
			}
		}

		int result = 0;
		for (int i = 0; i < arr.size(); i++) {
			long num = arr.get(i);
			if (map.containsKey(num * r) && map.containsKey(num * r * r)) {
				int val1 = map.get(num * r);
				int val2 = map.get(num * r * r);
				if (val1 > 1) {
					result += val1;
				}
				if (val2 > 1) {
					result += val2;
				}
				if (val1 == 1 && val2 == 1) {
					result++;
				}
			}
		}
		return result;
	}

	public static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> map1 = new HashMap<>();
		Map<Long, Long> map2 = new HashMap<>();
		long result = 0;
		for (Long num : arr) {
			if (map2.containsKey(num)) {
				result += map2.get(num);
			}
			if (map1.containsKey(num)) {
				map2.put(num * r, map2.getOrDefault(num * r, 0l) + map1.get(num));
			}
			map1.put(num * r, map1.getOrDefault(num * r, 0l) + 1);
		}

		return result;

	}

	public static void main(String[] args) {
		List<Long> list = new ArrayList<>();
		list.add(1l);
		list.add(3l);
		list.add(9l);
		list.add(9l);
		list.add(27l);
		list.add(81l);
		System.out.println(countTriplets(list, 3));
	}
}
