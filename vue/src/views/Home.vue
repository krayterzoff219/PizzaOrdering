<template>
	<section class="home">
		<div class="home-body">
			<social-icons />
			<div id="home-hero"></div>
			<testimonial-carousel />
			<div class="maps-image"></div>
		</div>
	</section>
</template>

<script>
import TestimonialCarousel from "../components/TestimonialCarousel.vue";
import SocialIcons from "../components/SocialIcons.vue";
export default {
	components: { TestimonialCarousel, SocialIcons },
	name: "home",
};
</script>

<style>
section.home {
	width: var(--section-width);
	background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	margin-bottom: var(--header-footer-inside-margin);
	margin-left: auto;
	margin-right: auto;
	flex-grow: 1;
	flex-shrink: 1;
	max-width: 1400px;
}
.home-body {
	display: flex;
	flex-direction: column;
	border-radius: var(--section-border-radius);
	background-color: transparent;
	height: 100%;
}

div#home-hero {
	background-image: url("https://img.freepik.com/free-photo/tasty-homemade-traditional-pizza-italian-recipe_24972-2141.jpg?w=740&t=st=1695856922~exp=1695857522~hmac=1c71cb6434d5c84e5cda3473660a59b26ba0f64d28ed01c66de178805903c96a");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	height: 100px;
	flex-grow: 1;
	flex-shrink: 1;
	border-bottom: 10px solid var(--dark-color);
}

div.maps-image {
	display: none;
}

@media only screen and (min-width: 600px) {
	div#home-hero {
		border-top-right-radius: var(--section-border-radius);
		border-top-left-radius: var(--section-border-radius);
	}
}

@media only screen and (min-width: 768px) {
	div#home-hero {
		grid-area: hero;
		height: 100%;
		border-bottom: none;
		border-top-right-radius: 0;
		border-right: 10px solid var(--dark-color);
		background-position: bottom;
		border-bottom-left-radius: var(--section-border-radius);
		background-image: url("https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_1280.jpg");
	}

	div.home-body {
		display: grid;
		grid-template-columns: 1fr 1fr;
		grid-template-rows: auto 1fr auto;
		grid-template-areas:
			"hero social-icons"
			"hero map"
			"hero carousel";
		background-size: contain;
	}

	div.testimonial-carousel {
		grid-area: carousel;
	}

	section.home > div.home-body div.social-icons {
		grid-area: social-icons;
		align-self: start;
		justify-self: start;
	}

	div.maps-image {
		display: block;
		grid-area: map;
		height: 100%;
		width: 100%;
		background-position: center;
		background-repeat: no-repeat;
		background-size: cover;
		background-image: url("https://www.google.com/maps/d/thumbnail?mid=1E3bwSOJUVCAcZRerfL9Jpp8vWTM&hl=en_US");
		border-top: 10px solid var(--dark-color);
	}
}
</style>
