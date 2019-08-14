package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.PageBean;
import com.pojo.Userinfo;
import com.service.IUserService;
import com.service.UserService;
@WebServlet("/user")
public class UserServlet extends HttpServlet{
	IUserService userSer = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		if("query".equals(type)){//查询用户
			//调用业务
			List<Userinfo> list = userSer.queryAllUser();
			req.setAttribute("list", list);//展示性数据放请求作用域，展示完就释放掉
			req.getRequestDispatcher("/jsp/xinhua.jsp").forward(req, resp);
			return;
		}
		
		if("del".equals(type)){//删除用户
			String id = req.getParameter("id");
			userSer.delUser(id);
			resp.sendRedirect("user?type=querybypage");
			return;
		}
		
		if("update".equals(type)){//修改用户
			System.out.println("============="+req.getParameter("uname"));
			String id = req.getParameter("id");
			String uname = req.getParameter("uname");
			String upwd = req.getParameter("upwd");
			String uphone = req.getParameter("uphone");
			String udate = req.getParameter("udate");
			String usex = req.getParameter("usex");
			String ustatus = req.getParameter("ustatus");
			
			try {
				userSer.updateUser(id, uname, upwd, uphone, udate, usex, ustatus);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect("user?type=querybypage");
			return;
		}
		
		if("querybypage".equals(type)){//分页查询
			String pageindex = req.getParameter("pageindex");
			int index = 0;
			if(pageindex==null){
				index = 1;
			}else{
				index = Integer.valueOf(pageindex);
			}
			PageBean<Userinfo> pb = userSer.queryUser(index);
			req.setAttribute("pb", pb);
			req.getRequestDispatcher("/jsp/xinhua.jsp").forward(req, resp);
			return;
		}
	}
}

















