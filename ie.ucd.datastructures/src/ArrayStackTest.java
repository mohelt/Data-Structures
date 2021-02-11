import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayStackTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	@Test
	void testSize() {
		ArrayStack<Integer> s = new ArrayStack<>();
		for(int i = 0; i < 10; ++i)
			s.push(i);
		assertEquals(10, s.size());
	}

	@Test
	void testIsEmpty() {
		ArrayStack<Integer> s = new ArrayStack<>();
		for(int i = 0; i < 10; ++i)
			s.push(i);
		for(int i = 0; i < 10; ++i) {
			s.pop();
		}
		assertEquals(true, s.isEmpty());
	}

	@Test
	void testPush() {
		ArrayStack<Integer> s = new ArrayStack<>();
		for(int i = 0; i < 10; ++i) {
			s.push(i);
		}
		assertEquals(10, s.size());
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",s.toString());
	}

	@Test
	void testTop() {
		ArrayStack<Integer> s = new ArrayStack<>();
		for(int i = 0; i < 10; ++i)
			s.push(i);
		assertEquals(9, s.top());
	}

	@Test
	void testPop() {
		ArrayStack<Integer> s = new ArrayStack<>();
		for(int i = 0; i < 10; ++i) {
			s.push(i);
		}
		assertEquals(9, s.pop());
		assertEquals(9, s.size());
	}


}
