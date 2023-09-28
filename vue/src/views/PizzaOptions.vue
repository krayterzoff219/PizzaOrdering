<template>
	<section
		id="pizza-options"
		class="employee-section">
		<horizontal-hero></horizontal-hero>
		<div class="table-wrapper">
			<h1>Pizza Options</h1>
			<an-alert
				v-if="alertText"
				:message="alertText"></an-alert>
			<table>
				<thead>
					<tr>
						<td class="table-cell-pizza-name">Specialty Pizza Name</td>
						<td class="table-cell-pizza-price">Price</td>
						<td class="table-cell-pizza-size">Size</td>
						<td class="table-cell-pizza-crust">Crust</td>
						<td class="table-cell-pizza-toppings">Toppings</td>
						<td class="table-cell-pizza-sauce">Sauce</td>
						<td class="table-cell-pizza-available">Availability</td>
						<td class="table-cell-buttons"></td>
					</tr>
				</thead>
				<tbody>
					<specialty-pizza-table-row
						v-for="pizza of $store.state.specialtyPizzas"
						:key="pizza.id"
						:pizza="pizza"></specialty-pizza-table-row>
				</tbody>
			</table>
		</div>
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
// import menuService from "../services/MenuService.js";
import HorizontalHero from "../components/HorizontalHero.vue";
import SpecialtyPizzaTableRow from "../components/SpecialtyPizzaTableRow.vue";

export default {
	components: { AnAlert, HorizontalHero, SpecialtyPizzaTableRow },
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
			{ name: "peppers", id: 1 },
			{ name: "olives", id: 2 },
			{ name: "pepperoni", id: 3 },
			{ name: "sausage", id: 4 },
			{ name: "onions", id: 5 },
			{ name: "anchoives", id: 6 },
			{ name: "chicken", id: 7 },
			{ name: "mushrooms", id: 8 },
		]);
		this.$store.commit("LOAD_CRUSTS", [
			{ name: "thin", id: 5 },
			{ name: "thick", id: 6 },
		]);
		this.$store.commit("LOAD_SIZES", [
			{ name: 12, id: 7 },
			{ name: 10, id: 8 },
		]);
		this.$store.commit("LOAD_SAUCES", [
			{ name: "red", id: 9 },
			{ name: "white", id: 10 },
		]);
	},
	// created() {
	// 	menuService.getMenuItems().then((res) => {
	// 		if (res.status === 200) {
	// 			const { toppings, sauces, crusts, sizes, specialtyPizzas } = res.data;
	// 			this.$store.commit("LOAD_TOPPINGS", toppings);
	// 			this.$store.commit("LOAD_SAUCES", sauces);
	// 			this.$store.commit("LOAD_CRUSTS", crusts);
	// 			this.$store.commit("LOAD_SIZES", sizes);
	// 			this.$store.commit("LOAD_SPECIALTY_PIZZAS", specialtyPizzas);
	// 		}
	// 	});
	// },
};
</script>

<style scoped>
section.employee-section#pizza-options {
	width: 97%;
	margin-bottom: var(--header-footer-inside-margin);
}

table {
	width: 100%;
	max-width: 100rem;
	text-align: left;
	margin-right: auto;
	margin-left: auto;
	padding: 0 var(--section-border-radius);
}
</style>
