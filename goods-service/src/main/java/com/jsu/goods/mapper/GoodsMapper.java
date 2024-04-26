package com.jsu.goods.mapper;

import com.jsu.goods.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface GoodsMapper {
	List<Goods> findAll();
	void saveMany(List<Goods> goodsList);
}
