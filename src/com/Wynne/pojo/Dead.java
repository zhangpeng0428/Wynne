package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <一句话简述本类作用>
 * 逝者信息表 
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:10:09  
 */
public class Dead extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//逝者姓名
	private String name;
	//性别
	private Integer sex;
	//生辰
	private String brithday;
	//去世时期
	private String death;
	//灵牌ID
	private String tableId;
	//头像
	private String head;
	
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
}
