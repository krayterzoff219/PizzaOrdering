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
		<the-footer></the-footer>
	</div>
</template>

<script>
import TheFooter from "./components/TheFooter.vue";
import NavBar from "./components/NavBar.vue";
export default {
	components: { NavBar, TheFooter },
};
</script>

<style>
@import url(css/styles.css);
</style>
