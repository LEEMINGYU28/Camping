package com.java4.camping.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.product.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
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
			return new Product(rs.getInt("id"), rs.getString("product_name"), rs.getInt("availability"),
					rs.getString("price"), rs.getString("details"), rs.getString("img_path"));
		}
	};

	public List<Product> getAll() {

		return jdbcTemplate.query("SELECT * FROM products", mapper);

	}
}