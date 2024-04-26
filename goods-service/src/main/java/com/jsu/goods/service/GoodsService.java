package com.jsu.goods.service;

import com.jsu.goods.entity.Goods;
import com.jsu.goods.mapper.GoodsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class GoodsService {
	@Resource
    GoodsMapper goodsRepository;
	public Iterable<Goods> findAll() {
		return goodsRepository.findAll();
	}
}
