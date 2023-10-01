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

				<checkout-amount/>

			<div class="checkout-button">
				<router-link to="/checkout">
				<small-button
				id="buttonText"
				buttonText="Checkout"/>
				</router-link>
			</div>
			
		</div>

		

		
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
import CartItem from "../components/CartItem.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import CheckoutAmount from "../components/CheckoutAmount.vue"
import SmallButton from '../components/SmallButton.vue';



export default {



	components: {
		AnAlert,
		HorizontalHero,
		CartItem,
		CheckoutAmount,
		SmallButton
		
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

<style scoped>
section.customer-section#order-section {
	width: 97%;
	margin-bottom: var(--header-footer-inside-margin);
	max-width: 60rem;
	/* background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826"); */
}

.checkout-button{
	display: block;
	text-align: right;
	margin-right: 200px;
}


</style>
