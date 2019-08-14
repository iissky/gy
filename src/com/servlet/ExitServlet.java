package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookies[] = req.getCookies();
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				if("username".equals(cookies[i].getName())){
					cookies[i].setMaxAge(0);
					resp.addCookie(cookies[i]);
				}
			}
		}
		req.getSession().removeAttribute("user");
		resp.sendRedirect("index.jsp");
	}
}
