package com.thread.syn;

/**
 * 
 *  1. 可以在一个加锁的方法中调用另外一个加锁的方法，同一个线程，同一把锁
 *  2. 可以同时调用一个对象中被锁住的方法和未被锁住的方法；
 *  3  子类可以调用父类中被锁住的方法，不会出现死锁现象；
 *	@author huanhongzhao
 *	@date 2019年1月16日 下午9:08:48 
 *
 */
public class T2 {

	public synchronized  void m1(){
		System.out.println("m1 start .....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m2();
		System.out.println("m1 end .....");
	}
	
	public synchronized  void m2(){
		System.out.println("m2 start .....");
		System.out.println("m2 end .....");
	}
	
	public  void m3(){
		System.out.println("m3 start..");
	}
	
	public static void main(String[] args) {
		T2 t2=new T2();
		new Thread(() ->{t2.m1();}).start();
		
		new Thread(() -> {t2.m3();}).start();
	}
}
