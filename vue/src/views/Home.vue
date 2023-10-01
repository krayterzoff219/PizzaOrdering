<template>
	<section class="home">
		<div class="home-body">
			<social-icons></social-icons>
			<div id="home-hero"></div>
			<testimonial-carousel />
			<div class="maps-image"></div>

			<!-- <img
				class="hero-image1"
				src="https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_1280.jpg"
				alt="HeroPic1" />
			<img
				class="hero-image2"
				src="https://img.freepik.com/free-photo/tasty-homemade-traditional-pizza-italian-recipe_24972-2141.jpg?w=740&t=st=1695856922~exp=1695857522~hmac=1c71cb6434d5c84e5cda3473660a59b26ba0f64d28ed01c66de178805903c96a" /> -->

			<!-- <div class="page-filler"> -->

			<!-- <div class="carousel"> -->
			<!-- </div> -->

			<!-- <div class="maps-image">
					<img
						src="https://www.google.com/maps/d/thumbnail?mid=1E3bwSOJUVCAcZRerfL9Jpp8vWTM&hl=en_US"
						alt="mapsPic" />
				</div> -->
			<!-- </div> -->
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
	width: 97%;
	background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	margin-bottom: var(--header-footer-inside-margin);
	margin-left: auto;
	margin-right: auto;
	flex-grow: 1;
	flex-shrink: 1;
}
.home-body {
	display: flex;
	/* grid-template-areas:
		"heroPic socials"
		"heroPic description1"
		"heroPic mapsImg"; */
	flex-direction: column;
	/* margin: var(--section-border-radius) auto; */
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
	/* margin: 0 20px; */
	border-bottom: 10px solid var(--dark-color);
}

@media only screen and (min-width: 600px) {
	div#home-hero {
		border-top-right-radius: var(--section-border-radius);
		border-top-left-radius: var(--section-border-radius);
	}
}

.page-filler {
	padding-top: 10px;
	margin-right: 100px;
	text-align: center;
}

/* .hero-image1 {
	grid-area: heroPic;
	margin: 10px;
	margin-bottom: 10px;
	border-radius: 25px;
	border: #124948 solid 5px;
	width: 92%;
}

.hero-image2 {
	display: none;
} */

.social-links {
	grid-area: socials;
	border: #124948 solid 10px;
	border-radius: 25px;
	background-color: white;
	margin: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 10px;
}

/* .home-body .testimonial-carousel {
	grid-area: description1;
	background-color: white;
	margin: 100px auto;
	padding: 15px;
	border: #124948 solid 10px;
	border-radius: 25px;
} */

/* .carousel {
	box-sizing: border-box;
	max-height: 500px;
	max-width: 100%;
} */

/* .maps-image > img {
	margin: 25px;
	grid-area: mapsImg;
	border-radius: 10%;
	border: #124948 solid 10px;
} */

/* @media screen and (max-width: 820px) { */
/* .page-filler {
		padding-top: 30px;
		margin-right: auto;
		margin-left: auto;
		text-align: center;
	} */

.home-body {
	/* background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826"); */
	/* border-radius: 25px 25px;
		display: grid;
		grid-template-columns: 1fr;
		grid-template-rows: repeat(6 1fr);
		grid-template-areas:
			"heroPic"
			"socials"
			"description1"
			"mapsImg";
		justify-content: center;
		align-items: center; */
}

/* .hero-image1 {
		display: none;
		grid-area: heroPic;
		margin-right: auto;
		margin-left: auto;
		margin-bottom: 5px;
		border-radius: 25px;
		border: #124948 solid 5px;
		width: 92%;
		height: 700px;
	}

	.hero-image2 {
		display: block;
		margin-left: auto;
		margin-right: auto;
		margin-top: 15px;
		border-top-left-radius: 25px;
border-top-right-radius: 25px;
		border-radius: 25px;
		border: #124948 solid 5px;
		width: 92%;
	} */
/* } */
</style>
