package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//����һ�������������
			FileItemFactory factory = new DiskFileItemFactory();
			//���ݽ�����������һ���ļ��ϴ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			//�����ϴ��ļ����ܴ�С 4m
			upload.setSizeMax(4194304);
			//�ϴ�����ȥ�������󣬽������е����б�Ԫ��ȫ�������һ�����ϣ��ļ��ͷ��ļ�����������
			List<FileItem> files = upload.parseRequest(req);
			//��ȡ��Ŀ���ļ��еľ���·��,��������ϴ����ļ�
			String realPath = getServletContext().getRealPath("/upload");
			
			if(files!=null){
				for (FileItem fi : files) {
					//fi.isFormField()�жϸò����ǲ���һ����ͨ�ı�Ԫ��
					if(fi.isFormField()){//��һ����ͨԪ��
						//���������������
						System.out.println("name="+fi.getFieldName()+",value="+new String(fi.getString().getBytes("iso-8859-1"),"utf-8"));
					}else{//��һ���ļ�
						//����ͻ�������·�����ļ�����Ŀ����Ϊ�˻�ȡ���ļ����ļ���
//						File fullFile = new File(fi.getName());
						//���ݷ�������·�����ļ����Ϲ���Ҫ���浽���������ļ�����
			            File savedFile = new File(realPath, fi.getName());
			            //���ļ�д��
			            fi.write(savedFile);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("mess", "<script>alert('�ϴ��ɹ���')</script>");
		req.getRequestDispatcher("/jsp/fileupload.jsp").forward(req, resp);
	}
}
