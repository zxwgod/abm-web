package com.abm.web.json;

import java.io.Serializable;
import java.math.BigDecimal;

import com.abm.web.pojo.Product;

public class SearchCateProduct implements Serializable{
	private static final long serialVersionUID = 7697614791994370556L;
	private String id;
	private String name;
	private String desc;
	private int praise;
	private BigDecimal price;
	
	public SearchCateProduct(Product product){
		id = product.getFid();
		name = product.getTitle();
		desc = product.getDesc();
		price = product.getPrice();
		praise = product.getPraise();
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

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SearchCateTreeProduct [id=" + id + ", name=" + name + ", desc="
				+ desc + ", praise=" + praise + ", price=" + price + "]";
	}
}
