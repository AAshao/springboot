package com.ss.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取init.properties文件中的内容
 *  
 *	@author huanhongzhao
 *	@date 2018年9月9日 上午8:41:15 
 *
 */
@Configuration
@PropertySource(value="classpath:init.properties")
public class InitPropertiesConfig {


	
	
	
}
