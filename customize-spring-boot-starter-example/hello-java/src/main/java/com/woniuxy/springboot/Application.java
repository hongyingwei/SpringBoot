package com.woniuxy.springboot;

import com.woniuxy.springboot.service.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
//			inspectBeans(ctx);
			test();
		};
	}

	private void inspectBeans(ApplicationContext ctx) {
		System.out.println("============ Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			Object bean = ctx.getBean(beanName);
			System.out.println(beanName + "--" + bean.getClass().getName());
		}

		System.out.println("========= inspect beans end");
	}

	@Resource
	HelloService helloService;

	private void test() {
		System.out.println(helloService.getMessage());
	}

}
