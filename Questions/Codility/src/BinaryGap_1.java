/*
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).

Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * 
 * */





public class BinaryGap_1 {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	    int cand = 0;
	    int flag = 0;
	    int value = 0;
	    
	    public int solution(int N) {
	        // write your code in Java SE 8
	        String r = Integer.toBinaryString(N);
	        for (int i = 0, n = r.length(); i < n; i++) {
	            char c = r.charAt(i);
	            if (c == '1') {
	                flag = 1;
	                //don't add the value if the one located at the start
	                if (value == 0){
	                	continue;
	                
	                }else{
	                	flag = 0;
	                }
	            }
	            
	            if (flag == 1){
	                value += 1;
	                
	            }else{
	                if (cand < value){
	                    cand = value;
	                }
	                value = 0;
	                flag = 1;
	            }

	        }
	        return cand;
	        
	    }
	
	
	    public static void main(String args[]){
	        BinaryGap_1 s = new BinaryGap_1();
	        System.out.println(s.solution(66561));
	    }
	}

