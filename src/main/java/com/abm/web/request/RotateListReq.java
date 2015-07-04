package com.abm.web.request;

import java.io.Serializable;

public class RotateListReq implements Serializable{
	private static final long serialVersionUID = -730372183095241298L;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RotateListReq [userId=" + userId + "]";
	}
	
}
