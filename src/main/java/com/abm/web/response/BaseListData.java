package com.abm.web.response;

import java.util.List;

public class BaseListData<T>{
	private int count = 0;
	private int start = 0;
	private int length = 0;
	private List<T> data = null;
	
	public BaseListData(int count, int start, List<T> data) {
		super();
		this.count = count;
		if(data != null){
			length = data.size();
		}
		this.start = start + length;
		this.data = data;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "BaseListData [count=" + count + ", start=" + start
				+ ", length=" + length + ", data=" + data + "]";
	}
	
}
