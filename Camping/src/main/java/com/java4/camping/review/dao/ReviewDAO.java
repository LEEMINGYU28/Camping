package com.java4.camping.review.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.review.domain.Review;


@Repository
public class ReviewDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<Review> mapper = new RowMapper<Review>() {
		@Override
		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Review(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("content"),
					rs.getDate("created_at"));
		}
	};

	public void add(Review review) {
	
		jdbcTemplate.update("insert into review (\"title\", \"user_id\", \"content\") values (?, ?, ?)",
				review.getTitle(), review.getUser().getId(), review.getContent());

	}

	public Review get(int id) {
		return jdbcTemplate.queryForObject("select * from review where \"id\"=?", new Object[] { id }, mapper);
	}

	public List<Review> getAll() {
		return jdbcTemplate.query("select * from review order by \"id\"", mapper);

	}

	public void update(Review review) {
		jdbcTemplate.update("update review set \"title\"=?, \"content\"=? where \"id\"=?", review.getTitle(),
				review.getContent(), review.getId());
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from review where \"id\"=?", id);
	}

}
