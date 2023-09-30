<template>
	<div
		id="page-cover"
		@click="hideDropDownMenu"
		:class="{
			'hide-drop-down-menu': $store.state.isDropDownMenuVisible,
		}">
		<div id="drop-down-menu">
			<ul>
				<router-link
					:to="{ name: 'home' }"
					@click.stop="hideDropDownMenu"
					><li>Home</li></router-link
				>
				<!-- ********************************** ROUTES FOR CUSTOMER PAGES ********************************** -->
				<router-link
					:to="{ name: 'customer-menu' }"
					v-if="!isEmployeePage"
					@click.stop="hideDropDownMenu"
					><li>Menu</li></router-link
				>
				<router-link
					:to="{ name: 'my-order' }"
					v-if="
						!isEmployeePage &&
						!isOrderPage &&
						Object.keys($store.state.cart).length
					"
					@click.stop="hideDropDownMenu"
					><li>My Order</li></router-link
				>
				<router-link
					:to="{ name: 'checkout' }"
					v-if="isOrderPage"
					@click.stop="hideDropDownMenu"
					><li>Checkout</li></router-link
				>
				<!-- ********************************** ROUTES FOR EMPLOYEE PAGES ********************************** -->
				<router-link
					:to="{ name: 'pending-orders' }"
					v-if="isEmployeePage && isLoggedIn"
					@click.stop="hideDropDownMenu"
					><li>Orders</li></router-link
				>
				<router-link
					:to="{ name: 'specialty-pizzas' }"
					v-if="isEmployeePage && isLoggedIn"
					@click.stop="hideDropDownMenu"
					><li>Pizzas</li></router-link
				>
				<router-link
					:to="{ name: 'pizza-options' }"
					v-if="isEmployeePage && isLoggedIn"
					@click.stop="hideDropDownMenu"
					><li>Options</li></router-link
				>
				<router-link
					:to="{ name: 'employee-login' }"
					v-if="
						isEmployeePage && !isLoggedIn && $route.path.includes('register')
					"
					@click.stop="hideDropDownMenu"
					><li>Login</li></router-link
				>
				<router-link
					:to="{ name: 'employee-register' }"
					v-if="isEmployeePage && !isLoggedIn && $route.path.includes('login')"
					><li>Register</li></router-link
				>

				<!-- ********************************** LOGOUT FOR BOTH PAGES ********************************** -->
				<router-link
					v-bind:to="{ name: 'logout' }"
					v-if="isLoggedIn"
					class="hide-when-small-screen"
					@click.stop="hideDropDownMenu"
					><li>Logout</li></router-link
				>
			</ul>
		</div>
	</div>
</template>

<script>
export default {
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
		hideDropDownMenu() {
			this.$store.commit("TOGGLE_DROP_DOWN_MENU");
		},
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
}

div#page-cover.hide-drop-down-menu {
	display: none;
}

div#drop-down-menu {
	--list-item-between-padding: 25px;
	--list-item-horizontal-padding: 25px;
	color: var(--white-color);
}

ul,
li {
	margin: 0;
	padding: 0;
}

ul {
	padding: var(--list-item-horizontal-padding);
	text-align: center;
}

li {
	color: var(--white-color);
	list-style: none;
	font-family: var(--loud-font-family);
	padding-bottom: var(--list-item-between-padding);
	padding-top: var(--list-item-between-padding);
}

a:not(:first-child) li {
	border-top: 2px solid var(--white-color);
}

a {
	display: block;
	max-width: 20rem;
	width: 100%;
	margin-right: auto;
	margin-left: auto;
}

div#page-cover::after {
	height: 100vh;
	width: 100vw;
}

div#drop-down-menu {
	position: fixed;
	top: 0;
	right: 1.5%;
	z-index: 1001;
	max-width: 582px; /* 97% of 600px */
	width: 97%;
	background-color: var(--dark-color);
	border-bottom-left-radius: var(--section-border-radius);
	border-bottom-right-radius: var(--section-border-radius);
}
</style>
