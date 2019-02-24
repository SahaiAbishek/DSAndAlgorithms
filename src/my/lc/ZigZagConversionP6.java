/*
 * 
	Input: s = "PAYPALISHIRING", numRows = 3
	Output: "PAHNAPLSIIGYIR"
	
	Input: s = "PAYPALISHIRING", numRows = 4
	Output: "PINALSIGYAHRPI"
 *
 */

package my.lc;

public class ZigZagConversionP6 {

	public static String convert(String s, int numRows) {
		if(numRows == 1){
			return s;
		}
		StringBuffer[] sbRows = new StringBuffer[numRows];
		for (int i = 0; i < sbRows.length; i++) {
			sbRows[i] = new StringBuffer();
		}
		boolean isBackward = true;
		int row = 0;
		for (int i = 0; i < s.length(); i++) {
			sbRows[row].append(s.charAt(i));
			if (row == 0 || row == numRows - 1) {
				isBackward = !isBackward;
			}
			if (isBackward) {
				row--;
			} else {
				row++;
			}
		}
		StringBuffer result = new StringBuffer();
		for (StringBuffer sb : sbRows) {
			result.append(sb);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}

}
