package at.fhj.iit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Testing the functionalities of the class QueueGeneric as String
 */

@DisplayName("Testing QueueGeneric<String>")
class QueueGenericStringTest {
	private QueueGeneric<String> sqg;
	private QueueGeneric<String> emptysqg;
	
	/**
	 * Inits two Queues for each test
	 */
	
	@BeforeEach
	public void setup() {
		sqg = new QueueGeneric(3);
		sqg.offer("String 1");
		sqg.offer("String 2");
		sqg.offer("String 3");
		emptysqg = new QueueGeneric(1);
	}
	
	/**
	 * Test offer(). "offering" string to an empty queue Also testing offer to an
	 * full Queue / creating overflow
	 */
	
	@Test
	@DisplayName("Testing offer")
	public void testGenericOffer() {
		assertTrue(emptysqg.offer("String 1"));
		assertFalse(sqg.offer("String 4"));
	}


	/**
	 * Testing poll()
	 */
	
	@Test
	@DisplayName("Testing poll")
	public void testGenericPoll() {
		assertEquals(sqg.poll(), "String 1");
		assertEquals(sqg.poll(), "String 2");
		assertEquals(sqg.poll(), "String 3");
	}
	

	/**
	 * Testing poll() with an empty Queue Null should be expected because its empty
	 */
	@Test
	@DisplayName("Testing poll with empty Queue")
	public void testGenericPollEmptyQueue() {
		assertNull(emptysqg.poll());
	}

	/**
	 * Test remove()
	 */
	@Test
	@DisplayName("Testing remove ")
	public void testGenericRemove() {
		assertEquals(sqg.remove(), "String 1");
		assertEquals(sqg.remove(), "String 2");
		assertEquals(sqg.remove(), "String 3");

	}

	/**
	 * Testing remove() with an empty Queue.
	 */
	@Test
	@DisplayName("Testing remove with empty Queue")
	public void testGenericRemoveEmptyQueue() {
		assertThrows(NoSuchElementException.class, () -> {
			emptysqg.remove();
		});

	}

	/**
	 * Test peek()
	 */
	@Test
	@DisplayName("Testing peek()")
	public void testGenericPeek() {
		assertEquals(sqg.peek(), "String 1");

	}

	/**
	 * Testing peek() with empty Queue Null should be expected because its empty
	 */

	@Test
	@DisplayName("Testing peek with empty Queue")
	public void testGenericPeekEmptyQueue() {
		assertNull(emptysqg.poll());
	}

	/**
	 * Test element()
	 */
	@Test
	@DisplayName("Testing element()")
	public void testGenericElement() {
		assertEquals(sqg.element(), "String 1");
	}

	/**
	 * Test element with empty Queue
	 */
	@Test
	@DisplayName("Testing element with empty Queue")
	public void testGenericElementEmptyQueue() {
		assertThrows(NoSuchElementException.class, () -> {
			emptysqg.element();
		});

	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
