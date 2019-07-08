package com.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *  
 *	@author A_Ashao
 *	@date 2019年3月3日 下午1:29:00 
 *
 */
public class DynamicProxyHandler  implements InvocationHandler{

	private Object objectTarget;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("动态代理之前");
		method.invoke(objectTarget, args);
		System.out.println("动态代理之后");
		return null;
	}
	
	public Object getInstace(Object object){
		this.objectTarget=object;
		return Proxy.newProxyInstance(objectTarget.getClass().getClassLoader(), objectTarget.getClass().getInterfaces(), this);
	}
	
	
	
	

}
