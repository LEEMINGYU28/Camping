package com.java4.camping.notice.domain;

import java.util.Date;
import java.util.List;

import com.java4.camping.admin.domain.Admin;

public class Notice {
    private int id;
    private int adminId;
    private Admin admin;
    private String title;
    private String content;
    private String writer;
    private Date createdAt;

 
    private int totalPages;
    private int currentPage;
    private List<Notice> notices;

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
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriter() {
        return writer;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getAdminId() {
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

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

    public List<Notice> getNotices() {
        return notices;
    }
}
