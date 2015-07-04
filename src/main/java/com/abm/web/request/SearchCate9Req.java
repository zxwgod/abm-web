package com.abm.web.request;


public class SearchCate9Req extends BaseListReq{
	private static final long serialVersionUID = -730372183095241298L;
	private String cateId;
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	@Override
	public String toString() {
		return "SearchCate9Req [cateId=" + cateId + ", start=" + start
				+ ", length=" + length + ", userId=" + userId + "]";
	}
	
	
}
