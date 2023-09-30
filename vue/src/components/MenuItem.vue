<template>
	<div
		class="customer-menu-item"
		v-if="isMenuItemAvailable">
		<div class="customer-menu-item-image-container"></div>
		<div class="customer-menu-item-description-container">
			<div class="name-price-container">
				<h2>{{ name }}</h2>
				<h3>${{ price.toFixed(2) }}</h3>
			</div>
			<small-button
				buttonText="Add to Order"
				:clickHandler="addToOrder"></small-button>
			<p>
				"Savor the irresistible allure of our Pepperoni Perfection, a culinary
				masterpiece that has stood the test of time. This iconic pizza is a
				testament to the beauty of simplicity, showcasing the finest ingredients
				and expert craftsmanship that our kitchen takes immense pride in."
			</p>
		</div>
	</div>
</template>

<script>
import SmallButton from "./SmallButton.vue";
export default {
	components: { SmallButton },
	props: ["menuItem"],
	data() {
		const { id, name, price, size, sauce, crust, toppings, isAvailable } =
			this.menuItem;
		return {
			id,
			name,
			price,
			isAvailable,
			details: { size, sauce, crust, toppings },
		};
	},
	methods: {
		addToOrder() {
			this.$store.dispatch("addItemsToCart", this.menuItem);
		
		},


	},
	computed: {
		isMenuItemAvailable() {
			// This property checks each individual item in the details to make sure it is available.
			// This protects against the situation where say the meat lovers' pizza is said to be
			// available, but salami is actually unavailable. This computed property would catch that and
			// let then be used to hide the menu item from view.
			const { isAvailable, details } = this;
			for (const descriptor in details) {
				if (Array.isArray(details[descriptor])) {
					for (const itemId of details[descriptor]) {
						if (
							!this.$store.state[descriptor].find((item) => item.id === itemId)
								.isAvailable
						)
							return false;
					}
				} else {
					if (!details[descriptor].available) return false;
				}
			}
			return isAvailable;
		},
	},
};
</script>

<style scoped>
div.customer-menu-item {
	display: flex;
	width: 100%;
	margin-right: auto;
	margin-left: auto;
	padding: 15px 10px;
}

/* ********** image container ********** */
div.customer-menu-item-image-container {
	background-image: url("https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	max-width: 300px;
	width: 100%;
	height: auto;
	aspect-ratio: 1 / 1;
}
div.customer-menu-item:nth-child(2n) div.customer-menu-item-image-container {
	order: 1;
	border-top-left-radius: var(--section-border-radius);
	border-bottom-left-radius: var(--section-border-radius);
}
div.customer-menu-item:nth-child(2n - 1)
	div.customer-menu-item-image-container {
	order: 2;
	border-top-right-radius: var(--section-border-radius);
	border-bottom-right-radius: var(--section-border-radius);
}
/* ********** text container ********** */
div.customer-menu-item-description-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	max-width: 35em;
	padding: 15px;
	border-bottom: 1px solid var(--dark-color);
}

div.customer-menu-item:last-child div.customer-menu-item-description-container {
	border-bottom: none;
}

div.customer-menu-item:nth-child(2n)
	div.customer-menu-item-description-container {
	order: 2;
}
div.customer-menu-item:nth-child(2n - 1)
	div.customer-menu-item-description-container {
	order: 1;
}

/* **************************************************************************** */

div.name-price-container {
	display: flex;
	align-items: flex-end;
	gap: 15px;
}

div.customer-menu-item:nth-child(2n-1) div.name-price-container {
	justify-content: flex-start;
	flex-direction: row-reverse;
	text-align: right;
}

h2,
h3 {
	display: inline-block;
}

h2 {
	flex-grow: 0;
	flex-shrink: 1;
	font-family: var(--loud-font-family);
}

h3 {
	flex-grow: 1;
	flex-shrink: 1;
	color: var(--primary-color);
}

p {
	text-align: justify;
}

button {
	align-self: flex-start;
	margin: 10px 0;
}

div.customer-menu-item:nth-child(2n-1) button {
	align-self: flex-end;
}
</style>
