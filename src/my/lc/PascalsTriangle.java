package my.lc;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static List<List<Integer>> generate(int numRows) {
		if(numRows == 0){
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> l = new ArrayList<>();
			l.add(1);
			result.add(l);
			return result;
		}
		List<List<Integer>> list = new ArrayList<>();
		generate(numRows - 1, list);
		return list;
	}

	public static void generate(int rows, List<List<Integer>> result) {
		List<Integer> lst = new ArrayList<>();
		if (rows == 0) {
			lst.add(1);
			result.add(lst);
			return;
		}
		generate(rows - 1, result);
		List<Integer> retList = result.get(rows - 1);
		for (int i = 0; i <= rows; i++) {
			if (i == 0 || i == rows) {
				lst.add(1);
			} else {
				int val = retList.get(i - 1) + retList.get(i);
				lst.add(val);
			}
		}
		result.add(lst);
	}

	public static void main(String[] args) {
		List<List<Integer>> result = generate(0);
		for(List<Integer> lst : result){
			System.out.println(lst);
		}
	}

}
