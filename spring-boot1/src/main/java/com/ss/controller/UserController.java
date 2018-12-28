package com.ss.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * 去用户页面
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("toUser")
	public String toUser(){
		return "main";
	}
	@RequestMapping(value="checkUser")
	@ResponseBody
	public boolean checkUser(String username){
		if("admin".equals(username)){
			return true;
		}
		return false;
	}
	
	
	@RequestMapping(value="/hello")
	public String hello(Model model,User user){
		System.out.println(user);
		model.addAttribute("name", "zhangsan");
		List<String> str=new ArrayList<String>();
		str.add("123");
		str.add("456");
		model.addAttribute("str", str);
		return "hello";
	}
	//ajax请求
	@RequestMapping("/ajaxRequest")
	@ResponseBody
	public boolean ajaxRequest(String username){
		if("admin".equals(username)){
			return true;
		}
		return false;
	}
	@RequestMapping("/ajaxArr")
	//@ResponseBody
	public void ajaxArr(String arr,HttpServletResponse response,HttpSession session,HttpServletRequest request){
		System.out.println(arr);
		String json1= request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equals(json1)){
			System.out.println("这是一个json请求");
		}
		session.setAttribute("name", "zhangsan");
		PrintWriter pw=null;
		try {
			response.setContentType("text/html");
			 pw= response.getWriter();
			 
			 String json="{\"name\":\"wangwu\"}";		 
//			 pw.write(json);
			 StringBuffer sb=new StringBuffer();
			 sb.append("<form action=\"user/testForm\" method=\"post\" id=\"formId\">");
			 sb.append("<input type=\"hidden\" value=\"123456\" name=\"formValue\">");
			 sb.append("<input type=\"submit\" value=\"提交\">");
			 sb.append("</form>");
			 sb.append("<script type=\"text/javascript\">");
			 sb.append("document.getElementById(\"formId\").submit();");
			 sb.append("</script>");
			 pw.write(sb.toString());
			 for(int i=0;i<10;i++){
				 System.out.println(i);
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(pw!=null){
				pw.close();
			}
		}
	}
	@RequestMapping("/testForm")
	public String  testForm(String formValue) {
		System.out.println(formValue);
		return null;
	}
	
	@RequestMapping("/ajaxMain")
	@ResponseBody
	public String ajaxMain(HttpServletRequest request){
		BufferedReader br=null;
		StringBuffer sb=new StringBuffer();
		String form="";
		try {
			br= request.getReader();
			char[] c=new char[1024];
			int temp=0;
			while((temp=br.read(c))!=-1){
				sb.append(c,0,temp);
			}
			System.out.println(sb.toString());			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return form;
	}
	
	
	public static void main(String[] args) {
		
		
		String  url="http://127.0.0.1:8080/spring-boot1/user/ajaxMain";
		String jsonParam="{\"name\":\"wangwu\"}";
		String json= testPost(jsonParam, url);
		System.out.println(json);
	}
	public static String testPost(String jsonObj,String url){
		StringEntity entity=new StringEntity(jsonObj, "utf-8");
		entity.setContentType("application/json");
		HttpClient client= new DefaultHttpClient();
		HttpPost post=new HttpPost(url);
		post.setEntity(entity);
		String returnStr="";
		try {
			 HttpResponse response= client.execute(post);
			 returnStr=EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnStr;
	}
	
	
	
}
