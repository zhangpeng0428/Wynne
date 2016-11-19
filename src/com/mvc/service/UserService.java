package com.mvc.service;

import java.util.List;

import com.mvc.model.User;

/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��15�� ����10:24:00  
 */
public interface UserService {

	public User findById(String id);
	public List<User> findByIds(String userids);
	public boolean create(User user);
	public boolean update(User user);
	public int delete(String idValues);
}
