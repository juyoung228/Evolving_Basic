
public class StringRotation1_9 {
	/**
	 * ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_09_String_Rotation/Question.java
	 **/

	//O(m*n)
	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRotation(String s1, String s2) {
	    int len = s1.length();
	    /* check that s1 and s2 are equal length and not empty */
	    if (len == s2.length() && len > 0) { 
	    	/* concatenate s1 and s1 within new buffer */
	    	String s1s1 = s1 + s1;
	    	return isSubstring(s1s1, s2);
	    }
	    return false;
	}
	
	public static void main(String args[]) {
		//false
		System.out.println(isRotation("abcde", "ccdeab"));
		
		//true
		System.out.println(isRotation("abcde", "cdeab"));

	}
}
