import java.util.Iterator;

/* A basic singly linked list implementation.
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
	//zero indexed, where 0 = first element in linked list for i
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		Node<E> current = head;
		if(i == 0) {
			this.removeFirst();
		}else if(i<this.size){
			for(int j =0;current.next != null &&j <(i-1);j++ ) {
				current = current.next;
			}
			Node<E> temp = current.next.next;
			current.next=temp;
			this.size--;
		}else {
			throw new IndexOutOfBoundsException("index to big");
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
		return head.value;
	}

	/**
	 * Returns the last node of the list
	 *
	 * @return last node of the list (or null if empty)
	 */
	public Node<E> getLast() {
		Node<E> current = head;
		while(current.next != null) {
			current=current.next;
		}
		if(current != null) {
			return current;
		}
		return null;
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 *
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		Node<E> current = head;
		while(current.next != null) {
			current=current.next;
		}
		if(current != null) {
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
		Node<E> current = head;
		Node<E> nodeToAdd = new Node<E>(e);
		while(current.next != null) {
			current=current.next;
		}
		current.next =nodeToAdd;
		this.size++;
	}

	/**
	 * Removes and returns the first element of the list.
	 *
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		Node<E> current = head;
		if(current.next != null) {
			head = current.next;
			this.size--;
		}else {
			head = null;
			this.size--;
		}

		return null;
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
		//ArrayList<String> all;
		//LinkedList<String> ll;
		/*SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());
        for (String s : sll) {
            System.out.print(s + ", ");
        }
		 */
		SinglyLinkedList <Integer> ll =new SinglyLinkedList <Integer>();
		ll.addFirst(6);
		ll.addFirst(5);
		ll.addFirst(4);
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(7);

		System.out.println(ll);
	}
}