<template>
	<section
		class="customer-section"
		id="build-your-own-pizza-section">
		<horizontal-hero />
		<h1>Build Your Own Pizza</h1>
		<form
			id="build-your-own-pizza-form"
			@submit.prevent="">
			<build-your-own-pizza-category
				optionsCategory="sizes"
				v-model="size" />
			<build-your-own-pizza-category
				optionsCategory="crusts"
				v-model="crust" />
			<build-your-own-pizza-category
				optionsCategory="sauces"
				v-model="sauce" />
			<build-your-own-pizza-category
				optionsCategory="toppings"
				v-model="toppings"
				isMultiple="true" />
			<small-button
				v-if="newPizza"
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
			crust: -1,
			size: -1,
			toppings: [],
			sauce: -1,
			newPizza: true,
			buttonText: "Add to Order",
		};
	},
	beforeCreate() {
		menuService.getPizzaOptions(); // TODO: .catch alert if error
		if (this.$store.state.cart[this.id]) this.newPizza = false;
	},
	created() {
		if (!this.newPizza) {
			this.buttonText = "Update Order";
		}
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
</style>
