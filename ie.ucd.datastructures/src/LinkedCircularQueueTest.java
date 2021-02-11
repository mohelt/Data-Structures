import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedCircularQueueTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSize() {
		LinkedQueue<Integer> s = new LinkedQueue<>();
		for(int i = 0; i < 10; ++i)
			s.enqueue(i);
		assertEquals(10, s.size());
	}

	@Test
	void testIsEmpty() {
		LinkedQueue<Integer> s = new LinkedQueue<>();
		for(int i = 0; i < 10; ++i)
			s.enqueue(i);
		for(int i = 0; i < 10; ++i)
			s.dequeue();
		assertEquals(true, s.isEmpty());
	}

	@Test
	void testEnqueue() {
		LinkedQueue<Integer> s = new LinkedQueue<>();
		for(int i = 0; i < 10; ++i)
			s.enqueue(i);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", s.toString());
	}

	@Test
	void testFirst() {
		LinkedQueue<Integer> s = new LinkedQueue<>();
		for(int i = 0; i < 10; ++i)
			s.enqueue(i);
		assertEquals(0, s.first());
	}

	@Test
	void testDequeue() {
		LinkedQueue<Integer> s = new LinkedQueue<>();
		for(int i = 0; i < 10; ++i)
			s.enqueue(i);

		assertEquals(0, s.dequeue());
		assertEquals(9, s.size());
	}


}
