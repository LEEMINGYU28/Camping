package com.java4.camping.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.user.domain.User;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<User> mapper=new RowMapper<User>(){@Override public User mapRow(ResultSet rs,int rowNum)throws SQLException{
	// TODO Auto-generated method stub
	return new User(rs.getInt("id"),rs.getString("name"),rs.getString("user_id"),rs.getString("user_pw"),rs.getDate("created_at"));}};

	public void add(User user) {
		jdbcTemplate.update("insert into users (\"name\", \"user_id\", \"user_pw\") values (?, ?, ?)", user.getName(),
				user.getUserId(), user.getUserPw());
	}

	public User get(int id) {
		return jdbcTemplate.queryForObject("select * from users where \"id\"=?", new Object[] { id }, mapper);
	}

	public User get(String userId) {
		return jdbcTemplate.queryForObject("select * from users where \"user_id\"=?", 
				new Object[] { userId },mapper);
	}

	public User getName(String name) {
		return jdbcTemplate.queryForObject("select * from users where \"name\"=?", 
				new Object[] { name },
				mapper);
	}

	public List<User> getAll() {
		return jdbcTemplate.query("SELECT * FROM users", mapper);
	}

	public void deleteAll() {
		jdbcTemplate.update("delete from users");
	}
}
