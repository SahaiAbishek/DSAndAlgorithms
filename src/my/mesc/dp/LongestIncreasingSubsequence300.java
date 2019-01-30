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

	public static void main(String[] args) {
		int[] nums = {  8,2, 5, 9};
		Map<Integer, Integer> map = new HashMap<>();

		System.out.println(lis(nums, 0, Integer.MIN_VALUE, map));
		System.out.println(map);
	}
}
