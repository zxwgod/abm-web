package com.abm.web.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 4233303062143933600L;
	private Integer id;
	private String fid;
	private int praise;
	private String url;
	private String buyUrl;
	private BigDecimal price;
	private String title;
	private String showPics;
	private String detailPics;
	private String desc;
	private String cate1Fid;
	private String cate2Fid;
	private String createdTs;
	private String updatedTs;
	
	//以下数据由读取收藏表设置
	private boolean userPraise = false;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBuyUrl() {
		return buyUrl;
	}
	public void setBuyUrl(String buyUrl) {
		this.buyUrl = buyUrl;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShowPics() {
		return showPics;
	}
	public void setShowPics(String showPics) {
		this.showPics = showPics;
	}
	public String getDetailPics() {
		return detailPics;
	}
	public void setDetailPics(String detailPics) {
		this.detailPics = detailPics;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCate1Fid() {
		return cate1Fid;
	}
	public void setCate1Fid(String cate1Fid) {
		this.cate1Fid = cate1Fid;
	}
	public String getCate2Fid() {
		return cate2Fid;
	}
	public void setCate2Fid(String cate2Fid) {
		this.cate2Fid = cate2Fid;
	}
	public String getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(String createdTs) {
		this.createdTs = createdTs;
	}
	public String getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(String updatedTs) {
		this.updatedTs = updatedTs;
	}
	public boolean getUserPraise() {
		return userPraise;
	}
	public void setUserPraise(boolean userPraise) {
		this.userPraise = userPraise;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", fid=" + fid + ", praise=" + praise
				+ ", url=" + url + ", buyUrl=" + buyUrl + ", price=" + price
				+ ", title=" + title + ", showPics=" + showPics
				+ ", detailPics=" + detailPics + ", desc=" + desc
				+ ", cate1Fid=" + cate1Fid + ", cate2Fid=" + cate2Fid
				+ ", createdTs=" + createdTs + ", updatedTs=" + updatedTs
				+ ", userPraise=" + userPraise + "]";
	}

}
