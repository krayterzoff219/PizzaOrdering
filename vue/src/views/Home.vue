<template>
	<div class="home">
		<div class="home-body">
			<img
				src="https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_1280.jpg"
				alt="HeroPic1" />
			<section class="testimonial-carousel">
				<div class="social-links"></div>

				<div class="carousel-inner1">
					<p></p>

					<testimonial-carousel />
				</div>
			</section>
		</div>
	</div>
</template>

<script>
import TestimonialCarousel from "../components/TestimonialCarousel.vue";
// import SmallButton from "../components/SmallButton.vue";
export default {
	// components: { SmallButton },
	components: { TestimonialCarousel },
	name: "home",
	TestimonialCarousel,
};
</script>

<style>
.home {
	display: block;
	width: 97%;
	background-color: white;
	border-radius: 25px;
	margin-bottom: var(--header-footer-inside-margin);
	margin-left: auto;
	margin-right: auto;
}

.testimonial-carousel {
	padding-top: 50px;
	margin-right: 100px;
	text-align: center;
}

/* .login-section {
	display: flex;
	background-color: white;
	width: 99%;
	border-radius: 25px;
	margin-bottom: 10px;
	margin-right: auto;
	margin-left: auto;
} */

.home-body {
	background-color: white;
	border-radius: 25px 25px;
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-template-rows: repeat(6 1fr);
	grid-template-areas:
		"heroPic description1"
		"heroPic description1";
}

.home-body > img {
	grid-area: heroPic;
	height: 800px;
	margin: 5px;
	border-radius: 25px;
	width: 90%;
}

.social-links {
	grid-area: socials;
}

.home-body .testimonial-carousel {
	grid-area: description1;
}
</style>
