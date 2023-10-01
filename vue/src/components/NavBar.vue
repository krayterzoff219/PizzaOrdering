<template>
	<div id="nav-wrapper">
		<nav>
			<router-link
				class="push-left"
				:to="{ name: 'home' }"
				><img
					src="../assets/logo-transparent-no-slogan-red-black.png"
					alt="UpperCrust Pizza Logo"
			/></router-link>
			<i
				class="fa-solid fa-bars show-when-small-screen"
				@click="showDropDownMenu"></i>
			<router-link
				:to="{ name: 'home' }"
				v-if="!isEmployeePage"
				class="jump hide-when-small-screen"
				>Home</router-link
			>
			<!-- ********************************** ROUTES FOR CUSTOMER PAGES ********************************** -->
			<router-link
				:to="{ name: 'customer-menu' }"
				v-if="!isEmployeePage"
				class="jump hide-when-small-screen"
				>Menu</router-link
			>
			<router-link
				class="hide-when-small-screen"
				:to="{ name: 'my-order' }"
				v-if="
					!isEmployeePage &&
					!isOrderPage &&
					Object.keys($store.state.cart).length
				"
				><small-button buttonText="My Order"></small-button
			></router-link>
			<router-link
				class="hide-when-small-screen"
				:to="{ name: 'checkout' }"
				v-if="isOrderPage"
				><small-button buttonText="Checkout"></small-button
			></router-link>
			<!-- ********************************** ROUTES FOR EMPLOYEE PAGES ********************************** -->
			<router-link
				:to="{ name: 'pending-orders' }"
				v-if="isEmployeePage && isLoggedIn"
				class="jump hide-when-small-screen"
				>Orders</router-link
			>
			<router-link
				:to="{ name: 'specialty-pizzas' }"
				v-if="isEmployeePage && isLoggedIn"
				class="jump hide-when-small-screen"
				>Pizzas</router-link
			>
			<router-link
				:to="{ name: 'pizza-options' }"
				v-if="isEmployeePage && isLoggedIn"
				class="jump hide-when-small-screen"
				>Options</router-link
			>
			<router-link
				:to="{ name: 'employee-login' }"
				class="hide-when-small-screen"
				v-if="isEmployeePage && !isLoggedIn && $route.path.includes('register')"
				><small-button buttonText="Login"></small-button
			></router-link>
			<router-link
				:to="{ name: 'employee-register' }"
				class="hide-when-small-screen"
				v-if="isEmployeePage && !isLoggedIn && $route.path.includes('login')"
				><small-button buttonText="Register"></small-button
			></router-link>
			<!-- ********************************** LOGOUT FOR BOTH PAGES ********************************** -->
			<router-link
				v-bind:to="{ name: 'logout' }"
				v-if="isLoggedIn"
				class="hide-when-small-screen"
				><small-button buttonText="Logout"></small-button
			></router-link>
		</nav>
	</div>
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
		isOrderPage() {
			return this.$route.path.includes("my-order");
		},
		isLoggedIn() {
			return this.$store.state.token != "";
		},
	},
	methods: {
		showDropDownMenu() {
			this.$store.commit("TOGGLE_DROP_DOWN_MENU");
		},
	},
};
</script>

<style scoped>
div#nav-wrapper {
	height: calc(10% + var(--header-footer-inside-margin));
	width: 97%;
	padding-bottom: var(--header-footer-inside-margin);
	background-color: var(--dark-color);
	position: fixed;
	top: 0;
	z-index: 999;
}

nav {
	--edge-padding: 30px;
	--between-padding: 30px;
	--top-bottom-padding: 15px;
	width: 100%;
	height: 100%;
	margin-right: auto;
	margin-left: auto;
	padding: var(--top-bottom-padding) 0;
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

nav a:last-child,
nav i {
	padding-right: var(--edge-padding);
}

nav a.push-left {
	margin-right: auto;
}

nav img {
	height: 100%;
	display: block;
	max-width: 100%;
}

nav a.hide-when-small-screen {
	display: none;
}

nav i.show-when-small-screen {
	display: inline;
}

nav i {
	cursor: pointer;
}

@media only screen and (min-width: 768px) {
	nav a.hide-when-small-screen {
		display: inline;
	}
	nav i.show-when-small-screen {
		display: none;
	}
}
</style>
