package com.mvc.request;
/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��22�� ����9:30:49  
 */
public class Req_Login {

	public FinalData finalData;
	
	public String user;
	
	public String pwd;

	public FinalData getFinalData() {
		return finalData;
	}

	public void setFinalData(FinalData finalData) {
		this.finalData = finalData;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
