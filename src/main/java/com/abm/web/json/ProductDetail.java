package com.abm.web.json;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import com.abm.web.dao.global.Separator;
import com.abm.web.pojo.Product;
import com.alibaba.fastjson.annotation.JSONField;

public class ProductDetail implements Serializable{
	private static final long serialVersionUID = 7697614791994370556L;
	private String id;
	private String name;
	private String desc;
	private String[] upImgs;
	private BigDecimal price;
	private String[] detailPics;
	private String link;

	@JSONField(name="isPraise")
	private boolean userPraise = false;
	
	public ProductDetail(Product product){
		id = product.getFid();
		name = product.getTitle();
		desc = product.getDesc();
		price = product.getPrice();
		link = product.getBuyUrl();
		upImgs = product.getShowPics().split(Separator.COMMON);
		detailPics = product.getDetailPics().split(Separator.COMMON);
		userPraise = product.getUserPraise();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String[] getUpImgs() {
		return upImgs;
	}

	public void setUpImgs(String[] upImgs) {
		this.upImgs = upImgs;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String[] getDetailPics() {
		return detailPics;
	}

	public void setDetailPics(String[] detailPics) {
		this.detailPics = detailPics;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean getUserPraise() {
		return userPraise;
	}

	public void setUserPraise(boolean userPraise) {
		this.userPraise = userPraise;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", upImgs=" + Arrays.toString(upImgs) + ", price=" + price
				+ ", detailPics=" + Arrays.toString(detailPics) + ", link="
				+ link + ", userPraise=" + userPraise + "]";
	}

}
