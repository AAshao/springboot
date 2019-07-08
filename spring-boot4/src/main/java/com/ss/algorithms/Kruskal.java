package com.ss.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ss.algorithms.UnionFind.UF;

/**
 *  要求：给定一个带权重的有向图，求最小生成树(权重和最小)的点
 *  克鲁斯卡尔算法，最小生成树
 *  1.取出所有的边，按权重进行排序
 *  2.重新进行组合，并判断是否存在环
 *	@author A_Ashao
 *	@date 2019年5月23日 下午9:59:25 
 *
 */
public class Kruskal {
	 static class Info{
		int x;
		int y;
		int weight;
		public Info(int x,int y,int weight){
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
		
	}
	
	public static void main(String[] args) {
		List<Info> points =new ArrayList<Info>();
		points.add(new Info(0, 1, 4));
		points.add(new Info(0, 7, 8));
		points.add(new Info(1, 7, 11));
		points.add(new Info(1, 2, 8));
		points.add(new Info(7, 8, 7));
		points.add(new Info(7, 6, 1));
		points.add(new Info(2, 8, 2));
		points.add(new Info(2, 5, 4));
		points.add(new Info(2, 3, 7));
		points.add(new Info(8, 6, 6));
		points.add(new Info(6, 5, 2));
		points.add(new Info(3, 5, 14));
		points.add(new Info(3, 4, 9));
		points.add(new Info(5, 4, 10));
		
		Collections.sort(points,(x,y)-> x.weight - y.weight);
		
		UnionFind.UF uf =new UF(9);
		List<Info> ansower =new ArrayList<Kruskal.Info>();
		for (int i = 0; i < points.size(); i++) {
			if(uf.union(points.get(i).x, points.get(i).y)){
				ansower.add(points.get(i));
			}
		}
		
		System.out.println(ansower);
	}
	
	/*
    [Info [x=7, y=6, weight=1],
     Info [x=2, y=8, weight=2],
      Info [x=6, y=5, weight=2],
       Info [x=0, y=1, weight=4], 
       Info [x=2, y=5, weight=4], 
       Info [x=2, y=3, weight=7], 
       Info [x=0, y=7, weight=8], 
       Info [x=3, y=4, weight=9]]

	*/
}
