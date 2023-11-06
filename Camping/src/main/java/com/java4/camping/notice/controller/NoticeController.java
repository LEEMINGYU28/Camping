package com.java4.camping.notice.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
@RequestMapping("/notices")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private AdminDAO adminDAO;

	@RequestMapping(value="/notices ",method = RequestMethod.GET)
	public String listNotices(Model model) {
		model.addAttribute("notices", noticeService.getAllNotices());
		return "admin/admin";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewNotice(Model model, @PathVariable("id") int id) {
	    Notice notice = noticeService.get(id);
	    model.addAttribute("notice", notice); 
	    return "admin/view";
	}


	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm() {
		return "admin/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNotice(@RequestParam Map<String, String> map, HttpSession session) {

		String adminId = (String) session.getAttribute("adminId");
		
		if (adminId == null) {

			return "redirect:/notices";
		}

		String title = map.get("title");
		String content = map.get("content");

		Admin admin = adminDAO.get(adminId);

		if (admin != null) {

			Notice notice = new Notice(admin, title, content);

			noticeService.addNotice(notice, notice.getAdminid());
		}

		return "redirect:/notices";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable("id") int id) {
		Notice notice = noticeService.getNoticeById(id);
		model.addAttribute("notice", notice);
		return "admin/edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editNotice(@PathVariable("id") int id, @RequestParam("title") String title,
			@RequestParam("content") String content,HttpSession session) {
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {

			return "redirect:/notices";
		}
		else {	Notice notice = new Notice();
		notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		noticeService.updateNotice(notice);
		return "redirect:/notices";
		}
	
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String showDeleteForm(Model model, @PathVariable("id") int id) {
		Notice notice = noticeService.getNoticeById(id);
		model.addAttribute("notice", notice);
		return "admin/delete";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteNotice(@PathVariable("id") int id,HttpSession session) {
		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {

			return "redirect:/notices";
		}
		else {
			noticeService.deleteNotice(id);
			return "redirect:/notices";
		}
	}
}
