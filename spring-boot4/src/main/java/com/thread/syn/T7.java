package com.thread.syn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;



/**
 * Callable，有返回值的；
 * FutureTask;通过get()可以获取未来的莫一个任务执行完成之后的返回值，会进行阻塞；
 * Future
 * 
 *  
 *	@author A_Ashao
 *	@date 2019年2月7日 上午10:58:00 
 *
 */
public class T7 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Integer> futureTask= new FutureTask<Integer>(()->{
			Thread.currentThread().sleep(2000);
			return 1000;
		});
		
		new Thread(futureTask).start();
		
		System.out.println();
		System.out.println(futureTask.get());
	}
}
