<template>
	<div class="pizza-option-row">
		<input
			v-model="name"
			class="pizza-option-cell-name" />
		<input
			v-model="price"
			type="number"
			max="999.99"
			class="pizza-option-cell-price" />
		<select
			v-model="isAvailable"
			class="pizza-option-cell-available">
			<option value="true">Available</option>
			<option value="false">Not Available</option>
		</select>
	</div>
</template>

<script>
export default {
	name: "pizza-option-row",
	props: ["option"],
	data() {
		return { id: -1, name: "", price: -1, isAvailable: false };
	},
	created() {
		this.initializeRow();
	},
	methods: {
		initializeRow() {
			const { id, name, price, isAvailable } = this.option;
			this.id = id;
			this.name = name;
			this.price = price;
			this.isAvailable = isAvailable;
		},
	},
};
</script>

<style scoped>
section.employee-section div.pizza-option-row {
	display: flex;
	width: 100%;
	justify-content: center;
	gap: 5px;
}

section.employee-section div.pizza-option-row:not(:nth-child(2)) {
	margin-top: 15px;
}

input.pizza-option-cell-price {
	flex-basis: 4rem;
	flex-grow: 0;
	flex-shrink: 0;
}

select.pizza-option-cell-available {
	flex-basis: 6rem;
	flex-grow: 1;
	flex-shrink: 1;
}

input.pizza-option-cell-name {
	flex-basis: 12rem;
	flex-grow: 1;
	flex-shrink: 4;
}

div.pizza-option-row select,
div.pizza-option-row input {
	width: 100%;

	padding: 3px;
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
</style>
