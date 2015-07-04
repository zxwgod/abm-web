package com.abm.web.enums;

public enum RecommendType {

	GUIDE(1);
	
	private RecommendType(int code){
		this.code = code;
	}
	private int code;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
