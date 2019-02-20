package com.rain.constant;

public class Constants {
	
	/** 初始化用户昵称 */
	public static final String INIT_USER_NICK = "安静的手风琴";
	
	/** 验证用户名的正则 */
	public static final String REGEX_USERNAME = "^[A-Za-z0-9]{3,10}$";
	/** 验证密码的正则 */
	public static final String REGEX_PASSWORD = "^[A-Za-z0-9]{8,15}$";
	
	/** 发送邮件的用户名 */
	public static final String SEND_MAIL_USERNAME = "若雨商城";
	/** 发送邮件的标题 */
	public static final String SEND_MAIL_TITLE = "若雨商城邮箱注册码";
	/** 发送邮件的内容前缀 */
	public static final String SEND_MAIL_CONTENT_PREFIX = "尊敬的用户，欢迎注册若雨商城！本次验证码为";
	/** 发送邮件的内容后缀 */
	public static final String SEND_MAIL_CONTENT_SUFFIX = "，请于5分钟内使用。";
	
	
	/** 用户token的过期时间（秒） */
	public static final long TOKEN_EXPIRE_SECOND = 1800;
	
	/** 手机验证码的过期时间（秒） */
	public static final long MOBILECODE_EXPIRE_SECOND = 60;
	
	/** 邮箱验证码的过期时间（秒） */
	public static final long MAILCODE_EXPIRE_SECOND = 3000;
	
	/** session过期时返回状态码 */
	public static final int HTTP_SESSIONOUT_CODE = 777;
	
	/** session过期时返回状态码 */
	public static final String HTTP_SESSIONOUT_MSG = "登录账户已过期，请重新登录！";
	
	/** 用户登录的URL（用于过滤器使用） */
	public static final String USER_LOGIN_URL = "/sys/user/login";
	/** 用户注册的URL（用于过滤器使用） */
	public static final String USER_REGIST_URL = "/sys/user/register";
	/** 用户发送手机号验证码的URL（用于过滤器使用） */
	public static final String SEND_MOBILECODE_URL = "/sys/user/sendMobileCode";
	/** 用户发送邮箱验证码的URL（用于过滤器使用） */
	public static final String SEND_MAILCODE_URL = "/sys/user/sendMailCode";
	/** 用户修改密码的URL（用于过滤器使用） */
	public static final String UPDATE_PASSWORD_URL = "/sys/user/updatePassword";
	
	/** 登陆成功标识状态码 */
	public static final String LOGIN_SUCCESS_CODE = "000000";
	/** 登陆成功状态码描述 */
	public static final String LOGIN_SUCCESS_MSG = "登录成功！";
	/** 登陆失败标识状态码 */
	public static final String LOGIN_FAIL_CODE = "999999";
	/** 登陆失败信息描述 */
	public static final String LOGIN_FAIL_MSG_SYSTEM = "系统异常，请稍后重试！";
	/** 登陆失败信息描述 */
	public static final String LOGIN_FAIL_MSG_NULL = "登录用户名或者密码为空！";
	/** 登陆失败信息描述 */
	public static final String LOGIN_FAIL_MSG_ERROR = "登录用户名或者密码错误！";
	
	/** 注册成功标识状态码 */
	public static final String REGISTER_SUCCESS_CODE = "000000";
	/** 注册成功状态码描述 */
	public static final String REGISTER_SUCCESS_MSG = "注册成功！";
	/** 注册失败标识状态码 */
	public static final String REGISTER_FAIL_CODE = "999999";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_SYSTEM = "系统异常，请稍后重试！";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_NULL = "必须使用邮箱或者手机号注册！";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_CODEERROR = "验证码输入错误，请重试！";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_USERNAMEDUPLICATE = "该用户名已经注册，请前往登录！";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_PHONEDUPLICATE = "该手机号码已经注册，请前往登录！";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_MAILDUPLICATE = "该邮箱已经注册，请前往登录！";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_USERNAME = "用户名不符合规范要求，请修改后重试！";
	/** 注册失败信息描述 */
	public static final String REGISTER_FAIL_MSG_PASSWORD = "密码不符合规范要求，请修改后重试！";
	
	/** 修改密码成功标识状态码 */
	public static final String UPDATE_PASSWORD_SUCCESS_CODE = "000000";
	/** 修改密码成功状态码描述 */
	public static final String UPDATE_PASSWORD_SUCCESS_MSG = "修改密码成功！";
	/** 修改密码失败标识状态码 */
	public static final String UPDATE_PASSWORD_FAIL_CODE = "999999";
	/** 修改密码失败信息描述 */
	public static final String UPDATE_PASSWORD_FAIL_MSG_SYSTEM = "系统异常，请稍后重试！";
	/** 修改密码失败信息描述 */
	public static final String UPDATE_PASSWORD_FAIL_MSG_NULL = "密码、手机号或验证码为空！";
	/** 修改密码失败信息描述 */
	public static final String UPDATE_PASSWORD_FAIL_MSG_CODEERROR = "手机验证码输入错误，请重试！";
	/** 修改密码失败信息描述 */
	public static final String UPDATE_PASSWORD_FAIL_MSG_PASSWORD = "密码不符合规范要求，请修改后重试！";
	
	/** 腾讯云短信API服务应用App ID */
	public static final int TXYUN_ACCESS_APPID = 1400184318;
	/** 腾讯云短信API服务应用App Key */
	public static final String TXYUN_ACCESS_APPKEY = "2bd0830cc7113c993d273b1f50936883";
	/** 腾讯云短信API服务应用短信正文模板ID */
	public static final int TXYUN_TEMPLATE_ID = 278784;
	/** 腾讯云短信API服务应用短信签名内容 */
	public static final String TXYUN_SIGN_CONTENT = "若雨商城";
	
	
}