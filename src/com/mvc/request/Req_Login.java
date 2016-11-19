package com.mvc.request;
/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月15日 下午9:36:12  
 */
public class Req_Login{
	
	//必传参数
	private FinalData finalData;

	//用户名
	private String user;
	
	//密码
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
