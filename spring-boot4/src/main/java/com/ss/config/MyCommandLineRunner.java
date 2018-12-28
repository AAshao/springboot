package com.ss.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * spring容器初始化完成之后执行
 *  当有多个时，通过使用 @order 控制执行的顺序
 *	@author huanhongzhao
 *	@date 2018年9月9日 上午9:06:06 
 *
 */
@Component
@Order(value=1)
public class MyCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("========================1.spring容器被启动了====================="+args);
	}

	
}
