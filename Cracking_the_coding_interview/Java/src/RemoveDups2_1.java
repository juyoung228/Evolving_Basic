import java.util.HashSet;


public class RemoveDups2_1 {
	
	//ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_01_Remove_Dups/QuestionA.java
	public static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
}

	//ref: https://github.com/careercup/ctci/blob/master/java/CtCILibrary/CtCILibrary/LinkedListNode.java
	public static class LinkedListNode {
		public LinkedListNode next;
		public LinkedListNode prev;
		public LinkedListNode last;
		public int data;
		public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
			data = d;
			setNext(n);
			setPrevious(p);
		}
		
		public LinkedListNode() { }

		public void setNext(LinkedListNode n) {
			next = n;
			if (this == last) {
				last = n;
			}
			if (n != null && n.prev != this) {
				n.setPrevious(this);
			}
		}
		
		public void setPrevious(LinkedListNode p) {
			prev = p;
			if (p != null && p.next != this) {
				p.setNext(this);
			}
		}	
		
		public String printForward() {
			if (next != null) {
				return data + "->" + next.printForward();
			} else {
				return ((Integer) data).toString();
			}
		}
		
		public LinkedListNode clone() {
			LinkedListNode next2 = null;
			if (next != null) {
				next2 = next.clone();
			}
			LinkedListNode head2 = new LinkedListNode(data, next2, null);
			return head2;
	}
	}

	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
}
	
}
