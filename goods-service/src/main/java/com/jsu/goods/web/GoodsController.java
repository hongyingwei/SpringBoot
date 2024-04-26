package com.jsu.goods.web;

import com.jsu.goods.entity.Goods;
import com.jsu.goods.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	private static final Logger logger = Logger.getLogger("GoodsController");

	@Resource
	private GoodsService goodsService;

	@GetMapping("/")
	public String root() {
		logger.info("in GoodsController.root");
		return "home.jsp";
	}

	@GetMapping("")
	public String rootBlank() {
		logger.info("in GoodsController.rootBlank");
		return "home.jsp";
	}

	@GetMapping("/h")
	public String home() {
		logger.info("in GoodsController.home");
		logger.info(System.getenv("CLASSPATH"));
		logger.info(System.getProperty("CLASSPATH"));
		return "home.jsp"; // webapp/goods/home.jsp
	}

	@GetMapping("/all")
	@ResponseBody
	public Iterable<Goods> all() {
		return goodsService.findAll();
	}
}
