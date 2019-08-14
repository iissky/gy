package com.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64.Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.fastinfoset.Decoder;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置字符集编码
		request.setCharacterEncoding("utf-8");
		
		//2.获取页面参数
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		//cookie演示
		Cookie c = new Cookie("pwd", pwd);
		c.setMaxAge(3600*24*7);//设置生命周期为一周
		response.addCookie(c);//把cookie放到相应对象中发送给前端
		
		if("管理员".equals(username)&&"admin".equals(pwd)){
			//登陆成功，将用户信息保存在session当中。
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			
			//判断是否记住密码
			String[] strs = request.getParameterValues("isRember");
			if(strs!=null){//记住密码
				Cookie cookie = new Cookie("username",URLEncoder.encode(username, "utf-8"));
				cookie.setMaxAge(3600*24*7);
				response.addCookie(cookie);
			}
			
			//将登陆次数累加
			ServletContext application = getServletContext();//这个对象等同于jsp中的application内置对象
			Integer count = (Integer) application.getAttribute("count");//null不能强转为基本数据类型
			if(count==null){
				count = 1;
			}else{
				count++;
			}
			application.setAttribute("count", count);
//			request.getRequestDispatcher("jsp/xinhua.jsp").forward(request, response);
			response.sendRedirect("jsp/xinhua.jsp");
		}else{
			response.sendRedirect("jsp/index.jsp?error=true");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
