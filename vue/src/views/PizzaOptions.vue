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

export default {
	components: { AnAlert, HorizontalHero, PizzaOptionsCategory },
	name: "pizza-options",
	data() {
		return {
			alertText: "",
		};
	},
	created() {
		this.$store.commit("LOAD_SPECIALTY_PIZZAS", [
			{
				id: 33,
				name: "Meat Lovers",
				price: 99.99,
				size: { id: 7 },
				crust: { id: 6 },
				toppings: [2, 4],
				sauce: { id: 9 },
				isAvailable: true,
			},
			{
				id: 34,
				name: "Veggie Lovers",
				price: 77.77,
				size: { id: 8 },
				crust: { id: 5 },
				toppings: [1, 3],
				sauce: { id: 10 },
				isAvailable: false,
			},
			{
				id: 35,
				name: "Meat and Veggie Lovers",
				price: 77.77,
				size: { id: 8 },
				crust: { id: 5 },
				toppings: [1, 2, 4, 3],
				sauce: { id: 10 },
				isAvailable: false,
			},
			{
				id: 36,
				name: "Meat and Veggie Lovers",
				price: 77.77,
				size: { id: 8 },
				crust: { id: 5 },
				toppings: [1, 2, 4, 3],
				sauce: { id: 10 },
				isAvailable: false,
			},
		]);
		this.$store.commit("LOAD_TOPPINGS", [
			{ name: "peppers", id: 1, isAvailable: true, price: 1.75 },
			{ name: "olives", id: 2, isAvailable: true, price: 2.75 },
			{ name: "pepperoni", id: 3, isAvailable: true, price: 3.75 },
			{ name: "sausage", id: 4, isAvailable: false, price: 0.75 },
			{ name: "onions", id: 5, isAvailable: true, price: 0.75 },
			{ name: "anchoives", id: 6, isAvailable: true, price: 0.75 },
			{ name: "chicken", id: 7, isAvailable: false, price: 0.75 },
			{ name: "mushrooms", id: 8, isAvailable: true, price: 0.75 },
		]);
		this.$store.commit("LOAD_CRUSTS", [
			{ name: "thin", id: 5, isAvailable: false },
			{ name: "thick", id: 6, isAvailable: true },
		]);
		this.$store.commit("LOAD_SIZES", [
			{ name: 12, id: 7, isAvailable: false, price: 0.75 },
			{ name: 10, id: 8, isAvailable: true, price: 0.75 },
		]);
		this.$store.commit("LOAD_SAUCES", [
			{ name: "red", id: 9, isAvailable: false, price: 0.75 },
			{ name: "white", id: 10, isAvailable: true, price: 0.75 },
		]);
	},
};
</script>

<style scoped>
section.employee-section#pizza-options {
	/* width: 97%; */
	margin-bottom: var(--header-footer-inside-margin);
}
</style>
