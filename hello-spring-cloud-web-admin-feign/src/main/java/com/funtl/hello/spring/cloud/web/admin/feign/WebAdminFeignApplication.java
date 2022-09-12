package com.funtl.hello.spring.cloud.web.admin.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 服务消费者
 * Feign客户端(默认集成负载均衡)
 */
@SpringBootApplication
@EnableFeignClients// 启用Feign客户端
@EnableDiscoveryClient// 启用服务发现客户端
public class WebAdminFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebAdminFeignApplication.class,args);
	}
}
