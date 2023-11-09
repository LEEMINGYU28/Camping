/**
 * 
 */
// Modal을 가져옵니다.
let modals = document.getElementsByClassName("modal");
// Modal을 띄우는 클래스 이름을 가져옵니다.
let btns = document.getElementsByClassName("btn");
// Modal을 닫는 close 클래스를 가져옵니다.
let spanes = document.getElementsByClassName("close");
let funcs = [];

// Modal을 띄우고 닫는 클릭 이벤트를 정의한 함수
function Modal(num) {
	return function() {
		// 해당 클래스의 내용을 클릭하면 Modal을 띄웁니다.
		btns[num].onclick = function() {
			modals[num].style.display = "block";
			console.log(num);
		};

		// <span> 태그(X 버튼)를 클릭하면 Modal이 닫습니다.
		spanes[num].onclick = function() {
			modals[num].style.display = "none";
		};
	};
}

// 원하는 Modal 수만큼 Modal 함수를 호출해서 funcs 함수에 정의합니다.
for (let i = 0; i < btns.length; i++) {
	funcs[i] = Modal(i);
}

// 원하는 Modal 수만큼 funcs 함수를 호출합니다.
for (let j = 0; j < btns.length; j++) {
	funcs[j]();
}

// Modal 영역 밖을 클릭하면 Modal을 닫습니다.
window.onclick = function(event) {
	if (event.target.className == "modal") {
		event.target.style.display = "none";
	}
};
window.addEventListener("keyup", e => {
    if (e.key === "Escape") { // 키보드 이벤트의 key 속성을 확인하여 Escape 키를 감지합니다.
        for (let modal of modals) {
            if (modal.style.display === "block") { // 열린 모달 창이 있는지 확인합니다.
                modal.style.display = "none"; // Escape 키를 누를 때 열린 모달 창을 닫습니다.
            }
        }
    }
});