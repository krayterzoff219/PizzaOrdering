<template>
	<div id="app">
		<nav-bar></nav-bar>
		<!-- <div id="nav">
			<router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
			<router-link
				v-bind:to="{ name: 'logout' }"
				v-if="$store.state.token != ''"
				>Logout</router-link
			>
		</div> -->
		<router-view />
	</div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
export default {
	components: { NavBar },
};
</script>

<style>
@import url(css/styles.css);

body,
#app {
	background-color: var(--dark-color);
}

#app {
	margin: 0;
	padding-top: 5px;
	height: 100%;
	width: 100%;
}

#login {
	background-color: var(--white-color);
}
</style>
