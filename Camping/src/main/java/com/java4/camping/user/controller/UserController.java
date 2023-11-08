package com.java4.camping.user.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.user.domain.User;
import com.java4.camping.user.sevice.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "main/main";
	}

	/*
	 * @RequestMapping(value = "/camping/main", method = RequestMethod.POST) public
	 * String handleHeaderPostRequest(@RequestParam Map<String, String> map,
	 * HttpSession session) { String name = map.get("joinName"); String userId =
	 * map.get("joinId"); String userPw = map.get("joinPw");
	 * 
	 * User user = new User(name, userId, userPw); userService.add(user);
	 * 
	 * return "redirect:/main"; }
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@RequestParam Map<String, String> map) {
		userService.add(new User(map.get("userName"), map.get("userId"), map.get("userPw")));

		return "redirect:/main";
	}

	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public String userLogInPost(@RequestParam Map<String, String> map, HttpSession session, Model model) {
	    User user = new User();
	    user.setUserId(map.get("userId"));
	    user.setUserPw(map.get("userPw"));

	    user = userService.logins(user);

	    if (user != null) {
	        session.setAttribute("userId", user.getUserId());
	        session.setAttribute("userName", user.getName()); 
	        return "redirect:/main";
	    } else {
	        model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
	        return "redirect:/main";
	    }
	}



	@RequestMapping(value = "/logouts", method = RequestMethod.POST)

	public String userLogOutPost(@RequestParam Map<String, String> map, HttpSession session) {

		session.setAttribute("userName", null);
		session.setAttribute("userId", null);
		return "redirect:/main";
	}

}
