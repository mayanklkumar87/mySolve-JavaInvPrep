
public class Interview {

	public static void main(String[] args) {
		InterviewUtility intUtil = new InterviewUtility();

		//isPallindrome Function four scenarios tested
		/** System.out.println(intUtil.isPallindrome(""));
		 	System.out.println(intUtil.isPallindrome("abccba"));
			System.out.println(intUtil.isPallindrome("abcdcba"));
			System.out.println(intUtil.isPallindrome("abcxyzdcba")); **/

		//anagramOfPallindromeFinder method scenarios 
		/** System.out.println(intUtil.anagramOfPallindromeFinder("abcdcdab"));
			System.out.println(intUtil.anagramOfPallindromeFinder("abccba"));
			System.out.println(intUtil.anagramOfPallindromeFinder(""));
			System.out.println(intUtil.anagramOfPallindromeFinder("abcxyzdcba"));
			System.out.println(intUtil.anagramOfPallindromeFinder("abcxyzabcxxxyzAaba")); **/

		//maximiseProfit
		/** float[] prices = {25,20,15,75,90,0,10};
			System.out.println(intUtil.maximiseProfit(prices));
			float[] prices1 = {15,5,85,105,65,35,25};
			System.out.println(intUtil.maximiseProfit(prices1));
			float[] prices2 = {10,15,5,0,15,10,5,10};
			System.out.println(intUtil.maximiseProfit(prices2)); **/

		//sortBinaryArray
		/**	int[] binaryArr = {0,1,1,0,0,1,1,1,0};
			int[] binaryArr = {1,1,0,0,0,1,1,0};
			int[] binaryArr = {1,0,0,0,0,1,1,0};
			int[] binaryArr = {0,0,1,0,0,1,1,0};
			int[] binarySortArr = intUtil.sortBinaryArray(binaryArr);
			for(int a : binarySortArr)
				System.out.println(a); **/

		//Count max votes election
		/**	String[] votes = {"ram", "rahul", "ram", "sachin", "sachin", "vineet", "ram", "sachin", "rahul", "ram"};
			String[] votes = {"ram", "rahul", "ram", "sachin", "sachin", "vineet", "ram", "sachin", "rahul", "ram", "sachin"};
			System.out.println(intUtil.electionResult(votes)); **/

		//Finding out are two string cyclic
		/**	String s1 = "mayank";
			String s2 = "knayam";
			String s3 = "yankma";
			System.out.println(intUtil.isCyclicStrings(s1, s2));
			System.out.println(intUtil.isCyclicStrings(s1, s3)); **/
		
		//Bracket Validator
		/**	String s1 = "[[{{(())}}]]";
			String s2 = "";
			String s3 = "{[}()]";
			String s4 = "}[(]){";
			String s5 = "abc";
			String s6 = "{()[}[";
			System.out.println(intUtil.bracketValidator(s1));
			System.out.println(intUtil.bracketValidator(s2));
			System.out.println(intUtil.bracketValidator(s3));
			System.out.println(intUtil.bracketValidator(s4));
			System.out.println(intUtil.bracketValidator(s5));
			System.out.println(intUtil.bracketValidator(s6)); **/
		
		//Find if the given Number is a pallindrome
		/**	int a = 12345;
			int b = 123321;
			int c = 0;//single digit is a pallindrome as read from front or back is same
			int d = 4557554;
			System.out.println(intUtil.isNumPallindrome(a));
			System.out.println(intUtil.isNumPallindrome(b));
			System.out.println(intUtil.isNumPallindrome(c));
			System.out.println(intUtil.isNumPallindrome(d)); **/
		
		//Find Missing number from list of n consecutive numbers
		/** int input[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,15};
			int start = 1;
			int end = 15;
			System.out.println("Missing number is : "+intUtil.findMissingNumber(input, start, end)); **/
		

	}

}
