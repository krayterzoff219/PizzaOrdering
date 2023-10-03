<template>
	<section
		class="customer-section"
		id="build-your-own-pizza-section">
		<horizontal-hero />
		<h1>Build Your Own Pizza</h1>
		<form
			id="build-your-own-pizza-form"
			@submit.prevent="submitForm">
			<build-your-own-pizza-category
				optionsCategory="sizes"
				v-model="sizeId"
				:defaultValue="sizeId" />
			<build-your-own-pizza-category
				optionsCategory="crusts"
				:defaultValue="crustId"
				v-model="crustId" />
			<build-your-own-pizza-category
				optionsCategory="sauces"
				:defaultValue="sauceId"
				v-model="sauceId" />
			<build-your-own-pizza-category
				optionsCategory="toppings"
				v-model="toppingIds"
				:defaultValue="toppingIds"
				isMultiple="true" />
			<p id="total"><span>Total: </span>&nbsp; ${{ totalPrice.toFixed(2) }}</p>
			<small-button
				v-if="isNewPizza"
				buttonType="submit"
				buttonText="Add to Order" />
			<small-button
				v-else
				buttonType="submit"
				buttonText="Update Pizza" />
			<call-to-action-buttons
				:formSubmissionButton="true"
				:dynamicButtonText="buttonText" />
		</form>
	</section>
</template>

<script>
import BuildYourOwnPizzaCategory from "../components/BuildYourOwnPizzaCategory.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import SmallButton from "../components/SmallButton.vue";
import CallToActionButtons from "../components/CallToActionButtons.vue";
import menuService from "../services/MenuService.js";

export default {
	components: {
		HorizontalHero,
		BuildYourOwnPizzaCategory,
		SmallButton,
		CallToActionButtons,
	},

	data() {
		return {
			id: -this.$route.params.id,
			crustId: -1,
			sizeId: -1,
			toppingIds: [],
			sauceId: -1,
			isNewPizza: true,
			buttonText: "Add to Order",
		};
	},
	beforeCreate() {
		menuService.getPizzaOptions(); // TODO: .catch alert if error
	},
	created() {
		// if the item is already in the cart
		if (this.$store.state.cart[this.id]) {
			this.isNewPizza = false;
			this.buttonText = "Update Order";
			const pizza = this.$store.state.cart[this.id];
			this.crustId = pizza.crust.id;
			this.sizeId = pizza.size.id;
			this.sauceId = pizza.sauce.id;
			this.toppingIds = pizza.toppings;
		}
	},
	methods: {
		submitForm() {
			const {
				isNewPizza,
				crustId,
				sauceId,
				sizeId,
				toppingIds,
				id,
				totalPrice,
				$store,
				$router,
			} = this;
			const { crusts, sauces, sizes } = $store.state;
			const crustName = crusts.find((crust) => crust.id === crustId).name;
			const sizeName = sizes.find((size) => size.id === sizeId).name;
			const sauceName = sauces.find((sauce) => sauce.id === sauceId).name;
			const pizza = { id };
			pizza.crust = { id: crustId, name: crustName };
			pizza.sauce = { id: sauceId, name: sauceName };
			pizza.size = { id: sizeId, name: sizeName };
			pizza.toppings = toppingIds;
			pizza.price = totalPrice;

			if (isNewPizza) {
				pizza.quantity = 1;
				pizza.name = "Build Your Own Pizza";
				pizza.imageURL =
					"https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais";
				$store.dispatch("addItemToCart", pizza);
				$router.push({ name: "customer-menu" });
				$store.commit("GO_TO_NEXT_CUSTOM_PIZZA_ID");
			} else {
				const originalPizza = this.$store.state.cart[this.id];
				const priceDifference = totalPrice - originalPizza.price;
				$store.dispatch("updateExistingCustomPizza", {
					pizza,
					priceDifference,
				});
				$router.push({ name: "my-order" });
			}
		},
	},
	computed: {
		totalPrice() {
			let price = 0;
			const { crustId, sizeId, toppingIds, sauceId } = this;
			const { crusts, sizes, toppings, sauces } = this.$store.state;

			toppingIds.forEach((toppingId) => {
				const topping = toppings.find((topping) => topping.id === toppingId);
				price += topping.price;
			});

			if (crustId > 0) {
				const crust = crusts.find((crust) => crust.id === crustId);
				price += crust.price;
			}
			if (sizeId > 0) {
				const size = sizes.find((size) => size.id === sizeId);
				price += size.price;
			}
			if (sauceId > 0) {
				const sauce = sauces.find((sauce) => sauce.id === sauceId);
				price += sauce.price;
			}
			return price;
		},
	},
};
</script>

<style scoped>
section.customer-section#build-your-own-pizza-section {
	max-width: 50rem;
}

section.customer-section#build-your-own-pizza-section
	form#build-your-own-pizza-form {
	display: grid;
	grid-template-columns: 1fr;
	width: 70%;
	row-gap: 2rem;
	grid-template-areas:
		"size"
		"crust"
		"sauce"
		"toppings";
	padding-top: 0;
	margin-top: 0;
}
div.build-your-own-pizza-category-wrapper:nth-child(1) {
	grid-area: size;
	margin-top: 0.25rem;
}
div.build-your-own-pizza-category-wrapper:nth-child(2) {
	grid-area: crust;
}
div.build-your-own-pizza-category-wrapper:nth-child(3) {
	grid-area: sauce;
}
div.build-your-own-pizza-category-wrapper:nth-child(4) {
	grid-area: toppings;
	margin-bottom: 1.5rem;
}

div.build-your-own-pizza-category-wrapper:nth-child(1),
div.build-your-own-pizza-category-wrapper:nth-child(2),
div.build-your-own-pizza-category-wrapper:nth-child(3) {
	border-bottom: 1px solid var(--dark-color);
	padding-bottom: 1.25rem;
}

form > button:nth-child(5) {
	display: none;
}

@media only screen and (min-width: 768px) {
	form > button:nth-child(5) {
		display: block;
		max-width: 24rem;
		width: 100%;
		justify-self: center;
	}
}

@media only screen and (max-width: 525px) {
	section.customer-section#build-your-own-pizza-section
		form#build-your-own-pizza-form {
		width: 90%;
	}
}

h1 {
	margin-top: var(--section-border-radius);
}

p {
	text-align: right;
}
</style>
