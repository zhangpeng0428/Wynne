package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static int getYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}

	public static int getMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.MONTH) + 1;
	}

	public static int getDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DATE);
	}

	public static int getLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.get(Calendar.DATE);
	}

	public static String getFull() {
		Calendar calendar = Calendar.getInstance();
		return String.format("%1$tY-%<tm-%<te", calendar);
	}

	public static String getWeekMonth() {
		return String.format("%1$tYå¹?%<tmæœ?", Calendar.getInstance());
	}

	public static String getDate(Date date){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	public static String getDateTime(Date date){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	//formatæ ¼å¼ï¼?"yyyyå¹?-MMæœ?-ddæ—? HHæ—?:mmåˆ?:ssç§?"
	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	public static Date formatString(String str,String format) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	public static void main(String[] args) {
		System.out.println(getWeekMonth());
	}

}
