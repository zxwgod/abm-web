package com.abm.web.response;

public class RespInfo {

	public static final RespInfo SUCCESS = new RespInfo(0,"成功");
	public static final RespInfo REQ_PARAM_ERROR = new RespInfo(1001,"请求参数有误");
	public static final RespInfo OBJECT_NOT_EXISTS_ERROR = new RespInfo(2001,"数据不存在");
	public static final RespInfo USER_NOT_EXISTS_ERROR = new RespInfo(2002,"用户不存在");
	public static final RespInfo PRODUCT_NOT_EXISTS_ERROR = new RespInfo(2003,"商品不存在");
	public static final RespInfo FAVORITE_NOT_EXISTS_ERROR = new RespInfo(2004,"收藏信息不存在");
	public static final RespInfo RECOMMEND_NOT_EXISTS_ERROR = new RespInfo(2005,"推荐信息不存在");
	public static final RespInfo FAVORITE_EXISTS_ERROR = new RespInfo(3002,"收藏信息已经存在");
	
	public RespInfo(){
		
	}
	public RespInfo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	@Override
	public String toString() {
		return "RespInfo [code=" + code + ", msg=" + msg + "]";
	}
	
}
