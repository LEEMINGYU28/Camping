package com.java4.camping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/notices", method = RequestMethod.GET)
	public String admin() {

		return "admin/admin";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String announcement() {
		return "board/announcement";
	}

	@RequestMapping(value = "/fee", method = RequestMethod.GET)
	public String fee() {
		return "category/fee";
	}

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve() {
		return "payment/reserve";
	}

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar() {
		return "layout/calendar";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String review() {
		return "board/review";
	}
}
