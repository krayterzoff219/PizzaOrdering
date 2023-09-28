<template>
	<div class="social-icons">
		<!-- <font-awesome-icon icon="fa-twitter" />
        <font-awesome-icon :icon="instagramIcon" />
        <font-awesome-icon :icon="facebookIcon" /> -->
		<i
			class="fa-brands fa-x-twitter"
			style="color: black"></i
		><i
			class="fa-brands fa-instagram"
			style="color: black"></i
		><i
			class="fa-brands fa-facebook"
			style="color: black"></i>
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
</style>
;
