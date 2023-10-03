<template>
	<div id="app">
		<nav-bar />
		<dropdown-overlay />
		<router-view />
		<call-to-action-buttons
			v-if="
				$route.name !== 'checkout' && !$route.path.includes('customize-pizza')
			" />
		<the-footer />
	</div>
</template>

<script>
import TheFooter from "./components/TheFooter.vue";
import NavBar from "./components/NavBar.vue";
import DropdownOverlay from "./components/DropdownOverlay.vue";
import CallToActionButtons from "./components/CallToActionButtons.vue";
export default {
	components: {
		NavBar,
		TheFooter,
		DropdownOverlay,
		CallToActionButtons,
	},
};
</script>

<style>
@import url(css/styles.css);
</style>
