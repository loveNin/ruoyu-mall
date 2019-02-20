package com.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@ServletComponentScan("com.rain.filter")
public class RuoyuWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuoyuWebApplication.class, args);
	}

}

