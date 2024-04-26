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

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest
public class GoodsRepositoryTest {
	@Resource
	private GoodsMapper dao;

	@Resource
	SqlSessionFactory fac;

	@Resource
	SqlSession sess;

	@Test
	public void contextLoads() {
		System.out.println(fac);
		System.out.println(sess);
	}

	@Test
	public void findAll(){
		List<Goods> goodsList = dao.findAll();
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}

	@Test
	public void saveMany() throws FileNotFoundException {
		Gson gson = new Gson();
		Type REVIEW_TYPE = new TypeToken<List<Goods>>() {}.getType();
		JsonReader reader = new JsonReader(new FileReader("/Users/jiang/tmp/working/src_android/第9章与第12章的服务器/Chapter09/goods/goods_list_data.json"));
		List<Goods> data = gson.fromJson(reader, REVIEW_TYPE);
		System.out.println(data);
		dao.saveMany(data);
	}
}
