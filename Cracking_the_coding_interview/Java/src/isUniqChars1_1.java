
public class isUniqChars1_1 {
	
	/*참고
	 * 비트연산 (Shift): http://egloos.zum.com/js7309/v/11128720
	 * 비트 마스크: http://oniondev.egloos.com/9839582
	 * */
	
	/*
	 * O(n), O(1)
	 * Assume that there are 128 characters.
	 * Reference: The book
	 * */
	boolean isUniqueChars(String str)
	{
		if (str.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);
			if (char_set[val])
			{
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	/*
	 * O(n), O(1/8)
	 * Use bitwise
	 * Reference: The book
	 * */
	static boolean isUniqueChars2(String str)
	{
		int checker = 0;
		for (int i = 0; i<str.length(); i++)
		{
			int val  = str.charAt(i) - 'a';
			//System.out.println(val);
			//System.out.println("***"+ (int)str.charAt(i));
			//System.out.println(1 << val);
			//정확한 계산 값을 가지고 체크하는 게 아니라, Hashmap처럼 일정 주소를 부여하는 것 
			if((checker & (1 << val)) > 0)
			{
				return false;
			}
			//a = a | (1	 << n)
			checker |= (1 << val);
		}
		return true;
	}
	
	
	public static void main(String args[])
	{
		System.out.println(isUniqueChars2("dlakjslk"));
	}

}
