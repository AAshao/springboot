package com.ss.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * bean在初始化之前开始执行
 *  
 *	@author huanhongzhao
 *	@date 2018年9月9日 上午9:00:37 
 *
 */
//@Component
public class MyBeanPostProcessor  implements  BeanPostProcessor{

//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName)
//			throws BeansException {
//		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(bean.getClass()+"：开始 被加载了;  beanName="+beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	
	
}
