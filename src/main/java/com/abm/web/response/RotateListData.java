package com.abm.web.response;

import java.util.List;

import com.abm.web.pojo.Rotate;

public class RotateListData{
	private int count;
	private List<Rotate> imgList = null;
	
	public RotateListData(List<Rotate> data) {
		super();
		if(data != null){
			count = data.size();
		}
		this.imgList = data;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Rotate> getImgList() {
		return imgList;
	}
	public void setImgList(List<Rotate> imgList) {
		this.imgList = imgList;
	}

	@Override
	public String toString() {
		return "RotateListData [count=" + count + ", imgList=" + imgList + "]";
	}

}
