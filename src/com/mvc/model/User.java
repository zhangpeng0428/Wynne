package com.mvc.model;


import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**  
 * <一句话简述本类作用> 
 * 用户表
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:13:46  
 */

@SuppressWarnings("serial")
public class User extends Model<User>{
	
	public static final User dao = new User();
	
	public User findLoginUser(String username, String userpassword) {
		String sql = "select * from user where name=? and pwd=?" ;
		return User.dao.findFirst(sql, username,userpassword);
	}
//	
//	public Page<User> paginate(int pageNumber, int pageSize) {
//		return paginate(pageNumber,pageSize,"select *","from sys_user order by order_id asc");
//	}
//	//身份類型  0：正常  1：會員
//	private String type;
//	//VIP開始時間
//	private Date vipstarttime;
//	//VIP結束時間
//	private Date vipendtime;
//	//紀念幣
//	private Integer money;
//	//頭像URL
//	private String head;
//	//用户昵称
//	private String name;
//	//密码（MD5）
//	private String pwd;
//	//邮箱
//	private String email;
//	//性别
//	private Integer sex;
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public Date getVipstarttime() {
//		return vipstarttime;
//	}
//
//	public void setVipstarttime(Date vipstarttime) {
//		this.vipstarttime = vipstarttime;
//	}
//
//	public Date getVipendtime() {
//		return vipendtime;
//	}
//
//	public void setVipendtime(Date vipendtime) {
//		this.vipendtime = vipendtime;
//	}
//
//	public Integer getMoney() {
//		return money;
//	}
//
//	public void setMoney(Integer money) {
//		this.money = money;
//	}
//
//	public String getHead() {
//		return head;
//	}
//
//	public void setHead(String head) {
//		this.head = head;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Integer getSex() {
//		return sex;
//	}
//
//	public void setSex(Integer sex) {
//		this.sex = sex;
//	}
}
