
public class Rotation_2 {

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Solution {
	    public int[] solution(int[] A, int K) {
	        // write your code in Java SE 8
	        
	        //lengths are same each other 
	        int len = A.length;
	        if ( len == 0 || K/len == 0) {
	            return A;
	        }
	        
	        int[] result = new int[len];
	        
	        int[] temp = new int[len];
	        System.arraycopy(A , 0, temp, 0, len );


	        int ki = 0;
	        while (ki < K){
	            for (int i = 0; i < len; i++) {
	                result[i] = temp[(len-1+i)/len];
	            }
	            
	            ki ++;
	            System.arraycopy(result , 0, temp, 0, len );

	        }
	        return result;
	    
	    }
	}
	
	
}
