<template>
	<div class="home">
		<div class="login-section">
			<small-button buttonText="Login"></small-button>
			<p>
				Don't have an account yet?
				<router-link :to="{ name: 'Employee-Register' }">Register</router-link>
			</p>
		</div>
		<div class="home-body">
			<img
				src="https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_1280.jpg"
				alt="HeroPic1" />
			<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
				tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
				veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
				commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
				velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
				occaecat cupidatat non proident, sunt in culpa qui officia deserunt
				mollit anim id est laborum.
			</p>
		</div>
	</div>
</template>

<script>
import SmallButton from "../components/SmallButton.vue";
export default {
	components: { SmallButton },
	name: "home",
};
</script>

<style>
.home {
	display: inline;
	background-color: white;
	border-radius: 25px;
	margin-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
}

.login-section {
	display: flex;
	background-color: white;
	width: 99%;
	border-radius: 25px;
	margin-bottom: 10px;
	margin-right: auto;
	margin-left: auto;
}

.home-body {
	background-color: white;
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
}

.home-body > p :nth-child(1) {
	grid-area: description1;
}
</style>
