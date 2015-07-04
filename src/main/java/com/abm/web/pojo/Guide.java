package com.abm.web.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class Guide implements Serializable{
	
	private static final long serialVersionUID = 4233303062143933600L;
	@JSONField(serialize = false)
	private Integer id;
	@JSONField(name = "id")
	private String fid;
	private String title;
	private String pic;
	private int praise;
	private int share;
	private String descHtml;
	@JSONField(serialize = false)
	private String createdTs;
	@JSONField(serialize = false)
	private String updatedTs;
	//用户是否收藏，手动设置
	@JSONField(name="isPraise")
	private boolean userPraise;

	@JSONField(serialize = false)
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public String getDescHtml() {
		return descHtml;
	}
	public void setDescHtml(String descHtml) {
		this.descHtml = descHtml;
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
	public boolean isUserPraise() {
		return userPraise;
	}
	public void setUserPraise(boolean userPraise) {
		this.userPraise = userPraise;
	}
	@Override
	public String toString() {
		return "Guide [id=" + id + ", fid=" + fid + ", title=" + title
				+ ", pic=" + pic + ", praise=" + praise + ", share=" + share
				+ ", descHtml=" + descHtml + ", createdTs=" + createdTs
				+ ", updatedTs=" + updatedTs + ", userPraise=" + userPraise
				+ "]";
	}

}
