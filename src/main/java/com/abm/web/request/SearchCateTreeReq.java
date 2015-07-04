package com.abm.web.request;


public class SearchCateTreeReq extends BaseListReq{
	private static final long serialVersionUID = -730372183095241298L;
	private String bigCate;
	private String smallCate;
	
	public String getBigCate() {
		return bigCate;
	}
	public void setBigCate(String bigCate) {
		this.bigCate = bigCate;
	}
	public String getSmallCate() {
		return smallCate;
	}
	public void setSmallCate(String smallCate) {
		this.smallCate = smallCate;
	}
	@Override
	public String toString() {
		return "SearchCateReq [bigCate=" + bigCate + ", smallCate=" + smallCate
				+ ", start=" + start + ", length=" + length + ", userId="
				+ userId + "]";
	}
	
}
