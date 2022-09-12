package com.funtl.hello.spring.cloud.service.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	// 获取yml配置端口
	@Value("${server.port}")
	private String port;

	/**
	 * 接收消息
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "hi",method = RequestMethod.GET)
	public String sayHi(String message){
		return String.format("Hi your message is:%s port:%s",message,port);
	}
}
