
public class OneModify {

	
	public static boolean oneEditReplace(String s1, String s2){
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				//return flase when foundDifference turns twice
				if (foundDifference){
					return false;
				}
				
				foundDifference = true;
			}
		}
		return true;
	}
	
	/* Check if you can insert a character into s1 to make s2 */
	public static boolean oneEditInsert(String s1, String s2){
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if (index1 != index2) {
					return false;
				}
				index2++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	
	/**
	 * Make Edit, Insert = Deletion function separately
	 * O(N)
	 * ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_05_One_Away/QuestionA.java
	 **/
	
	public static boolean oneEdit_1(String first, String second){
		if(first.length() == second.length()){
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()){
			return oneEditInsert(first, second);
		} else if (first.length() -1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	
	/**
	 * Make Edit, Insert, Deletion function as one
	 * O(N)
	 * simpler and easy to edit and maintain (no duplication)
	 **/
	
	public static boolean oneEdit_2(String first, String second){
		/* Length Check */
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		/*Get shorter and longer string*/
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)){
				/*Ensure that this is the first difference found*/
				if (foundDifference) return false;
				foundDifference = true;
				//for replace, move shorter pointer to check the next one
				if(s1.length() == s2.length()){
					index1++;
				}
			} else {
				index1++;// If matching, move shorter pointer
			}
			index2++; // Always move pointer for longer string
		}
		return true;
	}
	
	public static void main(String[] args){
		String a = "pssse";
		String b = "pase";
		boolean result = oneEdit_1(a,b);
		System.out.println(result);
		
		boolean result_2 = oneEdit_2(a,b);
		System.out.println(result_2);
		
	}
}
