package com.ss.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ss.entity.User;
//implements HandlerInterceptor
public class LoginInterceptor extends HandlerInterceptorAdapter{

	private List<String> exceptUrls;
	
 	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url=request.getRequestURI().toString();
		System.out.println("请求的url地址为："+url);
		url=url.substring(request.getContextPath().length(),url.length());
		System.out.println(url);
		/**
		 * 不拦截的地址
		 */
		for(String exceptUrl:exceptUrls){
			if(url.equals(exceptUrl)){
				return true;
			}
		}
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null){
			System.out.println("用户没有登陆返回登陆页面");
			request.setAttribute("notLogin", "请登陆~~");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("返回视图前开始调用");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("处理完成开始调用。。。");
	}

	public List<String> getExceptUrls() {
		return exceptUrls;
	}

	public void setExceptUrls(List<String> exceptUrls) {
		this.exceptUrls = exceptUrls;
	}
	
}
