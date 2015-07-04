package com.abm.web.enums;

public enum FavorProductType {

	FAVOR(1),UN_FAVOR(0);
	
	private FavorProductType(int code){
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
