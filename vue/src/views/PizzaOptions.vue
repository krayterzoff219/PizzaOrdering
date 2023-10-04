<template>
	<section
		id="pizza-options"
		class="employee-section">
		<horizontal-hero></horizontal-hero>
		<div class="pizza-options-wrapper">
			<h1>Pizza Options</h1>
			<an-alert
				v-if="alertText"
				:message="alertText"></an-alert>
			<pizza-options-category
				optionsCategory="toppings"></pizza-options-category>
			<pizza-options-category optionsCategory="sizes"></pizza-options-category>
			<pizza-options-category optionsCategory="crusts"></pizza-options-category>
			<pizza-options-category optionsCategory="sauces"></pizza-options-category>
		</div>
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import PizzaOptionsCategory from "../components/PizzaOptionsCategory.vue";
import menuService from "../services/MenuService.js";

export default {
	components: { AnAlert, HorizontalHero, PizzaOptionsCategory },
	name: "pizza-options",
	data() {
		return {
			alertText: "",
		};
	},
	beforeCreate() {
		if (Object.keys(this.$store.state.cart).length) {
			this.$store.commit("CLEAR_CART");
		}
		menuService.getPizzaOptions(); // TODO: .catch alert if error
	},
	destroyed() {
		this.$store.commit("UNLOAD_MENU");
	},
};
</script>
