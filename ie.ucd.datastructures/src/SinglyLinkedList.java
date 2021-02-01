import java.util.Iterator;

/**
 * A basic singly linked list implementation.
 */
public class SinglyLinkedList<E> implements Cloneable, Iterable<E>, List<E> {
	//---------------- nested Node class ----------------

	/**
	 * Node of a singly linked list, which stores a reference to its
	 * element and to the subsequent node in the list (or null if this
	 * is the last node).
	 */
	private static class Node<E> {
		E value;
		Node<E> next;
		public Node(E e) 
		{ 
			value = e; 
			next = null; 
		} 
	}

	//----------- end of nested Node class -----------

	// instance variables of the SinglyLinkedList
	private Node<E> head = null; // head node of the list (or null if empty)

	private int size = 0; // number of nodes in the list

	public SinglyLinkedList() {
	}              // constructs an initially empty list

	// access methods

	/**
	 * Returns the number of elements in the linked list.
	 *
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 *
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		Node<E> a = head;
		if(i<=this.size()) {
			int count = 0;
			while(count < i) {
				count ++;
				a = a.next;
			}
			return a.value;
		}

		return null;
	}

	@Override
	//i has to be zero indexed
	public E set(int i, E e) throws IndexOutOfBoundsException {
		Node<E> current = head;
		for(int j=0; current != null && j <= (i-1);j++) {
			current = current.next;
		}
		current.value = e;
		return current.value;
	}
	//zero indexed, where 0 = first element in linked list
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		Node<E> current = head;
		Node<E> setNode = new Node<E>(e);
		if(i==0) {
			this.addFirst(e);
		}
		else {
			for(int j=0; current != null && j < (i-1);j++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = setNode;
			setNode.next = temp;
			this.size++;
		}
	}
	//zero indexed, if you want to remove the first element , i must be 0;
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		Node<E> previous = head;
		int j =0;
		if(i == 0) {
			head = head.next;
			this.size--;
		}else if (i<this.size) {
			for(j=0;previous != null && j<(i-1);j++) {
				previous = previous.next;
			}
			Node<E> temp = previous.next.next;
			previous.next = temp;
			this.size--;
		}else if(i == (this.size-1)) {
			for(j=0;previous != null && j<(i-1);j++) {
				previous = previous.next;
			}
			previous.next = null;
			this.size--;
		}else if(i>(this.size-1)) {
			throw new  IndexOutOfBoundsException("Index to big,/ zero indexed");
		}
		return null;

	}

	/**
	 * Returns (but does not remove) the first element of the list
	 *
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		// TODO
		if(head != null) {
			return head.value;
		}
		return null;
	}

	/**
	 * Returns the last node of the list
	 *
	 * @return last node of the list (or null if empty)
	 */
	public Node<E> getLast() {
		Node<E> current= head;
		while(current.next != null) {
			current = current.next;
		}
		return current;
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 *
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		Node<E> current= head;
		if(current != null) {
			while(current.next != null) {
				current = current.next;
			}
			return current.value;
		}
		return null;
	}

	// update methods

	/**
	 * Adds an element to the front of the list.
	 *
	 * @param e the new element to add
	 */
	public void addFirst(E e) {
		Node<E> first = new Node<>(e);
		first.next = this.head;
		this.head = first;
		this.size++;
	}

	/**
	 * Adds an element to the end of the list.
	 *
	 * @param e the new element to add
	 */
	public void addLast(E e) {
		Node<E> current= head;
		Node<E> addedNode= new Node<E>(e);
			while(current.next != null) {
				current = current.next;
			}
			current.next = addedNode;
			this.size++;
	}

	/**
	 * Removes and returns the first element of the list.
	 *
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		head = head.next;
		this.size--;
		return head.value;
	}

	@SuppressWarnings({"unchecked"})
	public boolean equals(Object o) {
		// TODO
		return false;   // if we reach this, everything matched successfully
	}

	@SuppressWarnings({"unchecked"})
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		// TODO
		return null;
	}


	/**
	 * Produces a string representation of the contents of the list.
	 * This exists for debugging purposes only.
	 * @return 
	 */
	public String toString() {
		for(int i=0;i<this.size();i++) {
			System.out.println(this.get(i));
		}
		return "end of Linked List";
	}

	private class SinglyLinkedListIterator<E> implements Iterator<E> {
		@Override
		public boolean hasNext() {
			// TODO
			return false;
		}

		@Override
		public E next() {
			// TODO
			return null;
		}
	}

	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator<E>();
	}

	public static void main(String[] args) {
	}
}
