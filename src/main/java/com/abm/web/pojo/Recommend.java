package com.abm.web.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class Recommend implements Serializable{

	private static final long serialVersionUID = 4233303062143933600L;
	//以下数据从db取
	@JSONField(serialize = false)
	private Integer id;
	@JSONField(name="id")
	private String fid;
	@JSONField(serialize = false)
	private String recommendFid;
	@JSONField(serialize = false)
	private int recommendType;
	private String title;
	private String desc;
	@JSONField(serialize = false)
	private String userFid;
	private String pic;
	@JSONField(serialize = false)
	private String url;
	@JSONField(serialize = false)
	private int weight;
	@JSONField(serialize = false)
	private String createdTs;
	@JSONField(serialize = false)
	private String updatedTs;
	//从推荐内容表里获取
	private int praise;
	//以下数据从user表取
	@JSONField(name="user")
	private String userName;
	@JSONField(name="userHead")
	private String userHead;
	//以下数据根据是否用户收藏判断
	@JSONField(name="isPraise")
	private boolean userPraise;
	
	@JSONField(deserialize = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@JSONField(serialize = false)
	public String getUserFid() {
		return userFid;
	}
	public void setUserFid(String userFid) {
		this.userFid = userFid;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@JSONField(serialize = false)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@JSONField(serialize = false)
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@JSONField(serialize = false)
	public String getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(String createdTs) {
		this.createdTs = createdTs;
	}
	@JSONField(serialize = false)
	public String getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(String updatedTs) {
		this.updatedTs = updatedTs;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserHead() {
		return userHead;
	}
	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
	@JSONField(serialize = false)
	public String getRecommendFid() {
		return recommendFid;
	}
	public void setRecommendFid(String recommendFid) {
		this.recommendFid = recommendFid;
	}
	@JSONField(serialize = false)
	public int getRecommendType() {
		return recommendType;
	}
	public void setRecommendType(int recommendType) {
		this.recommendType = recommendType;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public boolean isUserPraise() {
		return userPraise;
	}
	public void setUserPraise(boolean userPraise) {
		this.userPraise = userPraise;
	}
	@Override
	public String toString() {
		return "Recommend [id=" + id + ", fid=" + fid + ", recommendFid="
				+ recommendFid + ", recommendType=" + recommendType
				+ ", title=" + title + ", desc=" + desc + ", userFid="
				+ userFid + ", pic=" + pic + ", url=" + url + ", weight="
				+ weight + ", createdTs=" + createdTs + ", updatedTs="
				+ updatedTs + ", praise=" + praise + ", userName=" + userName
				+ ", userHead=" + userHead + ", userPraise=" + userPraise + "]";
	}

}
