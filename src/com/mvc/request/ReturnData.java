package com.mvc.request;

import java.util.List;

/**  
 * <һ�仰������������> 
 * 
 * �ӿڷ������ݶ���
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��18�� ����9:46:32  
 */
public class ReturnData {

	private Integer code;
	
	private String msg;
	
	private Object data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
