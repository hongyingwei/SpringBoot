package com.woniuxy.springboot.service;

public class HelloService {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("in HelloService setMessage");
	}

}
