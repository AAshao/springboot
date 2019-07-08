package com.ss.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
/**
 * 例如：第一行：7 
	第二行：6 4 2 5 3 1 7 
	第三行：4 2 5 6 1 3 7 
	输出 ：5 2 4 1 7 3 6
 *  
 *	@author A_Ashao
 *	@date 2019年5月14日 下午10:25:21 
 *
 */
public class Main {


    static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        int pre[]=new int[n];
        int order[]=new int[n];
        int post[]=new int[n];

        for (int i = 0; i < pre.length; i++) {
            pre[i]=scanner.nextInt();
        }
        for (int i = 0; i < order.length; i++) {
            order[i]=scanner.nextInt();
        }

        scanner.close();



        TreeNode node=reConstructBinaryTree(pre, order);
        postOrder(node);



        for (int i = 0; i < list.size(); i++) {
            post[i]=list.get(i);

        }

        for (int i = 0; i < post.length; i++) {
            System.out.print(post[i]);
            if(i!=post.length-1) System.out.print(" ");

        }
   }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0||in.length == 0){
             return null;
         }
         TreeNode node = new TreeNode(pre[0]);
         for(int i = 0; i < in.length; i++){
             if(pre[0] == in[i]){
                 node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                 node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
             }
         }
         return node;
     }



    //后序遍历
    public static void postOrder(TreeNode node ) {
        if(node!=null) {
            postOrder(node.left);
            postOrder(node.right);
            list.add(node.val);
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        }

    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
