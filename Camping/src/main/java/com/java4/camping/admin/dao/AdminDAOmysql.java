package com.java4.camping.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.admin.domain.Admin;

@Repository
public class AdminDAOmysql {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<Admin> mapper = new RowMapper<Admin>() {
		@Override
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Admin(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("admin_id"),
					rs.getString("admin_pw"),
					rs.getDate("created_at"));
		}
	};

	public void add(Admin admin) {
		jdbcTemplate.update("insert into admins (name, admin_id, admin_pw) values (?, ?, ?)",
				admin.getName(), admin.getAdminId(), admin.getAdminPw());
		System.out.println(admin.getAdminId());
	}

	public Admin get(int id) {
		return jdbcTemplate.queryForObject("select * from admins where id =?", new Object[] { id }, mapper);
	}

	public Admin get(String adminId) {
		return jdbcTemplate.queryForObject("select * from admins where admin_id =?", new Object[] { adminId },
				mapper);
	}

	public void deleteAll() {
		jdbcTemplate.update("delete from admins");
	}

}
