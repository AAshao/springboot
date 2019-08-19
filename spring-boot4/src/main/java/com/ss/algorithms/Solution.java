package com.ss.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 *  无重复字符的最长子串
 *  
 *	@author A_Ashao
 *	@date 2019年7月23日 下午10:08:12 
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring(""));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int ansower = 0;
		char[] chars = s.toCharArray();
		Set<Character> sets = new HashSet<Character>();
		
		for(int i=0; i<chars.length; i++){
			sets.add(chars[i]);
			ansower = Math.max(ansower, sets.size());
			a: for(int j = i+1; j<chars.length;j++){
				if(!sets.add(chars[j])){
					ansower = Math.max(ansower, sets.size());
					sets.clear();
					break a;
				}
			}
		}
        return ansower;
    }	
}
