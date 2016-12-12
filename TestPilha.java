package testAluno;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class TestPilha {

	private Stack<Integer> pilha; // [4]
	private Stack<Integer> pilhaVazia; // []
	private Stack<Integer> pilhaCheia; // [3,2]
	private Stack<Integer> random;
	
	@Before
	public void setUp() throws StackOverflowException {
		pilha = new StackImpl<>(5);
		pilhaCheia = new StackImpl<>(2);
		pilhaVazia = new StackImpl<>(1);
		random = new StackImpl<>(6);
		
		pilhaCheia.push(new Integer(3));
		pilhaCheia.push(new Integer(2));
		
		pilha.push(new Integer(4));
		
	}
	
	@Test
	public void testTop() {
		assertEquals(pilha.top(), new Integer(4));
		assertEquals(pilhaVazia.top(), null);
		assertEquals(pilhaCheia.top(), new Integer(2));
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(pilhaVazia.isEmpty());
		assertFalse(pilhaCheia.isEmpty());
		assertFalse(pilha.isEmpty());
	}
	
	@Test
	public void testIsFull() {
		assertTrue(pilhaCheia.isFull());
		assertFalse(pilha.isFull());
		assertFalse(pilhaVazia.isFull());
	}
	
	@Test
	public void testPush() throws StackOverflowException {
		// pilha = [4,3,2,1,0]
		try {
			pilha.push(new Integer(3));
			pilha.push(new Integer(2));
			pilha.push(new Integer(1));
			pilha.push(new Integer(0));
			
		}catch (StackOverflowException e) {
			fail();
		}
		
	}
	
	@Test
	public void testPushError() {
		// pilha = [4,3,2,1,0]
		try {
			pilha.push(new Integer(3));
			pilha.push(new Integer(2));
			pilha.push(new Integer(1));
			pilha.push(new Integer(0));
			pilha.push(new Integer(-1));
			fail();
			
		}catch (StackOverflowException e) {
			assertEquals("Stack is full", e.getMessage());
		}
	}
	
	@Test
	public void testPop() {
		// pilhaCheia = [3,2]
		try {
			assertEquals(pilhaCheia.pop(), new Integer(2));
			assertEquals(pilhaCheia.pop(), new Integer(3));
			assertTrue(pilhaCheia.isEmpty());
			
		}catch (StackUnderflowException e) {
			fail();
		}
	}
	
	@Test
	public void testPopError() {
		try {
			assertEquals(pilhaCheia.pop(), new Integer(2));
			assertEquals(pilhaCheia.pop(), new Integer(3));
			assertEquals(pilhaCheia.pop(), null);
			fail();
			
		}catch (StackUnderflowException e) {
			assertEquals("Stack is empty", e.getMessage());
		}
	}
	
	@Test
	public void testAleatorio() throws StackOverflowException, StackUnderflowException {
		// random = [4,6,2,7,1,7]
		random.push(new Integer(4));
		random.push(new Integer(6));
		random.push(new Integer(2));
		random.push(new Integer(7));
		random.push(new Integer(1));
		random.push(new Integer(7));
		
		assertEquals(random.top(), new Integer(7));
		assertTrue(random.isFull());
		assertFalse(random.isEmpty());
		
		assertEquals(random.pop(), new Integer(7));
		assertEquals(random.pop(), new Integer(1));
		
		// random = [4,6,2,7]
		assertEquals(random.top(), new Integer(7));
		
		assertEquals(random.pop(), new Integer(7));
		
		// random = [4,6,2]
		assertEquals(random.top(), new Integer(2));
		assertFalse(random.isEmpty());
		assertFalse(random.isFull());
		
		random.push(new Integer(10));
		
		//random = [4,6,2,10]
		assertEquals(random.top(), new Integer(10));
		assertEquals(random.pop(), new Integer(10));
		assertEquals(random.pop(), new Integer(2));
		assertEquals(random.pop(), new Integer(6));
		assertEquals(random.pop(), new Integer(4));
		
		//random = []
		assertTrue(random.isEmpty());
		
		random.push(new Integer(1));
		random.push(new Integer(3));
		
		//random = [1,3]
		
		assertEquals(random.top(), new Integer(3));
		
		random.push(new Integer(5));
		random.push(new Integer(1));
		random.push(new Integer(4));
		random.push(new Integer(7));
		
		//random = [1,3,5,1,4,7]
		assertEquals(random.top(), new Integer(7));
		assertTrue(random.isFull());
	}
}
