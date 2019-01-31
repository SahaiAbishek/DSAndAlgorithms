/*
 
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

-------------------------------------------------------------------
Note : Solved it but not very fast :
Runtime: 142 ms, faster than 1.18% of Java online submissions for Longest Increasing Subsequence.

Try running a DP for loop instead
 */

package my.mesc.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence300 {

	public static int lis(int[] nums, int index, int min, Map<Integer, Integer> aux) {
		if (index == nums.length) {
			return 0;
		}

		int len = 0;
		int maxLen = 0;
		for (int i = index; i < nums.length; i++) {
			if (aux.containsKey(index)) {
				return aux.get(index);
			} else {
				if (nums[i] > min) {
					len = 1 + lis(nums, i + 1, nums[i], aux);
				}
				maxLen = Math.max(maxLen, len);
			}
		}
		aux.put(index, maxLen);
		return maxLen;
	}

	public static int lis(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}

		int maxVal = Integer.MIN_VALUE;
		int aux[] = new int[nums.length];
		aux[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max = Math.max(max, aux[j]);
				}
			}
			aux[i] = max + 1;
			maxVal = Math.max(maxVal, aux[i]);
		}
		return maxVal;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, -18 };
		Map<Integer, Integer> map = new HashMap<>();

		System.out.println(lis(nums));
		System.out.println(map);
	}
}
