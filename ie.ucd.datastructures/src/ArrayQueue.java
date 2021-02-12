public class ArrayQueue<E> implements Queue<E> {
	public static final int CAPACITY=1000;

	private E data[];      // array to store queue elements
	private int front;      // front points to the front element in the queue
	private int rear;       // rear points to the last element in the queue
	private int capacity;   // maximum capacity of the queue
	private int count;      // current size of the queue

	public ArrayQueue() {
		this(CAPACITY);
		capacity = CAPACITY;
		front = 0;
		rear = -1;
		count = 0;
	}
	@SuppressWarnings({"unchecked"})
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}
	public static void main(String[] args) {
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty()
	{
		return (size() == 0);
	}
	public boolean isFull()
	{
		return (size() == capacity);
	}
	@Override
	public void enqueue(E e) {
		if (isFull())
		{
		}
		rear = (rear + 1) % capacity;
		data[rear] = e;
		count++;
	}

	@Override
	public E first() {
		if (isEmpty())
		{
			return null;
		}
		return data[front];
	}

	@Override
	public E dequeue() {
		if (isEmpty())
		{
			System.out.println("Program Terminated underflow");
			System.exit(1);
		}
		E e = data[front];
		front = (front + 1) % capacity;
		count--;
		return e;
	}

	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");

		for (int i = (front % CAPACITY); i <= rear; i++)
		{
			stringBuilder.append(data[i] + ", ");
		}

		stringBuilder.replace(stringBuilder.length()-2, stringBuilder.length(), "");
		stringBuilder.append("]");

		return stringBuilder.toString();
	}
}
