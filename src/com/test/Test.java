package com.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {
	/**
	 *  //ȷ����ȡ����ҳ��ַ���˴�Ϊ�������ѻ�е����ʾ����ҳ
12         //��ַΪ        http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input
13         String strurl="http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input";
14         //����url��ȡ���Ķ���
15         try {
16             URL url=new URL(strurl);
17             //ͨ��url��������ҳ������
18             URLConnection conn=url.openConnection();
19             //ͨ������ȡ����ҳ���ص�����
20             InputStream is=conn.getInputStream();
21             
22             System.out.println(conn.getContentEncoding());
23             //һ�㰴�ж�ȡ��ҳ���ݣ����������ݷ���
24             //�����BufferedReader��InputStreamReader���ֽ���ת��Ϊ�ַ����Ļ�����
25             //����ת��ʱ����Ҫ��������ʽ����
26             BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
27         
28             //���ж�ȡ����ӡ
29             String line=null;
30             while((line=br.readLine())!=null){
31                 System.out.println(line);
32             }
33             
34             br.close();
35         } catch (Exception e) {
36             // TODO Auto-generated catch block
37             e.printStackTrace();
38         }
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "https://www.feixiaohao.com/";
		try {
			URL url = new URL(path);
			InputStream in = url.openConnection().getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
			
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
