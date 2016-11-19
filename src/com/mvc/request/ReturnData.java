package com.mvc.request;

import java.util.List;

/**  
 * <一句话简述本类作用> 
 * 
 * 接口返回数据对象
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月18日 下午9:46:32  
 */
public class ReturnData {

	private Integer code;
	
	private String msg;
	
	private List<Object> data;

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

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
}
