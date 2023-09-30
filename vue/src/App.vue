<template>
	<div id="app">
		<nav-bar></nav-bar>
		<dropdown-overlay></dropdown-overlay>
		<router-view />
		<the-footer></the-footer>
	</div>
</template>

<script>
import TheFooter from "./components/TheFooter.vue";
import NavBar from "./components/NavBar.vue";
import DropdownOverlay from "./components/DropdownOverlay.vue";
export default {
	components: { NavBar, TheFooter, DropdownOverlay },
};
</script>

<style>
@import url(css/styles.css);
</style>
