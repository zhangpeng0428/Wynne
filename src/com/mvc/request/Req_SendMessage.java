package com.mvc.request;
/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��20�� ����12:22:44  
 */
public class Req_SendMessage {

	public FinalData finalData;
	//����ID
	public String venueId;
	//��������
	public String content;
	//���ͣ�0�ο� 1ƽ̨�û� type==0ʱ���û�IDΪϵͳĬ���ο�ID��type==1ʱ���û�IDΪ��ǰ��½�û�ID
	public Integer type;
	//�û�ID
	public String userId;
	
	public FinalData getFinalData() {
		return finalData;
	}
	public void setFinalData(FinalData finalData) {
		this.finalData = finalData;
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
