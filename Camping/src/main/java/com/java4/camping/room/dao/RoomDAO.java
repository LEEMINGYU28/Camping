package com.java4.camping.room.dao;

import com.java4.camping.notice.domain.Notice;
import com.java4.camping.room.domain.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Room> mapper = new RowMapper<Room>() {
        @Override
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Room(
                rs.getInt("id"),
                rs.getString("room_name"),
                rs.getString("room_description"),
                rs.getInt("room_price")
            );
        }
    };

	public void addRoom(Room room) {
        String sql = "INSERT INTO rooms (\"room_name\", \"room_description\", \"room_price\") VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, room.getRoomName(), room.getRoomDescription(), room.getRoomPrice());
    }

    public List<Room> getAllRooms() {
        String sql = "SELECT * FROM rooms";
        return jdbcTemplate.query(sql, mapper);
    }
    public Room get(int id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM rooms WHERE \"id\" = ?",
            new Object[] { id },
            mapper
        );
    }
	
}