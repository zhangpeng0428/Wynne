package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.mvc.model.User;
import com.mvc.service.UserService;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月15日 下午10:26:15  
 */
public class UserServiceImpl implements UserService {

	@Override
	public boolean create(User user) {
		return user.save();
	}

	@Override
	public User findById(String id) {
		return User.dao.findById(id);
	}

	@Override
	public List<User> findByIds(String userids) {
		String[] ids = userids.split(",");
		String params = "";
		List<Object> paramObj = new ArrayList<Object>();
		for (String s:ids) {
			if ("".equals(params)){
				params="?";
				paramObj.add(s);
			}else{
				params=params+",?";
				paramObj.add(s);
			}
		}
		String sql = "select * from user where id in("+params+")";
		return User.dao.find(sql, paramObj.toArray());
	}

	@Override
	public boolean update(User user) {
		return user.update();
	}

	@Override
	public int delete(String idValues) {
		String[] ids = idValues.split(",");
		String params = "";
		List<Object> paramObj = new ArrayList<Object>();
		for (String s:ids) {
			if ("".equals(params)){
				params="?";
				paramObj.add(s);
			}else{
				params=params+",?";
				paramObj.add(s);
			}
		}
		return Db.update("delete from user where id in ("+params+")",paramObj.toArray());
	}
}
