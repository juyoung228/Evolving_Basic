
public class URLify1_3 {
	
	static void replaceSpaces(char[] str, int trueLength)
	{
		int spaceCount = 0, index, i = 0;
		for (i = 0; i <trueLength; i++){
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		
		index = trueLength + spaceCount * 2;
		char[] str_new = new char[index];
		//https://stackoverflow.com/questions/26558741/what-does-strnewlength-0-mean
		if (trueLength <str.length) str[trueLength] = '\0';
		for (i = trueLength -1; i >=0; i--)
		{
			if (str[i] == ' ') {
				str_new[index - 1] = '0';
				str_new[index - 2] = '2';
				str_new[index - 3] = '%';
				index = index -3;
			}else{
				str_new[index -1] = str[i];
				index--;
			}
		}
		
		System.out.println(str_new);
	}

	
	public static void main(String args[])
	{
		replaceSpaces("Mr John Smith".toCharArray(), 13);
	}
}
