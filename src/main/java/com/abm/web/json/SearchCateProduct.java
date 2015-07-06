package com.abm.web.json;

import java.io.Serializable;
import java.math.BigDecimal;

import com.abm.web.pojo.Product;

public class SearchCateProduct implements Serializable{
	private static final long serialVersionUID = 7697614791994370556L;
	private String fid;
	private String name;
	private String pic;
	private String desc;
	private int praise;
	private BigDecimal price;
	
	public SearchCateProduct(Product product){
		fid = product.getFid();
		name = product.getTitle();
		pic = product.getShowPics();
		desc = product.getDesc();
		price = product.getPrice();
		praise = product.getPraise();
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "SearchCateProduct [fid=" + fid + ", name=" + name + ", pic="
				+ pic + ", desc=" + desc + ", praise=" + praise + ", price="
				+ price + "]";
	}

}
