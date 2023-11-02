package com.java4.camping.user.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.user.domain.User;
import com.java4.camping.user.sevice.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String regist() {
		return "camping/main";
	}

	@RequestMapping(value = "/header", method = RequestMethod.POST)
	public String registPost(@RequestParam Map<String, String> map) {
		userService.add(new User(map.get("name"), map.get("userId"), map.get("userPw")));

		return "redirect:/main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogInPost(@RequestParam Map<String, String> map, HttpSession session) {
		User user = new User();
		user.setUserId(map.get("userId"));
		user.setUserPw(map.get("userPw"));
		user = userService.login(user);
		if (user != null)
			session.setAttribute("userName", user.getName());

		return "redirect:/main";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String userLogOutPost(@RequestParam Map<String, String> map, HttpSession session) {
		session.setAttribute("userName", null);

		return "redirect:/header";
	}

}
