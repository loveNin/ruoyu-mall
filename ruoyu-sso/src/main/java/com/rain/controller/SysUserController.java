package com.rain.controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rain.bean.dto.SysUserLoginDTO;
import com.rain.bean.dto.SysUserRegisterDTO;
import com.rain.constant.Constants;
import com.rain.service.SysUserService;

/**
 * 
 * @Title SysUserController.java
 * @Description 系统用户的请求处理控制器
 * @author rain
 * @date 2019年2月14日
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
	private final static Logger logger = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * * 用户单点登录（计划用redis做，由于外网原因暂定为token存到用户表）
	 * @param user 用户登录参数实体
	 * @return map 包含code（状态码：000000成功 999999失败）、msg（状态信息）、token（登录成功后的令牌）
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET,RequestMethod.OPTIONS })
	public Map<String, Object> login (@RequestBody SysUserLoginDTO userDTO){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = sysUserService.login(userDTO);
		} catch (Exception e) {
			logger.error("=====》用户登录出现异常：" + e);
			result.put("code", Constants.LOGIN_FAIL_CODE);
			result.put("msg", Constants.LOGIN_FAIL_MSG_SYSTEM);
			result.put("token", "");
		}
		return result;
	}
	
	/**
	 * 验证用户名是否已存在
	 * @param userName 用户名
	 * @return true 可用， false 不可用
	 */
	@RequestMapping(value = "/verifyUserName", method = { RequestMethod.POST, RequestMethod.GET,RequestMethod.OPTIONS })
	public boolean verifyUserName (@RequestParam(value = "userName", required = true) String userName){
		boolean result = false;//默认不可用
		try {
			result = sysUserService.verifyUserName(userName);
		} catch (Exception e) {
			logger.error("=====》验证用户名出现异常：" + e);
		}
		return result;
	}
	
	/**
	 * 根据手机号码发送验证码
	 * @param phoneNumber
	 * @return
	 */
	@RequestMapping(value = "/sendMobileCode", method = { RequestMethod.POST, RequestMethod.GET,RequestMethod.OPTIONS })
	public void sendMobileCode (@RequestParam(value = "phoneNumber", required = true) String phoneNumber){
		try {
			sysUserService.sendMobileCode(phoneNumber);
		} catch (Exception e) {
			logger.error("=====》根据手机号码发送验证码出现异常：" + e);
		}
	}
	
	/**
	 * 根据邮箱地址发送验证码
	 * @param phoneNumber
	 * @return
	 */
	@RequestMapping(value = "/sendMailCode", method = { RequestMethod.POST, RequestMethod.GET,RequestMethod.OPTIONS })
	public void sendMailCode (@RequestParam(value = "email", required = true) String email){
		try {
			sysUserService.sendMailCode(email);
		} catch (Exception e) {
			logger.error("=====》根据手机号码发送验证码出现异常：" + e);
		}
	}
	
	/**
	 * 根据手机号修改密码
	 * @param userDTO 修改密码所需参数：验证码，手机号码，新密码
	 * @return map 包含code（状态码：000000成功 999999失败）、msg（状态码信息）
	 */
	@RequestMapping(value = "/updatePassword", method = { RequestMethod.POST, RequestMethod.GET,RequestMethod.OPTIONS })
	public Map<String, Object> updatePassword (@RequestBody SysUserRegisterDTO userDTO){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = sysUserService.updatePassword(userDTO);
		} catch (Exception e) {
			logger.error("=====》根据手机号码修改密码出现异常：" + e);
			result.put("code", Constants.UPDATE_PASSWORD_FAIL_CODE);
			result.put("msg", Constants.UPDATE_PASSWORD_FAIL_MSG_SYSTEM);
		}
		return result;
	}
	
	/**
	 * @param userDTO 用户登录参数实体
	 * @return map 包含code（状态码：000000成功 999999失败）、msg（状态码信息）
	 */
	@RequestMapping(value = "/register", method = { RequestMethod.POST, RequestMethod.GET,RequestMethod.OPTIONS })
	public Map<String, Object> register (@RequestBody SysUserRegisterDTO userDTO){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = sysUserService.register(userDTO);
		} catch (Exception e) {
			logger.error("=====》用户注册出现异常：" + e);
			result.put("code", Constants.REGISTER_FAIL_CODE);
			result.put("msg", Constants.REGISTER_FAIL_MSG_SYSTEM);
		}
		return result;
	}
}