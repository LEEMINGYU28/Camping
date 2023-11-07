package com.java4.camping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java4.camping.notice.service.NoticeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	NoticeService noticeService;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/notices", method = RequestMethod.GET)
	public String listNotices(Model model) {
		model.addAttribute("notices", noticeService.getAllNotices());
		return "admin/admin";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String announcement(Model model) {
		model.addAttribute("notices", noticeService.getAllNotices());
		return "board/announcement";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String review() {
		return "board/review";
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

}
