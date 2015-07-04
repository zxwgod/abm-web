package com.abm.web.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

public class HotProduct implements Serializable{

	@JSONField(serialize = false)
	private static final long serialVersionUID = 4233303062143933600L;
	//以下数据从db取
	@JSONField(serialize = false)
	private Integer id;
	private String pic;
	@JSONField(name="id")
	private String productFid;
	private String desc;
	@JSONField(serialize = false)
	private String createdTs;
	@JSONField(serialize = false)
	private String updatedTs;
	
	//以下数据从product表取
	private BigDecimal price;
	private int praise;
	
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public String getProductFid() {
		return productFid;
	}
	public void setProductFid(String productFid) {
		this.productFid = productFid;
	}
	@Override
	public String toString() {
		return "HotProduct [id=" + id + ", pic=" + pic + ", productFid="
				+ productFid + ", desc=" + desc + ", createdTs=" + createdTs
				+ ", updatedTs=" + updatedTs + ", price=" + price + ", praise="
				+ praise + "]";
	}

}
