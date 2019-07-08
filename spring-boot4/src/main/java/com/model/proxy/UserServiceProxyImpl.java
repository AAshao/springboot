package com.model.proxy;

public class UserServiceProxyImpl implements UserService{

	private UserServiceActiveImpl userServiceActiveImpl;
	
	public UserServiceProxyImpl(){
		userServiceActiveImpl=new UserServiceActiveImpl();
	}
	@Override
	public void say() {
		System.out.println("before ...");
		
		userServiceActiveImpl.say();
		
		System.out.println("after ...");
	}

}
