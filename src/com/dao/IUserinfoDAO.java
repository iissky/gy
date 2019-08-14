package com.dao;

import java.util.List;

import com.pojo.Userinfo;

public interface IUserinfoDAO {
	public int addUser(Userinfo u);
	
	public int delUser(Userinfo u);
	
	public int updateUser(Userinfo u);
	
	public List<Userinfo> queryUser(String sql);
	
	public int getCount(String sql);
}
