package com.rain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @Title CorsConfig.java
 * @Description 此配置类解决跨域问题，当前台发起复杂请求时，会先发一次OPTIONS探测请求，判断请求是否能被后台允许，如果不配置则前台的探测请求过不了，也不会再发起真正的复杂请求
 * @author rain
 * @date 2019年2月14日
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedHeaders("*").allowedMethods("GET", "POST", "DELETE", "PUT")
		.exposedHeaders("access-control-allow-headers", "access-control-allow-methods", "access-control-allow-origin", "access-control-max-age", "X-Frame-Options")
		.allowCredentials(false)
		.maxAge(3600);
	}
}