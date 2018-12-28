package com.ss.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
/**
 * 异常处理配置类
 *  
 *	@author huanhongzhao
 *	@date 2018年8月17日 上午11:03:39 
 *
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar{

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage e404=new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
		ErrorPage e500=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
		registry.addErrorPages(e404,e500);
	}

}
