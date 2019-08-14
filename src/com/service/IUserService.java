package com.service;

import java.util.List;

import com.pojo.PageBean;
import com.pojo.Userinfo;

public interface IUserService {
	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public List<Userinfo> queryAllUser();

	public void delUser(String id);

	public void updateUser(String id, String uname, String upwd, String uphone, String udate, String usex,
			String ustatus) throws Exception;
	
	/***
	 * 分页查询
	 * @param pageindex
	 * @return
	 */
	public PageBean<Userinfo> queryByPage(int pageindex,int pagecount,String sql);
	
	public PageBean<Userinfo> queryUser(int pageindex);
	
	/**
	 * 
	 * @param name
	 * @return true:重复   flase：可用
	 */
	public boolean isRename(String name);
}
