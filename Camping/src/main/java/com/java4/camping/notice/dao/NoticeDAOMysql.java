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
import com.java4.camping.notice.domain.Notice;

@Repository
public class NoticeDAOMysql {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Notice> mapper = new RowMapper<Notice>() {
        @Override
        public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Notice(
                rs.getInt("id"),
                rs.getInt("admin_id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getDate("created_at")
            );
        }
    };

    public void add(Notice notice) {
        jdbcTemplate.update(
            "INSERT INTO notices (title, admin_id, content) VALUES (?, ?, ?)",
            notice.getTitle(), notice.getAdmin().getId(), notice.getContent()
        );
    }

    public Notice get(int id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM notices WHERE id = ?",
            new Object[] { id },
            mapper
        );
    }

    public List<Notice> getAll() {
        return jdbcTemplate.query(
            "SELECT * FROM notices ORDER BY id DESC",
            mapper
        );
    }


    public void update(Notice notice) {
        jdbcTemplate.update(
            "UPDATE notices SET title =?, content =? WHERE id =?",
            notice.getTitle(), notice.getContent(), notice.getId()
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM notices WHERE id = ?", id);
    }
    public int getTotalNoticesCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM notices", Integer.class);
    }

    public List<Notice> getNoticesInRange(int currentPage, int itemsPerPage) {
        int offset = (currentPage - 1) * itemsPerPage;
        return jdbcTemplate.query(
        		"SELECT * FROM notices ORDER BY id DESC LIMIT ?,?",
            new Object[] { offset + 1, offset + itemsPerPage },
            mapper
        );
    }

    
}
