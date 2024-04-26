package com.jsu.goods;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.jsu.goods.entity.Goods;
import com.jsu.goods.mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ViewResolver;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;

@SpringBootTest
public class PathTest {
	@Resource
	private ViewResolver mvcViewResolver;
	private ViewResolver beanNameViewResolver;

	@Test
	public void testPath() throws Exception {
		System.out.println("beanNameViewResolver: " + beanNameViewResolver);
		System.out.println("mvcViewResolver: " + mvcViewResolver);
		System.out.println("/goods/h: " + mvcViewResolver.resolveViewName("/goods/h", Locale.ENGLISH));
		System.out.println("/goods/h: " + mvcViewResolver.resolveViewName("home", Locale.ENGLISH));
	}
}
