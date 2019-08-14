package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡҪ���ص��ļ�
		File f = new File("D:\\�μ�\\jQuery1.4_1.8_1.11�����ֲ�\\jQuery�����ĵ�1.4.1.zip");
		if (f.exists()) {
			FileInputStream fis = new FileInputStream(f);
			String filename = URLEncoder.encode(f.getName(), "utf-8"); // ��������ļ������غ����������
			// resp.setCharacterEncoding("utf-8");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			// resp.setCharacterEncoding("utf-8");
			resp.setHeader("Content-Disposition", "attachment; filename=" + filename + "");
			// ��ȡ��Ӧ�������������
			ServletOutputStream out = resp.getOutputStream();
			// ���
			out.write(b);
			out.flush();
			out.close();
			fis.close();
		}
	}
}
