import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedDequeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSize() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for(int i = 0; i < 10; ++i)
		{
			s.addFirst(i);
		}
		assertEquals(10, s.size());
	}

	@Test
	void testIsEmpty() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		assertEquals(true, s.isEmpty());
		s.addFirst(1);
		assertEquals(false, s.isEmpty());
		s.removeFirst();
		assertEquals(true, s.isEmpty());
	}

	@Test
	void testFirst() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		s.addFirst(1);
		assertEquals(1, s.first());
		s.addFirst(2);
		assertEquals(2, s.first());
	}

	@Test
	void testLast() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		s.addLast(1);
		assertEquals(1, s.last());
		s.addLast(2);
		assertEquals(2, s.last());
	}

	@Test
	void testAddFirst() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		s.addFirst(1);
		assertEquals(1, s.first());
		s.addFirst(2);
		assertEquals(2, s.first());
	}

	@Test
	void testAddLast() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		s.addLast(1);
		assertEquals(1, s.last());
		s.addLast(2);
		assertEquals(2, s.last());
	}

	@Test
	void testRemoveFirst() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		s.addFirst(1);
		s.addFirst(2);
		s.removeFirst();
		assertEquals("[1]", s.toString());
	}

	@Test
	void testRemoveLast() {

		LinkedDeque<Integer> s = new LinkedDeque<>();
		s.addLast(1);
		s.addLast(2);
		s.removeLast();
		assertEquals("[1]", s.toString());
	}

}
