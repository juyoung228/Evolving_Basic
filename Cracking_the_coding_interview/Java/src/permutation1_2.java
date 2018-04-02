
public class permutation1_2 {

	public static String sort(String s)
	{
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
		
	}
	
	//ref: the book
	public static boolean checkPerm_1(String s, String t)
	{
		if (s.length() != t.length()){
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	
	//ref: the book
	public static boolean checkPerm_2(String s, String t)
	{
		if (s.length() != t.length()){
			return false;
		}
		
		int[] letters = new int[128]; //assume ASCII
		
		char[] s_array = s.toCharArray();
		for (char c: s_array) {
			letters[c]++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0)
			{
				return false;
			}
			
		}return true;
	} 
	
	
	public static void main(String args[])
	{
		System.out.println(checkPerm_1("dog", "cod"));
		System.out.println(checkPerm_2("dog", "god"));
	}
}
