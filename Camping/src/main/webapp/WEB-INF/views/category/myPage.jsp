<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link href="resources/styles/category/myPage.css" rel="stylesheet" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="resources/img/boards/favicon.ico" type="image/x-icon">
    <link rel="icon" href="resources/img/boards/favicon.ico" type="image/x-icon">
</head>
<body>
    <header>
        <jsp:include page='../layout/header.jsp'>
            <jsp:param name="pageName" value="header" />
        </jsp:include>
    </header>

    <div class="container">
        <div class="header">
            <h1>${user.name}님 안녕하세요.</h1>
        </div>
        <div class="user-info">
            <!-- 회원 정보 -->
            <h2>회원 정보</h2>
            <!-- 여기에 회원 정보가 들어갈 부분 -->
            <!-- 정보 수정, 회원 탈퇴 버튼 등을 추가할 수 있습니다 -->
            <button class="btn btn-primary" data-toggle="modal" data-target="#editModal">정보 수정</button>
            <button class="btn btn-danger" onclick="confirmWithdraw()">회원 탈퇴</button>
        </div>
        <div class="reservation-info">
            <!-- 주문/예약 정보 -->
            <h2>주문 조회</h2>
            <p>예약번호: 202310274017693</p>
            <p>예약일자: 2023-10-27</p>
            <h3>예약 상품 이미지</h3>
            <img src="resources/img/categorys/mypageBoxImg.jpg" alt="상품 이미지" class="product-image">
            <p>T2-테라스캠핑</p>
            <p>1박 (2023-10-27 ~ 2023-10-28)</p>
            <p>350,000원</p>
            <!-- 기타 주문 정보가 들어갈 부분 -->
        </div>
    </div>

    <!-- 모달(정보 수정) -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">정보 수정</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- 정보 수정 내용 -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" onclick="saveUserInfo()">저장</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="withdrawModal" tabindex="-1" role="dialog" aria-labelledby="withdrawModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="withdrawModalLabel">회원 탈퇴</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>정말 탈퇴하시겠습니까?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    <a href="<c:url value='/withdraw/${user.userId}'/>" class="btn btn-danger">탈퇴</a>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <jsp:include page='../layout/footer.jsp'>
            <jsp:param name="pageName" value="footer" />
        </jsp:include>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- 이 부분은 추가한 부분 -->
    <script>
        function saveUserInfo() {
            // 정보 수정 로직을 추가하세요.
            alert("정보가 수정되었습니다.");
            $("#editModal").modal("hide"); // 모달 닫기
        }

        function confirmWithdraw() {
            $("#withdrawModal").modal("show"); // 탈퇴 모달 보여주기
        }

        function withdrawUser() {

            window.location.href = "<c:url value='/withdraw/${user.userId}'/>"; 
        }
    </script>
</body>
</html>
