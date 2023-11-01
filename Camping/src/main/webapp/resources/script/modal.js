document.addEventListener("DOMContentLoaded", function() {
	let loginmodal = document.getElementById("modal");
	let btnModal = document.getElementById("btn-modal");
	let closeBtn = document.querySelector(".close-area");
	let usernameInput = document.getElementById("username");
	let passwordInput = document.getElementById("password");
	let loginButton = document.getElementById("login-button");

	btnModal.addEventListener("click", () => {
		loginmodal.style.display = "block";
	});

	window.addEventListener("click", (event) => {
		if (event.target === modal) {
			loginmodal.style.display = "none";
		}
	});

	closeBtn.addEventListener("click", () => {
		loginmodal.style.display = "none";
	});

	document.addEventListener("keydown", (event) => {
		if (event.key === "Escape") {
			loginmodal.style.display = "none";
		}
	});

/*	loginButton.addEventListener("click", () => {
		const username = usernameInput.value;
		const password = passwordInput.value;
		// alert("아이디: " + username + ", 비밀번호: " + password);
	});*/
	
});