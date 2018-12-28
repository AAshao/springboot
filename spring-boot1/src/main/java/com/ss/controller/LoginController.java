package com.ss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ss.entity.User;

@Controller
@RequestMapping("toLogin")
public class LoginController {

	/**
	 * 用户登陆
	 */
	@RequestMapping("login")
	public String login(User user,Model model,String password,HttpSession session){
		if(!"admin".equals(user.getUsername())){
			model.addAttribute("errorUserName", "用户名不正确");
			return "forward:/index.jsp";
		}else if(!"123456".equals(password)){
			model.addAttribute("errorPassword", "密码不正确");
			return "forward:/index.jsp";
		}
		session.setAttribute("user", user);
		return "redirect:/user/toUser";
	}
	//王博，yang gong
	
}
