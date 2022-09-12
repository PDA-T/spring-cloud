package com.funtl.hello.spring.cloud.web.admin.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Admin业务层
 */
@Service
public class AdminService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Admin控制层消息
	 * @param message
	 * @return
	 */
	public String sayHi(String message){
		/*
		 * 请求hello-spring-cloud-service-admin服务(通过服务名称在服务注册与发现中心获取ip端口)
		 * restTemplate通过Bean配置负载均衡,请求hello-spring-cloud-service-admin服务时(有多个)轮询调用
		 */
		return restTemplate.getForObject("http://hello-spring-cloud-service-admin/hi?message=" + message,String.class);
	}
}
