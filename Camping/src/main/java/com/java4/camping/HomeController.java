package com.java4.camping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java4.camping.notice.domain.Notice;
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

//	@RequestMapping(value = "/announcement/{page}", method = RequestMethod.GET)
//	public String announcement(Model model, @PathVariable("page") int page) {
//		int totalNotices = noticeService.getTotalNotices();
//		int itemsPerPage = 5; // 원하는 페이지 당 아이템 수
//		int totalPages = (int) Math.ceil((double) totalNotices / itemsPerPage);
//
//		List<Notice> notices = noticeService.getNoticesInRange(page, itemsPerPage);
//
//		model.addAttribute("notices", notices);
//		model.addAttribute("totalPages", totalPages);
//		model.addAttribute("currentPage", page); // 현재 페이지를 모델에 추가
//
//		return "board/announcement";
//	}

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
