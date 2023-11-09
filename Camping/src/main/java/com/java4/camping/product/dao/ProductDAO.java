package com.java4.camping.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.product.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

@Repository
public class ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<Product> mapper = new RowMapper<Product>() {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime(); // Assuming "timestamp" is the column name in your database
			return new Product(rs.getInt("id"), rs.getString("name"), rs.getString("detail"), rs.getInt("price"),
					rs.getInt("available"),timestamp);
		}
	};

	public List<Product> getAll() {

		return jdbcTemplate.query("SELECT * FROM products", mapper);

	}
	
	
	public List<Product> getAvailableProducts() {
        return jdbcTemplate.query("SELECT * FROM products WHERE available = 0", mapper);
    }
}

