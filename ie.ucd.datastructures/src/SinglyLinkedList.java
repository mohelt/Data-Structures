import static org.junit.jupiter.api.Assertions.assertEquals;

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
		private E data;  // reference to the element stored at this node

		private Node<E> nextNode; 


		//methods for accessing variables

		public Node<E> getNextNode() { return nextNode; }

		public E getData() { return data; }

		// Modifier methods
		public void setNext(Node<E> n) { nextNode = n; }
		public void setData(E n) { data = n; }
		public Node(E e, Node<E> n) {
			nextNode = n;
			data = e;
		}

		// reference to the subsequent node in the list// TODO
	} //----------- end of nested Node class -----------

	// instance variables of the SinglyLinkedList
	private int size = 0; // number of nodes in the list
	private Node<E> head = null; // head node of the list (or null if empty)

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
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if (isEmpty()) { // if list is empty
			throw new RuntimeException("The specified index does not exist");
		}

		if (i == 0) { // if element chosen is sopposed to be the head
		}

		Node<E> current = head;

		int count = 0;
		while (current.getNextNode() != null && count != i) { // go through the linkedlist until correct index element is chosen
			current = current.nextNode;
			count++;
		}

		if(count == i) { // returns the element in the correct index
			return current.getData();
		} else {
			throw new RuntimeException("the index you have chosen does not exist");
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}

	//zero indexed i.e i = 0 is the first element
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		Node<E> current = head;
		if(size == 0) {
			throw new RuntimeException("index doesn't exist");
		}
		if(size< i) {
			throw new RuntimeException("index doesn't exist");
		}
		for(int j =0; j<i;j++) {
			current =current.nextNode;
		}
		current.setData(e);
		return current.getData();
	}


	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		Node<E> deletedNode = head; // this is the element that will come back

		if (isEmpty()){
			throw new RuntimeException("cannot delete the element in question");
		}

		if (i == 0) { // if the element to be deleted is the head
			head = head.nextNode;
			size--;
			return deletedNode.data;
		}

		Node<E> current = head;
		Node<E> prev = null;

		int count = 0;
		while (current != null && count != i) { // walk through the linked list until the correct index is found from the list
			prev = current;
			current = current.nextNode;
			count++;
		}

		if (current == null) {
			throw new RuntimeException("cannot delete the element in question");
		}

		deletedNode = current;
		// delete the current node 
		prev.nextNode = current.nextNode;
		size--;

		return deletedNode.data;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		Node<E> newNode = new Node<E>(e, null);

		if (isEmpty() && i != 0) { //if the list is empty and index is not head element
			throw new RuntimeException("Index does not exist");
		}

		if (i == 0) { // if element is the head element
			addFirst(e);
		}

		Node<E> current = head;
		Node<E> prev = null;

		int count = 0;
		while (current != null && count != i) { //until correct index is found and chosen, walk walk through the list 
			prev = current;
			current = current.nextNode;
			count++;
		}

		if(count == i && current == null) { // if the item chosen index is the last element
			addLast(e);
		} else if (current == null && count < i){ // if index is tooo large
			throw new RuntimeException("Index does not exist");
		} else if (current != null) { // inserting the new element
			prev.nextNode = newNode;
			newNode.nextNode = current;
			size++;
		}
	}


	public E removeLast() {
		Node<E> current = head;
		if(current ==null) {
			head = null;
			return null;
		}
		while(current.nextNode.nextNode != null) {
			current = current.nextNode;
		}
		E value=current.nextNode.data;
		current.nextNode =null;
		size--;
		return value;

	}
	/**
	 * Returns (but does not remove) the first element of the list
	 *
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		if(isEmpty()) {
			return null;
		} else {
			return get(0);
		}
	}

	/**
	 * Returns the last node of the list
	 *
	 * @return last node of the list (or null if empty)
	 */
	public Node<E> getLast() {
		Node<E> current = head;
		if(isEmpty()) {
			return null;
		} else {
			while(current.getNextNode() != null) {
				current = current.nextNode;
			}

		}
		return current;
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 *
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		if(isEmpty()) {
			return null;
		} else {
			return this.getLast().getData();
		}
	}


	/**
	 * Adds an element to the front of the list.
	 *
	 * @param e the new element to add
	 */
	public void addFirst(E e) {
		head = new Node<E>(e, head); // create the new node and link new node
		size++;
	}

	/**
	 * Adds an element to the end of the list.
	 *
	 * @param e the new element to add
	 */
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null); // node will become the tail element
		Node<E> last = head;
		if(last == null) {
			head = newest;
			size++;
		} else {
			while (last.getNextNode() != null) {
				last = last.nextNode;
			}
			last.setNext(newest); 
			size++;
		}
	}

	/**
	 * Removes and returns the first element of the list.
	 *
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		Node<E> deleted = head; 

		if (isEmpty()){
			throw new RuntimeException("cannot delete the element in question");
		} else {
			head = head.nextNode; 
			size--;
		}
		return deleted.data;
	}

	@SuppressWarnings({"unchecked"})
	public boolean equals(Object o) {
		// TODO
		return false;   
	}

	@SuppressWarnings({"unchecked"})
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		// TODO
		return null;
	}


	/**
	 * Produces a string representation of the contents of the list.
	 * This exists for debugging purposes only.
	 */
	public String toString() {
		StringBuilder temporaryString = new StringBuilder();
		temporaryString.append("[");
		for(Iterator<E> iterator = iterator(); iterator.hasNext();){
			temporaryString.append(iterator.next()).append(", ");
		}
		temporaryString.deleteCharAt(temporaryString.length() - 1);
		temporaryString.deleteCharAt(temporaryString.length() - 1);
		temporaryString.append("]");
		return temporaryString.toString();
	}

	private class SinglyLinkedListIterator implements Iterator<E> {
		private Node<E> current;
		public SinglyLinkedListIterator() {
			current = head;
		}
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if(!hasNext()) throw new RuntimeException("No such element");

			E res = current.getData();
			current = current.getNextNode();
			return res;
		}
	}

	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator();
	}
	public void reverseLinkedList(SinglyLinkedList sll) {
		
		//creates previous and current nodes to store values
		Node<E> previous = null;
		Node<E> current = sll.head;
		
		//while the list isn't empty
		while (current != null) {
			
			//nextElement stores the value for nextElement
			Node<E> nextElement = current.getNextNode();
			//change the direction of the linked list by making the current element point to the previous element
			current.setNext(previous);
			
			//move up the list 
			previous = current;
			current = nextElement;
			
		}
		
		//make the head point to the start of the list
		sll.head = previous;
	}
	private static Node addTwoNumbers(Node list1, Node list2) {

		//The head of the resultant linked list 
		Node head = null;
		
		// head is null currently
		Node temporary = null;
		
		// carry value set to 0
		int carry = 0;
		
		// loop adjusting if any of the lists are null
		while (list1 != null || list2 != null) {
			
			//add the carry from the last summation so that it is consistent
			int sum = carry;

			// this checks for if one of the list is smaller tham the other, we are checking if the
			// current node is empty for one of the sets
			if ( list1!= null) {
				
				//casting to allow the integers to work 
				Integer a = (Integer) list1.getData();
				sum +=a;
				list1 = list1.nextNode;
			}
			if (list2 != null) {
				
				//casting to allow the integers to work 
				Integer a = (Integer) list2.getData();
				sum += a;
				list2 = list2.nextNode;
			}
			
			//the full sum % 10 is added to the new node
			// in the linked list thats the resultant list
			
			Node nodeNew = new Node(sum % 10,null);
			
			// Carry is meant to be added in the iteration thats next
			carry = sum / 10;
			
			// If it is the head or first node
			if (temporary == null) {
				temporary = head = nodeNew;
			}
			
			// For any other possible node
			else {
				temporary.nextNode = nodeNew;
				temporary = temporary.nextNode;
			}
		}
		
		// After the last iteration, we will check if there is carry left
		// If it's left then we will create a new node and add it
		if (carry > 0) {
			temporary.nextNode = new Node(carry,null);
		}
		
		//returns the head of the new list
		return head;
	}
	public static void main(String[] args) {
		//ArrayList<String> all;
		//LinkedList<String> ll;
		SinglyLinkedList<Integer> sll2 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> sll3 = new SinglyLinkedList<Integer>();

		sll2.addFirst(1);
		sll2.addFirst(2);
		sll2.addFirst(3);
		sll2.addFirst(6);
		sll2.reverseLinkedList(sll2);
		System.out.println(sll2.toString());
		sll3.addFirst(0);
		sll3.addFirst(4);
		sll3.addFirst(0);
		sll3.addFirst(0);
		sll3.addFirst(1);
		sll3.reverseLinkedList(sll3);
		System.out.println(sll3.toString());
		SinglyLinkedList<Integer> sll4 = new SinglyLinkedList<Integer>();
		sll4.head = addTwoNumbers(sll2.head,sll3.head);
		sll4.reverseLinkedList(sll4);
		System.out.println(sll4.toString());
	}
}