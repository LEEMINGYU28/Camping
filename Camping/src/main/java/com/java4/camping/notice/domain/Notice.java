package com.java4.camping.notice.domain;

import java.util.Date;

import com.java4.camping.admin.domain.Admin;

public class Notice {
	private int id;
	private int adminId;
	private Admin admin;
	private String title;
	private String content;
	private Date createdAt;
	
	public Notice() {
	}
	public Notice(Admin admin, String title, String content) {
		this.admin = admin;
		this.title = title;
		this.content = content;
	}

	public Notice(int id, int adminId, String title, String content, Date createdAt) {
		this.id = id;
		this.adminId = adminId;
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

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdminid(int adminId) {
		this.adminId = adminId;
	}

	public int getAdminid() {
		return adminId;
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
