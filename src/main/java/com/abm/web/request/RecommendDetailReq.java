package com.abm.web.request;

import java.io.Serializable;

public class RecommendDetailReq implements Serializable{
	private static final long serialVersionUID = -730372183095241298L;
	private String recommendId;
	private String userId;
	public String getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RecommendDetailReq [recommendId=" + recommendId + ", userId="
				+ userId + "]";
	}
	
}
