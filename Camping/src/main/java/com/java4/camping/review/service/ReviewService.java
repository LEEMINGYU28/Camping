package com.java4.camping.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
		try {
			return reviewDAO.get(id);
		} catch (EmptyResultDataAccessException e) {
			// 예외 처리: 결과가 없을 때
			System.out.println("No review found for id: " + id);
			return null; // 또는 예외 처리에 맞게 다른 동작 수행
		}
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
