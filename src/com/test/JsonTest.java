package com.test;

import java.util.List;

import com.dao.IUserinfoDAO;
import com.dao.UserinfoDAO;
import com.pojo.Userinfo;

import net.sf.json.JSONArray;

public class JsonTest {
	public static void main(String[] args) {
		IUserinfoDAO userDAO = new UserinfoDAO();
		List<Userinfo> list = userDAO.queryUser("select * from userinfo");
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
	}
}
