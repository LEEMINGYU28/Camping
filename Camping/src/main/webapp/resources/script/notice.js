/**
 * 
 */
window.onload = function() {
	let currentPage = window.location.href;

	if (currentPage.indexOf("../board/announcement") !== -1) {
		document.getElementById("reviewBox").style.backgroundColor = "navy";
		document.getElementById("reviewBox").style.color = "white";
		document.getElementById("noticeBox").style.backgroundColor = "white";
		document.getElementById("noticeBox").style.color = "black";
	}

	const noticeTitles = document.querySelectorAll('.notice-title');
	noticeTitles.forEach(function(title) {
		title.addEventListener('click', function() {
			const parentRow = title.parentNode.parentNode;
			const content = parentRow.querySelector('.notice-content');
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
function openModal(title, content, author, date) {
	var modal = document.getElementById("noticeModal");
	var modalTitle = document.getElementById("modalTitle");
	var modalContent = document.getElementById("modalContent");
	var modalAuthorDate = document.getElementById("modalAuthorDate");
	
	   var formattedDate = new Date(date).toLocaleString('ko-KR', {
        year: 'numeric',
        month: 'numeric',
        day: 'numeric',
        hour12: false // 24시간 표시
    });

	modalTitle.textContent = "제목: " + title;
	modalContent.textContent = "내용: " + content;
	modalAuthorDate.textContent = "작성자: " + author + " | 작성일: " + formattedDate;

	modal.style.display = "block";
}


function closeModal() {
	var modal = document.getElementById("noticeModal");
	modal.style.display = "none";
}
