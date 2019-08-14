package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IUserService;
import com.service.UserService;

import sun.print.PrinterJobWrapper;

@WebServlet("/checkName")
public class CheckNameServlet extends HttpServlet{
	IUserService userSer = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		PrintWriter pw = resp.getWriter();//�ַ��������ǰ̨��Ӧ
		if(userSer.isRename(name)){//�ظ�
			pw.print("yes");//��Ҫ�������
		}else{//����
			pw.print("no");
		}
		pw.flush();
		pw.close();
	}
}
