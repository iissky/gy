package com.service;

import java.text.SimpleDateFormat;
import java.util.List;

import com.dao.IUserinfoDAO;
import com.dao.UserinfoDAO;
import com.pojo.PageBean;
import com.pojo.Userinfo;

public class UserService implements IUserService {
	IUserinfoDAO userDAO = new UserinfoDAO();

	@Override
	public List<Userinfo> queryAllUser() {
		return userDAO.queryUser("select * from userinfo");
	}

	@Override
	public void delUser(String id) {
		Userinfo u = new Userinfo();
		u.setUserid(Integer.valueOf(id));
		userDAO.delUser(u);
	}

	@Override
	public void updateUser(String id, String uname, String upwd, String uphone, String udate, String usex,
			String ustatus) throws Exception {
		Userinfo u = new Userinfo();
		u.setUserid(Integer.valueOf(id));
		u.setUname(uname);
		u.setUpwd(upwd);
		u.setUphone(uphone);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		u.setUdate(sdf.parse(udate));
		if ("ÄÐ".equals(usex)) {
			u.setUsex("1");
		} else if ("Å®".equals(usex)) {
			u.setUsex("2");
		} else {
			u.setUsex(usex);
		}
		u.setUstatus(ustatus);
		userDAO.updateUser(u);
	}

	@Override
	public PageBean<Userinfo> queryByPage(int pageindex, int pagecount, String sql) {
		PageBean<Userinfo> pb = new PageBean<Userinfo>();
		pb.setPageindex(pageindex);
		pb.setPagecount(pagecount);
		String count_sql = "select count(1) from (" + sql + ")";
		int totalcount = userDAO.getCount(count_sql);// ×ÜÊý
		pb.setTotaldata(totalcount);
		String data_sql = "select * from (select a.*,rownum num_ from (" + sql + ") a ) where num_>(" + pageindex
				+ "-1)*" + pagecount + " and num_<=" + pagecount + "*" + pageindex;
		pb.setList(userDAO.queryUser(data_sql));
		int pagemax = totalcount%pagecount==0?totalcount/pagecount:(totalcount/pagecount)+1;
		pb.setPagemax(pagemax);
		return pb;
	}

	@Override
	public PageBean<Userinfo> queryUser(int pageindex) {
		return queryByPage(pageindex,20,"select * from userinfo");
	}

	@Override
	public boolean isRename(String name) {
		List<Userinfo> list = userDAO.queryUser("select * from userinfo where uname='"+name+"'");
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
}
