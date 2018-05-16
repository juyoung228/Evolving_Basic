
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

