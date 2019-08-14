package com.pojo;

import java.util.Date;
/**
 * 实体类：类名和表名队应   字段和属性对应
 * @author gy
 *
 */
public class Userinfo {
	private int userid;
	private String uname;
	private String upwd;
	private String uphone;
	private Date udate;
	private String usex;
	private String ustatus;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}
	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", uname=" + uname + ", upwd=" + upwd + ", uphone=" + uphone + ", udate="
				+ udate + ", usex=" + usex + ", ustatus=" + ustatus + "]";
	}
}
