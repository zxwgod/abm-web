package com.abm.web.response;

import java.util.List;

import com.abm.web.json.CateTreeItem;

public class CateTreeData{
	private List<CateTreeItem> cateList = null;
	
	public CateTreeData(List<CateTreeItem> data) {
		super();
		cateList = data;
	}

	public List<CateTreeItem> getCateList() {
		return cateList;
	}

	public void setCateList(List<CateTreeItem> cateList) {
		this.cateList = cateList;
	}

	@Override
	public String toString() {
		return "Cate9ListData [cateList=" + cateList + "]";
	}
	
}
