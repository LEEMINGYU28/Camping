package com.java4.camping.admin.domain;

import java.util.Date;

public class Admin {
	private int id;
	private String name;
	private String adminId;
	private String adminPw;
	private Date createdAt;

	public Admin() {
	}
	public Admin(String name, String adminId, String adminPw) {
		this.name = name;
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public Admin(int id, String name, String adminId, String adminPw, Date createdAt) {
		this.id = id;
		this.name = name;
		this.adminId = adminId;
		this.adminPw = adminPw;
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

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
}
