package com.java4.camping.admin.service;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.camping.admin.dao.AdminDAO;
import com.java4.camping.admin.domain.Admin;

@Service
public class AdminService {
	@Autowired
	AdminDAO adminDAO;

	public void add(Admin admin) {
		admin.setAdminPw(cryptoPassword(admin.getAdminPw()));
		adminDAO.add(admin);
		System.out.println(admin);
	}

	public Admin login(Admin admin) {
		Admin tempAdmin = adminDAO.get(admin.getAdminId());
		if (tempAdmin != null && tempAdmin.getAdminPw().equals(cryptoPassword(admin.getAdminPw()))) {
			return tempAdmin;
		} else
			return null;
	}

	private String cryptoPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] sha256Hash = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : sha256Hash) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
