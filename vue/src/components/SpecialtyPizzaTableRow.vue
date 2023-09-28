<template>
	<tr>
		<td class="table-cell-pizza-name"><input v-model="name" /></td>
		<td class="table-cell-pizza-price">
			<input
				v-model="price"
				type="number"
				max="999.99" />
		</td>
		<td class="table-cell-pizza-size">
			<select v-model="sizeId">
				<option
					v-for="size of $store.state.sizes"
					:key="size.id"
					:value="size.id">
					{{ size.name }}
				</option>
			</select>
		</td>
		<td class="table-cell-pizza-crust">
			<select v-model="crustId">
				<option
					v-for="crust of $store.state.crusts"
					:key="crust.id"
					:value="crust.id">
					{{ crust.name }}
				</option>
			</select>
		</td>
		<td class="table-cell-pizza-toppings">
			<select
				multiple
				size="5"
				v-model="toppingIds">
				<option
					v-for="topping of $store.state.toppings"
					:key="topping.id"
					:value="topping.id">
					{{ topping.name }}
				</option>
			</select>
		</td>
		<td class="table-cell-pizza-sauce">
			<select v-model="sauceId">
				<option
					v-for="sauce of $store.state.sauces"
					:key="sauce.id"
					:value="sauce.id">
					{{ sauce.name }}
				</option>
			</select>
		</td>
		<td class="table-cell-pizza-available">
			<select v-model="isAvailable">
				<option value="true">Available</option>
				<option value="false">Not Available</option>
			</select>
		</td>
		<td
			v-if="!pizza"
			class="table-cell-buttons table-icon-wrapper">
			<i
				class="fa-floppy-disk fa-solid grow employee-button-icon"
				@click="addNewSpecialtyPizza"></i>
		</td>
		<td
			v-else-if="areUnsavedChanges"
			class="table-cell-buttons table-button-wrapper">
			<small-button
				buttonText="Save Changes"
				:clickHandler="saveChanges"></small-button>
			<small-button
				buttonText="Discard Changes"
				:clickHandler="discardChanges"></small-button>
		</td>
		<td
			v-else
			class="table-cell-buttons table-icon-wrapper">
			<i
				class="fa-trash fa-solid grow employee-button-icon row-delete-button icon-hide"></i>
		</td>
	</tr>
</template>

<script>
import SmallButton from "./SmallButton.vue";
import specialtyPizzaService from "../services/SpecialtyPizzaService.js";

export default {
	name: "specialty-pizza-table-row",
	components: { SmallButton },
	props: ["pizza"],
	data() {
		return {
			pizzaId: -1,
			name: "",
			price: "",
			sizeId: -1,
			crustId: -1,
			toppingIds: [],
			sauceId: -1,
			isAvailable: true,
		};
	},
	computed: {
		areUnsavedChanges() {
			if (!this.pizza) {
				return false;
			}
			const { name, price, size, crust, toppings, sauce, isAvailable } =
				this.pizza;

			// Check that each topping in the original topping list accounted for in the local topping list
			let areToppingsDifferent = false;
			toppings.forEach((topping) => {
				if (this.toppingIds.indexOf(topping) === -1) {
					areToppingsDifferent = true;
				}
			});

			return (
				this.name !== name ||
				this.price !== price ||
				this.sizeId !== size.id ||
				this.crustId !== crust.id ||
				this.sauceId !== sauce.id ||
				this.isAvailable !== isAvailable ||
				this.toppingIds.length !== toppings.length ||
				areToppingsDifferent
			);
		},
	},
	created() {
		if (this.pizza) {
			this.initializeRow();
		}
	},
	methods: {
		resetRow() {
			this.pizzaId = -1;
			this.name = "";
			this.price = "";
			this.sizeId = -1;
			this.crustId = -1;
			this.toppingIds = [];
			this.sauceId = -1;
			this.isAvailable = true;
		},
		initializeRow() {
			const { id, name, price, size, crust, toppings, sauce, isAvailable } =
				this.pizza;
			this.pizzaId = id;
			this.name = name;
			this.price = price;
			this.sizeId = size.id;
			this.crustId = crust.id;
			this.toppingIds = toppings;
			this.sauceId = sauce.id;
			this.isAvailable = isAvailable;
		},
		discardChanges() {
			if (
				confirm(
					`Are you sure you want to discard the changes to ${this.pizza.name}`
				)
			) {
				this.initializeRow();
			}
		},
		saveChanges() {},
		addNewSpecialtyPizza() {
			const {
				areInputsValid,
				name,
				price,
				sizeId,
				crustId,
				toppingIds,
				sauceId,
				isAvailable,
				resetRow,
			} = this;
			if (areInputsValid()) {
				// ***** BUILD THE SPECIALTY PIZZA THAT WILL BE USED IN THE REQUEST IN CORRECT FORMAT *****
				const specialtyPizza = { name, price };
				const pizza = {};
				pizza.size = { id: sizeId };
				pizza.crust = { id: crustId };
				pizza.sauce = { id: sauceId };
				pizza.toppings = toppingIds.map((id) => ({ id }));
				specialtyPizza.available = isAvailable;
				specialtyPizza.pizza = pizza;
				// ****************************************************************************************

				specialtyPizzaService
					.createSpecialtyPizza(specialtyPizza)
					.then((res) => {
						if (res.status === 200) {
							// TODO: change status to 201
							this.$store.commit("ADD_SPECIALTY_PIZZA", {
								id: res.data,
								name,
								price,
								isAvailable,
								size: pizza.size,
								crust: pizza.crust,
								sauce: pizza.sauce,
								toppings: toppingIds,
							});
							resetRow();
						}
					})
					.catch((error) => {
						console.log(error);
						alert(
							"There was an error saving the new specialty pizza. Please try again later."
						);
					});
			}
		},
		areInputsValid() {
			const { name, price, sizeId, crustId, toppingIds, sauceId } = this;
			if (!name) {
				alert("New specialty pizza must have a name.");
				return false;
			}
			if (name.length > 40) {
				alert(
					"New specialty pizza must have a name that is 40 characters or less."
				);
				return false;
			}
			if (price < 0.01) {
				alert(
					"New specialty pizza must have a price that is greater than $0.00."
				);
				return false;
			}
			if (sizeId <= 0) {
				alert("New specialty pizza must have a size selected");
				return false;
			}
			if (crustId <= 0) {
				alert("New specialty pizza must have a crust selected");
				return false;
			}
			if (sauceId <= 0) {
				alert("New specialty pizza must have a sauce selected");
				return false;
			}
			if (!toppingIds.length) {
				alert("New specialty pizza must have at least 1 topping selected");
				return false;
			}
			return true;
		},
	},
};
</script>

<style>
tr {
	display: flex;
	width: 100%;
	justify-content: space-evenly;
	align-items: flex-start;
	gap: 10px;
}

tbody tr:first-child {
	margin-top: 10px;
}

tbody tr:not(:first-child),
tfoot tr {
	margin-top: 20px;
}

thead tr {
	text-align: center;
}

td.table-cell-pizza-price {
	flex-basis: 4rem;
	flex-grow: 0;
	flex-shrink: 0;
}

td.table-cell-pizza-available,
td.table-cell-pizza-crust,
td.table-cell-pizza-sauce,
td.table-cell-pizza-size {
	flex-basis: 6rem;
	flex-grow: 1;
	flex-shrink: 1;
}

td.table-cell-pizza-name {
	flex-basis: 15rem;
	flex-grow: 2;
	flex-shrink: 1;
}

td.table-cell-pizza-toppings,
td.table-cell-buttons {
	flex-basis: 9rem;
	flex-grow: 1;
	flex-shrink: 1;
}

td input,
td select {
	width: 100%;
	padding: 3px;
}

td.table-cell-buttons {
	min-width: 4rem;
}

td.table-button-wrapper button {
	display: block;
	min-width: 4rem;
	width: 100%;
}

/************************* PRICE CELL STYLE *************************/
/***** https://www.w3schools.com/howto/howto_css_hide_arrow_number.asp *****/
/* hide arrows in the number input field */
input[type="number"]::-webkit-inner-spin-button,
input[type="number"]::-webkit-outer-spin-button {
	appearance: none;
	margin: 0;
}
/* hide the arrows in the number input field for firefox */
input[type="number"] {
	-moz-appearance: textfield;
}

/************************* FINAL CELL STYLE *************************/
td.table-button-wrapper button:first-child {
	margin-bottom: 5px;
}
td.table-button-wrapper button:last-child {
	background-color: var(--primary-color);
	border-color: var(--primary-color);
}
td.table-icon-wrapper {
	color: var(--primary-color);
	padding-left: 20px;
}
td:last-child i.row-delete-button {
	background-color: var(--primary-color);
}
</style>
