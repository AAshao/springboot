package com.ss.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取 application.properties文件中的内容；
 *  
 *	@author huanhongzhao
 *	@date 2018年9月9日 上午8:40:14 
 *
 */
@Component
public class PropertiesConfig {

	@Value("${server.port}")
	private Integer port;
	
	@Value("${server.tomcat.accesslog.enabled}")
	private String enabled;

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	

	
	
	
}
