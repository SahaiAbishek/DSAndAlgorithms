/*
 * Trie implementation
 * 4
 *add hack
 *add hackerrank
 *find hac
 *find hak
 */

package my.hkr;

public class Contacts {

	private static class TrieNode {
		private TrieNode[] node = new TrieNode[26];
		private int count;

		public TrieNode(int count) {
			this.count = count;
		}
	}

	private static TrieNode trieNode = new TrieNode(0);

	public static void add(String name) {
		TrieNode node = trieNode;
		for (int i = 0; i < name.length(); i++) {
			int ch = name.charAt(i) - 'a';
			if (node.node[ch] == null) {
				TrieNode temp = new TrieNode(1);
				node.node[ch] = temp;
				node = temp;
			} else {
				node = node.node[ch];
				node.count += 1;
			}
		}
	}

	public static int find(String query) {
		int result = 0;
		TrieNode temp = trieNode;
		for (int i = 0; i < query.length(); i++) {
			int ch = query.charAt(i) - 'a';
			if (temp.node[ch] == null) {
				return 0;
			} else {
				temp = temp.node[ch];
				result = temp.count;
			}
		}
		return result;
	}

	static int[] contacts(String[][] queries) {

		int count = 0;
		for (int i = 0; i < queries.length; i++) {
			String opr = queries[i][0];
			if (opr.equals("find")) {
				count += 1;
			}
		}

		int result[] = new int[count];
		count = 0;
		for (int i = 0; i < queries.length; i++) {
			String opr = queries[i][0];
			String word = queries[i][1];
			if (opr.equals("add")) {
				add(word);
			} else if (opr.equals("find")) {
				result[count] = find(word);
				count += 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		// add("eouecvksgllpvfxfvndu");
		// add("uugxgcrtujxzyjysqrhu");
		add("ryhlozedmgzcmjdfjhte");
		// add("ibfzenldsdltkjbbsccq");
		// add("vvxwlttswneoosvgfezt");
		// add("qimoqjtjypqupwwrueew");
		// add("nkaetboylnjbxxvhzupk");
		// add("rdzddgjryupsyhhbjtmx");
		// add("kudnlccqbvkizsfdbwxy");
		// add("jgahjespbkxxeqnzwpjr");
		System.out.println(find("yyr"));

		// try {
		// BufferedReader br = new BufferedReader(new FileReader(new
		// File("C:\\test\\testCase2.txt")));
		// String string = br.readLine();
		// String[][] queries = new String[20][2];
		// int count = 0;
		// while(string != null){
		// String[] words = string.split(" ");
		// queries[count][0] = words[0];
		// queries[count][1] = words[1];
		// count++;
		// string = br.readLine();
		// }
		// int[] results =contacts(queries);
		// for(int res:results){
		// System.out.println(res);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

}
