<template>
	<div class="pizza-option-row">
		<input
			v-model="name"
			@change="saveChanges"
			class="pizza-option-cell-name"
			:placeholder="`New ${
				optionsCategory.charAt(0).toUpperCase() + optionsCategory.slice(1, -1)
			}`" />
		<input
			v-model="price"
			type="text"
			@focus="formatAsNumber"
			@blur="formatAsMoney"
			@change="saveChanges"
			placeholder="Price"
			class="pizza-option-cell-price" />
		<select
			v-model="isAvailable"
			class="pizza-option-cell-available"
			@change="saveChanges">
			<option value="true">Available</option>
			<option value="false">Not Available</option>
		</select>
		<i
			v-if="option"
			class="fa-floppy-disk fa-solid icon-hide employee-button-icon"></i>
		<i
			v-else
			class="fa-floppy-disk fa-solid grow employee-button-icon"
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
			this.price = `$${price.toFixed(2)}`;
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
		formatAsMoney(event) {
			const price = event.target.value
				? event.target.value >= 1000
					? "999.99"
					: event.target.value
				: "0";
			event.target.setAttribute("type", "text");
			event.target.value = `$${Number.parseFloat(price).toFixed(2)}`;
			this.price = event.target.value;
		},
		formatAsNumber(event) {
			event.target.value = event.target.value.replace("$", "");
			event.target.setAttribute("type", "number");
		},
		saveChanges() {
			const { areInputsValid, optionsCategory, id, price, name, isAvailable } =
				this;
			if (areInputsValid()) {
				optionService
					.updateOption(optionsCategory, {
						name,
						price: price.replace("$", ""),
						available: isAvailable,
						id,
					})
					.catch(() =>
						alert(
							`There was an error updating the ${name}. Please try again later.`
						)
					);
			}
		},
		addNewOption() {
			const { name, price, isAvailable, areInputsValid, optionsCategory } =
				this;
			if (areInputsValid()) {
				optionService
					.createOption(optionsCategory, {
						name,
						price: price.replace("$", ""),
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
			if (Number.parseFloat(price.replace("$", "")) < 0.01) {
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
