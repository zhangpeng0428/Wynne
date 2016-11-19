package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.mvc.model.Venue;
import com.mvc.service.VenueService;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月15日 下午10:26:15  
 */
public class VenueServiceImpl implements VenueService {

	@Override
	public boolean create(Venue venue) {
		return venue.save();
	}

	@Override
	public boolean update(Venue venue) {
		return venue.update();
	}

	@Override
	public Venue findById(String id) {
		return Venue.dao.findById(id);
	}

	@Override
	public List<Venue> findByIds(String userids) {
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
		String sql = "select * from venue where id in("+params+")";
		return Venue.dao.find(sql, paramObj.toArray());
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
		return Db.update("delete from venue where id in ("+params+")",paramObj.toArray());
	}
}
