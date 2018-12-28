package com.ss.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitProperties {

	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "InitPropertiesConfig [name=" + name + ", age=" + age + "]";
	}
	
}
