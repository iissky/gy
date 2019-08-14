package com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

//@WebListener
public class MyRequestListener implements ServletRequestListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		System.out.println(req.getRemoteHost());
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("«Î«ÛΩ· ¯");
	}
}
