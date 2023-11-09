package com.java4.camping.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.camping.notice.domain.Notice;
import com.java4.camping.review.dao.ReviewDAO;
import com.java4.camping.review.domain.Review;
import com.java4.camping.user.dao.UserDAO;
import com.java4.camping.user.domain.User;

@Service
public class ReviewService {
	@Autowired
	private ReviewDAO reviewDAO;
	@Autowired
	private UserDAO userDAO;

	public List<Review> getAllReview() {
		List<Review> reviews = reviewDAO.getAll();
		for (Review review : reviews) {
			int userId = review.getUserId();
			User user = userDAO.get(userId);
			review.setUser(user);
		}
		return reviews;
	}

	public Review get(int id) {
		Review review = reviewDAO.get(id);
		User user = userDAO.get(review.getUserId());
		review.setUser(user);

		return review;
	}

	public Review getReviewById(int id) {
		Review review = reviewDAO.get(id);

		if (review == null) {
			// 결과가 없는 경우의 처리
			// 예를 들어, null을 반환하거나 예외를 throw
		}

		return review;
	}

	public void addReview(Review review, int userId) {
		reviewDAO.add(review);
	}

	public void updateReview(Review review) {
		reviewDAO.update(review);
	}

	public void deleteReview(int id) {
		reviewDAO.delete(id);
	}

	public List<Review> getReviewInRange(int currentPage, int itemsPerPage) {
		return reviewDAO.getReviewInRange(currentPage, itemsPerPage);
	}

	public int getTotalReview() {
		return reviewDAO.getTotalReviewCount();
	}
}
