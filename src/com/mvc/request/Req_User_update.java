package com.mvc.request;
/**  
 * �༭�û���Ϣ
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��15�� ����9:36:12  
 */
public class Req_User_update{
	
	//�ش�����
	private FinalData finalData;
	//�ǳ�
	private String name;
	//����
	private String email;
	//ͷ��·��
	private String headId;
	//�Ա�0Ů 1��
	private Integer sex;
	
	private String userId;
	
	public FinalData getFinalData() {
		return finalData;
	}
	public void setFinalData(FinalData finalData) {
		this.finalData = finalData;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadId() {
		return headId;
	}
	public void setHeadId(String headId) {
		this.headId = headId;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
