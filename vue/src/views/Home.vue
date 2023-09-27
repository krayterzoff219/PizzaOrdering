<template>
	<div class="home">

		<div class="home-body">

			<img
				src="https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_1280.jpg"
				alt="HeroPic1" />

			<div class="page-filler">
        
				<div class="social-links">
          <p>This is where the social links for instagram, twitter, and facebook will go.</p>
          <!-- <social-icons/> -->
        </div>

				<div class="carousel">
					<testimonial-carousel />
				</div>

        <div class="maps-image">
          <img src="https://www.google.com/maps/d/thumbnail?mid=1E3bwSOJUVCAcZRerfL9Jpp8vWTM&hl=en_US" alt="mapsPic"/>
        </div>

			</div>

		</div>

	</div>
</template>

<script>

// import SocialIcons from '../components/SocialIcons.vue';
import TestimonialCarousel from "../components/TestimonialCarousel.vue";
// import SmallButton from "../components/SmallButton.vue";
export default {
	// components: { SmallButton},
	components: { TestimonialCarousel, },
	name: "home",
	
// SocialIcons, TestimonialCarousel,
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

.page-filler {
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
	background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826");
	border-radius: 25px 25px;
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-template-rows: repeat(3 1fr);
	grid-template-areas:
		"heroPic socials"
		"heroPic description1"
    "heroPic mapsImg";
}

.home-body > img {
  
	grid-area: heroPic;
	margin: 5px;
  margin-bottom: 5px;
	border-radius: 25px;
  border:  #124948 solid 5px;
	width: 90%;
}

.social-links {
	grid-area: socials;
  border: #124948 solid 10px;
  border-radius: 25px;
  background-color: white;
  margin: 50px;
}

.home-body .testimonial-carousel {
	grid-area: description1;
  background-color: white;
  margin: 50px auto;
  padding: 15px;
  border: #124948 solid 10px;
  border-radius: 25px;
}



.maps-image > img{
  margin: 25px;
  grid-area: mapsImg;
  border-radius: 10%;
  border: #124948 solid 10px;
}
</style>
