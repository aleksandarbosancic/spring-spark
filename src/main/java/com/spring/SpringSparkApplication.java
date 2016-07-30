package com.spring;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import spark.servlet.SparkFilter;

@SpringBootApplication
public class SpringSparkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSparkApplication.class, args);
	}
    
    @Bean
    public FilterRegistrationBean sparkFilterFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        EnumSet<DispatcherType> NON_ASYNC_DISPATCHER_TYPES = EnumSet
            .of(DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.REQUEST);
        registration.setDispatcherTypes(NON_ASYNC_DISPATCHER_TYPES);
        registration.addUrlPatterns("/*");
        registration.setName("sparkFilter");
        registration.setFilter(sparkFilter());
        registration.setOrder(1);
        registration.addInitParameter("applicationClass", "com.spring.spark.SparkApplication");
        return registration;
    }

    @Bean
    public Filter sparkFilter() {
        SparkFilter sparkFilter = new SparkFilter();
        return sparkFilter;
    }
    
}
