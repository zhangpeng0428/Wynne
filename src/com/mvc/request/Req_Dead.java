package com.mvc.request;
/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��20�� ����2:16:57  
 */
public class Req_Dead {
	
	private long id;
	//��������
	private String name;
	//�Ա�
	private Integer sex;
	//����
	private String brithday;
	//ȥ��ʱ��
	private String death;
	//����ID
	private String tableId;
	//ͷ��
	private String head;
	//ͷ��
	private String venueId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public String getDeath() {
		return death;
	}
	public void setDeath(String death) {
		this.death = death;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
