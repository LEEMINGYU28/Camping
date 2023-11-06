package com.java4.camping.successReserve;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SuccessReserve {

	
	@RequestMapping(value = "/successReserve", method = RequestMethod.GET)

	public String successReserve() {

		return "/successReserve";
	}


}