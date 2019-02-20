package com.rain.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.rain.constant.Constants;
import com.rain.service.RedisService;

/**
 * 
 * @Title TokenExperiFilter.java
 * @Description 验证token
 * @author rain
 * @date 2019年2月18日
 */
public class TokenExperiFilter implements Filter{
	
	@Autowired
	private RedisService redisService;
	
	private String[] allowUrls = new String[] {Constants.USER_LOGIN_URL, Constants.USER_REGIST_URL, Constants.SEND_MOBILECODE_URL
			, Constants.SEND_MAILCODE_URL, Constants.UPDATE_PASSWORD_URL};
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURL().toString();
		if(urlIsAllow(url)) {
			//登录请求不进行验证
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		String token = request.getParameter("token");
		
		if(StringUtils.isNotEmpty(token) && !org.springframework.util.StringUtils.isEmpty(redisService.get(token))) {
			//每次请求后重置token过期时间
			redisService.expire(token, Constants.TOKEN_EXPIRE_SECOND);
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		//未通过验证则返回自定义响应
		response.sendError(Constants.HTTP_SESSIONOUT_CODE, Constants.HTTP_SESSIONOUT_MSG);
	}

	@Override
	public void destroy() {
		
	}
	
	/**
	 * 判断url是否在允许通过的urls中
	 * @return
	 */
	private boolean urlIsAllow(String url) {
		for (int i = 0; i < allowUrls.length; i++) {
			String allowUrl = allowUrls[i];
			if(url.endsWith(allowUrl)) {
				return true;
			}
		}
		return false;
	}
}
