package com.mine.others;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleTest {
	static int a = 1;
	
	static void func(){
		int abc;
	}
	
	public static void main(String[] args) {
		char a = '3';
		int b = a - '0';
		Integer ab = 1;
		SimpleTest.a++;
		System.out.println(SimpleTest.a);
		
		int c[][] = new int[4][5];
		Queue<String> q = new LinkedList<>();
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
		ab = ab+1;
		
		System.out.println("***");
		Deque<Integer> dq = new LinkedList<>();	
		dq.offer(1);
		dq.offer(2);
		dq.offer(3);
		dq.offerFirst(5);
		dq.offerLast(6);
		System.out.println(dq.peekFirst());
		System.out.println(dq.peekLast());
		System.out.println(dq.remove());
		System.out.println(dq.remove());
		System.out.println(dq.remove());
		System.out.println(dq.remove());
		System.out.println(dq.remove());
		
		System.out.println("************");
		
		System.out.println(b);
		System.out.println(c[1].length);
	}

}
