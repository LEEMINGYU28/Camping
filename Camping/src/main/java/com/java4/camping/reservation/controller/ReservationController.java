/*
 * package com.java4.camping.reservation.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model;
 * 
 * import com.java4.camping.reservation.dto.ReservationRepository;
 * 
 * 
 * @Controller public class ReservationController {
 * 
 * @Autowired private ReservationRepository reservationRepository;
 * 
 * @GetMapping("/reservations") public String showReservations(Model model) {
 * List<Reservation> reservations = reservationRepository.findAll(); // 모든 예약 정보
 * 가져오기
 * 
 * // 가져온 데이터를 모델에 추가하여 JSP에 전달 model.addAttribute("reservations",
 * reservations);
 * 
 * return "reservations"; // JSP 페이지 이름 } }
 */