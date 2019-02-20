package com.rain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * @Title Md5Utils.java
 * @Description 阿里云工具类
 * @author rain
 * @date 2018年12月20日
 */
public class Md5Utils {
	public static String encodeByMd5(String password) throws NoSuchAlgorithmException {
		if(StringUtils.isEmpty(password)) {
			return null;
		}
		//确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		//将字符串转成字节数组
		byte[] pwdArr = password.getBytes();
		//使用指定字节更新摘要
		md5.update(pwdArr);
		//获取密文
		byte[] md5Arr = md5.digest();
		//16进制字符串
		String salt = "0123456789abcdef";
		char[] ch = salt.toCharArray();
		//创建一个32位长度的字节数组
		char[] chs = new char[md5Arr.length * 2];
		for (int i = 0, k = 0; i < md5Arr.length; i++) {
			byte temp = md5Arr[i];//摘要中的每个字节
			chs[k++] = ch[temp >>> 4 & 0xf];
			chs[k++] = ch[temp & 0xf];
		}
		return new String(chs);
	}
}