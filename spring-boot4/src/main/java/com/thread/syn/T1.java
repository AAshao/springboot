package com.thread.syn;

/**
 *  死锁模拟
 *  两个线程都在等待对方释放锁，因此会造成死锁现象
 *	@author huanhongzhao
 *	@date 2019年1月16日 下午8:59:00 
 *
 */
public class T1  {

	Object obj1=new Object();
	Object obj2=new Object();
	
	public void m1(){
		synchronized(obj1){
			System.out.println("m1 start ......");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			m2();
			System.out.println("m1 end .......");
		}
	}
	
	
	public void m2(){
		synchronized (obj2) {
			System.out.println("m2 start ......");
			try {
				//Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			m1();
			System.out.println("m2 end .......");
		}
	}
	
	public static void main(String[] args) {
		T1 t1=new T1();
		
		new Thread(() ->{t1.m1();}).start();
		
		new Thread(() ->{t1.m2();}).start();
		
	}
	
}
