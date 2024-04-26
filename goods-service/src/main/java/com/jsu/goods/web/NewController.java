package com.jsu.goods.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NewController {
	private static final Logger logger = Logger.getLogger("NewController");

//	@GetMapping("")
//	public String rootBlank() {
//		logger.info("in NewController.rootBlank");
//		return "home.jsp";
//	}

	@GetMapping("/")
	public String root() {
		logger.info("in NewController.root");
		return "home.jsp";
	}

	@GetMapping("/web_info_home")
	public String webInfoHome() {
		logger.info("in NewController.webInfoHome");
		return "WEB-INF/home.jsp";
	}

	@GetMapping("/h")
	public String home() {
		logger.info("in NewController.home");
		return "home.jsp";
	}

	@GetMapping("/bads/h")
	public String badsHome() {
		logger.info("in NewController.badsHome");
		return "home.jsp"; // webapp/bads/home.jsp
	}

	@GetMapping("/uglys/h")
	public String uglysHome() {
		logger.info("in NewController.uglysHome");
		return "home.jsp"; // webapp/uglys/home.jsp not exits, 404
	}
}
