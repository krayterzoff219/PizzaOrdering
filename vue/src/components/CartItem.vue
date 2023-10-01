<template>
	<div class="cart-item">
		<div class="cart-item-image-container"></div>
		<div class="cart-item-description-container">
			<h2>{{ name }}</h2>
			<div class="quantity-price-container">
				<quantity-counter
					:decrementHandler="decrementQuantity"
					:incrementHandler="incrementQuantity"
					:quantity="quantity"></quantity-counter>
				<h3 v-if="quantity === 1">
					<span>{{ `$${price.toFixed(2)}` }}</span>
				</h3>
				<h3 v-else>
					<div>{{ `$${price.toFixed(2)}` }}</div>
					<div>{{ ` &nbsp;x&nbsp; ${quantity} &nbsp;=&nbsp;` }}</div>
					<div>
						<span>{{ `$${(price * quantity).toFixed(2)}` }}</span>
					</div>
				</h3>
			</div>
			<div class="cart-details-container">
				<!-- FOR EVERY DETAIL THAT IS NOT AN ARRAY (I.E., SAUCE, SIZE, AND CRUST) -->
				<div
					class="single-detail-container"
					v-for="detail of Object.keys(details).filter(
						(detail) => !Array.isArray(details[detail])
					)"
					:key="detail">
					<p :key="detail">
						<!-- "Sauce:" "Crust:" "Size:" -->
						<span
							>{{ detail.charAt(0).toUpperCase() + detail.slice(1) }}:
							&nbsp;</span
						>
					</p>
					<p :key="details[detail].name">
						<!-- "Small" "Medium" "Cheesy" "Regular" "Marinara" -->
						{{ details[detail].name }}
					</p>
				</div>

				<!-- FOR EVERY DETAIL THAT IS AN ARRAY (I.E., TOPPINGS) -->
				<div
					:key="detail"
					class="single-detail-container"
					v-for="detail of Object.keys(details).filter((detail) =>
						Array.isArray(details[detail])
					)">
					<p :key="detail">
						<!-- "Topping(s):" -->
						<span
							>{{
								detail.charAt(0).toUpperCase() +
								(details[detail].length === 1
									? detail.slice(1, -1)
									: detail.slice(1))
							}}: &nbsp;</span
						>
					</p>
					<!-- prettier-ignore -->
					<p
						v-for="(itemId, index) of details[detail]"
						:key="`${detail}-${itemId}`"
						class="example" 
                        >{{
                            $store.state[detail].find((item) => item.id === itemId).name
                        }}{{ 
                            index !== details[detail].length - 1 ? ",&nbsp;" : "" 
                        }}</p
                    >
					<!-- "bacon, ham, pineapple" -->
				</div>
			</div>
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
			details: {
				size,
				sauce,
				crust,
				toppings,
			},
		};
	},
	methods: {
		incrementQuantity() {
			this.$store.dispatch("addItemToCart", this.cartItem);
		},
		decrementQuantity() {
			this.$store.dispatch("removeItemFromCart", this.cartItem);
		},
	},
};
</script>

<style scoped>
div.cart-item {
	display: grid;
	grid-template-columns: 1fr 2fr;
	width: 100%;
	justify-content: center;
	padding: 15px 10px;
}

/* ********** image container ********** */
div.cart-item-image-container {
	background-image: url("https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	max-width: 275px;
	width: 100%;
	height: auto;
	border-top-left-radius: var(--section-border-radius);
	border-bottom-left-radius: var(--section-border-radius);
	min-width: 100px;
}

/* ********** text container ********** */
div.cart-item-description-container {
	display: grid;
	grid-template-areas:
		"item-name"
		"quantity-price"
		"item-details";
	max-width: 35em;
	width: 100%;
	padding: 15px;
	border-bottom: 1px solid var(--dark-color);
	gap: 15px;
	justify-content: start;
}

/* **************************************************************************** */

div.quantity-price-container {
	display: flex;
	align-items: center;
	gap: 15px;
	width: fit-content;
	grid-area: quantity-price;
}

div.cart-details-container {
	grid-area: item-details;
}

h3 {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

h3 div {
	min-width: max-content;
}

h3 span {
	color: var(--primary-color);
}

h2 {
	font-family: var(--loud-font-family);
	grid-area: item-name;
	height: fit-content;
	align-self: top;
}

div.single-detail-container {
	display: flex;
	flex-wrap: wrap;
	padding-top: 3px;
}

p span {
	font-weight: bold;
}

@media only screen and (min-width: 768px) {
	div.cart-item {
		display: flex;
	}

	div.cart-item-description-container {
		grid-template-areas:
			"item-name item-details"
			"quantity-price quantity-price";
		grid-template-columns: 1fr 1fr;
		column-gap: 50px;
	}

	h2 {
		min-width: 14rem;
		padding-top: 0.5rem;
	}

	div.cart-item-image-container {
		max-width: 175px;
		aspect-ratio: 1 / 1;
	}
}
</style>
