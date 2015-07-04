package com.abm.web.response;


public class BaseResp {
	private RespInfo status = RespInfo.SUCCESS;
	private Object data;
	
	public BaseResp(){
		
	}
	public BaseResp(RespInfo info){
		this.status = info;
	}
	public BaseResp(RespInfo info, Object data){
		this.status = info;
		this.data = data;
	}
	public RespInfo getStatus() {
		return status;
	}
	public void setStatus(RespInfo status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "BaseResp [status=" + status + ", data=" + data + "]";
	}
	
	
}
