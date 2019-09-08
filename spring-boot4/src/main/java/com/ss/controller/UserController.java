package com.ss.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ss.service.UserService;

@Controller
public class UserController implements UserControllerInterface{

	@Resource
	private UserService userService;
	
	@RequestMapping("/user/home")
	public String home(String username,String password){
		return "user home";
	}
	
	@GetMapping("/user/ftl")
	public String toMyFtl(){
		return "my";
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
	
	@RequestMapping("/user/queryUsers")
	public List<Map<String, Object>> queryUsers(){
		return userService.queryUsers();
	}
	
	@RequestMapping("/user/addUser")
	public void addUser() throws Exception {
		userService.addUserBatch();
	}
	
}
