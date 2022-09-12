package com.funtl.hello.spring.cloud.web.admin.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * service接口
 */
@FeignClient(value = "hello-spring-cloud-service-admin")
public interface AdminService {

	/**
	 * 发送消息至hello-spring-cloud-service-admin服务
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "hi",method = RequestMethod.GET)
	public String sayHi(@RequestParam(value = "message") String message);
}
