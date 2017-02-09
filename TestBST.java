package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bt.BTNode;

public class TestBST {

	private BSTImpl tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();
	
	@Before
	public void setUp() {
		tree = new BSTImpl<>();
	}
	
	@Test
	public void testRandom() {
		assertTrue(tree.root.isEmpty());
		assertEquals(tree.size(), 0);
		assertEquals(tree.height(), -1);
		assertEquals(tree.search(40), NIL);
		
		// 40 30 50 20 35 45 60
		tree.insert(40);
		assertFalse(tree.root.isEmpty());
		assertEquals(tree.search(40).getData(), new Integer(40));
		
		tree.insert(30);
		assertEquals(tree.search(30).getData(), new Integer(30));
		assertNotEquals(tree.search(20).getData(), new Integer(20));
		
		tree.insert(50);
		assertEquals(tree.search(50).getData(), new Integer(50));
		assertNotEquals(tree.search(20).getData(), new Integer(20));
		
		tree.insert(20);
		assertEquals(tree.height(), 2);
		
		tree.insert(35);
		assertEquals(tree.height(), 2);
		
		tree.insert(45);
		tree.insert(60);
		assertEquals(tree.sucessor(40).getData(), new Integer(45));
		assertEquals(tree.sucessor(30).getData(), new Integer(35));
		assertEquals(tree.predecessor(40).getData(), new Integer(35));
		assertEquals(tree.predecessor(50).getData(), new Integer(45));
		
		assertEquals(tree.size(), 7);
		assertEquals(tree.maximum().getData(), new Integer(60));
		assertEquals(tree.minimum().getData(), new Integer(20));
		
		Integer order[] = {20, 30, 35, 40, 45, 50, 60};
		assertEquals(tree.order(), order);
		
		Integer preOrder[] = {40, 30, 20, 35, 50, 45, 60};
		assertEquals(tree.preOrder(), preOrder);
		
		Integer posOrder[] = {20, 35, 30, 45, 60, 50, 40};
		assertEquals(tree.postOrder(), posOrder);
		
		//remove leaf
		tree.remove(20);
		assertEquals(tree.search(20), NIL);
		
		//remove node 1 child
		tree.remove(50);
		assertEquals(tree.search(50), NIL);
		
		tree.remove(40);
		assertEquals(tree.search(40), NIL);
		//using sucessor
		assertEquals(tree.root.getData(), new Integer(45));
		
		assertEquals(tree.height(), 2);
		assertEquals(tree.size(), 4);
		assertEquals(tree.minimum().getData(), new Integer(30));
		
		Integer a[] = {30, 35, 45, 60};
		assertEquals(tree.order(), a);
		assertEquals(tree.preOrder(), new Integer[] {45, 30, 35, 60});
		assertEquals(tree.postOrder(), new Integer[] {35, 30, 60, 45});
		
		int size = 4;
		assertEquals(tree.size(), 4);
		
		while (!tree.isEmpty()) {
			tree.remove((Comparable) tree.root.getData());
			assertEquals(--size, tree.size());
		}
		
		assertTrue(tree.isEmpty());
	
		Integer array2[] = {40, 30, -1, 20, 32, 60, 35};
		
		for (int i = 0; i < array2.length; i++) {
			tree.insert(array2[i]);
		}
		
		assertEquals(tree.size(), array2.length);
		assertEquals(tree.root.getData(), new Integer(40));
		assertEquals(tree.height(), 3);
		assertEquals(tree.order(), new Integer[] {-1, 20, 30, 32, 35, 40, 60});
		
//		tree.remove(35);
//		assertEquals(tree.size(), 6);
//		assertEquals(tree.search(35), NIL);
//		
		tree.remove(-1);
		assertEquals(tree.size(), 6);
		
		//Deu merda! Nao remove :(
		tree.remove(32);
		assertEquals(tree.size(), 5);
	}

}
