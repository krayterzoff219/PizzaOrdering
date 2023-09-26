import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import EmployeeLogin from "../views/EmployeeLogin.vue";
import Logout from "../views/Logout.vue";
import EmployeeRegister from "../views/EmployeeRegister.vue";
import PendingOrders from "../views/PendingOrders.vue";
import PizzaOptions from "../views/PizzaOptions.vue";
import store from "../store/index";

Vue.use(Router);

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
	mode: "history",
	base: process.env.BASE_URL,
	routes: [
		{
			path: "/",
			name: "home",
			component: Home,
			meta: {
				requiresAuth: false,
			},
		},
		{
			path: "/employees/login",
			name: "employee-login",
			component: EmployeeLogin,
			meta: {
				requiresAuth: false,
			},
		},
		{
			path: "/employees/register",
			name: "employee-register",
			component: EmployeeRegister,
			meta: {
				requiresAuth: false,
			},
		},
		{
			path: "/employees/pending-orders",
			name: "pending-orders",
			component: PendingOrders,
			meta: {
				requiresAuth: true,
			},
		},
		{
			path: "/employees/pizza-options",
			name: "pizza-options",
			component: PizzaOptions,
			meta: {
				requiresAuth: true,
			},
		},
		{
			path: "/logout",
			name: "logout",
			component: Logout,
			meta: {
				requiresAuth: false,
			},
		},
	],
});

router.beforeEach((to, from, next) => {
	// Determine if the route requires Authentication
	const requiresAuth = to.matched.some((x) => x.meta.requiresAuth);

	// If it does and they are not logged in, send the user to "/employees/login"
	if (requiresAuth && store.state.token === "") {
		next("/employees/login");
	} else {
		// Else let them go to their next destination
		next();
	}
});

export default router;
