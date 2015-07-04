package com.abm.web.request;

import java.io.Serializable;

public class BaseListReq implements Serializable{
	private static final long serialVersionUID = -730372183095241298L;
	protected int start;
	protected int length;
	protected String userId;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BaseListReq [start=" + start + ", length=" + length
				+ ", userId=" + userId + "]";
	}
	
}
