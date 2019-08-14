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
		//1.�����ַ�������
		request.setCharacterEncoding("utf-8");
		
		//2.��ȡҳ�����
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		//cookie��ʾ
		Cookie c = new Cookie("pwd", pwd);
		c.setMaxAge(3600*24*7);//������������Ϊһ��
		response.addCookie(c);//��cookie�ŵ���Ӧ�����з��͸�ǰ��
		
		if("����Ա".equals(username)&&"admin".equals(pwd)){
			//��½�ɹ������û���Ϣ������session���С�
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			
			//�ж��Ƿ��ס����
			String[] strs = request.getParameterValues("isRember");
			if(strs!=null){//��ס����
				Cookie cookie = new Cookie("username",URLEncoder.encode(username, "utf-8"));
				cookie.setMaxAge(3600*24*7);
				response.addCookie(cookie);
			}
			
			//����½�����ۼ�
			ServletContext application = getServletContext();//��������ͬ��jsp�е�application���ö���
			Integer count = (Integer) application.getAttribute("count");//null����ǿתΪ������������
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
