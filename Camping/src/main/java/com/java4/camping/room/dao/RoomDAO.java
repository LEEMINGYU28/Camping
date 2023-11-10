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
import java.util.Date;
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
            Room room = new Room();
            room.setId(rs.getInt("id"));
            room.setRoomName(rs.getString("room_name"));
            room.setRoomDescription(rs.getString("room_description"));
            room.setRoomPrice(rs.getInt("room_price"));
            room.setAvailable("Y".equals(rs.getString("available"))); // "Y" 여부 확인
            return room;
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
    public boolean isRoomAvailable(int id) {
        String sql = "SELECT available FROM rooms WHERE \"id\" = ?";
        int availableValue = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return availableValue == 1;
    }
    public List<Room> getAvailableRooms(Date checkInDate, Date checkOutDate) {
        String sql = "SELECT * FROM rooms WHERE \"id\" NOT IN " +
                     "(SELECT \"room_id\" FROM reservation WHERE " +
                     "(\"check_in_date\" BETWEEN ? AND ? OR \"check_out_date\" BETWEEN ? AND ?))";
        return jdbcTemplate.query(sql, mapper, checkInDate, checkOutDate, checkInDate, checkOutDate);
    }
	
}