package com.rain.util;

import java.io.IOException;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.rain.constant.Constants;

/**
 * 
 * @Title TencentUtils.java
 * @Description 腾讯云工具类
 * @author rain
 * @date 2018年12月20日
 */
public class TencentUtils {
	private final static Logger logger = LoggerFactory.getLogger(TencentUtils.class);
	/**
	 * 通过腾讯云给手机发送短信验证码
	 * @param filePath 文件的全路径
	 * @return
	 * @throws HTTPException 
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public static String sendSecurityCode(String phoneNumber) throws JSONException, HTTPException, IOException {
		//生成6位验证码
		String code = RandomStringUtils.randomNumeric(6);
		logger.info("=====>开始发送短信验证码：phoneNumber={}， securityCode={}", phoneNumber, code);
	    String[] params = {code};//数组具体的元素个数和模板中变量个数必须一致
	    SmsSingleSender ssender = new SmsSingleSender(Constants.TXYUN_ACCESS_APPID, Constants.TXYUN_ACCESS_APPKEY);
	    SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, Constants.TXYUN_TEMPLATE_ID, 
	    		params, Constants.TXYUN_SIGN_CONTENT, "", "");  //签名参数未提供或者为空时，会使用默认签名发送短信
	    
	    logger.info("=====>已成功发送短信验证码，SmsSingleSenderResult返回：", result.toString());
		return code;
	}
}