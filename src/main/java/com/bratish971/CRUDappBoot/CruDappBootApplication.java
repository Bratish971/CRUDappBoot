package com.bratish971.CRUDappBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class CruDappBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDappBootApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpFilter(){
		FilterRegistrationBean<HiddenHttpMethodFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new HiddenHttpMethodFilter());
		registrationBean.addUrlPatterns("/users/*");
		registrationBean.setOrder(2);

		return registrationBean;
	}
}
