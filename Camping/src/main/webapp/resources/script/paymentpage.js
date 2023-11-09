window.addEventListener('scroll', function() {
    var paymentMethod = document.querySelector('.payment_method');
    
    if (paymentMethod) {
        var scrollY = window.scrollY || window.pageYOffset;
        var paymentMethodTop = paymentMethod.getBoundingClientRect().top;

        if (scrollY > paymentMethodTop) {
            paymentMethod.style.top = scrollY - paymentMethodTop + 'px';
        } else {
            paymentMethod.style.top;
        }
    }
});