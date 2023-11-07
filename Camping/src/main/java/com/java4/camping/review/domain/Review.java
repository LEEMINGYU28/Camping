package com.java4.camping.review.domain;

import java.util.Date;

import com.java4.camping.user.domain.User;

public class Review {
	private int id;
	private int userId;
	private User user;
	private String title;
	private String content;
	private Date createdAt;
	
	public Review() {
	}
	public Review(User user, String title, String content) {
		this.user = user;
		this.title = title;
		this.content = content;
	}

	public Review(int id, int userId, String title, String content, Date createdAt) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

}
