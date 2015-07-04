package com.abm.web.response;

import java.util.List;

import com.abm.web.json.Cate9Item;

public class Cate9ListData{
	private List<Cate9Item> cateList = null;
	
	public Cate9ListData(List<Cate9Item> data) {
		super();
		cateList = data;
	}

	public List<Cate9Item> getCateList() {
		return cateList;
	}

	public void setCateList(List<Cate9Item> cateList) {
		this.cateList = cateList;
	}

	@Override
	public String toString() {
		return "Cate9ListData [cateList=" + cateList + "]";
	}
	
}
