/*
 * check if stack is balanced
 * examples
 *{[()]} = YES
 *{[(])} = NO
 *{{[[(())]]}} = YES
 *
 */

package my.hkr;

import java.util.Stack;

public class BalancedBracket {

	static String isBalanced(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			}
			if (stack.isEmpty() && (ch == ']' || ch == '}' || ch == ')')) {
				return "NO";
			}
			if (ch == '}' && stack.pop() != '{') {
				return "NO";
			}
			if (ch == ']' && stack.pop() != '[') {
				return "NO";
			}
			if (ch == ')' && stack.pop() != '(') {
				return "NO";
			}
		}
		return stack.isEmpty() ? "YES" : "NO";
	}

	public static void main(String[] args) {
		String str = "{[[[]]]}";
		System.out.println(isBalanced(str));
	}
}
