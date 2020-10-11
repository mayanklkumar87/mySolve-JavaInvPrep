package dynamic.programming;

public class LongestCommonSubsequence {
	
	public static int getLengthLCS(String s1, String s2) {
		//// Returns length of LCS for X[0..m-1], Y[0..n-1]
		//abcdexyz,fbecdxyz-->bexyz and bcdxyz-->longest is bcdxyz
		//first row and first column is populated as 0 so that if either or both of the string is empty LCS will be of length 0
		// | |a|b|c|d|e|x|y|z
		// |0|0|0|0|0|0|0|0|0
		//f|0|0|0|0|0|0|0|0|0
		//b|0|0|1|1|1|1|1|1|1
		//e|0|0|1|1|1|2|2|2|2
		//c|0|0|1|2|2|2|2|2|2
		//d|0|0|1|2|3|3|3|3|3
		//x|0|0|1|2|3|3|4|4|4
		//y|0|0|1|2|3|3|4|5|5
		//z|0|0|1|2|3|3|4|5|6
		//		a	b	c	d	e	x	y	z
		//	0	0	0	0	0	0	0	0	0
		//f	0	0	0	0	0	0	0	0	0
		//b	0	0	1	1	1	1	1	1	1
		//e	0	0	1	1	1	2	2	2	2
		//c	0	0	1	2	2	2	2	2	2
		//d	0	0	1	2	3	3	3	3	3
		//x	0	0	1	2	3	3	4	4	4
		//y	0	0	1	2	3	3	4	5	5
		//z	0	0	1	2	3	3	4	5	6

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int[][] matrix = new int[arr1.length+1][arr2.length+1];
		// Following steps build L[m+1][n+1] in bottom up fashion. Note 
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 
		for(int i = 0 ; i < arr1.length+1 ; i++) {
			for(int j = 0; j < arr2.length+1 ; j++) {
				if(i==0||j==0) {
					matrix[i][j]=0;
				}
				else if(arr1[i-1] == arr2[j-1]) {
					matrix[i][j] = matrix[i-1][j-1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
		}
		return matrix[arr1.length][arr2.length];
	}
	
	public static String printLCS(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int[][] matrix = new int[arr1.length+1][arr2.length+1];
		// Following steps build L[m+1][n+1] in bottom up fashion. Note 
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 
		for(int i = 0 ; i < arr1.length+1 ; i++) {
			for(int j = 0; j < arr2.length+1 ; j++) {
				if(i==0||j==0) {
					matrix[i][j]=0;
				}
				else if(arr1[i-1] == arr2[j-1]) {
					matrix[i][j] = matrix[i-1][j-1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
		}
		int i = arr1.length;
		int j = arr2.length;
		int len = matrix[arr1.length][arr2.length];
		// Create a character array to store the lcs string
		char[] result = new char[len];
		int x = 0;
		// Start from the right-most-bottom-most corner and 
        // one by one store characters in lcs[] 
		while(x < len) {
			// If current character in X[] and Y are same, then 
            // current character is part of LCS 
			if(arr1[i-1] == arr2[j-1]) {
				// Put current character in result 
				result[len-x-1] = arr1[i-1];
				// reduce values of i, j and index
				x++;
				i--;
				j--;
			} else {
				// If not same, then find the larger of two and 
	            // go in the direction of larger value 
				if(arr1[i-2] > arr2[j-2]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		//Find length of LCS(Longest Common Subsequence)
			    String s1 = "bqdrcvefgh";
				String s2 = "abcvdefgh";
				System.out.println(getLengthLCS(s1, s2));
				System.out.println(printLCS(s1, s2));
				
				String s3 = "abcdexyz";
				String s4 = "fbecdxyz";
				System.out.println(getLengthLCS(s3, s4)); 
				System.out.println(printLCS(s3, s4));
		
	}

}
