package com.funtl.hello.spring.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer// 启用服务链路追踪
@EnableEurekaClient// 启用Eureka客户端
public class ZipKinApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipKinApplication.class,args);
	}
}
