package com.common.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月15日 下午10:08:39  
 */
public final class JsonUtil {

	 private JsonUtil(){}  
     
	    /** 
	     * 对象转换成json字符串 
	     * @param obj  
	     * @return  
	     */  
	    public static String toJson(Object obj) {  
	        Gson gson = new Gson();  
	        return gson.toJson(obj);  
	    }  
	  
	    /** 
	     * json字符串转成对象 
	     * @param str   
	     * @param type 
	     * @return  
	     */  
	    public static <T> T fromJson(String str, Type type) {  
	        Gson gson = new Gson();  
	        return gson.fromJson(str, type);  
	    }  
	  
	    /** 
	     * json字符串转成对象 
	     * @param str   
	     * @param type  
	     * @return  
	     */  
	    public static <T> T fromJson(String str, Class<T> type) {  
	        Gson gson = new Gson();  
	        return gson.fromJson(str, type);  
	    }  
}
