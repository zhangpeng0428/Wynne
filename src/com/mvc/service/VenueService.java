package com.mvc.service;

import java.util.List;

import com.mvc.model.Venue;

/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��18�� ����10:02:40  
 */
public interface VenueService {

	public Venue findById(String id);
	public List<Venue> findByIds(String userids);
	public boolean create(Venue user);
	public boolean update(Venue user);
	public int delete(String idValues);
}
