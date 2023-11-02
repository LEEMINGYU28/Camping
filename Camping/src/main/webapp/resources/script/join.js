document.addEventListener("DOMContentLoaded", function() {
	let closeBtn = document.querySelector(".join-close-area");
	let modal = document.getElementById("joinModal");
	let joinBtn = document.getElementById("joinBtn");
	let passwordMessage = document.getElementById('passwordMessage');
	let passwordCheckMessage = document.getElementById('passwordCheckMessage');

	closeBtn.addEventListener("click", () => {
		modal.style.display = "none";
	});

	function validatePassword() {
/*		const password = document.getElementById('userPw').value;
		const passwordCheck = document.getElementById('passwordCheck').value;

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

		if (requirementsMet >= 2) {
			passwordMessage.innerText = '';
		} else {
			passwordMessage.innerText = '비밀번호는 최소 6자 이상이어야 하며,\n'
				+ '소문자, 대문자, 숫자 중 2개 이상을 포함해야 합니다.';
		}

		if (password === passwordCheck) {
			passwordCheckMessage.innerText = '';
		} else {
			passwordCheckMessage.innerText = '비밀번호가 일치하지 않습니다.';
		}
		return requirementsMet >= 2 && password === passwordCheck;*/
	}

	joinBtn.addEventListener('click', function(event) {
/*		event.preventDefault();*/

		const isPasswordValid = validatePassword();
		if (isPasswordValid) {

			const registrationSuccess = true;
			if (registrationSuccess) {
				alert('회원가입이 성공적으로 완료되었습니다.');
				modal.style.display = "none"; // 모달 닫기
			}
		}
	});
});