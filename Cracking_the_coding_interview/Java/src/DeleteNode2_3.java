import utils.LinkedListNode;


public class DeleteNode2_3 {

	//ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_03_Delete_Middle_Node/Question.java
	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}
	
	public static void main(String args[]){
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteNode(head.next.next); //delete 2
		System.out.println(head.printForward());

	}
}
