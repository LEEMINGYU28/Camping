
document.addEventListener("DOMContentLoaded", function() {
	let allAgreeCheckbox = document.getElementById('allAgreeCheckbox');
	let loginmodal = document.getElementById("modal");
	let modal = document.getElementById("consentModal");
	let closeBtn = document.querySelector(".close-areas");
	let agreeButton = document.getElementById("nextModalbtn");
	let agreeCheckbox = document.getElementById("agreeCheckbox");
	let agreebox = document.getElementById("agreebox");
	let checkboxes = document.querySelectorAll('input[type="checkbox"]');
	let signupButton = document.getElementById("signup-button");


	signupButton.addEventListener("click", function() {
		modal.style.display = "block";
		loginmodal.style.display = "none";
	});

	closeBtn.addEventListener("click", () => {
		modal.style.display = "none";
	});
	
	document.addEventListener("keydown", (event) => {
		if (event.key === "Escape") {
			modal.style.display = "none";
		}
	});

	checkboxes.forEach(function(checkbox) {
		checkbox.addEventListener("change", function() {
			var allChecked = true;
			checkboxes.forEach(function(cb) {
				if (cb !== allAgreeCheckbox && !cb.checked) {
					allChecked = false;
				}
			});

			if (allChecked) {
				agreeButton.disabled = false;
			} else {
				agreeButton.disabled = true;
			}
		});
	});
	allAgreeCheckbox.addEventListener("change", function() {
		var isChecked = allAgreeCheckbox.checked;
		agreeCheckbox.checked = isChecked;
		agreebox.checked = isChecked;
		agreeButton.disabled = !isChecked;
	});
});