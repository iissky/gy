package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyContextListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//��������Դ�ĳ�ʼ��
		ServletContext application = sce.getServletContext();
		String path = application.getInitParameter("path");
		System.out.println("path="+path);
		application.setAttribute("path", path);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
