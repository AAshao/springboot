package com.ss.spring_boot1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ss.entity.StudentInfo;
import com.ss.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class JuintTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void test(){
		List<StudentInfo> stus= studentService.getStudentInfo();
		System.out.println(stus);
		System.out.println("123123");
	}
	
	@Test
	public void saveStu(){
		
		org.springframework.context.ApplicationContext context= new ClassPathXmlApplicationContext("");
		context=new FileSystemXmlApplicationContext("");
		
	}
	//更新
	@Test
	public void updateTest(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userName","王立刚");
		map.put("userAge",28);
		map.put("id", 7);
		try {
			studentService.updateStu(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
