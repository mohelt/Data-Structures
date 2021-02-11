import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {
    //---------------- nested Node class ----------------
    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {
        private E data;
		
		private Node<E> next;
		
		public Node(E d, Node<E> next)
		{
			this.data = d;
			this.next = next;
		}
		
		
		
		public Node<E> getNext()
		{
			return next;
		}
		public E getData()
		{
			return data;
		}
		
		public void setNext(Node<E> n)
		{
			next = n;
		}
		public void setData(E d)
		{
			data = d;
		}
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /** The designated cursor of the list */
    private Node<E> tail = null;                  // we store tail (but not head)

    /** Number of nodes in the list */
    private int size = 0;                         // number of nodes in the list

    /** Constructs an initially empty list. */
    public CircularlyLinkedList() { }             // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
    	if ( (i > size-1) || tail == null)
		{
			throw new RuntimeException("it is not possible to get this node");
		}
    	Node<E> current = tail.getNext();
    	//start at the first element and iterate through until ith element
    			for (int j = 0; j < i; j++)
    			{
    				current = current.getNext();
    			}
    			
    			return current.getData();
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
    	if ( (i > size-1) || tail == null)
		{
			throw new RuntimeException("it is not possible to set at this node");
		}
    	Node<E> current = tail.getNext();
    	//start at the first element and iterate through until ith element
    			for (int j = 0; j < i; j++)
    			{
    				current = current.getNext();
    			}
    			current.setData(e);
    			return current.getData();
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
    	if ( (i > size-1) || tail == null)
		{
			throw new RuntimeException("it is not possible to add at this node");
		}
    	Node<E> current = tail.getNext();
		Node<E> previous = null;
		for (int j = 0; j < i; j++)
		{
			previous = current;
			current = current.getNext();
		}
		Node<E> newNode = new Node<E>(e, current);
		previous.setNext(newNode);
		this.size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
    	if ( (i > size-1) || tail == null)
		{
			throw new RuntimeException("it is not possible to remove at this node");
		}
    	Node<E> current = tail.getNext();
		Node<E> previous = null;
		for (int j = 0; j < i; j++)
		{
			previous = current;
			current = current.getNext();
		}
		if (current == null)
		{
			throw new RuntimeException("its not possible to delete add this node");
		}
		E e = current.getData();
		previous.setNext(current.getNext());
		this.size--;
		return e;
		
    }
    private class CircularlyLinkedListIterator implements Iterator<E>
	{
    	Node<E> current;
		
		@Override
		public boolean hasNext() {
			current = tail.getNext();
				return current != null;
		}

		@Override
		public E next() {
			if(!hasNext()) throw new RuntimeException("No such element");

			E res = current.getData();
			current = current.getNext();
			return res;
		}
    	
	}
    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator();
        
    }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
    	if (this.isEmpty())
		{
			return null;
		}

		else {
			return tail.getNext().getData();
		}
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
    	return tail.getData();
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
    	tail = tail.getNext();
    }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
       Node<E> newNode = new Node<E>(e, null);
		
		if (tail == null)
		{
			tail = newNode;
			tail.setNext(tail);
		}else {
       Node<E> current= tail;
			
		for (int j = 0; j < size-1; j++)
			{
				current = current.getNext();
			}
			current.setNext(newNode);
			newNode.setNext(tail);
		}
		this.size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
    	if (tail == null)
		{
			Node<E> newNode = new Node<E>(e, null);
			tail = newNode;
			tail.setNext(tail);
		}
		
		else
		{
			Node<E> newNode = new Node<E>(e, null);
			
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
			tail = newNode;
		}
		this.size++;
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
    	if (size == 0)
		{
			throw new RuntimeException("cant remove the specified node");
		}
		
		if (size == 1)
		{
			E e = tail.getData();
			tail = null;
			size--;
			return e;
		}
		
		else
		{
			E e = tail.getNext().getData();
			//skip pointer over first element
			tail.setNext(tail.getNext().getNext());
			size--;
			return e;
		}
    }
    public E removeLast() {
		if (size == 0)
		{
			throw new RuntimeException("cant remove element at this node");
		}
		
		if (size == 1)
		{
			E e = tail.getData();
			tail = null;
			this.size--;
			return e;
		}
		
		else
		{
			Node<E> finder = tail;
		
			//need to find node to reconnect to new tail
			while (finder.getNext() != tail)
			{
				finder = finder.getNext();
			}
			E e = tail.getData();
			finder.setNext(tail.getNext());
			tail = finder;
			this.size--;
			return e;
		}
	}
    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("[");

		Node<E> current = tail.getNext();

		do
		{
			stringBuilder.append(current.getData());
			stringBuilder.append(", ");
			current = current.getNext();
		} while (current != tail.getNext());

		stringBuilder.replace(stringBuilder.length()-2, stringBuilder.length(), "");
		stringBuilder.append("]");

		return stringBuilder.toString();
    }


    public static void main(String [] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
        CircularlyLinkedList<String> ll = new CircularlyLinkedList<>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            ll.addFirst(s);
            ll.addLast(s);
        }
        System.out.println(ll.toString());

        ll.rotate();
        ll.rotate();

        System.out.println(ll.toString());
    }
}
