package com.abm.web.json;

import java.io.Serializable;
import java.util.List;

import com.abm.web.pojo.Category;
import com.google.common.collect.Lists;

public class CateTreeItem  implements Serializable{

	private static final long serialVersionUID = 1037673782376499365L;

	private String id;
	private String name;
	private String pic;
	private String picLink;
	private List<CateTreeItemChild> children = Lists.newArrayList();
	
	public CateTreeItem(){
		
	}
	
	public CateTreeItem(Category category){
		id = category.getFid();
		name = category.getName();
		pic = category.getShowUrl();
		picLink = category.getUrl();
		
		if(category.getChildren() != null){
			for(Category child : category.getChildren()){
				children.add(new CateTreeItemChild(child));
			}
		}
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	public List<CateTreeItemChild> getChildren() {
		return children;
	}

	public void setChildren(List<CateTreeItemChild> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "CateTreeItem [id=" + id + ", name=" + name + ", pic=" + pic
				+ ", picLink=" + picLink + ", children=" + children + "]";
	}
	
}
