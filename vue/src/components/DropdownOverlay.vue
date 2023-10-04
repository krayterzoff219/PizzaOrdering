<template>
	<div
		id="page-cover"
		@click.stop="hideDropDownMenu"
		:class="{ open: $store.state.dropdownMenu.isDropDownMenuVisible }">
		<div
			id="drop-down-menu"
			:class="{ open: $store.state.dropdownMenu.isDropDownMenuVisible }">
			<router-link
				@click.stop="hideDropDownMenu"
				:to="{ name: 'home' }">
				<img
					alt="UpperCrust Pizza Logo"
					src="../assets/pizza-transparent-white.png"
			/></router-link>

			<i class="fa-solid fa-x"></i>
			<dropdown-register
				v-if="$store.state.dropdownMenu.isDropDownRegisterActivated" />
			<dropdown-login
				v-else-if="$store.state.dropdownMenu.isDropDownLoginActivated" />
			<dropdown-navigation v-else />
		</div>
	</div>
</template>

<script>
import DropdownLogin from "./DropdownLogin.vue";
import DropdownRegister from "./DropdownRegister.vue";
import DropdownNavigation from "./DropdownNavigation.vue";
export default {
	name: "dropdown-overlay",
	methods: {
		hideDropDownMenu() {
			this.$store.dispatch("hideDropDownMenu");
		},
	},
	components: {
		DropdownNavigation,
		DropdownLogin,
		DropdownRegister,
	},
};
</script>

<style scoped>
div#page-cover {
	position: fixed;
	top: calc(10vh + var(--header-footer-inside-margin));
	right: 0;
	z-index: 1000;
	background-color: rgba(18, 73, 72, 0.75);
	height: 100vh;
	width: 100vw;
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.3s cubic-bezier(0, 0, 1, 1);
}

div#drop-down-menu {
	position: fixed;
	top: 0;
	right: 1.5%; /* because the header is 97% of viewport width and centered */
	z-index: 1001;
	max-width: 745px; /* 97% of 768px */
	width: var(--header-footer-width);
	background-color: var(--dark-color);
	border-bottom-left-radius: var(--section-border-radius);
	border-bottom-right-radius: var(--section-border-radius);
	color: var(--white-color);
	max-height: 0;
	transition: max-height 0.5s cubic-bezier(0, 0, 1, 1);
	overflow: hidden;
}

@media only screen and (min-width: 768px) {
	div#drop-down-menu {
		max-width: 48.5%;
	}
}

div#drop-down-menu.open {
	max-height: 100vh;
}

div#page-cover.open {
	max-height: 100vh;
}

div#drop-down-menu > a {
	position: absolute;
	top: 0;
	left: 0;
	height: fit-content;
	width: fit-content;
}

div#drop-down-menu > a > img {
	position: absolute;
	top: 0;
	left: 0;
	padding: 20px;
	height: 60px;
	width: auto;
	cursor: pointer;
}
div#drop-down-menu > i {
	position: absolute;
	top: 0;
	right: 0;
	padding: 20px;
	cursor: pointer;
	z-index: 1002;
}
</style>
