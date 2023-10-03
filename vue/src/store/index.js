import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

const sortArrayByName = (array) =>
	array.sort((a, b) => {
		if (a.name < b.name) {
			return -1;
		}
		if (a.name > b.name) {
			return 1;
		}
		return 0;
	});

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
		cart: {},
		subtotal: 0,
		isDropDownMenuVisible: false,
		isDropDownLoginActivated: true,
		nextCustomPizzaId: -1,
	},
	mutations: {
		GO_TO_NEXT_CUSTOM_PIZZA_ID(state) {
			state.nextCustomPizzaId--;
		},
		ADD_TOPPING(state, payload) {
			state.toppings.push(payload);
		},
		ADD_SAUCE(state, payload) {
			state.sauces.push(payload);
		},
		ADD_CRUST(state, payload) {
			state.crusts.push(payload);
		},
		ADD_SIZE(state, payload) {
			state.sizes.push(payload);
		},
		ADD_SPECIALTY_PIZZA(state, payload) {
			state.specialtyPizzas.push(payload);
		},
		UPDATE_SPECIALTY_PIZZA(state, payload) {
			const pizza = state.specialtyPizzas.find(
				(specialtyPizza) => specialtyPizza.id === payload.id
			);
			const {
				crust,
				description,
				id,
				imageURL,
				isAvailable,
				name,
				price,
				sauce,
				size,
				toppings,
			} = payload;
			pizza.crust = crust;
			pizza.description = description;
			pizza.id = id;
			pizza.imageURL = imageURL;
			pizza.isAvailable = isAvailable;
			pizza.name = name;
			pizza.price = price;
			pizza.sauce = sauce;
			pizza.size = size;
			pizza.toppings = toppings;
		},
		UPDATE_CUSTOM_PIZZA(state, payload) {
			const pizza = state.cart[payload.id];
			const { toppings, crust, sauce, size, price } = payload;
			pizza.toppings = toppings;
			pizza.crust = crust;
			pizza.sauce = sauce;
			pizza.size = size;
			pizza.price = price;
		},
		ADD_SINGLE_ITEM_TO_CART(state, payload) {
			if (!([payload.id] in state.cart)) {
				state.cart = {
					...state.cart,
					[payload.id]: { ...payload, quantity: 1 },
				};
			} else {
				state.cart[payload.id].quantity++;
			}
		},
		REMOVE_SINGLE_ITEM_FROM_CART(state, payload) {
			if ([payload.id] in state.cart) {
				if (state.cart[payload.id].quantity === 1) {
					delete state.cart[payload.id];
					state.cart = { ...state.cart };
				} else {
					state.cart[payload.id].quantity--;
				}
			}
		},
		UPDATE_SUBTOTAL(state, payload) {
			state.subtotal += payload;
		},
		RESET_SUBTOTAL(state) {
			state.subtotal = 0;
		},
		LOAD_TOPPINGS(state, payload) {
			state.toppings = sortArrayByName(payload);
		},
		LOAD_SAUCES(state, payload) {
			state.sauces = sortArrayByName(payload);
		},
		LOAD_CRUSTS(state, payload) {
			state.crusts = sortArrayByName(payload);
		},
		LOAD_SIZES(state, payload) {
			state.sizes = sortArrayByName(payload);
		},
		LOAD_SPECIALTY_PIZZAS(state, payload) {
			state.specialtyPizzas = sortArrayByName(payload);
		},
		UNLOAD_MENU(state) {
			state.specialtyPizzas = [];
			state.sauces = [];
			state.sizes = [];
			state.crusts = [];
			state.toppings = [];
		},
		CLEAR_CART(state) {
			state.cart = {};
		},
		LOAD_PENDING_ORDERS(state, payload) {
			state.pendingOrders = payload;
		},
		TOGGLE_DROP_DOWN_MENU(state) {
			state.isDropDownMenuVisible = !state.isDropDownMenuVisible;
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

	actions: {
		addItemToCart(context, item) {
			context.commit("ADD_SINGLE_ITEM_TO_CART", item);
			context.commit("UPDATE_SUBTOTAL", item.price);
		},

		removeItemFromCart(context, item) {
			context.commit("REMOVE_SINGLE_ITEM_FROM_CART", item);
			context.commit("UPDATE_SUBTOTAL", -item.price);
		},

		updateExistingCustomPizza(context, payload) {
			context.commit("UPDATE_CUSTOM_PIZZA", payload.pizza);
			context.commit("UPDATE_SUBTOTAL", payload.priceDifference);
		},
	},
});
