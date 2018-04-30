
public class Stack {
	
	/**
	 * ref: https://www.youtube.com/watch?v=wjI1WNcIntg
	 **/
	
	
	private static class Node {
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
		//private constructor
		//why? see the following link.
		//http://www.juyan.kr/w/index.php/Java
	}
	
	private Node top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		return top.data;
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	public int pop(){
		int data = top.data;
		top = top.next; 
		return data;
	}

}
