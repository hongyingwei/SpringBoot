package com.woniuxy.springboot.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.woniuxy.springboot.service.HelloService;

import javax.annotation.Resource;

@Configuration("HelloServiceAC")
//开启属性配置
@EnableConfigurationProperties(HelloServiceProperties.class)
//如果在类路径下存在HelloService才进行自动的配置
@ConditionalOnClass(HelloService.class)
//总开关
@ConditionalOnProperty(prefix = "woniuxy.hello", value = "enabled", matchIfMissing = true)
public class HelloServiceAutoConfiguration {
	HelloServiceAutoConfiguration() {
		System.out.println("in HelloServiceAutoConfiguration()");
		System.out.println("in HelloServiceAutoConfiguration() helloServiceProperties:" + helloServiceProperties);
//		System.out.println("in HelloServiceAutoConfiguration() helloServiceProperties.message:" + helloServiceProperties.getMessage());
	}

	@Resource
	private HelloServiceProperties helloServiceProperties;

	@Bean
	@ConditionalOnMissingBean(HelloService.class)
	// bean不存在则创建
	public HelloService helloService() {
		System.out.println("in HelloServiceAutoConfiguration.helloService() helloServiceProperties.message:" + helloServiceProperties.getMessage());
		HelloService helloService = new HelloService();
		helloService.setMessage(helloServiceProperties.getMessage());
		return helloService;
	}

}
