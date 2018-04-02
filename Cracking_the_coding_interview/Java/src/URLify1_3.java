
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
		//https://stackoverflow.com/questions/26558741/what-does-strnewlength-0-mean
		if (trueLength <str.length) str[trueLength] = '\0';
		for (i = trueLength -1; i >=0; i--)
		{
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index -3;
			}else{
				str[index -1] = str[i];
				index--;
			}
		}
		
		System.out.println(str);
	}

	
	public static void main(String args[])
	{
		// Assume string has sufficient free space at the end
		replaceSpaces("Mr John Smith    ".toCharArray(), 13);
	}
}
