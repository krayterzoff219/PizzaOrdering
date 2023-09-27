<template>
	<tr>
		<td><input v-model="name" /></td>
		<td>
			<input
				v-model="price"
				type="number" />
		</td>
		<td>
			<select v-model="sizeId">
				<option
					v-for="size of $store.state.sizes"
					:key="size.id"
					:value="size.id">
					{{ size.name }}
				</option>
			</select>
		</td>
		<td>
			<select v-model="crustId">
				<option
					v-for="crust of $store.state.crusts"
					:key="crust.id"
					:value="crust.id">
					{{ crust.name }}
				</option>
			</select>
		</td>
		<td>
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
		<td>
			<select v-model="sauceId">
				<option
					v-for="sauce of $store.state.sauces"
					:key="sauce.id"
					:value="sauce.id">
					{{ sauce.name }}
				</option>
			</select>
		</td>
		<td>
			<select v-model="isAvailable">
				<option value="true">Available</option>
				<option value="false">Not Available</option>
			</select>
		</td>
		<td v-if="areUnsavedChanges">
			<small-button buttonText="Save"></small-button>
			<small-button buttonText="Discard Changes"></small-button>
		</td>
		<td v-else>x</td>
	</tr>
</template>

<script>
import SmallButton from "./SmallButton.vue";
export default {
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

			// Is each topping in the original topping list accounted for in the local topping list?
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
};
</script>

<style></style>
