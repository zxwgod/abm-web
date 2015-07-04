package com.abm.web.request;

import java.io.Serializable;

public class ProductDetailReq implements Serializable{
	private static final long serialVersionUID = -730372183095241298L;
	private String goodsId;
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
	@Override
	public String toString() {
		return "ProductDetailReq [goodsId=" + goodsId + ", userId=" + userId
				+ "]";
	}
	
}
