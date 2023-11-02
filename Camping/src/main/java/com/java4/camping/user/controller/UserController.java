package com.java4.camping.user.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.admin.domain.Admin;
import com.java4.camping.admin.service.AdminService;
import com.java4.camping.user.domain.User;
import com.java4.camping.user.sevice.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() {
		return "admin/admin";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(@RequestParam Map<String, String> map) {
		userService.add(new User(map.get("user-name"), map.get("user-id"), map.get("user-pw")));

		return "redirect:/admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogInPost(@RequestParam Map<String, String> map, HttpSession session) {
		User user = new User();
		user.setUserId(map.get("user-id"));
		user.setUserPw(map.get("user-pw"));
		user = userService.login(user);
		if (user != null)
			session.setAttribute("userName", user.getName());

		return "redirect:/admin";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String adminLogOutPost(@RequestParam Map<String, String> map, HttpSession session) {
		session.setAttribute("userName", null);

		return "redirect:/admin";
	}

}
