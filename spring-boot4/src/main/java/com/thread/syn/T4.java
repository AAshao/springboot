package com.thread.syn;

import java.util.Arrays;

public class T4 {

	public static void main(String[] args) {
		String str="123,456,\"678,798,632\",\"6,2,2\",001";
		System.out.println(str);
		
		String[] strArr= str.split(",");
		
		System.out.println(Arrays.toString(strArr));
		
		for(int i=0; i<strArr.length; i++){
			if(strArr[i].startsWith("\"")){
				i=findLast(i,strArr);
			}else{
				System.out.println(i+":"+strArr[i]);
			}				
		}
		
	}

	private static int findLast(int i, String[] strArr) {
		String temp=strArr[i];
		int index=0;
		
		for(int j=i+1; j<strArr.length; j++){
			temp+=","+strArr[j];
			
			if(strArr[j].endsWith("\"")){
				index=j;
				break;
			}
		}
		
		System.out.println(temp);
		
		return index;
	}
	
	
	
	
	
	
}
