document.addEventListener("DOMContentLoaded", function() {
	let closeBtn = document.querySelector(".join-close-area");
	let modal = document.getElementById("joinModal");

	closeBtn.addEventListener("click", () => {
		modal.style.display = "none";
	});

	function validatePassword() {
		const password = document.getElementById('userPw').value;
		const passwordMessage = document.getElementById('passwordMessage');
		const passwordCheck = document.getElementById('passwordCheck').value;
		const passwordCheckMessage = document.getElementById('passwordCheckMessage');

		const lowercaseRegex = /[a-z]/;
		const uppercaseRegex = /[A-Z]/;
		const digitRegex = /[0-9]/;

		let requirementsMet = 0;

		if (password.length >= 6) {
			requirementsMet++;
		}

		if (lowercaseRegex.test(password)) {
			requirementsMet++;
		}

		if (uppercaseRegex.test(password)) {
			requirementsMet++;
		}

		if (digitRegex.test(password)) {
			requirementsMet++;
		}

		if (requirementsMet >= 3) {
			passwordMessage.innerText = '';
		} else {
			passwordMessage.innerText = '비밀번호는 최소 6자 이상이어야 하며,\n'
				+ '소문자, 대문자, 숫자 중 2개 이상을 포함해야 합니다.';
		}
		if (password === passwordCheck) {
			passwordCheckMessage.innerText = '';
			return true;
		} else {
			passwordCheckMessage.innerText = '\n비밀번호가 일치하지 않습니다.';
			return false;
		}

	}

	document.getElementById('joinBtn').addEventListener('click', function(event) {
		const isPasswordValid = validatePassword();

		if (!isPasswordValid) {
			event.preventDefault();
		}
	});
});