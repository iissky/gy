package com.pojo;

import java.util.List;
/**
 * ��ҳ��ʵ����
 * @author gy
 *
 * @param <T>
 */
public class PageBean<T> {
	List<T> list;//չʾ�����ݼ���
	int pageindex;//��ǰҳ��
	int pagecount;//ÿҳ����
	int pagemax;//���ҳ��
	int totaldata;//ԭʼ��������
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
