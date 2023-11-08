package com.java4.camping.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java4.camping.user.domain.User;
import com.java4.camping.user.sevice.UserService;


@Controller
public class MyPageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public String myPage(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        
        if (userId != null) {
            User user = userService.getUser(userId);
            model.addAttribute("user", user);
            return "category/myPage";
        } else {

            return "redirect:/main";
        }
    }
}
