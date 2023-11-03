package com.java4.camping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String home() {

		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)

	public String index() {

		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {

		return "admin";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String announcement() {
		return "announcement";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String review() {
		return "review";
	}

	@RequestMapping(value = "/fee", method = RequestMethod.GET)
	public String fee() {
		return "fee";
	}

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve() {
		return "reserve";
	}
	
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar() {
		return "calendar";
	}
}
