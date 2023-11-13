package com.java4.camping.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class paymentController {

	@RequestMapping(value = "/paymentpage", method = RequestMethod.GET)
	public String payment() {

		return "/payment/paymentpage";
	}

}
