package com.abm.web.enums;

public enum FavorTypeReq {

	PRODUCT(1),GUIDE(2);
	
	private FavorTypeReq(int code){
		this.code = code;
	}
	private int code;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public static FavorTypeReq codeOf(int code){
		for(FavorTypeReq type : FavorTypeReq.values()){
			if(code == type.getCode()){
				return type;
			}
		}
		return null;
	}
	
}
