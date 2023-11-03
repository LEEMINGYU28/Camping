var payment = document.querySelector('.payment_info');
var isSticky = false;

window.addEventListener('scroll', function() {
	var topOffset = payment.getBoundingClientRect().top;

	if (topOffset < 0 && !isSticky) {
		payment.style.position = 'fixed';
		payment.style.top = '0';
		isSticky = true;
	} else if (topOffset >= 0 && isSticky) {
		payment.style.position = 'static';
		isSticky = false;
	}
});