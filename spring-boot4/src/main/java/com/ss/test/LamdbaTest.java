package com.ss.test;



public class LamdbaTest {
	public static void main(String[] args) {
		
		
		TestA ta=(String str)-> {return str;};
		
		System.out.println(ta.printStr("121212"));
		
		TestB tb=() -> {System.out.println("123456");};
		tb.print();
		 
	}
	
}

@FunctionalInterface
interface TestA{
	public String printStr(String str);
}

interface TestB{
	public void print();
}

