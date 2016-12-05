package test;

import static org.junit.Assert.*;

import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class TesteOrder {

	public static final Comparable[] positivos = {4,8,6,9,12,1};
	
	private static final Comparable[] first = {12};
	private static final Comparable[] second = {12,9};
	private static final Comparable[] th = {12,9,8};
	private static final Comparable[] last = {12,9,8,6,4,1};
	
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

}
