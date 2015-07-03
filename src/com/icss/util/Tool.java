package com.icss.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class Tool {

	/**
	 * 获取系统当前时间,返回值类型为Timestamp
	 */
	public static Timestamp getCurrentTime(){
		Timestamp currentTime = null;
		//HH：24小时制时间显示  hh:12小时制时间显示
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String systemTime = f.format(date);
		currentTime = Timestamp.valueOf(systemTime);
		return currentTime;
	}
	/**
	 * 将时间戳(Timestamp)转化为字符串
	 * @param timestamp
	 * @return
	 */
	public static String timestampToString(Timestamp timestamp) {
		//HH：24小时制时间显示  hh:12小时制时间显示
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(timestamp.getTime());
		String time = f.format(date);
		return time;
	}
	/**
	 * 获得系统当前日期（2014-10-10）
	 * @return
	 */
	public static String getCurrentDate() {
		//HH：24小时制时间显示  hh:12小时制时间显示
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String time = f.format(date);
		return time;
	}
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}
}
