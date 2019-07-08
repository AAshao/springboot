package com.thread.syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池 Executor 具体的执行器 ExecuteService 执行器的服务 Executors 执行器的工具类
 *
 * @author A_Ashao
 * @date 2019年2月10日 上午9:39:11
 *
 */
public class T8 {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 6; i++) {
			executorService.execute(() -> {
				try {
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		System.out.println(executorService);
		System.out.println(executorService.isShutdown());
		System.out.println(executorService.isTerminated());
		
		executorService.shutdown();
		Thread.sleep(1000);
		System.out.println(executorService);
		System.out.println(executorService.isShutdown());
		System.out.println(executorService.isTerminated());
	}
}
