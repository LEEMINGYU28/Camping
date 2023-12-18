package com.java4.camping.review.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.review.domain.Review;

@Repository
public class ReviewDAOMysql {
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
					rs.getString("image_filename"), rs.getDate("created_at"));

		}
	};

	public void add(Review review) {

		jdbcTemplate.update(
				"insert into review (title, user_id, content,image_filename) values (?, ?, ?, ?)",
				review.getTitle(), review.getUser().getId(), review.getContent(), review.getImageFilename());

	}

	public Review get(int id) {
		try {
			return jdbcTemplate.queryForObject("select * from review where id =?", new Object[] { id }, mapper);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No review found for id: " + id);
			return null;
		}
	}

	public Review get(String userId) {
		return jdbcTemplate.queryForObject("select * from review where user_id =?", new Object[] { userId }, mapper);
	}

	public List<Review> getAll() {
		return jdbcTemplate.query("select * from review order by id DESC", mapper);

	}

	public void update(Review review) {
		jdbcTemplate.update("update review set title =?, content =? where id =?", review.getTitle(),
				review.getContent(), review.getId());
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from review where id =?", id);
	}

	public int getTotalReviewCount() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM review", Integer.class);
	}

	public List<Review> getReviewInRange(int currentPage, int itemsPerPage) {
		int offset = (currentPage - 1) * itemsPerPage;
		return jdbcTemplate.query(
				"SELECT * FROM review ORDER BY id DESC LIMIT ?,?",
				new Object[] { offset + 1, offset + itemsPerPage }, mapper);
	}
}
