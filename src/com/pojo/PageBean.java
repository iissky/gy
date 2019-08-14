package com.pojo;

import java.util.List;
/**
 * 分页的实体类
 * @author gy
 *
 * @param <T>
 */
public class PageBean<T> {
	List<T> list;//展示的数据集合
	int pageindex;//当前页数
	int pagecount;//每页条数
	int pagemax;//最大页数
	int totaldata;//原始数据条数
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getPagemax() {
		return pagemax;
	}
	public void setPagemax(int pagemax) {
		this.pagemax = pagemax;
	}
	public int getTotaldata() {
		return totaldata;
	}
	public void setTotaldata(int totaldata) {
		this.totaldata = totaldata;
	}
}
