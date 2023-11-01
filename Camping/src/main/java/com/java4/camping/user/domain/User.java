package com.java4.camping.user.domain;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String userId;
	private String userPw;
	private Date createdAt;

	public User() {
	}

	public User(String name, String userId, String userPw) {
		this.name = name;
		this.userId = userId;
		this.userPw = userPw;
	}

	public User(int id, String name, String userId, String userPw, Date createdAt) {
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.userPw = userPw;
		this.createdAt = createdAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
}
