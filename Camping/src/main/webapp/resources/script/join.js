document.addEventListener("DOMContentLoaded", function() {
	let closeBtn = document.querySelector(".join-close-area");
	let loginModal = document.getElementById("modal");
	let modal = document.getElementById("joinModal");
	let joinBtn = document.getElementById("joinBtn");
	let passwordMessage = document.getElementById('passwordMessage');
	let passwordCheckMessage = document.getElementById('passwordCheckMessage');

	closeBtn.addEventListener("click", () => {
		modal.style.display = "none";
	});

	function validatePassword() {

		let password = document.getElementById('joinPw').value;
		let passwordCheck = document.getElementById('passwordCheck').value;
		let joinIdInput = document.getElementById('joinId').value;

		passwordMessage.innerText = '';
		passwordCheckMessage.innerText = '';
		joinIdMessage.innerText = '';

		if (joinId.trim() === '') {
			joinIdInput.style.border = "1px solid red";
			joinIdMessage.innerText = '아이디를 입력해주세요.';
		} else {
			joinIdInput.style.border = "";
		}

		if (password.trim() === '') {
			password.style.border = "1px solid red";
			passwordMessage.innerText = '비밀번호를 입력해주세요.';
		} else {
			password.style.border = "";
		}

		if (passwordCheck.trim() === '') {
			passwordCheck.style.border = "1px solid red";
			passwordCheckMessage.innerText = '비밀번호 확인을 입력해주세요.';
		} else {
			passwordCheck.style.border = "";
		}

		let lowercaseRegex = /[a-z]/;
		let uppercaseRegex = /[A-Z]/;
		let digitRegex = /[0-9]/;

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

		if (requirementsMet >= 2) {
			passwordMessage.innerText = '';
		} else {
			passwordMessage.innerText = '비밀번호는 최소 6자 이상이어야 하며,\n'
				+ '소문자, 대문자, 숫자 중 2개 이상을 포함해야 합니다.';
		}

		if (password === passwordCheck) {
			passwordCheckMessage.innerText = '';
		} else {
			passwordCheckMessage.innerText = '\n비밀번호가 일치하지 않습니다.';
		}
		return requirementsMet >= 2 && password === passwordCheck && joinId.trim() !== '' && password.trim() !== '';
	}

	joinBtn.addEventListener('click', function(event) {

		const isPasswordValid = validatePassword();
		if (!isPasswordValid) {
			event.preventDefault();
		} else {
			const registrationSuccess = true;
			if (registrationSuccess) {
				alert('회원가입이 성공적으로 완료되었습니다.');
				modal.style.display = "none";
				loginModal.style.display = "block";
			}
		}

	});

});