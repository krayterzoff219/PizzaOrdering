<template>
	<div class="cart-item">
		<div class="cart-item-image-container"></div>
		<div class="cart-item-description-container">
			<h2>{{ name }}</h2>
			<quantity-counter
				:decrementHandler="decrementQuantity"
				:incrementHandler="incrementQuantity"
				:quantity="quantity"></quantity-counter>
			<h3>$ {{ (price * quantity).toFixed(2) }}</h3>
		</div>
	</div>
</template>

<script>
import QuantityCounter from "./QuantityCounter.vue";
export default {
	components: { QuantityCounter },
	props: ["cartItem", "quantity"],
	data() {
		const { id, name, price, size, sauce, crust, toppings } = this.cartItem;
		return {
			id,
			name,
			price,
			details: { size, sauce, crust, toppings },
		};
	},
	updated() {
		console.log(this.quantity);
	},
	methods: {
		incrementQuantity() {
			this.$store.commit("ADD_SINGLE_ITEM_TO_CART", this.cartItem);
		},
		decrementQuantity() {
			this.$store.commit("REMOVE_SINGLE_ITEM_FROM_CART", this.cartItem);
		},
	},
};
</script>

<style scoped>
div.cart-item {
	display: flex;
	width: 100%;
	margin-right: auto;
	margin-left: auto;
	padding: 15px 10px;
}

div.cart-item-image-container {
	background-image: url("https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	max-width: 150px;
	width: 100%;
	height: auto;
	aspect-ratio: 1 / 1;
	border-top-left-radius: var(--section-border-radius);
	border-bottom-left-radius: var(--section-border-radius);
}

div.cart-item-description-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	max-width: 35em;
	padding: 15px;
	border-bottom: 1px solid var(--dark-color);
}

div.cart-item:last-child div.cart-item-description-container {
	border-bottom: none;
}
</style>
