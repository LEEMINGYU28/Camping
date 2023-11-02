package com.java4.camping.notice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.admin.dao.AdminDAO;
import com.java4.camping.admin.domain.Admin;
import com.java4.camping.notice.domain.Notice;


@Repository
public class NoticeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private AdminDAO adminDAO;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<Notice> mapper = new RowMapper<Notice>() {
		@Override
		public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Notice(rs.getInt("id"), rs.getInt("admin_id"), rs.getString("title"), rs.getString("content"),
					rs.getDate("created_at"));
		}
	};

	public void add(Notice notice) {
	
		jdbcTemplate.update("insert into notices (\"title\", \"admin_id\", \"content\") values (?, ?, ?)",
				notice.getTitle(), notice.getAdmin().getId(), notice.getContent());

	}

	public Notice get(int id) {
		return jdbcTemplate.queryForObject("select * from notices where \"id\"=?", new Object[] { id }, mapper);
	}

	public List<Notice> getAll() {
		return jdbcTemplate.query("select * from notices order by \"id\"", mapper);

	}

	public void update(Notice notice) {
		jdbcTemplate.update("update notices set \"title\"=?, \"content\"=? where \"id\"=?", notice.getTitle(),
				notice.getContent(), notice.getId());
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from notices where \"id\"=?", id);
	}

}
