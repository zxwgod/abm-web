package com.abm.web.enums;

public enum PraiseType {

	PRAISE(1),UN_PRAISE(0);
	
	private PraiseType(int code){
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
