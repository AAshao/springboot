package com.ss.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ss.entity.ClassRoom;
import com.ss.entity.User;

@Controller
public class TestRestController {
	@RequestMapping("toHelloPage")
	public ModelAndView toHelloPage(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/hello");
		mav.addObject("name", "张三");
		List<String> str=new ArrayList<String>();
		str.add("1");
		str.add("2");
		str.add("3");
		str.add("4");
		mav.addObject("str", str);
		return mav;
	}
	
	@RequestMapping("toFormPage")
	public ModelAndView toFormPage(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/form");
		return mav;
	}
	@RequestMapping("saveForm")
	@ResponseBody
	public Map<String, Object> saveForm(ClassRoom cr){
		System.out.println(cr.getUserList());
		Map<String, Object>  map=new HashMap<String, Object>();
		map.put("ok", "ok");
		return map;
	}
	
	
	
	
}
