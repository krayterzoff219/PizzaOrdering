<template>
	<div id="app">
		<nav-bar />
		<dropdown-overlay />
		<router-view />
		<call-to-action-button />
		<the-footer />
	</div>
</template>

<script>
import TheFooter from "./components/TheFooter.vue";
import NavBar from "./components/NavBar.vue";
import DropdownOverlay from "./components/DropdownOverlay.vue";
import CallToActionButton from "./components/CallToActionButton.vue";
export default {
	components: { NavBar, TheFooter, DropdownOverlay, CallToActionButton },
};
</script>

<style>
@import url(css/styles.css);
</style>
