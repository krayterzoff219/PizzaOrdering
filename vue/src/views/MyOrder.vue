<template>
	<section
		id="order-section"
		class="customer-section">
		<horizontal-hero></horizontal-hero>
		<div class="order-wrapper">
			<h1>My Order</h1>
			<an-alert
				v-if="alertText"
				:message="alertText"></an-alert>
			<cart-item
				v-for="item of cartItems"
				:key="item.id"
				:cartItem="item"
				:quantity="item.quantity"></cart-item>
			<checkout-amount
				buttonText="Checkout"
				:buttonClickHandler="() => $router.push({ name: 'checkout' })" />
		</div>
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
import CartItem from "../components/CartItem.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import CheckoutAmount from "../components/CheckoutAmount.vue";

export default {
	components: {
		AnAlert,
		HorizontalHero,
		CartItem,
		CheckoutAmount,
	},
	name: "my-order",
	data() {
		return {
			alertText: "",
		};
	},
	computed: {
		cartItems() {
			return Object.values(this.$store.state.cart).filter(
				(item) => item.quantity
			);
		},
	},
	updated() {
		if (!this.cartItems.length) {
			this.redirectToMenu();
		}
	},
	created() {
		if (!this.cartItems.length) {
			this.redirectToMenu();
		}
	},
	methods: {
		redirectToMenu() {
			this.$router.push({ name: "customer-menu" });
		},
	},
};
</script>
