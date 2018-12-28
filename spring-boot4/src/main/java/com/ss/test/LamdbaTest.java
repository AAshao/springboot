package com.ss.test;



public class LamdbaTest {
	public static void main(String[] args) {
		
		
		TestA ta=(String str)-> {return str;};
		
		System.out.println(ta.printStr("121212"));
	}
	
}

@FunctionalInterface
interface TestA{
	public String printStr(String str);

}


