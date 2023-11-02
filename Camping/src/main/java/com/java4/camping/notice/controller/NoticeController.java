package com.java4.camping.notice.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.admin.dao.AdminDAO;
import com.java4.camping.admin.domain.Admin;
import com.java4.camping.admin.service.AdminService;
import com.java4.camping.notice.domain.Notice;
import com.java4.camping.notice.service.NoticeService;

@Controller
@RequestMapping("/notices")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminDAO adminDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String listNotices(Model model) {
		model.addAttribute("notices", noticeService.getAllNotices());
		return "admin/list";
	}

//	@RequestMapping(value = "/view", method = RequestMethod.POST)
//	public String viewNotice(Model model, int id) {
//		Notice notice = noticeService.getNoticeById(id);
//		model.addAttribute("notice", notice);
//		return "admin/view";
//	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm() {
		return "admin/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNotice(@RequestParam Map<String, String> map, HttpSession session) {

		String adminName = (String) session.getAttribute("adminName");

		if (adminName == null) {

			return "redirect:/admin";
		}

		String title = map.get("title");
		String content = map.get("content");

		Admin admin = adminDAO.get(adminName);

		if (adminName != null) {

			Notice notice = new Notice(admin, title, content);

			noticeService.addNotice(notice,notice.getAdminid());
		}

		return "redirect:/notices";
	}

//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public String showEditForm(Model model, @RequestParam("id") int id) {
//		Notice notice = noticeService.getNoticeById(id);
//		model.addAttribute("notice", notice);
//		return "admin/edit";
//	}
//
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	public String editNotice(@RequestParam("id") int id, @RequestParam("title") String title,
//			@RequestParam("content") String content) {
//		Notice notice = new Notice();
//		notice.setId(id);
//		notice.setTitle(title);
//		notice.setContent(content);
//		noticeService.updateNotice(notice);
//		return "redirect:/notices";
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String showDeleteForm(Model model, @RequestParam("id") int id) {
//		Notice notice = noticeService.getNoticeById(id);
//		model.addAttribute("notice", notice);
//		return "notices/delete";
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String deleteNotice(@RequestParam("id") int id) {
//		noticeService.deleteNotice(id);
//		return "redirect:/notices";
//	}
}
