import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedQueue<E> implements Queue<E> {
	
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public static void main(String[] args) {
		LinkedQueue<Integer> s = new LinkedQueue<>();
		for(int i = 0; i < 10; ++i) 
		{
			s.enqueue(i);
		}
		System.out.println( s.toString());
	
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E dequeue() {
		E e = list.first();
		list.removeFirst();
		return e;
	}
	@Override
	public String toString() {
		return list.toString();
	}

}
