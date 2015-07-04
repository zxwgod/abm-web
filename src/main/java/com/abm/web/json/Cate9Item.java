package com.abm.web.json;

import java.io.Serializable;

import com.abm.web.pojo.Category;

public class Cate9Item implements Serializable{

	private static final long serialVersionUID = 377180110729140321L;
	private String icon;
	private String name;
	private String catId;
	private String link;
	
	public Cate9Item(){
		
	}
	public Cate9Item(Category category) {
		super();
		this.icon = category.getShowUrl();
		this.name = category.getName();
		this.catId = category.getFid();
		this.link = category.getUrl();
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Cate9Item [icon=" + icon + ", name=" + name + ", catId="
				+ catId + ", link=" + link + "]";
	}
	
	
}
