public class LinkedDeque<E> implements Deque<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	public E first() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return list.last();
	}

	@Override
	public void addFirst(E e) {
		list.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		list.addLast(e);
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return list.removeLast();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return list.toString();
	}

}
