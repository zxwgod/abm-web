package com.abm.web.enums;

public enum FavorType {

	RECOMMEND(1),PRODUCT(2),GUIDE(3);
	
	private FavorType(int code){
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
