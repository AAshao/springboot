package com.ss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserControllerInterface{

	@RequestMapping("/user/home")
	public String home(String username,String password){
		return "user home";
	}

	@GetMapping("/user/session")
	public String userSession(HttpServletRequest request) throws Exception{
		HttpSession session= request.getSession();
		String sessionid="";
		sessionid=session.getId();
		
		
		
		return "sessionId:"+sessionid;
	}
	
	
	@RequestMapping("/user/error")
	public String error() throws Exception{
		throw new Exception("500错误测试");
	}
	
}
