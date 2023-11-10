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

function openModal(title, content, imageUrl, reviewId) {
	var modal = document.getElementById("reviewModal");
	var modalTitle = document.getElementById("modalTitle");
	var modalContent = document.getElementById("modalContent");
	var modalImage = document.getElementById("modalImage");
	var editLink = document.getElementById("editLink");
	var deleteLink = document.getElementById("delete");

	modalTitle.textContent = title;
	modalContent.textContent = content;
	modalImage.src = imageUrl;

	modalImage.style.height = "300px";
	modalImage.style.width = "300px";
	modalImage.style.display = "block";
	modalTitle.setAttribute("data-review-id", reviewId);
	editLink.href = "/camping/reviewedit/" + reviewId;


	deleteLink.setAttribute('data-review-id', reviewId);


	modal.style.display = "block";
}
function closeModal() {
	var modal = document.getElementById("reviewModal");
	modal.style.display = "none";
}


function deleteReview() {
	var reviewIdElement = document.getElementById('delete');
	var reviewId = reviewIdElement.dataset.reviewId;
	if (!reviewId) {
		console.error("Review ID is undefined.");
		return;
	}


	console.log("reviewId:", reviewId);


	if (confirm("이 리뷰를 삭제하시겠습니까?")) {
		$.ajax({
			type: "POST",
			url: `${contextPath}/reviewdelete/${reviewId}`,
			success: function(data) {
				closeModal();

				$(`#board-list tbody tr[data-review-id=${reviewId}]`).remove();

				location.reload();
			},
			error: function(error) {
				console.error("리뷰 삭제 중 에러:", error);
			}
		});
	}
}