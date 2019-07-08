package com.ss.algorithms;

import java.util.Arrays;

/**
 * 并查集
 * 无相图，用来判断是由存在环
 * 
 *	@author A_Ashao
 *	@date 2019年5月23日 下午9:17:37 
 *
 */
public class UnionFind {

	static  class UF{
		public int[] data; // parent 数组
		public int[] rank; // 路径深度
		public UF(int size){
			data = new int[size];
			rank = new int[size];
			for(int i= 0; i<size; i++){
				data[i] = -1;
				rank[i] = 0;
			}
		}
		// x为index
		public int find(int x){
			int root_x = x;
			while(data[root_x] != -1){
				root_x = data[root_x];
			}
			return root_x;
		}
		
		// union
		public boolean union(int x,int y){
			int root_x = find(x);
			int root_y = find(y);
			
			if(root_x == root_y){
				// 根节点相同，肯定存在环
				return false;
			}else{
				// 合并
				data[root_x] = root_y;
				// 压缩路径,
				if(rank[root_x] > rank[root_y]){
					data[root_y] = root_x;
				}else if(rank[root_x] < rank[root_y]){
					data[root_x] = root_y;
				}else {
					data[root_x] = root_y;
					rank[root_y]++;
				}
				
				return true;
			}
		}
	}
	
	public static void main(String[] args) {
		UF uf = new UF(6);
		int[][] edges ={{0,1},{1,2},{1,3},{3,4},{3,5}};
		for(int i=0; i<edges.length; i++){
			if(!uf.union(edges[i][0], edges[i][1])){
				System.out.println("you huan");
				break;
			}
		}
		System.out.println(Arrays.toString(uf.data));
		System.out.println(Arrays.toString(uf.rank));
	}
	
}
