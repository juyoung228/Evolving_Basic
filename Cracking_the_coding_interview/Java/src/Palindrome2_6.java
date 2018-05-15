
import utils.LinkedListNode;
import java.util.Stack;

public class Palindrome2_6 {

	/**
	 * the 1st solution: reverse the list and check 
	 * whether the reversed one is same with the original one.
	 **/
	
	static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}
	
	static LinkedListNode reverseAndClone(LinkedListNode node){
		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data); //copy
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}
	
	static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
	
	
	/**
	 * the 2nd solution: iterate the list by using 
	 * fast runner and slow runner with stack
	 * (assume that we don't know length of the list)
	 **/
	
	static boolean isPalindrome2(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack stack = new Stack();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
			/*Fast runner is faster as two times as
             *the slow runner is, so if the fast runner
             *reach the end of the list, it means that
             *the slow runner is located at the center of the list
			 */
		}
		
		/*if # of the list is odd, skip the central node*/
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = Integer.parseInt(stack.pop().toString());
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		//make each node 0 1 2 3 4 3 2 1 0
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		//connect the nodes back and forth
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		 //nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		//System.out.println(isPalindrome(head));
		System.out.println(isPalindrome2(head));

	}
}
