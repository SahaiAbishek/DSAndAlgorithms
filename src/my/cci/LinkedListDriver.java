package my.cci;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListDriver {

	public static class LinkedList {
		private LinkedList next;
		private int val;

		public LinkedList() {
		}

		public LinkedList(int val) {
			this.val = val;
		}
	}

	private LinkedList node;

	public void add(int num) {
		node = add(num, this.node);
	}

	private LinkedList add(int num, LinkedList root) {
		if (root == null) {
			root = new LinkedList(num);
			return root;
		}
		LinkedList temp = root;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new LinkedList(num);
		return root;
	}

	public void deleteDuplicate() {
		Set<Integer> set = new HashSet<>();
		LinkedList temp = this.node;
		set.add(temp.val);
		while (temp.next != null) {
			int data = temp.next.val;
			if (set.contains(data)) {
				temp.next = temp.next.next;
			} else {
				set.add(data);
				temp = temp.next;
			}
		}

		if (set.contains(temp.val)) {
			temp.next = null;
		}
	}

	/*
	 * Given only a pointer/reference to a node to be deleted in a singly linked
	 * list, how do you delete it?
	 */
	public void deleteMiddleNode(LinkedList node) {
//		LinkedList temp = node;
		node = node.next;
		this.node = node;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		LinkedList temp = this.node;
		while (temp != null) {
			sb.append(temp.val + " ,");
			temp = temp.next;
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		LinkedListDriver list = new LinkedListDriver();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.deleteMiddleNode(list.node);
		System.out.println(list);
	}
}
