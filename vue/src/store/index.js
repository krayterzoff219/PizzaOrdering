import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem("token");
const currentUser = JSON.parse(localStorage.getItem("user"));

if (currentToken != null) {
	axios.defaults.headers.common["Authorization"] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
	state: {
		token: currentToken || "",
		user: currentUser || {},
		toppings: [],
		sauces: [],
		crusts: [],
		sizes: [],
		specialtyPizzas: [],
		pendingOrders: [],
	},
	mutations: {
		ADD_TOPPING(state, payload) {
			state.toppings.push(payload);
		},
		ADD_SAUCE(state, payload) {
			state.sizes.push(payload);
		},
		ADD_CRUST(state, payload) {
			state.crusts.push(payload);
		},
		ADD_SIZE(state, payload) {
			state.sizes.push(payload);
		},
		ADD_SPECIALTY_PIZZA(state, payload) {
			state.sizes.specialtyPizzas(payload);
		},
		ADD_PENDING_ORDER(state, payload) {
			state.sizes.pendingOrders(payload);
		},
		LOAD_TOPPINGS(state, payload) {
			state.toppings = payload;
		},
		LOAD_SAUCES(state, payload) {
			state.sauces = payload;
		},
		LOAD_CRUSTS(state, payload) {
			state.crusts = payload;
		},
		LOAD_SIZES(state, payload) {
			state.sizes = payload;
		},
		LOAD_SPECIALTY_PIZZAS(state, payload) {
			state.specialtyPizzas = payload;
		},
		LOAD_PENDING_ORDERS(state, payload) {
			state.pendingOrders = payload;
		},
		SET_AUTH_TOKEN(state, token) {
			state.token = token;
			localStorage.setItem("token", token);
			axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
		},
		SET_USER(state, user) {
			state.user = user;
			localStorage.setItem("user", JSON.stringify(user));
		},
		LOGOUT(state) {
			localStorage.removeItem("token");
			localStorage.removeItem("user");
			state.token = "";
			state.user = {};
			axios.defaults.headers.common = {};
		},
	},
});
