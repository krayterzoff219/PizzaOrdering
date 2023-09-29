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
				v-for="id in $store.state.cart"
				:key="id"
				:cartItem="$store.state.cart[id]"></cart-item>
		</div>
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
import CartItem from "../components/CartItem.vue";
import HorizontalHero from "../components/HorizontalHero.vue";

export default {
	components: {
		AnAlert,
		HorizontalHero,
		CartItem,
	},
	name: "my-order",
	data() {
		return {
			alertText: "",
		};
	},
};
</script>

<style scoped>
section.customer-section#order-section {
	width: 97%;
	margin-bottom: var(--header-footer-inside-margin);
	max-width: 60rem;
	/* background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826"); */
}
</style>
