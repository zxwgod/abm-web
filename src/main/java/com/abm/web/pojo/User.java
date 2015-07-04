package com.abm.web.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class User implements Serializable{
	
	private static final long serialVersionUID = 4233303062143933600L;
	@JSONField(serialize = false)
	private Integer id;
	@JSONField(serialize = false)
	private String wechatId;
	private String name;
	@JSONField(name = "headUrl")
	private String headPic;
	@JSONField(name = "userId")
	private String fid;
	@JSONField(serialize = false)
	private String createdTs;
	@JSONField(serialize = false)
	private String updatedTs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", wechatId=" + wechatId + ", name=" + name
				+ ", headPic=" + headPic + ", fid=" + fid + ", createdTs="
				+ createdTs + ", updatedTs=" + updatedTs + "]";
	}
	
}
