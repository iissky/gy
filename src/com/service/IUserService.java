package com.service;

import java.util.List;

import com.pojo.PageBean;
import com.pojo.Userinfo;

public interface IUserService {
	/**
	 * ��ѯ�����û���Ϣ
	 * 
	 * @return
	 */
	public List<Userinfo> queryAllUser();

	public void delUser(String id);

	public void updateUser(String id, String uname, String upwd, String uphone, String udate, String usex,
			String ustatus) throws Exception;
	
	/***
	 * ��ҳ��ѯ
	 * @param pageindex
	 * @return
	 */
	public PageBean<Userinfo> queryByPage(int pageindex,int pagecount,String sql);
	
	public PageBean<Userinfo> queryUser(int pageindex);
	
	/**
	 * 
	 * @param name
	 * @return true:�ظ�   flase������
	 */
	public boolean isRename(String name);
}
