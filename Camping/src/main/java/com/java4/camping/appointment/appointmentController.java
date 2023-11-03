package com.java4.camping.appointment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class appointmentController {

	
	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public String appointment() {

		return "appointment/appointment";
	}
}
