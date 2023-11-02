package com.java4.camping.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.admin.domain.Admin;
import com.java4.camping.admin.service.AdminService;

// @Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() {
		return "admin/admin";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(@RequestParam Map<String, String> map) {
		adminService.add(new Admin(map.get("admin-name"), map.get("admin-id"), map.get("admin-pw")));

		return "redirect:/admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogInPost(@RequestParam Map<String, String> map, HttpSession session) {
		Admin admin = new Admin();
		admin.setAdminId(map.get("admin-id"));
		admin.setAdminPw(map.get("admin-pw"));
		admin = adminService.login(admin);
		if (admin != null)
			session.setAttribute("adminName", admin.getName());
		session.setAttribute("adminId", admin.getAdminId());
		return "redirect:/admin";
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String adminLogOutPost(@RequestParam Map<String, String> map, HttpSession session) {
		session.setAttribute("adminName", null);

		return "redirect:/admin";
	}

}
