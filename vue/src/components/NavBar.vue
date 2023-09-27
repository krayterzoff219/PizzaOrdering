<template>
	<nav>
		<router-link
			class="push-left"
			:to="{ name: 'home' }"
			><img
				src="../assets/logo-transparent-no-slogan-red-black.png"
				alt="UpperCrust Pizza Logo"
		/></router-link>
		<!-- ********************************** ROUTES FOR CUSTOMER PAGES ********************************** -->
		<router-link
			:to="{ name: 'home' }"
			v-if="!isEmployeePage"
			>Home</router-link
		>
		<router-link
			:to="{ name: 'menu' }"
			v-if="!isEmployeePage"
			>Menu</router-link
		>
		<!-- <router-link
			:to="{ name: 'about' }"
			v-if="!isEmployeePage"
			>About</router-link
		>
		<router-link
			:to="{ name: 'contact' }"
			v-if="!isEmployeePage"
			>Contact</router-link
		> -->
		<router-link
			:to="{ name: 'my-order' }"
			v-if="!isEmployeePage"
			><small-button buttonText="My Order"></small-button
		></router-link>
		<!-- ********************************** ROUTES FOR EMPLOYEE PAGES ********************************** -->
		<router-link
			:to="{ name: 'pending-orders' }"
			v-if="isEmployeePage && isLoggedIn"
			>Orders</router-link
		>
		<router-link
			:to="{ name: 'pizza-options' }"
			v-if="isEmployeePage && isLoggedIn"
			>Pizzas</router-link
		>
		<router-link
			:to="{ name: 'employee-login' }"
			v-if="isEmployeePage && !isLoggedIn && $route.path.includes('register')"
			><small-button buttonText="Login"></small-button
		></router-link>
		<router-link
			:to="{ name: 'employee-register' }"
			v-if="isEmployeePage && !isLoggedIn && $route.path.includes('login')"
			><small-button buttonText="Register"></small-button
		></router-link>
		<!-- ********************************** LOGOUT FOR BOTH PAGES ********************************** -->
		<router-link
			v-bind:to="{ name: 'logout' }"
			v-if="isLoggedIn"
			><small-button buttonText="Logout"></small-button
		></router-link>
	</nav>
</template>

<script>
import SmallButton from "./SmallButton.vue";
export default {
	components: {
		SmallButton,
	},
	computed: {
		isEmployeePage() {
			return this.$route.path.includes("employees");
		},
		isLoggedIn() {
			return this.$store.state.token != "";
		},
	},
};
</script>

<style scoped>
nav {
	--edge-padding: 30px;
	--between-padding: 30px;
	--top-bottom-padding: 15px;

	width: 97%;
	height: 10%;
	margin-right: auto;
	margin-left: auto;
	margin-bottom: var(--header-footer-inside-margin);
	padding: var(--top-bottom-padding) 0;
	position: sticky;
	display: flex;
	align-items: center;
	background-color: var(--white-color);
	border-bottom-left-radius: var(--section-border-radius);
	border-bottom-right-radius: var(--section-border-radius);
}

nav a {
	padding-right: var(--between-padding);
	color: var(--dark-color);
	text-decoration: none;
	font-family: var(--loud-font-family);
}

nav a.router-link-exact-active {
	color: var(--primary-color);
	text-decoration: underline;
}

nav a.router-link-exact-active button {
	color: var(--secondary-color);
}

nav a:first-child {
	padding-left: var(--edge-padding);
	height: 100%;
}

nav a:last-child {
	padding-right: var(--edge-padding);
}

nav a.push-left {
	margin-right: auto;
}

nav img {
	height: 100%;
	display: block;
}
</style>
