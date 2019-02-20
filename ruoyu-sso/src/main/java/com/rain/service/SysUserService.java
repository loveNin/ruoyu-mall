package com.rain.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rain.bean.dto.SysUserLoginDTO;
import com.rain.bean.dto.SysUserRegisterDTO;
import com.rain.bean.entity.SysUser;
import com.rain.constant.Constants;
import com.rain.dao.SysUserDao;
import com.rain.util.JsonUtils;
import com.rain.util.MailUtils;
import com.rain.util.Md5Utils;
import com.rain.util.TencentUtils;

/**
 * 
 * @Title SysUserService.java
 * @Description 系统用户的service
 * @author rain
 * @date 2019年2月14日
 */
@Service
public class SysUserService {
	private final static Logger logger = LoggerFactory.getLogger(SysUserService.class);
	
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private RedisService redisService;
	@Autowired
	private JavaMailSender javaMailSender;
	
	/**
	 * 用户单点登录
	 * @param user 用户登录参数实体
	 * @return map 包含code（状态码：000000成功 999999失败）、msg（状态码信息）、token（登录成功后的令牌）
	 * @throws NoSuchAlgorithmException 
	 */
	@Transactional
	public Map<String, Object> login(SysUserLoginDTO userDTO) throws NoSuchAlgorithmException {
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("=====》用户开始登录：username={}, password={}", userDTO.getUserName(), userDTO.getPassword());
		if(StringUtils.isEmpty(userDTO.getUserName()) || StringUtils.isEmpty(userDTO.getPassword())) {
			result.put("code", Constants.LOGIN_FAIL_CODE);
			result.put("msg", Constants.LOGIN_FAIL_MSG_NULL);
			result.put("token", "");
			return result;
		}
		SysUser user = sysUserDao.findByNameAndPassword(userDTO.getUserName(), Md5Utils.encodeByMd5(userDTO.getPassword()));
		if(user == null) {
			result.put("code", Constants.LOGIN_FAIL_CODE);
			result.put("msg", Constants.LOGIN_FAIL_MSG_ERROR);
			result.put("token", "");
			return result;
		}
		//如果之前已登录，删除之前的token
		Object oldToken = redisService.get(user.getUserName());
		if(!org.springframework.util.StringUtils.isEmpty(oldToken)) {
			redisService.del(new String[]{oldToken.toString()});
		}
		//生成新的token,并保存到redis用于验证token
		String token = UUID.randomUUID().toString();
		redisService.set(token, user.getUserName(), Constants.TOKEN_EXPIRE_SECOND);
		//以userName作为key，token为value记录最后一次该用户登录成功的token(同key此版本会覆盖值)，用于登录后清楚之前的key
		redisService.set(user.getUserName(), token);
		
		result.put("code", Constants.LOGIN_SUCCESS_CODE);
		result.put("msg", Constants.LOGIN_SUCCESS_MSG);
		result.put("token", token);
		logger.info("=====》用户登录成功：username={}, password={}, token={}", userDTO.getUserName(), userDTO.getPassword(), token);
		return result;
	}
	
	/**
	 * 验证用户名是否已存在
	 * @param userName 用户名
	 * @return true 可用， false 不可用
	 */
	public boolean verifyUserName(String userName) {
		logger.info("=====》验证用户名开始：username={}", userName);
		if(StringUtils.isEmpty(userName)) {
			return false;
		}
		SysUser user = sysUserDao.findByUserName(userName);
		if(user != null) {
			return false;
		}
		logger.info("=====》验证用户名可用：username={}", userName);
		return true;
	}
	
	/**
	 * 用户注册
	 * @param userDTO 用户登录参数实体
	 * @return map 包含code（状态码：000000成功 999999失败）、msg（状态码信息）
	 * @throws Exception 
	 */
	@Transactional
	public Map<String, Object> register(SysUserRegisterDTO userDTO) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("=====》用户开始注册：data={}", JsonUtils.obj2json(userDTO));
		String phoneNumber = userDTO.getPhoneNumber();
		String email = userDTO.getEmail();
		if(StringUtils.isEmpty(phoneNumber) && StringUtils.isEmpty(email)) {
			result.put("code", Constants.REGISTER_FAIL_CODE);
			result.put("msg", Constants.REGISTER_FAIL_MSG_NULL);
			return result;
		}
		
		//验证用户名是否符合要求
		Pattern userRex = Pattern.compile(Constants.REGEX_USERNAME);
		if(!userRex.matcher(userDTO.getUserName()).matches()) {
			result.put("code", Constants.REGISTER_FAIL_CODE);
			result.put("msg", Constants.REGISTER_FAIL_MSG_USERNAME);
			return result;
		}
		//验证密码是否符合要求
		Pattern pwdRex = Pattern.compile(Constants.REGEX_PASSWORD);
		if(!pwdRex.matcher(userDTO.getPassword()).matches()) {
			result.put("code", Constants.REGISTER_FAIL_CODE);
			result.put("msg", Constants.REGISTER_FAIL_MSG_PASSWORD);
			return result;
		}
		//验证用户名是否已注册
		SysUser user = sysUserDao.findByUserName(userDTO.getUserName());
		if(user != null) {
			result.put("code", Constants.REGISTER_FAIL_CODE);
			result.put("msg", Constants.REGISTER_FAIL_MSG_USERNAMEDUPLICATE);
			return result;
		}
		
		if(StringUtils.isNotEmpty(phoneNumber)) {//使用的是手机号注册
			//验证手机号是否已注册
			user = sysUserDao.findByPhoneNumber(phoneNumber);
			if(user != null) {
				result.put("code", Constants.REGISTER_FAIL_CODE);
				result.put("msg", Constants.REGISTER_FAIL_MSG_PHONEDUPLICATE);
				return result;
			}
			//验证验证码是否正确
			Object securityCode = redisService.get(phoneNumber);
			if(securityCode == null || !userDTO.getSecurityCode().equalsIgnoreCase(securityCode.toString())) {
				result.put("code", Constants.REGISTER_FAIL_CODE);
				result.put("msg", Constants.REGISTER_FAIL_MSG_CODEERROR);
				return result;
			}
			SysUser bean = new SysUser();
			bean.setUserId(UUID.randomUUID().toString());
			bean.setUserName(userDTO.getUserName());
			bean.setUserNick(Constants.INIT_USER_NICK);
			bean.setPassword(Md5Utils.encodeByMd5(userDTO.getPassword()));
			bean.setPhoneNumber(phoneNumber);
			sysUserDao.save(bean);
			
		}
		
		if(StringUtils.isNotEmpty(phoneNumber)) {//使用的是邮箱注册
			//验证邮箱是否已注册
			user = sysUserDao.findByEmail(email);
			if(user != null) {
				result.put("code", Constants.REGISTER_FAIL_CODE);
				result.put("msg", Constants.REGISTER_FAIL_MSG_MAILDUPLICATE);
				return result;
			}
			//验证验证码是否正确
			Object securityCode = redisService.get(email);
			if(securityCode == null || !userDTO.getSecurityCode().equalsIgnoreCase(securityCode.toString())) {
				result.put("code", Constants.REGISTER_FAIL_CODE);
				result.put("msg", Constants.REGISTER_FAIL_MSG_CODEERROR);
				return result;
			}
			SysUser bean = new SysUser();
			bean.setUserId(UUID.randomUUID().toString());
			bean.setUserName(userDTO.getUserName());
			bean.setUserNick(Constants.INIT_USER_NICK);
			bean.setPassword(Md5Utils.encodeByMd5(userDTO.getPassword()));
			bean.setEmail(email);
			sysUserDao.save(bean);
			
		}
		
		result.put("code", Constants.REGISTER_SUCCESS_CODE);
		result.put("msg", Constants.REGISTER_SUCCESS_MSG);
		logger.info("=====》用户注册成功：data={}", JsonUtils.obj2json(userDTO));
		return result;
	}
	/**
	 * 根据手机号码发送验证码
	 * @param phoneNumber
	 * @return
	 */
	@Transactional
	public void sendMobileCode (String phoneNumber){
		logger.info("=====》开始发送验证码：phoneNumber={}", phoneNumber);
		try {
			String securityCode = TencentUtils.sendSecurityCode(phoneNumber);
			logger.info("=====》发送验证码结束：securityCode={}", securityCode);
			//发送验证码之后存入redis
			redisService.set(phoneNumber, securityCode, Constants.MOBILECODE_EXPIRE_SECOND);
		} catch (Exception e) {
			logger.error("=====>发送短信验证码失败：", e);
		}
	}
	
	/**
	 * 根据邮箱发送验证码
	 * @param phoneNumber
	 */
	@Transactional
	public void sendMailCode (String email){
		logger.info("=====》开始发送验证码：email={}", email);
		try {
			//生成6位验证码
			String code = RandomStringUtils.randomNumeric(6);
			SimpleMailMessage msg = MailUtils.buildMailMessage(email, code);
			javaMailSender.send(msg);
			
			logger.info("=====》发送验证码结束：securityCode={}", code);
			//发送验证码之后存入redis
			redisService.set(email, code, Constants.MAILCODE_EXPIRE_SECOND);
		} catch (Exception e) {
			logger.error("=====>发送短信验证码失败：", e);
		}
	}
	
	/**
	 * 根据手机号修改密码
	 * @param userDTO 修改密码所需参数：验证码，手机号码，新密码
	 * @return map 包含code（状态码：000000成功 999999失败）、msg（状态码信息）
	 * @throws NoSuchAlgorithmException 
	 */
	@Transactional
	public Map<String, Object> updatePassword (SysUserRegisterDTO userDTO) throws NoSuchAlgorithmException{
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("=====》用户修改密码开始：password={}, phoneNumber={}, securityCode={}", userDTO.getPassword(), userDTO.getPhoneNumber(), userDTO.getSecurityCode());
		if(StringUtils.isEmpty(userDTO.getPassword()) || StringUtils.isEmpty(userDTO.getPhoneNumber()) || StringUtils.isEmpty(userDTO.getSecurityCode())) {
			result.put("code", Constants.UPDATE_PASSWORD_FAIL_CODE);
			result.put("msg", Constants.UPDATE_PASSWORD_FAIL_MSG_NULL);
			return result;
		}
		//验证密码是否符合要求
		Pattern pwdRex = Pattern.compile(Constants.REGEX_PASSWORD);
		if(!pwdRex.matcher(userDTO.getPassword()).matches()) {
			result.put("code", Constants.UPDATE_PASSWORD_FAIL_CODE);
			result.put("msg", Constants.UPDATE_PASSWORD_FAIL_MSG_PASSWORD);
			return result;
		}
		//验证验证码是否正确
		Object securityCode = redisService.get(userDTO.getPhoneNumber());
		if(securityCode == null || !userDTO.getSecurityCode().equalsIgnoreCase(securityCode.toString())) {
			result.put("code", Constants.UPDATE_PASSWORD_FAIL_CODE);
			result.put("msg", Constants.UPDATE_PASSWORD_FAIL_MSG_CODEERROR);
			return result;
		}
		SysUser user = sysUserDao.findByPhoneNumber(userDTO.getPhoneNumber());
		user.setPassword(Md5Utils.encodeByMd5(userDTO.getPassword()));
		sysUserDao.save(user);
		result.put("code", Constants.UPDATE_PASSWORD_SUCCESS_CODE);
		result.put("msg", Constants.UPDATE_PASSWORD_SUCCESS_MSG);
		logger.info("=====》用户修改密码成功：password={}, phoneNumber={}, securityCode={}", userDTO.getPassword(), userDTO.getPhoneNumber(), userDTO.getSecurityCode());
		
		return result;
	}
}