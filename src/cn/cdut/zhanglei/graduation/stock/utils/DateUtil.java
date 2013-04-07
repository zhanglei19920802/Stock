package cn.cdut.zhanglei.graduation.stock.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * @author zhanglei
 *
 */
public class DateUtil {
	
	/**
	 * 将Calendar对象进行格式化
	 * @param time
	 * @return
	 */
	public static String formatCalendar2String(Calendar time){
		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss",Locale.SIMPLIFIED_CHINESE);
		return sdf.format(calendar2Date(time));
	}
	
	/**
	 * 将Calendar转化为Date类型
	 * @param time
	 * @return
	 */
	public static Date calendar2Date(Calendar time){
		return time.getTime();
	}
	
	/**
	 * 将Date类型格式化成字符串
	 * @param time
	 * @return
	 */
	public static String formatDate2String(Date time){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss",Locale.SIMPLIFIED_CHINESE);
		return sdf.format(time);
	}
}
