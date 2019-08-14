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
		// 读取要下载的文件
		File f = new File("D:\\课件\\jQuery1.4_1.8_1.11离线手册\\jQuery中文文档1.4.1.zip");
		if (f.exists()) {
			FileInputStream fis = new FileInputStream(f);
			String filename = URLEncoder.encode(f.getName(), "utf-8"); // 解决中文文件名下载后乱码的问题
			// resp.setCharacterEncoding("utf-8");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			// resp.setCharacterEncoding("utf-8");
			resp.setHeader("Content-Disposition", "attachment; filename=" + filename + "");
			// 获取响应报文输出流对象
			ServletOutputStream out = resp.getOutputStream();
			// 输出
			out.write(b);
			out.flush();
			out.close();
			fis.close();
		}
	}
}
