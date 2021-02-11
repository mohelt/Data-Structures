import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularlyLinkedListTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSize() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        assertEquals(0, ll.size());
        ll.addFirst(1);
        assertEquals(1, ll.size());
        ll.addFirst(1);
        assertEquals(2, ll.size());
        assertEquals("[1, 1]", ll.toString());
	}

	@Test
	void testIsEmpty() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        assertEquals(ll.isEmpty(),true);
        ll.addFirst(0);
        assertEquals("[0]", ll.toString());
        assertEquals( ll.isEmpty(),false);
        ll.removeFirst();
        assertEquals(ll.isEmpty(),true);
	}

	@Test
	void testGet() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        for(int j = 0; j < 5; j++) {
        	ll.addLast(j);
        }
        assertEquals(0, ll.get(0));
        assertEquals(1, ll.get(1));
        assertEquals(2, ll.get(2));
	}

	@Test
	void testSet() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        for(int j = 0; j < 5; j++) {
        	ll.addLast(j);
        }
        assertEquals(0, ll.get(0));
        ll.set(0, 1);
        assertEquals(1, ll.get(1));

        assertEquals(4, ll.get(4));
        ll.set(4, 3);
        assertEquals(3, ll.get(4));
        
	}

	@Test
	void testAdd() {
	CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
    for(int i = 0; i < 5; ++i) ll.addLast(i);

    ll.add(2, -5);
    assertEquals(ll.toString(),"[0, 1, -5, 2, 3, 4]");
	}

	@Test
	void testRemove() { 
	CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
    for(int i = 0; i < 5; ++i) ll.addLast(i);

    ll.remove(2);
    assertEquals( ll.toString(),"[0, 1, 3, 4]");
	}

	@Test
	void testIterator() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        for(int i = 0; i < 6; ++i) ll.addLast(i);

        ArrayList<Integer> arrayListInteger = new ArrayList<Integer>();
        for(Integer i : ll) {
        	arrayListInteger.add(i);
        }
        assertEquals("[0, 1, 2, 3, 4, 5]", arrayListInteger.toString());
	}

	@Test
	void testFirst() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        ll.addFirst(-5);
        assertEquals(-5, ll.first());

        //removing the first to check its null
        ll.removeFirst();
        assertEquals(null, ll.first());
	}

	@Test
	void testLast() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        ll.addFirst(-4);
        assertEquals(-4, ll.last());
        ll.addFirst(-2);
        assertEquals(-4, ll.last());
//checking if addLast and add first methods correctly work
        ll.addLast(-6);
        assertEquals(-6, ll.last());
	}

	@Test
	void testRotate() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
		for(int i = 0; i < 6; ++i) {
			ll.addLast(i);
			}
		assertEquals(ll.last(),5);
		ll.rotate();
		assertEquals(ll.last(),0);

		ll.rotate();
		assertEquals(ll.last(),1);
	}

	@Test
	void testAddFirst() {

        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
		ll.addFirst(-1);
        assertEquals(-1, ll.first());
	}

	@Test
	void testAddLast() {

        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
		ll.addLast(-3);
        assertEquals(-3, ll.last());
	}

	@Test
	void testRemoveFirst() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        ll.addFirst(-7);
        assertEquals(-7, ll.first());

        ll.removeFirst();
        assertEquals(null, ll.first());
	}

	@Test
	void testRemoveLast() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        ll.addFirst(-5);
        ll.addFirst(-4);
        assertEquals(-5, ll.removeLast());
	}

	@Test
	void testToString() {

		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
	    for(int i = 0; i < 5; ++i) ll.addLast(i);

	    ll.add(2, -5);
	    assertEquals(ll.toString(),"[0, 1, -5, 2, 3, 4]");
		
	}

}
