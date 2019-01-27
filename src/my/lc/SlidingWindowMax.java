package my.lc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMax {

	public static int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		if (k == 1) {
			return nums;
		}

		int result[] = new int[nums.length - (k - 1)];

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}

		int resultIndex = 0;
		result[resultIndex++] = pq.peek();

		int start = 1;
		int end = start + (k - 1);
		while (end < nums.length) {
			pq.remove(nums[start-1]);
			pq.add(nums[end++]);
			start++;
			result[resultIndex++] = pq.peek();
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};//{9,10,9,-7,-4,-8,2,-6};
		int[] res = maxSlidingWindow(nums, 3);
		for (int num : res) {
			System.out.println(num + ", ");
		}
	}
}
