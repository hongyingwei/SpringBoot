package com.woniuxy.springboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.springboot.service.HelloService;

@RestController
public class HelloController {
	
	@Resource
	private HelloService helloService;
	
	@RequestMapping("/")
	public String hello(){
		return this.helloService.getMessage();
	}

}
