/**first slider*/ 
$('.slider-n1')
.not("slick-started")
.slick({
    autoplay:true,
    autoplaySpeed:2500,
    dots:true,
    prevArrow:".site-slider.slider-btn.prev",
    nextArrow:".site-slider.slider-btn.next"
});
