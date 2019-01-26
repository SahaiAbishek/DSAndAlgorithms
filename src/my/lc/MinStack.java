/*
 * 
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 * 
 */

package my.lc;

class MinStack {

	int[] arr;
	int size;
	int min = Integer.MAX_VALUE;

	/** initialize your data structure here. */
	public MinStack() {
		arr = new int[10000];
		size = 0;
	}

	public void push(int x) {
		arr[size++] = x;
		if (x < min) {
			min = x;
		}

	}

	public void pop() {
		if (size == 0) {
			System.out.println("stack is empty");
			return;
		}
		int elem = arr[size-1];
		if (elem <= min) {
			min = Integer.MAX_VALUE;
			for (int i = 0; i < size - 1; i++) {
				if (arr[i] < min) {
					min = arr[i];
				}
			}
		}
		size--;
	}

	public int top() {
		if (size == 0) {
			System.out.println("Stack is empty");
			return -1;
		}
		return arr[size-1];

	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // Returns -3.
		minStack.pop();
		minStack.pop();
		minStack.pop();
		System.out.println(minStack.top()); // Returns 0.
		System.out.println(minStack.getMin()); // Returns -2.
	}
}