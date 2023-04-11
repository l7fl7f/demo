/**
 * 
 */
package com.springboot.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Copyright 2020
 *
 * @Title: DateUtil
 * @Project: epguser
 * @Date: 2020-02-13 16:17
 * @Author: WeiR
 * @Description:  
 * TODO
 */
public class DateUtil {

	/**
	 * @Fields TIME_FORMAT : yyyy-MM-dd HH:mm:ss
	 */
	public static Format  TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * @Fields TIME_FORMAT2 : yyyyMMddHHmmss
	 */
	public static Format  TIME_FORMAT2 = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * @Auth: WeiR
	 * @Date: 2020-02-13 16:26
	 * @Description:<p>TODO</p>
	 * @return 日期格式yyyyMMddHHmmss
	 */
	public static String getDateString2(){
		return TIME_FORMAT2.format(new Date());
	}
}
