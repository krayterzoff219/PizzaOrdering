<template>
	<div class="social-icons">
		<!-- <font-awesome-icon icon="fa-twitter" />
        <font-awesome-icon :icon="instagramIcon" />
        <font-awesome-icon :icon="facebookIcon" /> -->

		<a href="https://twitter.com/"><i
			class="fa-brands fa-x-twitter"
			style="color: black" ></i
		></a>

		<a href="https://www.instagram.com/"><i
			class="fa-brands fa-instagram"
			style="color: black"></i
		></a>
		
		<a href="https://www.facebook.com/"><i
			class="fa-brands fa-facebook"
			style="color: black"></i
		></a>
	</div>
</template>

<script>
// import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
// import { faTwitter, faInstagram, faFacebook } from "@fortawesome/free-brands-svg-icons";

export default {
	// components: {
	//     FontAwesomeIcon,
	// },
	data() {
		return {
			// twitterIcon: faTwitter,
			// instagramIcon: faInstagram,
			// facebookIcon: faFacebook,
		};
	},
};
</script>
<style>
.social-icons {
	display: flex;
	justify-content: center;
	align-items: center;
	
}

.fa-brands {
	margin-left: 60px;
	margin-right: 60px;
	font-size: 30px;
}

</style>
;
