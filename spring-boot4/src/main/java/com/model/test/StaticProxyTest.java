package com.model.test;

import com.model.proxy.UserService;
import com.model.proxy.UserServiceProxyImpl;

public class StaticProxyTest {

	public static void main(String[] args) {
		UserService  userService=new UserServiceProxyImpl();
		userService.say();
		
	
	}
}
