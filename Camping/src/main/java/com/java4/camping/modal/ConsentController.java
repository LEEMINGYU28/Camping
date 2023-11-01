package com.java4.camping.modal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsentController {

private static final Logger logger = LoggerFactory.getLogger(ConsentController.class);
	
	
	@RequestMapping(value = "/consent", method = RequestMethod.GET)
	public String consent() {
		
		return "consent";
	}
}
