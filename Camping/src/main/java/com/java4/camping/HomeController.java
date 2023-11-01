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
<<<<<<< HEAD
	public String home(Locale locale, Model model) {

=======
	public String home() {
		
>>>>>>> login-out-modal
		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
<<<<<<< HEAD
	public String index(Locale locale, Model model) {
=======
	public String index() {
>>>>>>> login-out-modal
		

		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {

		return "admin";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String announcement(Locale locale, Model model) {
		return "announcement";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String review(Locale locale, Model model) {
		return "review";
	}
	
	@RequestMapping(value = "/fee", method = RequestMethod.GET)
	public String fee(Locale locale, Model model) {
		return "fee";
	}
	
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve(Locale locale, Model model) {
		return "reserve";
	}
}
