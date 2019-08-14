package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.JsonDateFormat;
import com.pojo.Userinfo;
import com.service.IUserService;
import com.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@WebServlet("/jsonTest")
public class JsonServlet extends HttpServlet{
	IUserService userSer = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Userinfo> list = userSer.queryAllUser();
		//json格式中date转换为指定格式字符串
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonValueProcessor(Date.class, new JsonDateFormat());
		
		JSONArray json = JSONArray.fromObject(list,jsonconfig);
		PrintWriter out = resp.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
