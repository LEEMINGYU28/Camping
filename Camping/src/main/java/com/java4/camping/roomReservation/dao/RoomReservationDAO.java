package com.java4.camping.roomReservation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java4.camping.roomReservation.domain.RoomReservation;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomReservationDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<RoomReservation> mapper = new RowMapper<RoomReservation>() {
		@Override
		public RoomReservation mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new RoomReservation(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("room_id"),
					rs.getDate("check_in_date"), rs.getDate("check_out_date"), rs.getInt("total_price"));
		}
	};

	public void addReservation(RoomReservation reservation) {
		String sql = "INSERT INTO reservations (user_id, room_id, check_in_date, check_out_date, total_price) "
				+ "VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, reservation.getUserId(), reservation.getRoomId(), reservation.getCheckInDate(),
				reservation.getCheckOutDate(), reservation.getTotalPrice());
	}

	public List<RoomReservation> getAllReservations() {
		String sql = "SELECT * FROM reservations";
		return jdbcTemplate.query(sql, mapper);
	}

	public RoomReservation getById(int id) {
		String sql = "SELECT * FROM reservations WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, mapper);
	}

}
