package com.thread.syn;

import java.util.concurrent.TimeUnit;


/**
 * 
 *  出现异常的情况下，锁会被释放；
 *  以下程序，若不出现异常，t2线程永远不会被执行；
 *	@author huanhongzhao
 *	@date 2019年1月16日 下午9:28:04 
 *
 */
public class T3 {
	int count;
	public  synchronized void m(){
		while(true){
			count++;
			System.out.println(Thread.currentThread().getName()+":"+count);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(count == 5){
				try {
					int i= count / 0;
				} catch (Exception e) {
					System.err.println("此处发生异常，默认锁会被释放，手动处理，不释放锁！！！！");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		T3 t3=new T3();
		
		new Thread(()->{t3.m();},"t1").start();
		
		new Thread(()->{t3.m();},"t2").start();
	}
}
