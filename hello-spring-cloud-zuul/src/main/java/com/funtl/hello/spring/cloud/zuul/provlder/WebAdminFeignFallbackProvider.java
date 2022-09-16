package com.funtl.hello.spring.cloud.zuul.provlder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 路由失败回调
 */
@Component
public class WebAdminFeignFallbackProvider implements FallbackProvider {
	/**
	 * 回退服务
	 * @return
	 */
	@Override
	public String getRoute() {
		return "hello-spring-cloud-web-admin-feign";
	}

	/**
	 * 请求服务失败,返回指定信息
	 * @param route
	 * @param cause
	 * @return
	 */
	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
			/**
			 * 返回状态码
			 * @return
			 * @throws IOException
			 */
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			/**
			 * 返回状态Code
			 * @return
			 * @throws IOException
			 */
			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();
			}

			/**
			 * 返回状态信息
			 * @return
			 * @throws IOException
			 */
			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}

			@Override
			public void close() {
			}

			/**
			 * 响应内容
			 * @return
			 * @throws IOException
			 */
			@Override
			public InputStream getBody() throws IOException {
				// 封装JSON
				ObjectMapper objectMapper = new ObjectMapper();
				Map<String,Object> map = new HashMap<>();
				// 封装新状态码
				map.put("status",200);
				map.put("message","无法连接");
				return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
			}

			/**
			 * 响应请求头
			 * @return
			 */
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				// 和getBody中的内容编码一致
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
		};
	}
}
