document.addEventListener('DOMContentLoaded', function() {
  // Slider principal en el header
  var swiper1 = new Swiper('.mySwiper-1', {
      loop: true,
      navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
      },
      autoplay: {
          delay: 3000,
          disableOnInteraction: false,
      },
  });

  var swiper2 = new Swiper('.mySwiper-2', {
    // Opciones del slider
    loop: true,
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });
});
