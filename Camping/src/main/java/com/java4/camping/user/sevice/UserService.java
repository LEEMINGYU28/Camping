package com.java4.camping.user.sevice;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.camping.user.dao.UserDAO;
import com.java4.camping.user.domain.User;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;

	public void add(User user) {
		user.setUserPw(cryptoPassword(user.getUserPw()));
		userDAO.add(user);
		System.out.println(user);
	}

	public User logins(User user) {
		User tempUser = userDAO.get(user.getUserId());
		if (tempUser != null && tempUser.getUserPw().equals(cryptoPassword(user.getUserPw()))) {
			return tempUser;
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
