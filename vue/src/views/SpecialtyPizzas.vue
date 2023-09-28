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
				<tfoot>
					<!-- new option row--><specialty-pizza-table-row
					></specialty-pizza-table-row>
				</tfoot>
			</table>
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
	created() {
		this.$store.commit("LOAD_SPECIALTY_PIZZAS", [
			{
				id: 33,
				name: "Meat Lovers",
				price: 88.88,
				size: { id: 1 },
				crust: { id: 2 },
				toppings: [1, 2, 4],
				sauce: { id: 1 },
				isAvailable: true,
			},
			{
				id: 34,
				name: "Veggie Lovers",
				price: 77.77,
				size: { id: 2 },
				crust: { id: 2 },
				toppings: [1, 3, 5],
				sauce: { id: 2 },
				isAvailable: false,
			},
			{
				id: 35,
				name: "Meat and Veggie Lovers",
				price: 99.99,
				size: { id: 1 },
				crust: { id: 1 },
				toppings: [1, 2, 3, 4, 5],
				sauce: { id: 2 },
				isAvailable: false,
			},
		]);
		menuService.getMenuItems();
	},
};
</script>

<style scoped>
section.employee-section#specialty-pizzas {
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
