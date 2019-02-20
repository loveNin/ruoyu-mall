package com.rain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @Title DateUtils.java
 * @Description 
 * @author rain
 * @date 2018年12月20日
 */
public class DateUtils {
	/**
	 * 获取默认格式的日期字符串
	 * @return
	 */
	public static String getDefaultFormatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		return sdf.format(date);
	}
	
	/**
	 * 获取指定格式的日期字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 获取昨天的时间字符串，以默认格式返回
	 * @return
	 */
	public static String getDefaultYesterdayFormatDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return getDefaultFormatDate(calendar.getTime());
	}
	
	/**
	 * 字符串转换成日期(不传入simpleDateFormat 默认格式为yyyy-MM-dd HH:mm:ss)
	 * @param str
	 * @param sdf
	 * @return
	 */
	public static Date str2Date(String str, String simpleDateFormat) {
		if (null == str || "".equals(str)) {
			return null;
		}
		if(StringUtils.isEmpty(simpleDateFormat)) {
			simpleDateFormat = "yyyy-MM-dd HH:mm:ss";
		}
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
			date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
