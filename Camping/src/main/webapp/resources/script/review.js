window.onload = function() {
	let currentPage = window.location.href;

	if (currentPage.indexOf("../board/review") !== -1) {
		document.getElementById("reviewBox").style.backgroundColor = "navy";
		document.getElementById("reviewBox").style.color = "white";
		document.getElementById("noticeBox").style.backgroundColor = "white";
		document.getElementById("noticeBox").style.color = "black";
	}

	const reviewTitles = document.querySelectorAll('.review-title');
	reviewTitles.forEach(function(title) {

		title.addEventListener('click', function() {
			const parentRow = title.parentNode.parentNode;
			const content = parentRow.querySelector('.review-content');
			const image = parentRow.querySelector('.review-image');
			if (content.style.display === 'none') {
				content.style.display = 'block';
				image.style.display = 'block';
			} else {
				content.style.display = 'none';
				image.style.display = 'none';
			}
		});
	});
}

function goToPage(pageURL) {
	window.location.href = pageURL;
}

function openModal(title, content, imageUrl, reviewId) {
	var modal = document.getElementById("reviewModal");
	var modalTitle = document.getElementById("modalTitle");
	var modalContent = document.getElementById("modalContent");
	var modalImage = document.getElementById("modalImage");

	modalTitle.textContent = title;
	modalContent.textContent = content;
	modalImage.src = imageUrl;
	modalTitle.setAttribute("data-review-id", reviewId);

	document.getElementById("title").value = title;
	document.getElementById("content").value = content;

	console.log("선택한 리뷰의 제목: " + title);
	console.log("선택한 리뷰의 내용: " + content);
	console.log("선택한 리뷰의 이미지 경로: " + imageUrl);
	console.log("선택한 리뷰의 ID: " + reviewId);

	modal.style.display = "block";
	modalImage.style.maxHeight = "100%";
	modalImage.style.maxWidth = "100%";
}
function closeModal() {
	var modal = document.getElementById("reviewModal");
	modal.style.display = "none";
}
function openEditForm() {
	document.querySelector('.edit').style.display = 'block';
}
function saveReview() {
	// 수정된 리뷰 제목과 내용을 가져옴
	var editedTitle = document.getElementById('title').value;
	var editedContent = document.getElementById('content').value;

	// 서버로 데이터를 보낼 URL 설정
	var serverURL = 'http://localhost/camping/board/review'; // 실제 서버 URL로 변경 필요

	// Ajax를 사용하여 서버로 데이터 전송
	$.ajax({
		type: 'POST',
		url: serverURL,
		data: {
			id: getCurrentReviewId(),
			title: editedTitle,
			content: editedContent,
			_csrf: '${_csrf.token}'
		},
		success: function(data) {
			// 저장에 성공하면 모달 창을 닫거나 다른 작업 수행
			closeModal();
		},
		error: function(xhr, status, error) {
			// 에러 처리
			handleAjaxError(xhr.status);
		}
	});
}
function getCurrentReviewId() {
	// 현재 리뷰의 ID를 가져오는 로직 추가
	var modalTitle = document.getElementById("modalTitle");
	return modalTitle.getAttribute("data-review-id");
}

function handleAjaxError(status) {
	// Ajax 에러 처리 로직 추가
	if (status === 404) {
		alert("서버 URL을 찾을 수 없습니다.");
	} else if (status === 500) {
		alert("서버 내부 에러가 발생했습니다.");
	} else {
		alert("에러가 발생했습니다. 다시 시도해 주세요.");
	}
}