package com.java4.camping.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.camping.admin.dao.AdminDAO;
import com.java4.camping.admin.domain.Admin;
import com.java4.camping.notice.dao.NoticeDAO;
import com.java4.camping.notice.domain.Notice;

@Service
public class NoticeService {
    @Autowired
    private NoticeDAO noticeDAO;
    @Autowired
    private AdminDAO adminDAO;
    
    public List<Notice> getAllNotices() {
        List<Notice> notices = noticeDAO.getAll();
        for (Notice notice : notices) {
            int adminId = notice.getAdminid();
            Admin admin = adminDAO.get(adminId);
            notice.setAdmin(admin);
        }
        return notices;
    }

	public Notice get(int id) {
		Notice notice = noticeDAO.get(id);
		Admin admin = adminDAO.get(notice.getAdminid());
		notice.setAdmin(admin);

		return notice;
	}
    public Notice getNoticeById(int id) {
        return noticeDAO.get(id);
    }

    public void addNotice(Notice notice, int adminId) {
        noticeDAO.add(notice);
    }

    public void updateNotice(Notice notice) {
        noticeDAO.update(notice);
    }

    public void deleteNotice(int id) {
        noticeDAO.delete(id);
    }
}
