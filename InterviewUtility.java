import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class InterviewUtility {

	public static boolean anagramOfPallindromeFinder(String input) {
		//check if the given string can be rearranged to form a pallindrom 
		//we will store each character and it's count in a Hash Map 
		//first case : count of each character should be even (e.g.aabbccdd)
		//second case : count of each character should be even except one (e.g.aabbZccdd)
		char[] arr = input.toCharArray();
		Map<Character,Integer> countPal = new HashMap<>();
		boolean result = true;
		for(char c  : arr) {
			if(countPal.containsKey(c)) {
				int val = countPal.get(c);
				val = val + 1;
				countPal.put(c, val);
			} else {
				countPal.put(c, 1);
			}
		}
		int i = 0;
		for(char c  : countPal.keySet()) {
			if(countPal.get(c)%2 != 0) {
				i++;
				if(i>1) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isPallindrome(String input) {
		//compare first and last char and keep iterating till the middle char.
		boolean result = true;
		int size = input.length();
		char[] arr = input.toCharArray();
		for(int i = 0 ; i < size/2 ; i++) {
			if(arr[i] != arr[size-i-1]) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static float maximiseProfit(float[] input) {
		//{25,20,15,75,90,0,10}buy on dips sell on highs
		//float[] arr = {25,20,15,75,90,0,10};
		/**float buyPrice = 0;
		float sellPrice = 0;
		float profit = 0;
		boolean flag = false;
		for(int i = 0 ; i < input.length-1 ; i++) {
			if(flag == false && input[i] < input[i+1]) {
				buyPrice = input[i];
				flag = true;
			}
			if(flag == true && input[i] > input[i+1] ) {
				sellPrice = input[i];
				profit = profit + sellPrice - buyPrice;
				flag = false;
			}
			//handle edge case of last price is greater then second last sell....
			if(flag == true && i ==  input.length-2 && input[i] < input[i+1]) {
				sellPrice = input[i+1];
				profit = profit + sellPrice - buyPrice;
				flag = false;
			}
		}
		return profit;**/
		float profit = 0 ;
		for(int i = 0; i < input.length-1 ; i++) {
			if(input[i+1] > input[i]) {
				profit = profit + input[i+1] - input[i];
			}
		}
		return profit;
	}

	public static int[] sortBinaryArray(int[] input) {
		//{0,1,1,0,0,1,1,1,0} ==> {0,0,0,0,1,1,1,1,1}
		//{1,1,0,0,0,1,1,0} ==> {0,0,0,0,1,1,1,1}
		//{1,0,0,0,0,1,1,0} ==> {0,0,0,0,0,1,1,1}
		//{0,0,1,0,0,1,1,0} ==> {0,0,0,0,0,1,1,1}
		//have to pointers i,j keep i at 0 and keep incrementing j when 
		//next 0 found replace the index and increment i
		int i = 0;
		for(int j = 0 ; j < input.length-1 ; j++) {
			if(input[j] < input[j+1]) {
				i++;
			} else if(input[j] > input[j+1]) {
				input[j+1] = 1;
				input[i] = 0;
				i++;
			}
		}
		return input;
	}

	public static String electionResult(String[] input) {
		Map<String, Integer> results = new HashMap<>();
		int count = 0;
		String result = "";
		for(String name : input) {
			count = results.containsKey(name) ? results.get(name) : 0;
			results.put(name, count+1);
		}
		int maxCount = 0;
		for(String name : results.keySet()) {
			if(results.get(name) > maxCount) {
				result = name;
			}
		} 
		return result;
	} 

	public static void sortMapByValue() {
		final Map<String, Integer> wordCounts = new HashMap<>();
		wordCounts.put("USA", 100);
		wordCounts.put("jobs", 200);
		wordCounts.put("software", 50);
		wordCounts.put("technology", 70);
		wordCounts.put("opportunity", 200);
		final Map<String, Integer> sortedByCount = wordCounts.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	}	

	public static boolean isCyclicStrings(String s1, String s2) {
		boolean result = false;
		result = s1.length()==s2.length() && (s1+s1).contains(s2);
		return result;
	}	
	
	public static boolean bracketValidator(String input) {
		//[[{{(())}}]]
		boolean result = false;
		if(input.length()==0)result=true;
		Stack<Character> stack = new Stack<>();
		for(int i = 0 ; i < input.length() ; i++) {
			if(input.charAt(i)=='[' || input.charAt(i)=='{' || input.charAt(i)=='(') {
				stack.push(input.charAt(i));
			}
			else if((input.charAt(i)==']' || input.charAt(i)=='}' || input.charAt(i)==')') && stack.size()==0) {
				result=false;
				break;
			}
			else if(input.charAt(i)==']') {
				Character out = stack.peek();
				if(out=='[') {
					result=true;
					stack.pop();
				}
				else {
					result=false;
					break;
				}				
			} else if(input.charAt(i)=='}') {
				Character out = stack.peek();
				if(out=='{')  {
					result=true;
					stack.pop();
				}
				else {
					result=false;
					break;
				}				
			} else if(input.charAt(i)==')') {
				Character out = stack.peek();
				if(out=='(') {
					result=true;
					stack.pop();
				}
				else {
					result=false;
					break;
				}
			}				
		}
		return result; 
	} 
	
	
	
	public static boolean isNumPallindrome(int input) {
		//12345->54321 or 123321->123321
		boolean result = false;
		int revNum = 0;
		int num = input;
		while(num>=1) {
			int rem = num%10;
			revNum = revNum*10 + rem;
			num = num/10;
		}
		if(revNum==input)
			result = true;
		return result;
	}
	
	public static int findMissingNumber(int[] input, int start, int end) {
		// 1-10 find 5
		int sum = (end-start+1)*(start+end)/2;
		int sumInput = 0;
		for(int i = 0; i < input.length ; i++) {
			sumInput = sumInput + input[i];
		} 
		return sum-sumInput;
	}
		
}
