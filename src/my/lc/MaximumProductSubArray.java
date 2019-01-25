/*
Problem statement
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

package my.lc;

public class MaximumProductSubArray {

	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int min = nums[0];
		int max = nums[0];
		int maxProd = nums[0];

		for (int i = 1; i < nums.length; i++) {
			//Min number is just a place holder
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(max * nums[i], nums[i]);
			min = Math.min(min * nums[i], nums[i]);

			if (max > maxProd) {
				maxProd = max;
			}
		}
		return maxProd;
	}

	public static void main(String args[]) {
		MaximumProductSubArray mps = new MaximumProductSubArray();
		int[] nums = { 0, -1, -2, -3, -4 };
		System.out.println(mps.maxProduct(nums));
	}
}
