
public class Main {

	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addLast(10);
		numbers.addLast(30);
		System.out.println(numbers.node(1));
		System.out.println(numbers);
		
		
		LinkedList.ListIterator li = numbers.listIterator();
		while(li.hasNext()){
			/**
			 *next()가 한 번도 안 돈다는 것은 맨 앞에 node를 추가한다는 것.
			 *ListIterator.add function에서는 lastReturned==null로 표시된다.
			 **/
			if((int)li.next() == 10)
				li.add(20);
			//System.out.println(li.next());
		}
		
	System.out.println(numbers);
		
	}
}
