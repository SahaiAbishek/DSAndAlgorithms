package my.cci;

public class ArraysSrings {

	public boolean isUnique(String str) {

		//check if the string is more than 256 chars, if yes than chars are repeated
		if(str.length() > 256){
			return false;
		}
		
		boolean[] arr = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);
			if (arr[ch]) {
				return false;
			} else {
				arr[ch] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArraysSrings as = new ArraysSrings();
		System.out.println(as.isUnique("abcda"));
		int checker = 0;
		checker = checker & (1<<5);
		System.out.println(checker);
	}

}
