package com.thread.syn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *  Queue
 *	@author A_Ashao
 *	@date 2019年2月6日 上午9:34:36 
 *
 */
public class T6 {
	//static ConcurrentLinkedDeque queue=new ConcurrentLinkedDeque(); // 非阻塞
	//static Queue queue=new LinkedBlockingDeque(); // 阻塞 无界队列
	 static BlockingQueue queue=new ArrayBlockingQueue(10); // 阻塞 有界队列
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			queue.offer(i);
		}
		queue.offer(10);
		System.out.println(queue);
		try {
			queue.put(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(queue);
	}	
}
