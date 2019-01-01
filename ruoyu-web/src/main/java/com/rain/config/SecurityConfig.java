package com.rain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//loginPage("/login")表示登录时跳转的页面，因为登录页面我们不需要登录认证，所以我们需要添加 permitAll() 方法。
		http.formLogin().loginPage("/login").loginProcessingUrl("/login/form")
			.failureUrl("/login-error").permitAll() // 表单登录，permitAll()表示这个不需要验证
			.and().authorizeRequests().anyRequest().authenticated().and().csrf().disable();
	}
}
