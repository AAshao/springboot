package com.model.proxy;

public class UserServiceActiveImpl implements UserService
{

	@Override
	public void say() {
		System.out.println("hello 代理模式！！");
	}

}
