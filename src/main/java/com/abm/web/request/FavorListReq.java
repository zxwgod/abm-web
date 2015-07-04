package com.abm.web.request;

import java.io.Serializable;

public class FavorListReq implements Serializable{
	private static final long serialVersionUID = -730372183095241298L;
	private int type;
	private String userId;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "FavorListReq [type=" + type + ", userId=" + userId + "]";
	}
	
}
