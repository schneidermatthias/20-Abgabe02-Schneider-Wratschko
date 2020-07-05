package at.fhj.iit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Testing the functionalities of the class QueueGeneric as Integer
 */

@DisplayName("Testing QueueGeneric<Integer>")
class QueueGenericIntegerTest {
	private QueueGeneric<Integer> iqg;
	private QueueGeneric<Integer> emptyIQG;

	/**
	 * Inits two Queues for each test
	 */

	@BeforeEach
	public void setup() {
		iqg = new QueueGeneric(3);
		iqg.offer(1);
		iqg.offer(2);
		iqg.offer(3);
		emptyIQG = new QueueGeneric(1);
	}

	/**
	 * Test offer(). "offering" string to an empty queue Also testing offer to an
	 * full Queue / creating overflow
	 */

	@Test
	@DisplayName("Testing offer")
	public void testGenericOffer() {
		assertTrue(emptyIQG.offer(1));
		assertFalse(iqg.offer(4));
	}

	/**
	 * Testing poll()
	 */

	@Test
	@DisplayName("Testing poll")
	public void testGenericPoll() {
		assertEquals(iqg.poll(), 1);
		assertEquals(iqg.poll(), 2);
		assertEquals(iqg.poll(), 3);
	}

	/**
	 * Testing poll() with an empty Queue Null should be expected because its empty
	 */
	@Test
	@DisplayName("Testing poll with empty Queue")
	public void testGenericPollEmptyQueue() {
		assertNull(emptyIQG.poll());
	}

	/**
	 * Test remove()
	 */
	@Test
	@DisplayName("Testing remove ")
	public void testGenericRemove() {
		assertEquals(iqg.remove(), 1);
		assertEquals(iqg.remove(), 2);
		assertEquals(iqg.remove(), 3);

	}

	/**
	 * Testing remove() with an empty Queue.
	 */
	@Test
	@DisplayName("Testing remove with empty Queue")
	public void testGenericRemoveEmptyQueue() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyIQG.remove();
		});

	}

	/**
	 * Test peek()
	 */
	@Test
	@DisplayName("Testing peek()")
	public void testGenericPeek() {
		assertEquals(iqg.peek(), 1);

	}

	/**
	 * Testing peek() with empty Queue Null should be expected because its empty
	 */

	@Test
	@DisplayName("Testing peek with empty Queue")
	public void testGenericPeekEmptyQueue() {
		assertNull(emptyIQG.poll());
	}

	/**
	 * Test element()
	 */
	@Test
	@DisplayName("Testing element()")
	public void testGenericElement() {
		assertEquals(iqg.element(), 1);
	}

	/**
	 * Test element with empty Queue
	 */
	@Test
	@DisplayName("Testing element with empty Queue")
	public void testGenericElementEmptyQueue() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyIQG.element();
		});

	}

}
