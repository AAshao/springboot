package com.model.test;

import com.model.proxy.DynamicProxyHandler;
import com.model.proxy.UserService;
import com.model.proxy.UserServiceActiveImpl;

public class DynaicProxyTest {

	public static void main(String[] args) {
		DynamicProxyHandler handler=new DynamicProxyHandler();
		UserService userService=(UserService) handler.getInstace(new UserServiceActiveImpl());
		userService.say();
	}
}
