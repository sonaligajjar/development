package com.example.SpringCRUD.Model;

import lombok.Data;
import java.io.Serializable;

@Data
public class CommonResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	private Object data;

	private Integer status;

	private Boolean flag;

	public CommonResponse() {
		super();
	}

	public CommonResponse(String message, Integer status) {
		super();
		this.message = message;
		this.status = status;
	}

	public CommonResponse(String message, Object data, Integer status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public CommonResponse(String message, Object data, Integer status, Boolean flag) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
		this.flag = flag;
	}
	
	public CommonResponse(String message, Integer status, Boolean flag) {
		super();
		this.message = message;
		this.status = status;
		this.flag = flag;
	}


}
