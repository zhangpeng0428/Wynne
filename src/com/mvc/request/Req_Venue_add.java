package com.mvc.request;

import java.util.List;

import com.mvc.model.Dead;

/**  
 * <һ�仰������������> 
 * request �������
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��18�� ����9:42:46  
 */
public class Req_Venue_add {

	//�ش�����
	private FinalData finalData;
	//������ID
	private String userId;
	//�������ͣ�1 ���ˣ�2˫�� ��3 ����
	private String type;
	//�������ID
	private String styleId;
	//���ݴ������Id
	private String worshipId;
	//���߼��϶��󣬲ο��ĵ�Dead��
	private List<Req_Dead> deads;

	public FinalData getFinalData() {
		return finalData;
	}

	public void setFinalData(FinalData finalData) {
		this.finalData = finalData;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStyleId() {
		return styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public String getWorshipId() {
		return worshipId;
	}

	public void setWorshipId(String worshipId) {
		this.worshipId = worshipId;
	}

	public List<Req_Dead> getDeads() {
		return deads;
	}

	public void setDeads(List<Req_Dead> deads) {
		this.deads = deads;
	}
}
