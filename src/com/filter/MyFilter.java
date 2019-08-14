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
@WebFilter("/jsp/*")// "/*"��ʾ������������
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("���ǹ�����");
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("user");
		
		String loginpath = req.getServletContext().getInitParameter("loginpath");//��ȫ���õ�·��
		if(username==null){//û�е�¼
			resp.sendRedirect(loginpath);
			return;
		}
		arg2.doFilter(arg0, arg1);//������������
	}

}
