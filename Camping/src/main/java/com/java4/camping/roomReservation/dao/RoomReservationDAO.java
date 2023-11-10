package com.java4.camping.roomReservation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java4.camping.roomReservation.domain.RoomReservation;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoomReservationDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addReservation(RoomReservation reservation) {
        String insertSql = "INSERT INTO reservations (\"user_id\", \"room_id\", \"check_in_date\", \"check_out_date\", \"total_price\") VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertSql, reservation.getUserId(), reservation.getRoomId(), reservation.getCheckInDate(),
                reservation.getCheckOutDate(), reservation.getTotalPrice());

        // ���� �� �ش� ���� ���¸� '���� �Ұ���'���� ������Ʈ
        String updateRoomStatusSql = "UPDATE rooms SET \"available\" = 'N' WHERE \"id\" = ?";
        jdbcTemplate.update(updateRoomStatusSql, reservation.getRoomId());
    }

    public List<RoomReservation> getAllReservations() {
        String selectAllSql = "SELECT * FROM reservations";
        return jdbcTemplate.query(selectAllSql, new RoomReservationRowMapper());
    }

    public RoomReservation getById(int id) {
        String selectByIdSql = "SELECT * FROM reservations WHERE \"id\" = ?";
        return jdbcTemplate.queryForObject(selectByIdSql, new Object[]{id}, new RoomReservationRowMapper());
    }

    public void cancelReservation(int reservationId) {
        // ������ ����ϸ� �ش� ���� ���¸� '���� ����'���� ������Ʈ
        String updateRoomStatusSql = "UPDATE rooms SET \"available\" = 'Y' WHERE \"id\" = (SELECT \"room_id\" FROM reservations WHERE \"id\" = ?)";
        jdbcTemplate.update(updateRoomStatusSql, reservationId);

        // ������ ����
        String deleteReservationSql = "DELETE FROM reservations WHERE \"id\" = ?";
        jdbcTemplate.update(deleteReservationSql, reservationId);
    }

    private static class RoomReservationRowMapper implements org.springframework.jdbc.core.RowMapper<RoomReservation> {
        @Override
        public RoomReservation mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            return new RoomReservation(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("room_id"),
                    rs.getDate("check_in_date"),
                    rs.getDate("check_out_date"),
                    rs.getInt("total_price")
            );
        }
    }
}
