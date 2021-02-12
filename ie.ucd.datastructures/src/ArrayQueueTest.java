import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	 @Test
	    void testSize() {
	        ArrayQueue<Integer> s = new ArrayQueue<>();
	        for(int i = 0; i < 9; ++i) {
	            s.enqueue(i);
	        }
	        assertEquals(9, s.size());
	    }

	    @Test
	    void testIsEmpty() {
	        ArrayQueue<Integer> s = new ArrayQueue<>();
	        for(int i = 0; i < 8; ++i)
	        {
	            s.enqueue(i);
	        }
	        for(int i = 0; i <8; ++i) {
	            s.dequeue();
	        }
	        assertEquals(true, s.isEmpty());
	    }

	    @Test
	    void testEnqueue() {
	        ArrayQueue<Integer> s = new ArrayQueue<>();
	        for(int i = 0; i < 8; ++i) {
	            s.enqueue(i);
	        }
	        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7]", s.toString());
	    }

	    @Test
	    void testFirst() {
	        ArrayQueue<Integer> s = new ArrayQueue<>();
	        for(int i = 0; i < 6; ++i) {
	            s.enqueue(i);
	            }
	        assertEquals(0, s.first());
	    }

	    @Test
	    void testDequeue() {
	        ArrayQueue<Integer> s = new ArrayQueue<>();
	        for(int i = 0; i < 5; ++i) {
	            s.enqueue(i);
	        }

	        assertEquals(5, s.size());
	        assertEquals(0, s.dequeue());
	    }
}
