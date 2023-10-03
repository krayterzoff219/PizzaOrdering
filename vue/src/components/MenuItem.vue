<template>
	<div
		class="customer-menu-item"
		v-if="isMenuItemAvailable || !menuItem">
		<div
			class="customer-menu-item-image-container"
			:style="{ 'background-image': `url('${imageURL}')` }"></div>
		<p class="description-small-screen">{{ description }}</p>
		<div class="customer-menu-item-description-container">
			<div class="name-price-container">
				<h2 v-if="name">{{ name }}</h2>
				<h2 v-else>{{ "Create Your Own Pizza" }}</h2>
				<h3
					v-if="price"
					class="large-screen-price">
					${{ price.toFixed(2) }}
				</h3>
			</div>
			<h3
				v-if="price"
				class="small-screen-price">
				${{ price.toFixed(2) }}
			</h3>

			<small-button
				v-if="menuItem"
				buttonText="Add to Order"
				:clickHandler="addToOrder" />
			<small-button
				v-else
				buttonText="Build Your Own"
				id="button-build-your-own"
				:clickHandler="
					() =>
						$router.push({
							name: 'build-your-own-pizza',
							params: { id: -$store.state.nextCustomPizzaId },
						})
				" />
			<p class="description-large-screen">
				{{ description }}
				<!-- Savor the irresistible allure of our Pepperoni Perfection, a culinary
				masterpiece that has stood the test of time. This iconic pizza is a
				testament to the beauty of simplicity, showcasing the finest ingredients
				and expert craftsmanship that our kitchen takes immense pride in. -->
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
		if (this.menuItem) {
			const {
				id,
				name,
				price,
				size,
				sauce,
				crust,
				toppings,
				isAvailable,
				description,
				imageURL,
			} = this.menuItem;
			return {
				id,
				name,
				price,
				isAvailable,
				description,
				imageURL,
				details: { size, sauce, crust, toppings },
			};
		} else
			return {
				name: undefined,
				price: undefined,
				imageURL:
					"https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais",
				description:
					"Choose from a wide array of fresh, high-quality ingredients, from mouthwatering toppings to delectable sauces, and create a personalized masterpiece that'll satisfy your unique cravings. It's time to turn your pizza fantasies into reality!",
			};
	},
	methods: {
		addToOrder() {
			this.$store.dispatch("addItemToCart", this.menuItem);
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
/* ************************** <p> tags ************************** */
p {
	text-align: justify;
	display: -webkit-box;
	-webkit-line-clamp: 8;
	-webkit-box-orient: vertical;
	line-height: 1.3;
	overflow: hidden;
	font-size: 0.9rem;
}

p.description-small-screen {
	grid-area: description;
	padding-top: 20px;
	padding-bottom: 20px;
}

p.description-large-screen {
	display: none;
}

div.customer-menu-item:nth-child(2n) p.description-small-screen {
	border-left: 1px solid var(--dark-color);
	border-bottom-left-radius: var(--section-border-radius);
	padding-left: 20px;
	padding-right: 10px;
}
div.customer-menu-item:nth-child(2n - 1) p.description-small-screen {
	border-right: 1px solid var(--dark-color);
	border-bottom-right-radius: var(--section-border-radius);
	padding-right: 20px;
	padding-left: 10px;
}

/* ************************** <h> tags ************************** */

div.customer-menu-item:nth-child(2n - 1) h2 {
	text-align: right;
}
div.customer-menu-item:nth-child(2n) h2 {
	text-align: left;
}

h3 {
	color: var(--primary-color);
}

h3.large-screen-price {
	display: none;
}

/* ************************** parent wrapper ************************** */
div.customer-menu-item {
	display: grid;
	grid-template-columns: 3fr 5fr;
	grid-template-areas: "image info" "description description";
	width: 100%;
	margin-right: auto;
	margin-left: auto;
	padding: 15px 10px;
}

div.customer-menu-item:nth-child(2n - 1) {
	grid-template-columns: 5fr 3fr;
	grid-template-areas: "info image" "description description";
}

/* ************************** image wrapper ************************** */

div.customer-menu-item-image-container {
	grid-area: image;
	height: 100%;
	width: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

div.customer-menu-item:nth-child(2n) div.customer-menu-item-image-container {
	border-top-left-radius: var(--section-border-radius);
	border-bottom-right-radius: var(--section-border-radius);
}

div.customer-menu-item:nth-child(2n-1) div.customer-menu-item-image-container {
	border-top-right-radius: var(--section-border-radius);
	border-bottom-left-radius: var(--section-border-radius);
}

/* ************************** text wrapper ************************** */

div.customer-menu-item-description-container {
	grid-area: "info";
	border-top: 1px solid var(--dark-color);
	display: flex;
	flex-direction: column;
	padding: 10px 15px;
	row-gap: 8px;
}

div.customer-menu-item:nth-child(2n)
	div.customer-menu-item-description-container {
	border-top-right-radius: var(--section-border-radius);
	align-items: flex-start;
}
div.customer-menu-item:nth-child(2n - 1)
	div.customer-menu-item-description-container {
	border-top-left-radius: var(--section-border-radius);
	align-items: flex-end;
}
/**********************************************************************************************************************
*****************MEDIA QUERIES 500PX+**********************************************************************************
***********************************************************************************************************************/
@media only screen and (min-width: 500px) {
	/* ************************** <p> tags ************************** */
	p.description-small-screen {
		display: none;
	}

	p.description-large-screen {
		display: -webkit-box;
		padding-top: 10px;
		padding-right: 5px;
	}

	/* ************************** <h> tags ************************** */
	div.customer-menu-item:nth-child(2n) h2,
	div.customer-menu-item:nth-child(2n - 1) h2 {
		text-align: center;
		flex: 0;
	}

	h3 {
		text-align: center;
		flex: 0;
	}

	/* ************************** button ************************** */
	button {
		flex: 0;
	}

	/* ************************** parent wrapper ************************** */

	div.customer-menu-item {
		display: flex;
		flex-direction: column;
		width: 50%;
	}
	/* ************************** image wrapper ************************** */
	div.customer-menu-item:nth-child(2n) div.customer-menu-item-image-container,
	div.customer-menu-item:nth-child(2n - 1)
		div.customer-menu-item-image-container {
		order: 1;
		border-bottom-left-radius: 0;
		border-top-left-radius: var(--section-border-radius);
		border-top-right-radius: var(--section-border-radius);
		border-bottom-right-radius: 0;
		height: 150px;
	}
	/* ************************** text wrapper ************************** */
	div.customer-menu-item:nth-child(2n)
		div.customer-menu-item-description-container,
	div.customer-menu-item:nth-child(2n-1)
		div.customer-menu-item-description-container {
		order: 2;
		border-top: none;
		border-top-right-radius: 0;
		border-bottom-right-radius: var(--section-border-radius);
		border-bottom-left-radius: var(--section-border-radius);
		justify-content: flex-start;
		align-items: center;
		flex: 1;
		border-right: 1px solid var(--dark-color);
		border-bottom: 1px solid var(--dark-color);
	}
}

@media only screen and (min-width: 768px) {
	p.description-large-screen {
		-webkit-line-clamp: 4;
		padding: 0;
	}
}

/* 















 */

div.customer-menu-item {
	/* display: flex;
	width: 100%;
	margin-right: auto;
	margin-left: auto;
	padding: 15px 10px; */
}

/* ********** image container ********** */
div.customer-menu-item-image-container {
	/* background-image: url("https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais"); */

	/* max-width: 300px; */
	/* height: auto; */
	/* aspect-ratio: 1 / 1; */
}
div.customer-menu-item:nth-child(2n) div.customer-menu-item-image-container {
	/* order: 1; */
	/* border-top-left-radius: var(--section-border-radius);
	border-bottom-left-radius: var(--section-border-radius); */
}
div.customer-menu-item:nth-child(2n - 1)
	div.customer-menu-item-image-container {
	/* order: 2; */
	/* border-top-right-radius: var(--section-border-radius);
	border-bottom-right-radius: var(--section-border-radius); */
}
/* ********** text container ********** */
div.customer-menu-item-description-container {
	/* display: flex;
	flex-direction: column;
	justify-content: center;
	max-width: 35em;
	padding: 15px; */
	/* border-bottom: 1px solid var(--dark-color); */
}

/* div.customer-menu-item:last-child div.customer-menu-item-description-container {
	border-bottom: none;
} */

div.customer-menu-item:nth-child(2n)
	div.customer-menu-item-description-container {
	/* order: 2; */
}
div.customer-menu-item:nth-child(2n - 1)
	div.customer-menu-item-description-container {
	/* order: 1; */
}

/* **************************************************************************** */

/* div.name-price-container {
	display: flex;
	align-items: flex-end;
	gap: 15px;
} */
/* 
div.customer-menu-item:nth-child(2n-1) div.name-price-container {
	justify-content: flex-start;
	flex-direction: row-reverse;
	text-align: right;
} */

/* h2,
h3 {
	display: inline-block;
} */

/* h2 {
	flex-grow: 0;
	flex-shrink: 1;
	font-family: var(--loud-font-family);
} */

/* h3 {
	flex-grow: 1;
	flex-shrink: 1;
	color: var(--primary-color);
} */

/* p {
	text-align: justify;
} */
/* 
button {
	align-self: flex-start;
	margin: 10px 0;
} */

/* div.customer-menu-item:nth-child(2n-1) button {
	align-self: flex-end;
} */

/* button#button-build-your-own {
	background-color: var(--primary-color);
	border-color: var(--primary-color);
} */
</style>
