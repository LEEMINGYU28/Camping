package com.java4.camping.review.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.camping.review.domain.Review;
import com.java4.camping.review.service.ReviewService;
import com.java4.camping.user.dao.UserDAO;
import com.java4.camping.user.domain.User;

@Controller
//@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value="/review ",method = RequestMethod.GET)
	public String listReview(Model model) {
		model.addAttribute("review", reviewService.getAllReview());
		return "board/review";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewReview(Model model, @PathVariable("id") int id) {
	    Review review = reviewService.get(id);
	    model.addAttribute("review", review); 
	    return "board/review";
	}


	@RequestMapping(value = "/reviewCreate", method = RequestMethod.GET)
	public String showReviewCreateForm() {
		return "board/reviewCreate";
	}

	@RequestMapping(value = "/reviewCreate", method = RequestMethod.POST)
	public String createReview(@RequestParam Map<String, String> map, HttpSession session) {
		System.out.println("createReview 메서드 호출");
	

		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {

			return "redirect:/review";
		}

		String title = map.get("title");
		String content = map.get("content");
		User user = userDAO.get(userId);
		System.out.println("userId: " + userId);
		System.out.println("user: " + user);
		if (user != null) {

			Review review = new Review(user, title, content);
			System.out.println("Review 객체: " + review);

			reviewService.addReview(review, review.getUserId());
			System.out.println("작성성공");
		}

		return "redirect:/review";
	}

	@RequestMapping(value = "/reviewEdit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable("id") int id) {
		Review review = reviewService.getReviewById(id);
		model.addAttribute("review", review);
		return "board/reviewEdit";
	}

	@RequestMapping(value = "/reviewEdit/{id}", method = RequestMethod.POST)
	public String editReview(@PathVariable("id") int id, @RequestParam("title") String title,
			@RequestParam("content") String content,HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {

			return "redirect:/review";
		}
		else {	Review review = new Review();
		review.setId(id);
		review.setTitle(title);
		review.setContent(content);
		reviewService.updateReview(review);
		return "redirect:/review";
		}
	
	}

	@RequestMapping(value = "/reviewDelete/{id}", method = RequestMethod.GET)
	public String showDeleteForm(Model model, @PathVariable("id") int id) {
		Review review = reviewService.getReviewById(id);
		model.addAttribute("review", review);
		return "board/reviewDelete";
	}

	@RequestMapping(value = "/reviewDelete/{id}", method = RequestMethod.POST)
	public String deleteReview(@PathVariable("id") int id,HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {

			return "redirect:/review";
		}
		else {
			reviewService.deleteReview(id);
			return "redirect:/review";
		}
	}
}
