package com.abm.web.request;

import java.io.Serializable;

public class FavorProductReq implements Serializable{
	private static final long serialVersionUID = -730372183095241298L;
	private String goodsId;
	private int operate;
	private String userId;
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getOperate() {
		return operate;
	}
	public void setOperate(int operate) {
		this.operate = operate;
	}
	@Override
	public String toString() {
		return "FavorProductlReq [goodsId=" + goodsId + ", operate=" + operate
				+ ", userId=" + userId + "]";
	}
	
}
