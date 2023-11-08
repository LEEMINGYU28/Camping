package com.java4.camping.review.controller;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
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

	@RequestMapping(value = "/reviewList", method = RequestMethod.GET)
	public String ReviewList(Model model) {
		List<Review> reviews = reviewService.getAllReview();
		model.addAttribute("reviews", reviews);
		return "board/reviewList";
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

	@Autowired
	private ServletContext servletContext; // 서블릿 컨텍스트 객체를 주입합니다.

	@RequestMapping(value = "/reviewCreate", method = RequestMethod.POST)
	public String createReview(@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam Map<String, String> map, HttpSession session) {

		System.out.println("createReview 메서드 호출");

		String userId = (String) session.getAttribute("userId");
		System.out.println("userId =" + userId);
		if (userId == null) {
			return "redirect:/review";
		}

		// 이미지 파일 처리
		if (!imageFile.isEmpty()) {
			try {
				// 이미지 파일을 저장할 경로 설정 (경로를 적절하게 변경하세요)
				String uploadDirectory = "C:\\Users\\KGA\\git\\img";
				System.out.println("uploadDirectory = " + uploadDirectory);
				// 업로드 파일명 생성 (중복을 방지하기 위해 파일명을 변경)
				String originalFilename = imageFile.getOriginalFilename();
				System.out.println("originalFilename = " + originalFilename);
				String newFilename = StringUtils.cleanPath(originalFilename); // 예: "image.jpg"
				System.out.println("newFilename = " + newFilename);
				String fileExtension = StringUtils.getFilenameExtension(newFilename); // 파일 확장자
				System.out.println("fileExtension = " + fileExtension);
				if (fileExtension.isEmpty()) {
					// 파일 확장자를 얻을 수 없을 때 예외 처리
					// 다른 처리를 하거나 에러 메시지를 반환하세요.
					System.out.println("이미지 업로드 실패");
				}

				// 새로운 파일명 생성 (고유성을 보장하도록 변경)
				newFilename = System.currentTimeMillis() + "." + fileExtension; // 예: "1605855612356.jpg"

				// 이미지 파일을 서버에 저장
				String filePath = uploadDirectory + File.separator + newFilename;
				Files.copy(imageFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

				// 리뷰 작성
				User user = userDAO.getName(userId);
				System.out.println("userId1 =" + userId);
				if (user != null) {
					String title = map.get("title");
					System.out.println("title =" + title);
					String content = map.get("content");
					System.out.println("content =" + content);
					Review review = new Review(user, title, content);
					review.setImageFilename(newFilename); // 이미지 파일명을 리뷰에 저장
					reviewService.addReview(review, review.getUserId());
					System.out.println("작성 성공");
				}
			} catch (IOException e) {
				e.printStackTrace();
				// 에러 처리
			}
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

	@RequestMapping(value = "/reviewDelete/{id}", method = RequestMethod.GET)
	public String showDeleteForm(Model model, @PathVariable("id") int id) {
		Review review = reviewService.getReviewById(id);
		model.addAttribute("review", review);
		return "board/reviewDelete";
	}

	@RequestMapping(value = "/reviewDelete/{id}", method = RequestMethod.POST)
	public String deleteReview(@PathVariable("id") int id, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {

			return "redirect:/review";
		} else {
			reviewService.deleteReview(id);
			return "redirect:/review";
		}
	}
}
