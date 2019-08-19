package com.ss.test;

public class Test2 {
	public static void main(String[] args) {
		System.out.println(reverse(-123456111));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
	
	 public static int reverse(int x) {
		 String ansower = "";
		 Integer i = new Integer(x);
		 char[] ci = i.toString().toCharArray();
		 for(int a = ci.length-1; a>=0; a--){
			 if(ci[a] == '-'){				 
				ansower = '-' + ansower;
			 }else{				 
				ansower += ci[a];
			 }
		 }
		 int a = Long.parseLong(ansower) > Integer.MAX_VALUE || Long.parseLong(ansower) < Integer.MIN_VALUE  ? 0 :Integer.parseInt(ansower);
		 return a; 
     }

}
