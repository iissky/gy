package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/jsp/*")// "/*"表示拦截所有请求
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("我是过滤器");
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("user");
		
		String loginpath = req.getServletContext().getInitParameter("loginpath");//从全局拿到路径
		if(username==null){//没有登录
			resp.sendRedirect(loginpath);
			return;
		}
		arg2.doFilter(arg0, arg1);//继续发送请求
	}

}
