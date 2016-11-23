package com.mvc.request;
/**  
 * 编辑用户信息
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月15日 下午9:36:12  
 */
public class Req_User_update{
	
	//必传参数
	private FinalData finalData;
	//昵称
	private String name;
	//邮箱
	private String email;
	//头像路径
	private String headId;
	//性别：0女 1男
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
