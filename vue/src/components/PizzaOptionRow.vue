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
		<i
			v-if="option"
			class="fa-floppy-disk fa-solid icon-hide"></i>
		<i
			v-else
			class="fa-floppy-disk fa-solid grow"
			@click="addNewOption"></i>
	</div>
</template>

<script>
import optionService from "../services/OptionService.js";
export default {
	name: "pizza-option-row",
	props: ["option", "optionsCategory"],
	data() {
		return { id: -1, name: "", price: "", isAvailable: true };
	},
	created() {
		if (this.option) {
			this.initializeRow();
		}
	},
	methods: {
		initializeRow() {
			const { id, name, price, isAvailable } = this.option;
			this.id = id;
			this.name = name;
			this.price = price;
			this.isAvailable = isAvailable;
		},
		resetRow() {
			this.name = "";
			this.price = "";
			this.isAvailable = true;
		},
		handleChange() {
			if (this.option) {
				this.saveChanges();
			}
		},
		saveChanges() {},
		addNewOption() {
			const { name, price, isAvailable, areInputsValid, optionsCategory } =
				this;
			if (areInputsValid()) {
				optionService
					.createOption(optionsCategory, {
						name,
						price,
						available: isAvailable,
					})
					.then((res) => {
						if (res.status === 200) {
							// TODO: change status to 201
							const { id, name, price, available } = res.data;
							this.$store.commit(
								`ADD_${optionsCategory.toUpperCase().slice(0, -1)}`,
								{ id, name, price, isAvailable: available }
							);
							this.resetRow();
						}
					})
					.catch((error) => {
						console.log(error);
						alert(
							`There was an error saving the new ${optionsCategory
								.toUpperCase()
								.slice(0, -1)}. Please try again later.`
						);
					});
			}
		},
		areInputsValid() {
			const { name, price, optionsCategory } = this;
			if (!name) {
				alert(`New ${optionsCategory} must have a name.`);
				return false;
			}
			if (name.length > 40) {
				alert(
					`New ${optionsCategory} must have a name that is 40 characters or less.`
				);
				return false;
			}
			if (price < 0.01) {
				alert(
					`New ${optionsCategory} must have a price that is greater than $0.00.`
				);
				return false;
			}
			return true;
		},
	},
};
</script>

<style scoped>
section.employee-section div.pizza-option-row {
	display: flex;
	width: 100%;
	justify-content: center;
	align-items: center;
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

i {
	padding: 4px;
	border-radius: 5px;
	color: var(--white-color);
}

i:not(.icon-hide) {
	background-color: var(--dark-color);
	cursor: pointer;
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
