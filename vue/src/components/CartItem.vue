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
					{{ `$${price.toFixed(2)} &nbsp;x&nbsp; ${quantity} &nbsp;=&nbsp;` }}
					<span>{{ `$${(price * quantity).toFixed(2)}` }}</span>
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
	justify-content: center;
	padding: 15px 10px;
}

/* ********** image container ********** */
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

/* ********** text container ********** */
div.cart-item-description-container {
	display: flex;
	flex-direction: column;
	justify-content: flex-end;
	max-width: 35em;
	width: 100%;
	padding: 15px;
	border-bottom: 1px solid var(--dark-color);
	gap: 15px;
}

/* **************************************************************************** */

div.quantity-price-container {
	display: flex;
	align-items: center;
	gap: 15px;
	width: fit-content;
}

h3 span {
	color: var(--primary-color);
}

h2 {
	font-family: var(--loud-font-family);
}

div.single-detail-container {
	display: flex;
}

p span {
	font-weight: bold;
}
</style>
