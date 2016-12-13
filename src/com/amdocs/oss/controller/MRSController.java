package com.amdocs.oss.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MRSController {

	static Logger logger = Logger.getLogger(MRSController.class);
	
	@RequestMapping(value = "/sendMRS")
	public String sendMRS(){
		System.out.println("helooooo");
		logger.info("hello logger");
		return "Response";
		
	}
}
