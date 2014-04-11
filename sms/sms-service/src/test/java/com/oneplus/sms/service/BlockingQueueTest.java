package com.oneplus.sms.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		try {
			queue.put("1");
			System.out.println(queue.size());
			queue.add("2");
			System.out.println(queue.size());
			queue.add("3");
			System.out.println(queue.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
