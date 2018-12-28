package com.ss.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 主配置类
 *  
 *	@author huanhongzhao
 *	@date 2018年12月28日 上午10:50:38 
 *
 */
@Configuration
public class MySpringboootConfig  extends WebMvcConfigurationSupport{

	/**
	 * 拦截器配置
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}

	/**
	 * 静态资源处理映射
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
	}
	
	/**
	 * 消息转换器（Json格式的数据类型转换）
	 */
	@Override
	protected void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
	}
	
	
	
	

	
}
