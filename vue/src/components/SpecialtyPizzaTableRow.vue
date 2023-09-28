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
			v-if="areUnsavedChanges"
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
			class="table-cell-buttons table-delete-wrapper">
			<span class="row-delete-button">X</span>
		</td>
	</tr>
</template>

<script>
import SmallButton from "./SmallButton.vue";
export default {
	name: "specialty-pizza-table-row",
	components: { SmallButton },
	props: ["pizza"],
	data() {
		return {
			pizzaId: -1,
			name: "",
			price: -1,
			sizeId: -1,
			crustId: -1,
			toppingIds: [],
			sauceId: -1,
			isAvailable: false,
		};
	},
	computed: {
		areUnsavedChanges() {
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
		this.initializeRow();
	},
	methods: {
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

tbody tr:not(:first-child) {
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
td.table-delete-wrapper {
	color: var(--primary-color);
	padding-left: 20px;
}
span.row-delete-button {
	cursor: pointer;
}
</style>
