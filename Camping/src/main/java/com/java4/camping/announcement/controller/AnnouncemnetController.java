package com.java4.camping.announcement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.admin.dao.AdminDAO;
import com.java4.camping.admin.domain.Admin;
import com.java4.camping.notice.domain.Notice;
import com.java4.camping.notice.service.NoticeService;

@Controller
public class AnnouncemnetController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	AdminDAO adminDAO;
	
	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String listNotices(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		int totalNotices = noticeService.getTotalNotices();
		int itemsPerPage = 5;
		int totalPages = (int) Math.ceil((double) totalNotices / itemsPerPage);

		List<Notice> notices = noticeService.getNoticesInRange(page, itemsPerPage);

		for (Notice notice : notices) {
			int adminId = notice.getAdminId();
			Admin admin = adminDAO.get(adminId);
			notice.setAdmin(admin);
		}

		model.addAttribute("notices", notices);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);

		return "board/announcement";
	}
	@RequestMapping(value = "/announcement/{page}", method = RequestMethod.GET)
	public String list(Model model, @PathVariable("page") Integer page) {
		int totalNotices = noticeService.getTotalNotices();
		int itemsPerPage = 5;
		int totalPages = (int) Math.ceil((double) totalNotices / itemsPerPage);

		List<Notice> notices = noticeService.getNoticesInRange(page, itemsPerPage);

		for (Notice notice : notices) {
			int adminId = notice.getAdminId();
			Admin admin = adminDAO.get(adminId);
			notice.setAdmin(admin);
		}

		model.addAttribute("notices", notices);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);

		return "board/announcement";
	}
	@RequestMapping(value = "/announcement/view/{id}", method = RequestMethod.GET)
	public String announcementViewNotice(Model model, @PathVariable("id") int id) {
		Notice notice = noticeService.get(id);
		model.addAttribute("notice", notice);
		return "admin/announcementView";
	}
}
