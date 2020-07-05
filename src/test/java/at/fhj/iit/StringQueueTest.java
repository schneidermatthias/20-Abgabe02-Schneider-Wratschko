package at.fhj.iit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Testing the functionalities of the class StringQueue
 */

@DisplayName("Testing Stringqueue")
class StringQueueTest {
	private StringQueue sq, emptysq;

	/**
	 * Inits two StringQueues for each test
	 */
	@BeforeEach
	public void setup() {
		sq = new StringQueue(3);
		sq.offer("String 1");
		sq.offer("String 2");
		sq.offer("String 3");
		emptysq = new StringQueue(1);
	}

	/**
	 * Test offer(). "offering" string to an empty queue Also testing offer to an
	 * full Queue / creating overflow
	 */
	@Test
	@DisplayName("Testing offer")
	public void testOffer() {
		assertTrue(emptysq.offer("String 1"));
		assertFalse(sq.offer("String 4"));
	}

	/**
	 * Testing poll()
	 */
	@Test
	@DisplayName("Testing poll")
	public void testPoll() {
		assertEquals(sq.poll(), "String 1");
		assertEquals(sq.poll(), "String 2");
		assertEquals(sq.poll(), "String 3");
	}

	/**
	 * Testing poll() with an empty Queue Null should be expected because its empty
	 */
	@Test
	@DisplayName("Testing poll with empty Queue")
	public void testPollEmptyQueue() {
		assertNull(emptysq.poll());
	}

	/**
	 * Test remove()
	 */
	@Test
	@DisplayName("Testing remove ")
	public void testRemove() {
		assertEquals(sq.remove(), "String 1");
		assertEquals(sq.remove(), "String 2");
		assertEquals(sq.remove(), "String 3");

	}

	/**
	 * Testing remove() with an empty Queue.
	 */
	@Test
	@DisplayName("Testing remove with empty Queue")
	public void testRemoveEmptyQueue() {
		assertThrows(NoSuchElementException.class, () -> {
			emptysq.remove();
		});

	}

	/**
	 * Test peek()
	 */
	@Test
	@DisplayName("Testing peek()")
	public void testPeek() {
		assertEquals(sq.peek(), "String 1");

	}

	/**
	 * Testing peek() with empty Queue Null should be expected because its empty
	 */

	@Test
	@DisplayName("Testing peek with empty Queue")
	public void testPeekEmptyQueue() {
		assertNull(emptysq.poll());
	}

	/**
	 * Test element()
	 */
	@Test
	@DisplayName("Testing element()")
	public void testElement() {
		assertEquals(sq.element(), "String 1");
	}

	/**
	 * Test element with empty Queue
	 */
	@Test
	@DisplayName("Testing element with empty Queue")
	public void testElementEmptyQueue() {
		assertThrows(NoSuchElementException.class, () -> {
			emptysq.element();
		});

	}

}
