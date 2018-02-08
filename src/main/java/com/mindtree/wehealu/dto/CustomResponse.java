package com.mindtree.wehealu.dto;

public class CustomResponse {
	
	Object data;
	int error;
	String message;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CustomResponse [data=" + data + ", error=" + error + ", message=" + message + "]";
	}
	

}
