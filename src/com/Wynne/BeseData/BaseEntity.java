package com.Wynne.BeseData;

import java.io.Serializable;

public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String createtime;
	
	private String uodatetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUodatetime() {
		return uodatetime;
	}

	public void setUodatetime(String uodatetime) {
		this.uodatetime = uodatetime;
	}
	
	
}
