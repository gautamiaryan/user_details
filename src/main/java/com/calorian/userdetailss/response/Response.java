package com.calorian.userdetailss.response;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;

	private String response;

	private Object data;

	public Response(Integer status, String response, Object data) {
		super();
		this.status = status;
		this.response = response;
		this.data = data;
	}

	public Response(Integer status, String response) {

		this.status = status;
		this.response = response;

	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
