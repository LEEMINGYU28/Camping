<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- jQuery 라이브러리 추가 -->

<link href="resources/styles/layout/calendar.css" rel="stylesheet" />
<link href="<%=contextPath%>/resources/styles/main.css" rel="stylesheet" />
<link rel="shortcut icon"
	href="<%=contextPath%>/resources/img/boards/favicon.ico"
	type="image/x-icon">
<link rel="icon"
	href="<%=contextPath%>/resources/img/boards/favicon.ico"
	type="image/x-icon">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="resources/styles/layout/calendar.css" rel="stylesheet" />
</head>
<body>
	<div>
		<table id="calendar">
			<thead>
				<tr>
					<th colspan="7">
						<button onclick="prevMonth()">&#9668;</button> <span
						id="currentMonthYear"></span>
						<button onclick="nextMonth()">&#9658;</button>
					</th>
				</tr>
				<tr>
					<th>일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토</th>
				</tr>
			</thead>
			<tbody id="calendar-body">
			</tbody>
		</table>
		<p id="selected-date">선택한 날짜: 없음</p>
	</div>
	<script>
		var today = new Date();
		var currentMonth = today.getMonth();
		var currentYear = today.getFullYear();
		var monthNames = [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월",
				"9월", "10월", "11월", "12월" ];

		function generateCalendar(month, year) {
			var calendarBody = document.getElementById("calendar-body");
			calendarBody.innerHTML = "";
			var date = new Date(year, month, 1);
			var firstDay = date.getDay();
			var daysInMonth = new Date(year, month + 1, 0).getDate();

			var dateCounter = 1;
			for (var i = 0; i < 6; i++) {
				var row = document.createElement("tr");
				for (var j = 0; j < 7; j++) {
					if (i === 0 && j < firstDay) {
						var cell = document.createElement("td");
						var cellText = document.createTextNode("");
						cell.appendChild(cellText);
						row.appendChild(cell);
					} else if (dateCounter <= daysInMonth) {
						var cell = document.createElement("td");
						cell.classList.add("selectable");
						var cellText = document.createTextNode(dateCounter);
						cell.appendChild(cellText);
						row.appendChild(cell);
						dateCounter++;
					}
				}
				calendarBody.appendChild(row);
			}
		}

		function prevMonth() {
			currentMonth--;
			if (currentMonth < 0) {
				currentMonth = 11;
				currentYear--;
			}
			updateCalendar();
		}

		function nextMonth() {
			currentMonth++;
			if (currentMonth > 11) {
				currentMonth = 0;
				currentYear++;
			}
			updateCalendar();
		}

		function updateCalendar() {
			document.getElementById("currentMonthYear").innerText = " "
					+ monthNames[currentMonth] + " " + currentYear + " ";
			generateCalendar(currentMonth, currentYear);
		}

		updateCalendar();

		var calendarBody = document.getElementById("calendar-body");
		calendarBody
				.addEventListener(
						"click",
						function(e) {
							if (e.target
									&& e.target.classList
											.contains("selectable")) {
								var selectedDate = e.target.textContent;
								var selectedMonth = currentMonth + 1;
								var selectedYear = currentYear;

								// 예약 정보를 가져오기 위한 날짜 포맷 생성
								var selectedDateFormatted = selectedYear + '-'
										+ (selectedMonth < 10 ? '0' : '')
										+ selectedMonth + '-'
										+ (selectedDate < 10 ? '0' : '')
										+ selectedDate;

								// Ajax 요청
								$
										.ajax({
											url : '/room/available?date='
													+ selectedDateFormatted,
											method : 'GET',
											success : function(data) {
												// 가져온 데이터를 기반으로 UI 업데이트
												updateRoomListUI(data);
											},
											error : function(error) {
												console
														.error(
																"Error while fetching available rooms:",
																error);
											}
										});

								// 선택한 날짜 표시
								document.getElementById("selected-date").textContent = "선택한 날짜: "
										+ selectedYear
										+ "년 "
										+ (selectedMonth < 10 ? "0"
												+ selectedMonth : selectedMonth)
										+ "월 "
										+ (selectedDate < 10 ? "0"
												+ selectedDate : selectedDate)
										+ "일";
							}
						});

		// 예약 정보를 업데이트하는 함수
		function updateReservationInfoUI(reservationInfo) {
			var reservationInfoContainer = document
					.getElementById("reservation-info-container");

			// 예약 가능 여부에 따라 UI 업데이트
			if (reservationInfo.isAvailable) {
				reservationInfoContainer.innerHTML = 'Hotel: '
						+ reservationInfo.hotelName + '<br>Price: $'
						+ reservationInfo.price;
			} else {
				reservationInfoContainer.innerHTML = 'This date is not available for reservation.';
			}
		}
	</script>
</body>
</html>
