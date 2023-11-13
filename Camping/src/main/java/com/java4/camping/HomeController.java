package com.java4.camping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java4.camping.product.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/fee", method = RequestMethod.GET)
	public String fee() {
		return "category/fee";
	}

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve(Model model) {
		model.addAttribute("products", productService.getAvailableProducts());
		return "payment/reserve";
	}

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar() {
		return "layout/calendar";
	}

}
