package com.jsu.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
//import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;

import java.util.Arrays;
import java.util.Locale;

@SpringBootApplication
@MapperScan(basePackages="com.jsu.goods.mapper")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Value("${spring.mvc.view.prefix}")
	//@Value("${server.port:8080}")
	// 必须明确写了才能去到（包括 application.yaml)
	// 没写的话，默认值取不到
//	@Value("${server.port}")
//	String myProp;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new MyInternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		// private String prefix = "";
//		this.prefix = (prefix != null ? prefix : "");
//		viewResolver.setPrefix("/views/");
		// this.suffix = (suffix != null ? suffix : "");
//		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);

		return viewResolver;
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//			System.out.println("============ Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				if (beanName.endsWith("ViewResolver") || beanName.endsWith("viewResolver")) {
//					Object bean = ctx.getBean(beanName);
//					System.out.println(beanName + "--" + bean.getClass().getName());
//					testPath(bean);
//				}
//			}
//
//			System.out.printf("myProp: %s%n", myProp);
//
////			PropertyPlaceholderHelper 盘 = new PropertyPlaceholderHelper("psfk", "adsf");
////			System.out.printf("盘: %s%n", 盘.getClass().getSimpleName());
////			PropertyPlaceholderHelper pan = new PropertyPlaceholderHelper("sss", "sdf");
////			System.out.printf("pan: %s%n", pan.getClass().getSimpleName());
//
//			System.out.println("========= inspect beans end");
//		};
//	}
//
//	private void testPath(Object vr0) throws Exception {
//		if (vr0 instanceof ViewResolver) {
//			ViewResolver vr = (ViewResolver) vr0;
//			// IllegalStateException: No current ServletRequestAttributes
////			View v = vr.resolveViewName("home", Locale.ENGLISH);
////			System.out.printf("		view home from %s: %s%n", vr.getClass().getSimpleName(), v);
//		}
//	}
}
