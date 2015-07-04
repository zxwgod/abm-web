package com.abm.web.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class Rotate implements Serializable{
	
	private static final long serialVersionUID = 4233303062143933600L;
	@JSONField(serialize = false)
	private Integer id;
	@JSONField(name="img")
	private String pic;
	private String desc;
	@JSONField(name="link")
	private String url;
	@JSONField(serialize = false)
	private int weight;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
		return "Rotate [id=" + id + ", pic=" + pic + ", desc=" + desc
				+ ", url=" + url + ", weight=" + weight + ", createdTs="
				+ createdTs + ", updatedTs=" + updatedTs + "]";
	}

}
