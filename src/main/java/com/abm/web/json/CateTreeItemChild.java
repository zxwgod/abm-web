package com.abm.web.json;

import java.io.Serializable;

import com.abm.web.pojo.Category;

public class CateTreeItemChild  implements Serializable{

	private static final long serialVersionUID = 1037673782376499365L;

	private String id;
	private String name;
	private String pic;
	
	public CateTreeItemChild(){
		
	}
	
	public CateTreeItemChild(Category category){
		id = category.getFid();
		name = category.getName();
		pic = category.getShowUrl();
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

	@Override
	public String toString() {
		return "CateTreeItemChild [id=" + id + ", name=" + name + ", pic="
				+ pic + "]";
	}

	
}
