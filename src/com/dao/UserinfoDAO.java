package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Userinfo;

public class UserinfoDAO implements IUserinfoDAO {
	Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public int addUser(Userinfo u) {
		if (u != null) {
			try {
				conn = DBUtils.getConn();
				String sql = "insert into userinfo values(user_seq.nextval,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, u.getUname());
				ps.setString(2, u.getUpwd());
				ps.setString(3, u.getUphone());
				ps.setTimestamp(4, new Timestamp(u.getUdate().getTime()));// date类型转换timestamp类型
				ps.setString(5, u.getUsex());
				ps.setString(6, u.getUstatus());

				return ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeAll(conn, ps, rs);
			}
		}
		return 0;
	}

	@Override
	public int delUser(Userinfo u) {
		if (u != null && u.getUserid() != 0) {
			try {
				conn = DBUtils.getConn();
				String sql = "delete from userinfo where userid=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, u.getUserid());
				return ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeAll(conn, ps, rs);
			}
		}
		return 0;
	}

	@Override
	public int updateUser(Userinfo u) {
		if (u != null) {
			try {
				conn = DBUtils.getConn();
				String sql = "update userinfo set uname=?,upwd=?,uphone=?,udate=?,usex=?,ustatus=? where userid=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, u.getUname());
				ps.setString(2, u.getUpwd());
				ps.setString(3, u.getUphone());
				ps.setTimestamp(4, new Timestamp(u.getUdate().getTime()));// date类型转换timestamp类型
				ps.setString(5, u.getUsex());
				ps.setString(6, u.getUstatus());
				ps.setInt(7, u.getUserid());
				return ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeAll(conn, ps, rs);
			}
		}
		return 0;
	}

	@Override
	public List<Userinfo> queryUser(String sql) {
		List<Userinfo> list = new ArrayList<Userinfo>();
			try {
				conn = DBUtils.getConn();
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					Userinfo u = new Userinfo();
					u.setUserid(rs.getInt(1));
					u.setUname(rs.getString(2));
					u.setUpwd(rs.getString(3));
					u.setUphone(rs.getString(4));
					u.setUdate(rs.getTimestamp(5));
					u.setUsex(rs.getString(6));
					u.setUstatus(rs.getString(7));
					list.add(u);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeAll(conn, st, rs);
			}
		return list;
	}
	public static void main(String[] args) {
		IUserinfoDAO userDAO = new UserinfoDAO();
		List<Userinfo> list = userDAO.queryUser("select * from userinfo");
		for (Userinfo u : list) {
			System.out.println(u.toString());
		}
	}

	@Override
	public int getCount(String sql) {
		try {
			conn = DBUtils.getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(conn, st, rs);
		}
		return 0;
	}
}
