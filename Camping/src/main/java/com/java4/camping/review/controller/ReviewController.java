package com.java4.camping.review.controller;

import java.util.List;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

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

//	@RequestMapping(value = "/review", method = RequestMethod.GET)
//	public String ReviewList(Model model) {
//		List<Review> reviews = reviewService.getAllReview();
//		model.addAttribute("reviews", reviews);
//		return "board/review";
//	}

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
	public String createReview(@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
			@RequestParam("title") String title, @RequestParam("content") String content, HttpSession session) {

		String userId = (String) session.getAttribute("userId");

		if (userId == null) {
			return "redirect:/review";
		}
		String newFilename = "";
		// 이미지 파일 처리
		if (imageFile != null && !imageFile.isEmpty()) {
			try {
				// 이미지 파일을 저장할 경로 설정
				String uploadDirectory = "C:\\Users\\KGA\\git\\Camping\\Camping\\src\\main\\webapp\\resources\\uploadimg";

				// 업로드 파일명 생성
				String originalFilename = imageFile.getOriginalFilename();

				newFilename = StringUtils.cleanPath(originalFilename);

				String fileExtension = StringUtils.getFilenameExtension(newFilename);

				if (fileExtension.isEmpty()) {

					System.out.println("이미지 업로드 실패");
				}

				// 새로운 파일명 생성
				newFilename = System.currentTimeMillis() + "." + fileExtension; // 예: "1605855612356.jpg"

				// 이미지 파일 저장
				String filePath = uploadDirectory + File.separator + newFilename;
				Files.copy(imageFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
				// 에러 처리
			}
		}

		// 리뷰 작성
		User user = userDAO.get(userId);
		System.out.println("userId1 =" + userId);
		if (user != null) {
			Review review = new Review(user, title, content);
			review.setImageFilename(newFilename); // 이미지 파일명을 리뷰에 저장
			reviewService.addReview(review, review.getUserId());
			System.out.println("작성 성공");
		}

		return "redirect:/review";
	}

	@RequestMapping(value = "/reviewedit/{id}", method = RequestMethod.GET)
	public String showEditForm(Model model, @PathVariable("id") int id) {
		Review review = reviewService.getReviewById(id);
		model.addAttribute("review", review);
		return "board/reviewEdit";
	}

	@RequestMapping(value = "/reviewedit/{id}", method = RequestMethod.POST)
	public String editReview(@PathVariable("id") int id, @RequestParam("title") String title,
			@RequestParam("content") String content, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {

			return "redirect:/review";
		} else {
			Review review = new Review();
			review.setId(id);
			review.setTitle(title);
			review.setContent(content);
			reviewService.updateReview(review);
			return "redirect:/review";
		}

	}

	@RequestMapping(value = "/reviewdelete/{id}", method = RequestMethod.GET)
	public String showDeleteForm(Model model, @PathVariable("id") int id) {
		Review review = reviewService.getReviewById(id);
		model.addAttribute("review", review);
		return "board/reviewDelete";
	}

	@RequestMapping(value = "/reviewdelete/{id}", method = RequestMethod.POST)
	public String deleteReview(@PathVariable("id") int id, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/review";
		} else {
			reviewService.deleteReview(id);
			return "redirect:/review";
		}
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String listReviews(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		int totalreviews = reviewService.getTotalReview();
		int itemsPerPage = 6;
		int totalPages = (int) Math.ceil((double) totalreviews / itemsPerPage);

		List<Review> reviews = reviewService.getReviewInRange(page, itemsPerPage);

		for (Review review : reviews) {
			int userId = review.getUserId();
			User user = userDAO.get(userId);
			review.setUser(user);
		}

		model.addAttribute("reviews", reviews);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);

		return "board/review";
	}

	@RequestMapping(value = "/review/{page}", method = RequestMethod.GET)
	public String reviewListByPage(Model model, @PathVariable("page") int page) {
		int totalNotices = reviewService.getTotalReview();
		int itemsPerPage = 6;
		int totalPages = (int) Math.ceil((double) totalNotices / itemsPerPage);

		List<Review> reviews = reviewService.getReviewInRange(page, itemsPerPage);

		for (Review review : reviews) {
			int userId = review.getUserId();
			User user = userDAO.get(userId);
			review.setUser(user);
		}

		model.addAttribute("reviews", reviews);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);

		return "board/review";
	}

}