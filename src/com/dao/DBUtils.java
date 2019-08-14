package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;

/**
 * 链接数据库和关闭资源
 * @author gy
 *
 */
public class DBUtils {
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	static{//只会执行一次，类加载时执行
		Properties pro = new Properties();//读取文件工具
		InputStream in;
		try {
			in = DBUtils.class.getResourceAsStream("jdbc.properties");
//			in = new FileInputStream(new File("jdbc.properties"));//文件字节输入流
			pro.load(in);//加载配置文件
			DRIVER = pro.getProperty("oracle.driver");
			URL = pro.getProperty("oracle.url");
			USER = pro.getProperty("oracle.username");
			PASSWORD = pro.getProperty("oracle.password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		DBUtils.getConn();
	}
}
