import java.util.Iterator;


public class DoublyLinkedList<E> implements List<E> {
	/** Sentinel node at the beginning of the list */
	private Node<E> header;                    // header sentinel

	/** Sentinel node at the end of the list */
	private Node<E> trailer;                   // trailer sentinel

	/** Number of elements in the list (not including sentinels) */
	private int size = 0; 
	//---------------- nested Node class ----------------
	/**
	 * Node of a doubly linked list, which stores a reference to its
	 * element and to both the previous and next node in the list.
	 */

	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> previous; 

		public Node(E data, Node<E> previous,Node<E> next)
		{
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
		public E getData()
		{
			return data;
		}

		public Node<E> getNext()
		{
			return next;
		}
		public Node<E> getPrevious()
		{
			return previous;
		}

		public void setNext(Node<E> n)
		{
			next = n;
		}
		public void setPrevious(Node<E> p)
		{
			previous = p;
		}
		public void setData(E d)
		{
			data = d;
		}
	} //----------- end of nested Node class -----------

	// instance variables of the DoublyLinkedList
	// number of elements in the list

	/** Constructs a new empty list. */
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	// public accessor methods
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
		if((i>size()-1) || isEmpty()) {
			throw new IndexOutOfBoundsException("It is not possible to get this indexed value");
		}
		Node<E> current = header.getNext();
		for(int j=0;j<i && current != trailer;j++) {
			current = current.getNext();
		}
		return current.getData();
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		Node<E> current = header.getNext();
		if (isEmpty() || i > size()-1)
		{
			throw new RuntimeException("cannot delete either index too big or list is empty");
		}
		for(int j =0; j<i;j++) {
			current = current.getNext();
		}
		current.setData(e);
		return current.getData();
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0|| i > size()-1)
		{
			throw new RuntimeException("cannot delete either index too big or list is empty");
		}
		else {
			Node<E> current = header.getNext();
			for(int j = 0; j< i;j++) {
				current = current.getNext();	
			}
			addBetween(e,current.getPrevious(),current);
		}
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if (isEmpty() || i > size()-1)
		{
			throw new RuntimeException("cannot delete either index too big or list is empty");
		}
		Node<E> current = header.getNext();
		Node<E> previous = header;

		//find the correct node to remove
		for (int k = 0; k < i; k++)
		{
			previous = current;
			current = current.getNext();
		}
		Node<E> next =current.getNext();
				previous.setNext(next);
		next.setPrevious(previous);
		size--;
		return current.getData();

	}

	@Override
	public Iterator<E> iterator() {
		return new DoublyLinkedListIterator();
	}
	private class DoublyLinkedListIterator implements Iterator<E> {
		private Node<E> current;
		public DoublyLinkedListIterator() {
			current = header.getNext();
		}
		@Override
		public boolean hasNext() {
			return ((current != null) && (current != trailer));
		}

		@Override
		public E next() {
			if(!hasNext()) throw new RuntimeException("No such element");

			E res = current.getData();
			current = current.getNext();
			return res;
		}
	}
	/**
	 * Returns (but does not remove) the first element of the list.
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		// TODO
		return header.getNext().getData();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		// TODO
		return trailer.getPrevious().getData();
	}

	// public update methods
	/**
	 * Adds an element to the front of the list.
	 * @param e   the new element to add
	 */
	public void addFirst(E e) {
		addBetween(e,header,header.getNext());
	}

	/**
	 * Adds an element to the end of the list.
	 * @param e   the new element to add
	 */
	public void addLast(E e) {
		addBetween(e,trailer.getPrevious(),trailer);
	}

	/**
	 * Removes and returns the first element of the list.
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		Node<E> current = header.getNext();
		remove(0);
		return current.getData();
	}

	/**
	 * Removes and returns the last element of the list.
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() {
		return remove((this.size()-1));
	}

	// private update methods
	/**
	 * Adds an element to the linked list in between the given nodes.
	 * The given predecessor and successor should be neighboring each
	 * other prior to the call.
	 *
	 * @param predecessor   node just before the location where the new element is inserted
	 * @param successor     node just after the location where the new element is inserted
	 */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node(e,predecessor,successor);
		predecessor.setNext(newNode);
		successor.setPrevious(newNode);
		this.size++;
	}

	/**
	 * Removes the given node from the list and returns its element.
	 * @param node    the node to be removed (must not be a sentinel)
	 */

	/**
	 * Produces a string representation of the contents of the list.
	 * This exists for debugging purposes only.
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");

		Node<E> current = header.getNext();
		while (current.getNext() != null && current != null)
		{
			stringBuilder.append(current.getData());
			stringBuilder.append(", ");
			current = current.getNext();
		}

		stringBuilder.replace(stringBuilder.length()-2, stringBuilder.length(), "");
		stringBuilder.append("]");

		return stringBuilder.toString();
	}

	public static void main(String [] args) {
		//ArrayList<String> all;
		//LinkedList<String> ll;
		DoublyLinkedList<String> ll = new DoublyLinkedList<String>();

		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		for (String s : alphabet) {
			ll.addFirst(s);
			ll.addLast(s);
		}
		System.out.println(ll.toString());

		for (String s : ll) {
			System.out.print(s + ", ");
		}
	}
} //----------- end of DoublyLinkedList class -----------