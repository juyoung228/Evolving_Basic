import utils.LinkedListNode;

public class PrintingLast2_2 {
	
	/**
	 * use recursive, Space complexity O(N)
	 * print the last kth item instead of return
	 * ref: https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2002.%20Linked%20Lists/Q2_02_Return_Kth_To_Last/QuestionA.java
	 **/

	public static int printKthToLast_1(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast_1(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}
	
	/**
	 * use recursive, Space complexity O(N)
	 * mimic delivery of a value by wrapping the value of counter
	 * ref:https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_02_Return_Kth_To_Last/QuestionC.java
	 **/
	
	public static class Index {
		public int value = 0;
	}
	
	//overloading because in java, 2 return values doesn't exist.
	public static LinkedListNode kthToLast_2(LinkedListNode head, int k) {
		Index idx = new Index();
		return kthToLast_2(head, k, idx);
	}
	
	public static LinkedListNode kthToLast_2(LinkedListNode head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = kthToLast_2(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		} 
		return node;
	}
	
	
	/**
	 * iterative way 
	 * Time:O(N), Space: O(1)
	 **/
	public static LinkedListNode kthToLast_3(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		/* Move p1 k nodes into the list.*/
		for (int i = 0; i < k; i++) {
			if (p1 == null) return null; // Out of bounds
			p1 = p1.next;
		}
		
		/* Move them at the same pace. When p1 hits the end, 
		 * p2 will be at the right element. */
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
	  	}
	  	return p2;
}
	
	/**
	 * The code to create LinkedLIst from array
	 * ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/CtCILibrary/CtCILibrary/AssortedMethods.java
	 **/
	
	public static LinkedListNode createLinkedListFromArray(int[] vals) {
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		return head;
		
}
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			printKthToLast_1(head, i);
		}

		System.out.println("====================================");
		
		LinkedListNode head2 = createLinkedListFromArray(array);
		for (int i = 1; i <= array.length; i++) {
			LinkedListNode node = kthToLast_2(head2, i);
			String nodeValue = ""+ node.data;
			System.out.println(i + "th to last node is " + nodeValue);
		}
		
		System.out.println("====================================");
		LinkedListNode head3 = createLinkedListFromArray(array);
		for (int i = 1; i <= array.length; i++) {
			LinkedListNode node = kthToLast_2(head3, i);
			String nodeValue = ""+ node.data;
			System.out.println(i + "th to last node is " + nodeValue);
		}
		
}
}
