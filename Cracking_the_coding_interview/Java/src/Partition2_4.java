import utils.LinkedListNode;

public class Partition2_4 {

	/**
	 *The method is stable because the order of items is consistent
	 *using 4 variables
	 *ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_04_Partition/Question.java
	 **/
	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	/**
	 * make 'new' list using existing nodes
	 * ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_04_Partition/QuestionB.java
	 **/
	
	public static LinkedListNode partition2(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;	
			} else {
				/* Insert node into front of after list */
				node.next = afterStart;
				afterStart = node;
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		LinkedListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}
	
	
	/**
	 * ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_04_Partition/QuestionC.java
	 **/
	public static LinkedListNode partition3(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node at head. */
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail. */
				tail.next = node;
				tail = node;
			}	
			node = next;
		}
		tail.next = null;
		
		return head;
	}
	
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {33,9,2,3,10,10389,838,874578,5};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		//33->9->2->3->10->10389->838->874578->5
		
		/* Partition */
		//LinkedListNode h = partition(head, 3);
		//2->33->9->3->10->10389->838->874578->5
		
		//LinkedListNode h = partition2(head, 3);
		//2->5->874578->838->10389->10->3->9->33

		LinkedListNode h = partition3(head,3);
		//2->33->9->3->10->10389->838->874578->5

		System.out.println(h.printForward());
}
}
