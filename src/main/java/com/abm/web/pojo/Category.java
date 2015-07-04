package com.abm.web.pojo;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class Category implements Serializable{
	
	private static final long serialVersionUID = 4233303062143933600L;
	
	public static final int CATE9 = 1;
	public static final int CATE_FIRST = 2;
	public static final int CATE_SECOND = 3;
	
	private Integer id;
	private String fid;
	private String name;
	private String showUrl;
	private String url;
	private int type;
	private String parentFid;
	private String createdTs;
	private String updatedTs;
	//cateTree时会设置
	private List<Category> children = Lists.newArrayList();
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowUrl() {
		return showUrl;
	}
	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	public String getParentFid() {
		return parentFid;
	}
	public void setParentFid(String parentFid) {
		this.parentFid = parentFid;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", fid=" + fid + ", name=" + name
				+ ", showUrl=" + showUrl + ", url=" + url + ", type=" + type
				+ ", parentFid=" + parentFid + ", createdTs=" + createdTs
				+ ", updatedTs=" + updatedTs + ", children=" + children + "]";
	}

}
