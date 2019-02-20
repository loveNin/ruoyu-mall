package com.rain.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rain.filter.TokenExperiFilter;

/**
 * 
 * @Title FilterConfig.java
 * @Description 过滤器的config(spring是配置在web.xml)，此类也可以省略，通过在Filter类上添加@WebFilter并在启动类上添加@ServletComponentScan实现
 * @author rain
 * @date 2019年2月19日
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean registFilter() {
		FilterRegistrationBean register = new FilterRegistrationBean();
		
		register.setFilter(new TokenExperiFilter());
		register.addUrlPatterns("/*");
		register.setName("tokenExperiFilter");
		register.setOrder(2);
		
		return register;
	}
}