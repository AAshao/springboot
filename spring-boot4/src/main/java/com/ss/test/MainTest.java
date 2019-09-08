package com.ss.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class MainTest {
	public static void main(String[] args) {
		Integer[] a ={1,2,3};
		List<Integer> asList = Arrays.asList(a);
		System.out.println(asList.getClass());
		List<Integer> list = Arrays.stream(a).collect(Collectors.toList());
		list.add(4);
		System.out.println(list);
		List<Integer> list2= new ArrayList<Integer>(Arrays.asList(a));
		list2.add(5);
		System.out.println(list2.getClass());
	}
	
	private static void m8(){
		String[] strs=new  String[]{"1","2","3","4"};
		List<String> list= Arrays.asList(strs);
		
		Consumer<String> consumer=s->System.out.println(s); 
		Predicate<String> predicate=p->Integer.parseInt(p)>2;
		Comparator<String> comparator=(String c1,String c2) -> c1.compareTo(c2);
		
		String maxStr= list.stream().limit(3).filter(predicate).max(comparator).get();
		
		System.out.println("前三位，大于2，的最大值max="+maxStr);
		
		List<String> filterList= list.stream().filter(predicate).collect(Collectors.toList());
		filterList.forEach((filterElement)->System.out.println("collect、"+filterElement));
		
		// lambda表达式
		Collections.sort(list, (String s1,String s2) -> (s2.compareTo(s1)));
		list.forEach((str)->System.out.println(str));
		
		
		Thread t=new Thread(() -> func());
		t.start();
	
	}
	

	private static Object func() {
			System.out.println("12121212111111111111");
		return null;
	}
}
