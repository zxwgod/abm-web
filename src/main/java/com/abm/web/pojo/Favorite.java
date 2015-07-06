package com.abm.web.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

public class Favorite implements Serializable{
	
	private static final long serialVersionUID = 4233303062143933600L;
	@JSONField(serialize = false)
	private transient Integer id;
	@JSONField(serialize = false)
	private String userFid;
	@JSONField(name = "praiseLinkId")
	private String favorFid;
	@JSONField(name = "praiseLink")
	private String favorUrl;
	@JSONField(name = "praisePic")
	private String favorPic;
	@JSONField(name = "praiseDesc")
	private String desc = "";
	@JSONField(name = "praiseType")
	private int type;
	@JSONField(serialize = false)
	private String createdTs = "";
	@JSONField(serialize = false)
	private String updatedTs = "";
	private String title;
	private BigDecimal price = BigDecimal.ZERO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserFid() {
		return userFid;
	}
	public void setUserFid(String userFid) {
		this.userFid = userFid;
	}
	public String getFavorFid() {
		return favorFid;
	}
	public void setFavorFid(String favorFid) {
		this.favorFid = favorFid;
	}
	public String getFavorUrl() {
		return favorUrl;
	}
	public void setFavorUrl(String favorUrl) {
		this.favorUrl = favorUrl;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public String getFavorPic() {
		return favorPic;
	}
	public void setFavorPic(String favorPic) {
		this.favorPic = favorPic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", userFid=" + userFid + ", favorFid="
				+ favorFid + ", favorUrl=" + favorUrl + ", favorPic="
				+ favorPic + ", desc=" + desc + ", type=" + type
				+ ", createdTs=" + createdTs + ", updatedTs=" + updatedTs
				+ ", title=" + title + ", price=" + price + "]";
	}

}
