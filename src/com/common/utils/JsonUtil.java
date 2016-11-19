package com.common.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;

/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��15�� ����10:08:39  
 */
public final class JsonUtil {

	 private JsonUtil(){}  
     
	    /** 
	     * ����ת����json�ַ��� 
	     * @param obj  
	     * @return  
	     */  
	    public static String toJson(Object obj) {  
	        Gson gson = new Gson();  
	        return gson.toJson(obj);  
	    }  
	  
	    /** 
	     * json�ַ���ת�ɶ��� 
	     * @param str   
	     * @param type 
	     * @return  
	     */  
	    public static <T> T fromJson(String str, Type type) {  
	        Gson gson = new Gson();  
	        return gson.fromJson(str, type);  
	    }  
	  
	    /** 
	     * json�ַ���ת�ɶ��� 
	     * @param str   
	     * @param type  
	     * @return  
	     */  
	    public static <T> T fromJson(String str, Class<T> type) {  
	        Gson gson = new Gson();  
	        return gson.fromJson(str, type);  
	    }  
}
