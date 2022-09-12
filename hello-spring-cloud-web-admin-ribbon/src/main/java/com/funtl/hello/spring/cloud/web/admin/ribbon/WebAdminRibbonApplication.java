package com.funtl.hello.spring.cloud.web.admin.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务消费者
 * Ribbon模式
 */
@SpringBootApplication
@EnableDiscoveryClient // 启用服务发现客户端
public class WebAdminRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAdminRibbonApplication.class,args);
	}
}
