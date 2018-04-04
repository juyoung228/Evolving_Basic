//ref: https://opentutorials.org/module/1335/8857#entirecode

public class LinkedList {

	//the 1st node
	private Node head;
	//the last node
	private Node tail;
	//the tail and size reduce time of calculation
	//(find the last node or count the # of nodes)
	private int size = 0;

	private class Node{
		//the value will be stored here
		private Object data;
		//the next node
		private Node next;
		public Node(Object input)
		{
			this.data = input;
			this.next = null;
		
		}
	
		/**
		 * print content
		 **/
		public String toString(){
			return String.valueOf(this.data);
		}
	}
		/**
		 * add node at front
		 **/
		public void addFirst(Object input){
			//make a node
			Node newNode = new Node(input);
			//set head as the next node of 'newNode'
			newNode.next = head;
			//set Newnode as head
			head = newNode;
			size ++;
			if(head.next == null){
				tail = head;
			}
		}
		
		/**
		 * add node at the last
		 **/
		public void addLast(Object input){
			//make a node
			Node newNode = new Node(input);
			//if there is no node, use addFirst method
			if(size == 0){
				addFirst(input);
			}else {
				//set the newNode as the next node of the last node
				tail.next = newNode;
				//set the newNode as a tail
				tail = newNode;
				size++;
			}
		}
		
		/**
		 * internal API
		 * used to find the node at certain index 
		 **/
		
		Node node(int index){			
			Node x = head;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		}
		
		
		public void add(int k, Object input){
			if(k == 0){
				addFirst(input);
			}else{
				Node temp1 = node(k-1);
				Node temp2 = temp1.next;
				Node newNode = new Node(input);
				temp1.next = newNode;
				newNode.next = temp2;
				size++;
				
				//if there is no next node of the new node,set the new node as a tail
				if(newNode.next == null){
					tail = newNode;
				}
			}
		}
		
		public String toString(){
			
			//if there is no node, return []
			if(head == null){
				return "[]";
			}
			
			Node temp = head;
			String str = "[";
			
			while(temp.next != null){
				str += temp.data + ",";
				temp = temp.next;
			}
			
			str += temp.data;
			return str+"]";
		}
		
		public Object removeFirst (){
			Node temp = head;
			head = temp.next;
			Object returnData = temp.data;
			temp = null;
			size--;
			return returnData;
		}
		
		public Object remove(int k){
			if(k == 0)
				return removeFirst();
			
			Node temp = node(k-1);
			//set deleted node to todoDelete
			//if you delete the node now, you cannot connect back & front nodes
			Node todoDeleted = temp.next;
			temp.next = temp.next.next;
			Object returnData = todoDeleted.data;
			if(todoDeleted == tail){
				tail = temp;
			}
			
			//delete cur.next
			todoDeleted = null;
			size --;
			return returnData;
		}
		
		public Object removeLast() {
			return remove(size-1);
		}
		
		public int size() {
			return size;
		}
		
		public Object get(int k) {
			Node temp = node(k);
			return temp.data;
		}
		
		
		public int indexOf(Object data){
			Node temp = head;
			int index = 0;
			while(temp.data != data){
				temp = temp.next;
				index ++;
				
				//there is no more search candidates
				if(temp == null)
					return -1;
			}
			return index;
		}
		
		/**
		 *기본적인 반복작업은 다음과 같다
		 *for(int i=0; i<numbers.size(); i++){
         *    System.out.println(numbers.get(i));
         * }
         *하지만 linked list에서는 이것은 바람직하지 않은 방법입니다. 
         *왜냐하면 ArrayList와 다르게 LinkedList에서 get은 효율적이지 않기 때문입니다. 
         *get을 호출할 때마다 내부적으로는 반복문이 실행됩니다. 
         *이런 경우 Iterator를 사용하는 것이 유리합니다. 
         *Iterator는 내부적으로 반복 처리된 노드가 무엇인지에 대한 정보를 유지하기 때문입니다.
         *아래의 listIterator() 함수는 반복자를 생성해서 리턴해줍니다.
		 **/
		public ListIterator listIterator() {
			return new ListIterator();
		}
		
		public class ListIterator {
			private Node lastReturned;
			private Node next;
			private int nextIndex;
			
			ListIterator(){
				next = head;
				nextIndex = 0;
			}
			
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		
		public boolean hasNext(){
			return nextIndex < size();
		}
		
		/**
		 *  Iterator add
		 **/
		public void add(Object input){
		
			Node newNode = new Node(input);
			if(lastReturned == null){
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			lastReturned = newNode;
			nextIndex++;
			size++;
			
			}
		
		public void remove() {
			if(nextIndex == 0){
				throw new IllegalStateException();
			}
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
		}
		
	}


