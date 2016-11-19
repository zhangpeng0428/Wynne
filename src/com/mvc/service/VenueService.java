package com.mvc.service;

import java.util.List;

import com.mvc.model.Venue;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月18日 下午10:02:40  
 */
public interface VenueService {

	public Venue findById(String id);
	public List<Venue> findByIds(String userids);
	public boolean create(Venue user);
	public boolean update(Venue user);
	public int delete(String idValues);
}
