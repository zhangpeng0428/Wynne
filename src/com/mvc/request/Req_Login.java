package com.mvc.request;
/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��15�� ����9:36:12  
 */
public class Req_Login{
	
	//�ش�����
	private FinalData finalData;

	//�û���
	private String user;
	
	//����
	private String pwd;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public FinalData getFinalData() {
		return finalData;
	}

	public void setFinalData(FinalData finalData) {
		this.finalData = finalData;
	}
}
