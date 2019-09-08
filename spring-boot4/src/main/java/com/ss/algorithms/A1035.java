package com.ss.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *  
 *	@author A_Ashao
 *	@date 2019年9月3日 下午8:26:13 
 *
 */
public class A1035 {
	static List<String> words = new ArrayList<String>();
	static List<String> missWords = new ArrayList<String>();
	static List<String> temps = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int flag = 0 ;
		while(true){
			if(flag == 2) break;
			String str = sc.next();
			if(!"#".equals(str) && flag == 0){
				words.add(str);
			}else if("#".equals(str)){
				flag ++;
			}else{
				missWords.add(str);
			}
		}
		
		for(int i=0; i<missWords.size(); i++){
			temps.clear();
			int result = getDistance(missWords.get(i));
			System.out.println(result+" "+temps);
		}
		
	}
	/**
	 * 
	 * 0 相等
	 * 1可替换
	 * 2不同
	 * @param missWord
	 * @return
	 */
	private static int getDistance(String missWord) {
		int result = -1;
		for(int j = 0; j < words.size() ; j++){
			if((words.get(j).length() - missWord.length() > 1 || missWord.length() - words.get(j).length() >2) && temps.size() ==0){
				result = 2;	
			}else if(words.get(j).length() == missWord.length()){
				int flag = 0;
				for(int m = 0; m<missWord.length();m++){
					if(words.get(j).charAt(m) != missWord.charAt(m)){
						flag ++;
					}
				}
				if(flag == 0){
					result = 0;
					temps.clear();
					temps.add(words.get(j));
					break;
				}else if(flag == 1){
					result = 1;
					temps.add(words.get(j));
				}
			}else if(missWord.length() - words.get(j).length() == 1){
				int flag = 0 , n = 0;
				for(int m = 0; m< missWord.length();m++){
					if(words.get(j).charAt(n) != missWord.charAt(m)){
						n --;
						flag++;
					}
					n++;
				}
				if(flag == 1){
					result = 1;
					temps.add(words.get(j));
				}
			}else if(words.get(j).length() - missWord.length()  == 1){
				int flag = 0 , n = 0;
				for(int m = 0; m< missWord.length();m++){
					if(words.get(j).charAt(n) != missWord.charAt(m)){
						n --;
						flag++;
					}
					n++;
				}
				if(flag == 1){
					result = 1;
					temps.add(words.get(j));
				}
			}
		}
		return result;
	}
}
