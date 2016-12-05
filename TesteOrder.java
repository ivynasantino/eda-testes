package test;

import static org.junit.Assert.*;

import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class TesteOrder {

	public static final Comparable[] positivos = {4,8,6,9,12,1};
	public static final Comparable[] negativos = {-1,4,6,2,0};
	public static final Comparable[] ascending = {1,2,3,4};
	
	private static final Comparable[] first = {12};
	private static final Comparable[] second = {12,9};
	private static final Comparable[] th = {12,9,8};
	private static final Comparable[] last = {12,9,8,6,4,1};
	
	private static final Comparable[] nFirst = {6};
	private static final Comparable[] nSecond = {6,4};
	private static final Comparable[] nTh = {6,4,2};
	private static final Comparable[] nLast = {6,4,2,0,-1};

	private static final Comparable[] vazio = {};

	private static final Comparable[] aFirst = {4};
	private static final Comparable[] aLast = {4,3,2,1};
	
	KLargestOrderStatisticsImpl order = new KLargestOrderStatisticsImpl<>();
	
	@Test
	public void testOrder() {
		assertEquals(order.orderStatistics(positivos, 6), 12);
		assertEquals(order.orderStatistics(positivos, 5), 9);
		assertEquals(order.orderStatistics(positivos, 1), 1);
		assertEquals(order.orderStatistics(positivos, 2), 4);
		assertEquals(order.orderStatistics(positivos, -3), null);
	}
	
	@Test
	public void testGet() {
		assertEquals(order.getKLargest(positivos, 1), first);
		assertEquals(order.getKLargest(positivos, 2), second);
		assertEquals(order.getKLargest(positivos, 3), th);
		assertEquals(order.getKLargest(positivos, -1), null);
		assertEquals(order.getKLargest(positivos, 6), last);
		assertEquals(order.getKLargest(positivos, 7), null);
	}
	
	@Test
	public void testOrderNegative() {
		assertEquals(order.orderStatistics(negativos, 5), 6);
		assertEquals(order.orderStatistics(negativos, 4), 4);
		assertEquals(order.orderStatistics(negativos, 3), 2);
		assertEquals(order.orderStatistics(negativos, 2), 0);
		assertEquals(order.orderStatistics(negativos, 1), -1);
		assertEquals(order.orderStatistics(negativos, 0), null);
		assertEquals(order.orderStatistics(negativos, 6), null);
		assertEquals(order.orderStatistics(negativos, -2), null);
	}
	
	@Test
	public void testGetNegative() {
		assertEquals(order.getKLargest(negativos, 1), nFirst);
		assertEquals(order.getKLargest(negativos, 2), nSecond);
		assertEquals(order.getKLargest(negativos, 3), nTh);
		assertEquals(order.getKLargest(negativos, 5), nLast);
	}
	
	@Test
	public void testVazio() {
		assertEquals(order.getKLargest(vazio, 1), null);
		assertEquals(order.orderStatistics(vazio, 0), null);
	}
	
	@Test
	public void testAscendingGet() {
		assertEquals(order.getKLargest(ascending, 1), aFirst);
		assertEquals(order.getKLargest(ascending, 4), aLast);
		
	}
	
	@Test
	public void testAscendingOrder() {
		assertEquals(order.orderStatistics(ascending, 1), 1);
		assertEquals(order.orderStatistics(ascending, 4), 4);
	}
}
