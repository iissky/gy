package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//@WebListener
public class MySessionListener implements HttpSessionListener{
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//在线人数加一
		HttpSession session = se.getSession();
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//在线人数减一
	}
}
