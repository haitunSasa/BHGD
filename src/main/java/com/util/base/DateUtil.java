package com.util.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author 孙宇
 * 
 */
public class DateUtil {

	public static void main(String[] args) {

	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
		return "";
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, "yyyy-MM-dd hh:mm:ss");
	}

	/*验证是否为日期格式
	0-否
	1-YYYY
	2-YYYY MM
	3-YYYY MM DD
	*/
	public static int isValidDate(String dateStr, String dilimeter){
		if(dateStr == null) return 0;
		if(dilimeter == "" || dilimeter == null)dilimeter = "-";
		String tempy, tempm, tempd;
		if(dateStr.length()<4 || dateStr.length()> 10) return 0;
		String[] tempArray = dateStr.split(dilimeter);
		if(tempArray.length == 1 && tempArray[0].length() == 4){
			return 1;
		}
		if(tempArray.length == 2 && tempArray[0].length() == 4 && tempArray[1].length() == 2){
			int monthInt = Integer.parseInt(tempArray[1]);
			if(monthInt>0 && monthInt<13) return 2;
			return 0;
		}
		if(tempArray.length == 3 && tempArray[0].length() == 4 && tempArray[1].length() == 2 && tempArray[2].length() == 2){
			int monthInt = Integer.parseInt(tempArray[1]);
			if(monthInt>0 && monthInt<13) {
				int dayInt = Integer.parseInt(tempArray[2]);
				if(dayInt >0 && dayInt < 31)return 3;
			}
			return 0;
		}
		return 0;

	}


}
