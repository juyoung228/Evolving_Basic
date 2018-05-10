import utils.LinkedListNode;

public class Sum2_5 {

	//ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_05_Sum_Lists/QuestionA.java
	private static LinkedListNode addLists_1(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
             return null;
		}
		
		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists_1(l1 == null ? null : l1.next, 
										   l2 == null ? null : l2.next, 
										   value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		
		/*
		 *  ternary operation of JAVA
		      result = a > b ? x : y;
		      
		      if (a > b) {
       				result = x;
   				} else {
       				result = y;
   				}
		 */
		
		return result;
	}
	

	public static int linkedListToInt_1(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			
			value = 10 * linkedListToInt_1(node.next);
		}
		return value + node.data;
	}	
	
	
	
	
	//Wrapper to return sum and carry in recursive method
	public static class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}
	
	private static int length(LinkedListNode l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}
	
	
	private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}
	
	private static LinkedListNode addLists_2(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		
		//add '0' at the shorter list
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		PartialSum sum = addListsHelper(l1, l2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}	
	
	private static LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	private static LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}
	
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}	
	
	
	public static void main(String[] args) {
		
		
		//test code for addLists_1
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);
		
		LinkedListNode list3 = addLists_1(lA1, lB1, 0);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt_1(lA1);
		int l2 = linkedListToInt_1(lB1);
		int l3 = linkedListToInt_1(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));	
		
		
		
		System.out.println("\n===================================");
		
		//test code for addLIsts_2
		//assume that the liknedlist is sorted in not reversed way
		
		
		LinkedListNode l2A1 = new LinkedListNode(9, null, null);
		LinkedListNode l2A2 = new LinkedListNode(9, null, l2A1);
		LinkedListNode l2A3 = new LinkedListNode(9, null, l2A2);
		
		LinkedListNode l2B1 = new LinkedListNode(1, null, null);	
		
		LinkedListNode list3_2 = addLists_2(l2A1, l2B1);
		
		System.out.println("  " + l2A1.printForward());		
		System.out.println("+ " + l2B1.printForward());			
		System.out.println("= " + list3_2.printForward());	
		
		int l21 = linkedListToInt(l2A1);
		int l22 = linkedListToInt(l2B1);
		int l23 = linkedListToInt(list3_2);
		
		System.out.print(l21 + " + " + l22 + " = " + l23 + "\n");
		System.out.print(l21 + " + " + l22 + " = " + (l21 + l22));		
	}

}
