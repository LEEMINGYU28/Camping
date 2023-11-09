package com.java4.camping.user.sevice;

import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.java4.camping.admin.domain.Admin;
import com.java4.camping.notice.domain.Notice;
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
		try {
			User tempUser = userDAO.get(user.getUserId());
			if (tempUser != null && tempUser.getUserPw().equals(cryptoPassword(user.getUserPw()))) {
				return tempUser;
			} else {
				return null;
			}
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
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

	public List<User> getAllUsers() {
		return userDAO.getAll();
	}

	public User getUserById(int id) {
		return userDAO.get(id);
	}

	public User getUser(String userId) {
		return userDAO.get(userId);
	}

	public void withdrawUserById(int id) {
		userDAO.delete(id);
	}
}
