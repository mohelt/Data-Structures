import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY=1000;
	
	private E[] data;
	
	private int t = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	@SuppressWarnings({"unchecked"})
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (t+1);
	}

	@Override
	public boolean isEmpty() {

		return (t == -1);
	}

	@Override
	public void push(E e) {
		if (size() == CAPACITY) {
			throw new RuntimeException("Cannot add stack full");
		}else {
			t++;
			data[t] = e;
		}
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return data[t];
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new RuntimeException("Cannot pop, stack empty");
		}
		else {
			E value = data[t];
			t--;
			return value;
		}
	}
	@Override
	public String toString() {
		int i =0;
		StringBuilder temporaryString = new StringBuilder();
		temporaryString.append("[");
		while(data[i] != null) {
			temporaryString.append(data[i]).append(", ");
			i++;
		}
		temporaryString.deleteCharAt(temporaryString.length() - 1);
		temporaryString.deleteCharAt(temporaryString.length() - 1);
		temporaryString.append("]");
		return temporaryString.toString();
	}

}
