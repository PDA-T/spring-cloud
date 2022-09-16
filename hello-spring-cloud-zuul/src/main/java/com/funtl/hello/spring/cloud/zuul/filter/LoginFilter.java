package com.funtl.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {
	/**
	 * 返回过滤类型
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤顺序
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 是否需要过滤
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器具体业务
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String token = request.getParameter("token");
		// 如果token为空拦截请求
		if (token == null){
			// 禁止发送Zuul响应
			context.setSendZuulResponse(false);
			// 设置未授权状态码
			context.setResponseStatusCode(401);
			try {
				// 修改编码格式
				HttpServletResponse response = context.getResponse();
				response.setContentType("text/html;charset=utf-8");
				// 页面响应
				context.getResponse().getWriter().write("非法请求");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}
