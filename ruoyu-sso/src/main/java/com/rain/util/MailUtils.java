package com.rain.util;

import org.springframework.mail.SimpleMailMessage;

import com.rain.constant.Constants;

/**
 * 
 * @Title MailUtils.java
 * @Description 邮件发送工具类
 * @author rain
 * @date 2019年2月20日
 */
public class MailUtils {
	/**
	 * 生成邮件消息实体
	 * @param email
	 */
	public static SimpleMailMessage buildMailMessage(String email, String code) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(Constants.SEND_MAIL_USERNAME);
		message.setTo(email);
		message.setSubject(Constants.SEND_MAIL_TITLE);
		message.setText(Constants.SEND_MAIL_CONTENT_PREFIX + code + Constants.SEND_MAIL_CONTENT_SUFFIX);
		
		return message;
	}
}
