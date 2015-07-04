package com.abm.web.request;

import java.io.Serializable;

public class PraiseRecommendReq implements Serializable{
	private static final long serialVersionUID = -730372183095241298L;
	private String recommendId;
	private int operate;
	private String userId;
	public String getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}
	public int getOperate() {
		return operate;
	}
	public void setOperate(int operate) {
		this.operate = operate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "PraiseRecommendReq [recommendId=" + recommendId + ", operate="
				+ operate + ", userId=" + userId + "]";
	}
	
}
