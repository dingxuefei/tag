package com.hummingbird.tag.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/activity",method=RequestMethod.POST)
public class TestController {

	@RequestMapping(value="/join",method=RequestMethod.POST)
	@ResponseBody
	public String isLeaving(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("服务器地址："+request.getServerName());
		System.out.println("端口号："+request.getServerPort());
		System.out.println("项目名称："+request.getContextPath());
		System.out.println("请求页面或其他地址："+request.getRequestURI());
		String strBackUrl = "http://" + request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() // 端口号
				+ request.getContextPath() // 项目名称
				+ request.getRequestURI(); // 请求页面或其他地址
		
		System.out.println(strBackUrl);
		return "1";
	}
	
}
