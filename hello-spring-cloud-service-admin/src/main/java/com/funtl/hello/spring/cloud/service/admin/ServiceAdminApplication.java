package com.funtl.hello.spring.cloud.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者
 */
@SpringBootApplication
@EnableEurekaClient// 启用eureka客户端(服务注册进eureka服务器)
public class ServiceAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAdminApplication.class,args);
	}
}
