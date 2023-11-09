package com.java4.camping.review.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.notice.domain.Notice;
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
					rs.getString("image_filename"), rs.getDate("created_at"));

		}
	};

	public void add(Review review) {

		jdbcTemplate.update(
				"insert into review (\"title\", \"user_id\", \"content\",\"image_filename\") values (?, ?, ?, ?)",
				review.getTitle(), review.getUser().getId(), review.getContent(), review.getImageFilename());

	}

	public Review get(int id) {
		List<Review> reviews = jdbcTemplate.query("select * from review where \"id\"=?", new Object[] { id }, mapper);

		if (reviews.isEmpty()) {
			// 결과가 없으면 null 반환 또는 예외 처리를 수행
			return null;
		}

		return reviews.get(0);
	}

	public Review get(String userId) {
		return jdbcTemplate.queryForObject("select * from review where \"user_id\"=?", new Object[] { userId }, mapper);
	}

	public List<Review> getAll() {
		return jdbcTemplate.query("select * from review order by \"id\" DESC", mapper);

	}

	public void update(Review review) {
		jdbcTemplate.update("update review set \"title\"=?, \"content\"=? where \"id\"=?", review.getTitle(),
				review.getContent(), review.getId());
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from review where \"id\"=?", id);
	}

	public int getTotalReviewCount() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM review", Integer.class);
	}

	public List<Review> getReviewInRange(int currentPage, int itemsPerPage) {
		int offset = (currentPage - 1) * itemsPerPage;
		return jdbcTemplate.query(
				"SELECT * FROM (SELECT n.*, ROWNUM rnum FROM (SELECT * FROM review ORDER BY \"id\" DESC) n) WHERE rnum BETWEEN ? AND ?",
				new Object[] { offset + 1, offset + itemsPerPage }, mapper);
	}
}
