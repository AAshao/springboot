package com.thread.syn;

import java.util.concurrent.CountDownLatch;

public class T5 {

	volatile int count;
	
  CountDownLatch countDownLatch=new CountDownLatch(10);
	/*synchronized*/ void add(){
		for (int i = 0; i <10000; i++) {
			count++;
		}
	}
	
	public static void main(String[] args) {
		T5 t5=new T5();
		
		for (int i = 0; i < 10; i++) {
			new Thread(
					()->{
						t5.add();
						t5.countDownLatch.countDown();
					}).start();
		}
		
		try {
			t5.countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("count="+t5.count);
		
	}
}
