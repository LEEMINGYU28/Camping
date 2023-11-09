package com.java4.camping.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.admin.domain.Admin;
import com.java4.camping.admin.service.AdminService;
import com.java4.camping.user.domain.User;
import com.java4.camping.user.sevice.UserService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(@RequestParam Map<String, String> map) {
		adminService.add(new Admin(map.get("admin-name"), map.get("admin-id"), map.get("admin-pw")));

		return "redirect:/notices";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogInPost(@RequestParam Map<String, String> map, HttpSession session, Model model) {
	    Admin admin = new Admin();
	    admin.setAdminId(map.get("admin-id"));
	    admin.setAdminPw(map.get("admin-pw"));
	    admin = adminService.login(admin);
	    if (admin != null) {
	        session.setAttribute("adminName", admin.getName());
	        session.setAttribute("adminId", admin.getAdminId());
	        return "redirect:/notices";
	    } else {
	  
	        model.addAttribute("loginError", "Invalid username or password");
	        return "admin/loginPage";
	    }
	}


	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String adminLogOutPost(@RequestParam Map<String, String> map, HttpSession session) {
		session.setAttribute("adminName", null);
		session.setAttribute("adminId", null);

		return "redirect:/notices";
	}
	
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList(Model model, HttpSession session) {
    	String adminId = (String) session.getAttribute("adminId");
    	if(adminId != null) {
    		List<User> users = userService.getAllUsers();
    		model.addAttribute("users", users);
    		return "admin/userList";  		
    	}
    	else {
    		return "redirect:/notices";
    	}
    }

    @RequestMapping(value = "/viewUser/{id}", method = RequestMethod.GET)
    public String viewUser(Model model, @PathVariable("id") int id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/viewUser";
    }
}