package testAluno;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.queue.Queue;
import adt.queue.QueueImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class TestFila {

	private Queue<Integer> fila; // [5,3,1]
	private Queue<Integer> filaCheia; // [4,1,5]
	private Queue<Integer> filaVazia; // []
	private Queue<Integer> random;
	
	@Before
	public void setUp() throws QueueOverflowException {
		fila = new QueueImpl<>(4);
		filaCheia = new QueueImpl<>(3);
		filaVazia = new QueueImpl<>(1);
		random = new QueueImpl<>(5);
		
		fila.enqueue(new Integer(1));
		fila.enqueue(new Integer(3));
		fila.enqueue(new Integer(5));
		
		filaCheia.enqueue(new Integer(5));
		filaCheia.enqueue(new Integer(1));
		filaCheia.enqueue(new Integer(4));
	}
	
	@Test
	public void testHead() {
		assertEquals(fila.head(), new Integer(1));
		assertEquals(filaCheia.head(), new Integer(5));
		assertNull(filaVazia.head());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(filaVazia.isEmpty());
		assertFalse(fila.isEmpty());
		assertFalse(filaCheia.isEmpty());
	}
	
	@Test
	public void testIsFull() {
		assertTrue(filaCheia.isFull());
		assertFalse(fila.isFull());
		assertFalse(filaVazia.isFull());
	}
	
	@Test
	public void testEnqueue() {
		//fila = [5,3,1,0]
		try{
			fila.enqueue(new Integer(0));
		}catch (QueueOverflowException e) {
			fail();
		}
	}
 	
	@Test
	public void testEnqueueError() {
		try {
			filaCheia.enqueue(new Integer(0));
			fail();
			
		}catch (QueueOverflowException e) {
			assertEquals("Fila cheia", e.getMessage());
		}
	}
	
	@Test
	public void testDequeueError() {
		try {
			filaVazia.dequeue();
			fail();
			
		}catch (QueueUnderflowException e) {
			assertEquals("Fila vazia", e.getMessage());
		}
	}
	
	@Test
	public void testDequeue() {
		try {
			fila.dequeue();
			fila.dequeue();
			fila.dequeue();
			
		}catch (QueueUnderflowException e) {
			fail();
		}
	}
	
	@Test
	public void testRandom() throws QueueOverflowException {
		// random = [2,4,5,7,9]
		assertTrue(random.isEmpty());
		
		random.enqueue(new Integer(9));
		
	}
	
	
}
