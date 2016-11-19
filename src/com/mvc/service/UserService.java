package com.mvc.service;

import java.util.List;

import com.mvc.model.User;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月15日 下午10:24:00  
 */
public interface UserService {

	public User findById(String id);
	public List<User> findByIds(String userids);
	public boolean create(User user);
	public boolean update(User user);
	public int delete(String idValues);
}
