import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedStack<E> implements Stack<E> {
	
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	public static void main(String[] args) {
		LinkedStack<Integer> s = new LinkedStack<>();
		for(int i = 0; i < 10; ++i) {
			s.push(i);
		}
		System.out.println(s.size());
		System.out.println(s.toString());
		
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E pop() {
		return list.removeFirst();
				
	}
	
	public String toString()
	{
		return list.toString();
	}
}
