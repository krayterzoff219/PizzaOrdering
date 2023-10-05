<template>
	<section
		id="specialty-pizzas"
		class="employee-section">
		<horizontal-hero></horizontal-hero>
		<div class="table-wrapper">
			<h1>Specialty Pizzas</h1>
			<an-alert
				v-if="alertText"
				:message="alertText"></an-alert>
			<div id="specialty-pizzas-table">
				<div
					class="table-row"
					id="header-row">
					<div class="table-cell-pizza-name">Specialty Pizza Name</div>
					<div class="table-cell-pizza-price">Price</div>
					<div class="table-cell-pizza-size">Size</div>
					<div class="table-cell-pizza-crust">Crust</div>
					<div class="table-cell-pizza-toppings">Toppings</div>
					<div class="table-cell-pizza-sauce">Sauce</div>
					<div class="table-cell-pizza-available">Availability</div>
					<div class="table-cell-buttons"></div>
				</div>
				<specialty-pizza-table-row
					v-for="pizza of $store.state.specialtyPizzas"
					:key="pizza.id"
					:pizza="pizza"></specialty-pizza-table-row>
				<!-- new option row--><specialty-pizza-table-row
				></specialty-pizza-table-row>
			</div>
		</div>
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import SpecialtyPizzaTableRow from "../components/SpecialtyPizzaTableRow.vue";
import menuService from "../services/MenuService.js";

export default {
	components: { AnAlert, HorizontalHero, SpecialtyPizzaTableRow },
	name: "specialty-pizzas",
	data() {
		return {
			alertText: "",
		};
	},
	beforeCreate() {
		if (Object.keys(this.$store.state.cart).length) {
			this.$store.commit("CLEAR_CART");
		}
		menuService
			.getPizzaOptions()
			.catch(() =>
				alert(
					"There was an error retrieving the pizza options. Please try again later."
				)
			); // TODO: .catch alert if error
		menuService
			.getMenuItems()
			.catch(() =>
				alert(
					"There was an error retrieving the specialty pizzas. Please try again later."
				)
			); // TODO: .catch alert if error
	},
	destroyed() {
		this.$store.commit("UNLOAD_MENU");
	},
};
</script>

<style scoped>
section.employee-section#specialty-pizzas {
	width: var(--section-width);
	margin-bottom: var(--header-footer-inside-margin);
}

div#specialty-pizzas-table {
	width: 100%;
	max-width: 100rem;
	text-align: left;
	margin-right: auto;
	margin-left: auto;
	padding: 0 var(--section-border-radius);
}
</style>
