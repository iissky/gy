package com.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {
	/**
	 *  //确定爬取的网页地址，此处为当当网搜机械表显示的网页
12         //网址为        http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input
13         String strurl="http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input";
14         //建立url爬取核心对象
15         try {
16             URL url=new URL(strurl);
17             //通过url建立与网页的连接
18             URLConnection conn=url.openConnection();
19             //通过链接取得网页返回的数据
20             InputStream is=conn.getInputStream();
21             
22             System.out.println(conn.getContentEncoding());
23             //一般按行读取网页数据，并进行内容分析
24             //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
25             //进行转换时，需要处理编码格式问题
26             BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
27         
28             //按行读取并打印
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
