package com.ss.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *Md5加密类
 */
public class Md5 
{
	private static final String[] arr={ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
   public static String getMD5EncodStr(String str){
	   if(str!=null && str.length()<=0){
		   return null;
	   }
		   try {
			MessageDigest digest=MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			byte[] b=digest.digest();
			//将数组转换成16进制字符串
			String md5Str=Md5.objectHEx(b);
			return md5Str;
		} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	   return null;
   }
   public static String objectHEx(byte[] b){
	   if(b ==null &&b.length==0){
		   return null;
	   }
	   StringBuffer sb=new StringBuffer();
	   for (int i = 0; i < b.length; i++) {
		int m=b[i];
		if(m<0){
			m+=256;
		}
		int d1=m/16;
		int d2=m%16;
		sb.append(arr[d1]+arr[d2]);
	   }
	   return sb.toString();
   }
   public static void main(String[] args) {
	System.out.println(Md5.getMD5EncodStr("1212111111111111111111111111"));
}
}
