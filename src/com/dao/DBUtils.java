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
 * �������ݿ�͹ر���Դ
 * @author gy
 *
 */
public class DBUtils {
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	static{//ֻ��ִ��һ�Σ������ʱִ��
		Properties pro = new Properties();//��ȡ�ļ�����
		InputStream in;
		try {
			in = DBUtils.class.getResourceAsStream("jdbc.properties");
//			in = new FileInputStream(new File("jdbc.properties"));//�ļ��ֽ�������
			pro.load(in);//���������ļ�
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
