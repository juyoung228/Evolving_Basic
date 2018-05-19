
// time complexity: O(N) or O(N*log(N))
	import java.util.HashMap;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Iterator;

public class OddOccurrences_2 {

	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i < A.length; i++){
	            int val = A[i];
	            if (map.containsKey(val)) {
	             map.remove(val);
	            }else{
	             map.put(val, i);
	            }
	        }
	        Iterator<Integer> iterator = map.keySet().iterator();
	        
	        int key = iterator.next();
	        
	        
	        return key;
	        
	    }
}

