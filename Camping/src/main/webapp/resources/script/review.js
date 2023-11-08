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
function openModal(title, content, imageUrl) {
    var modal = document.getElementById("reviewModal");
    var modalTitle = document.getElementById("modalTitle");
    var modalContent = document.getElementById("modalContent");
    var modalImage = document.getElementById("modalImage");

    modalTitle.textContent = title;
    modalContent.textContent = content;
    modalImage.src = imageUrl;

    modal.style.display = "block";
    modalImage.style.maxHeight = "100%"; // 이미지를 확대하는 부분 추가
    modalImage.style.maxWidth = "100%";
}

function closeModal() {
    var modal = document.getElementById("reviewModal");
    modal.style.display = "none";
}

function enlargeImage(imageUrl) {
    var enlargedImageModal = document.getElementById("imageModal");
    var enlargedImage = document.getElementById("enlargedModalImage");

    enlargedImage.src = imageUrl;
    enlargedImageModal.style.display = "block";
}

function closeEnlargedImage() {
    var enlargedImageModal = document.getElementById("imageModal");
    enlargedImageModal.style.display = "none";
}