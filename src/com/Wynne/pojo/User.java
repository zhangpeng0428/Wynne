package com.Wynne.pojo;

import java.util.Date;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <һ�仰������������> 
 * �û���
 * @author ����   
 * @version ����ʱ�䣺2016��11��13�� ����4:13:46  
 */

public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//�������  0������  1�����T
	private String type;
	//VIP�_ʼ�r�g
	private Date vipstarttime;
	//VIP�Y���r�g
	private Date vipendtime;
	//�o���
	private Integer money;
	//�^��URL
	private String head;
	//�û��ǳ�
	private String name;
	//���루MD5��
	private String pwd;
	//����
	private String email;
	//�Ա�
	private Integer sex;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getVipstarttime() {
		return vipstarttime;
	}

	public void setVipstarttime(Date vipstarttime) {
		this.vipstarttime = vipstarttime;
	}

	public Date getVipendtime() {
		return vipendtime;
	}

	public void setVipendtime(Date vipendtime) {
		this.vipendtime = vipendtime;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}