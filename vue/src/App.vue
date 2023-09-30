<template>
	<div id="app">
		<nav-bar></nav-bar>
		<dropdown-menu></dropdown-menu>
		<router-view />
		<the-footer></the-footer>
	</div>
</template>

<script>
import TheFooter from "./components/TheFooter.vue";
import NavBar from "./components/NavBar.vue";
import DropdownMenu from "./components/DropdownMenu.vue";
export default {
	components: { NavBar, TheFooter, DropdownMenu },
};
</script>

<style>
@import url(css/styles.css);
</style>
