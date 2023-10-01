<template>
	<section
		class="input-section"
		id="checkout-section">
		<horizontal-hero></horizontal-hero>
		<div class="checkout-inputs">
			<h1>Checkout</h1>
			<form
				class="checkout-wrapper"
				@submit.prevent="placeOrder">
				<user-input
					label="Cardholder name: "
					inputId="Cardholder-name"
					:isRequired="true"
					inputType="text"
					v-model="cardholderName" />

				<user-input
					label="Card Number:"
					inputId="Card-Number"
					inputType="number"
					:isRequired="true"
					v-model="cardNumber" />

				<user-input
					label="Exp Date:"
					inputId="exp-date"
					inputType="number"
					:isRequired="true"
					v-model="expDate" />

				<user-input
					label="CVC"
					inputId="CVC"
					inputType="number"
					:isRequired="true"
					v-model="cvc" />

				<user-input
					label="Address"
					inputId="Address"
					:isRequired="true"
					inputType="text"
					v-model="address" />

				<user-input
					inputType="text"
					label="City"
					inputId="City"
					:isRequired="true"
					v-model="city" />

				<user-input
					label="State:"
					:isRequired="true"
					inputId="State"
					inputType="text"
					v-model="state" />

				<user-input
					label="Zip-Code"
					inputId="Zip-Code"
					:isRequired="true"
					inputType="number"
					v-model="zipCode" />

				<user-input
					label="Phone number:"
					inputId="Phone-number"
					inputType="number"
					v-model="phoneNumber"
					:isRequired="true" />

				<user-input
					label="Email"
					inputId="email"
					inputType="text"
					v-model="email"
					:isRequired="true" />

				<div class="delivery">
					<p>How would you like to receive your pizza?</p>
					<div>
						<input
							type="radio"
							v-model="isDelivery"
							:value="false"
							id="Pick-up" />
						<label for="Pick-up">Pick-up</label>
						<input
							type="radio"
							v-model="isDelivery"
							:value="true"
							id="Delivery" />
						<label for="Delivery">Delivery</label>
					</div>
				</div>
			</form>
			<div class="total-payment">
				<p id="subtotal">
					<span>Subtotal:</span>&nbsp; ${{ $store.state.subtotal.toFixed(2) }}
				</p>
				<p id="tax"><span>Tax:</span>&nbsp; ${{ tax.toFixed(2) }}</p>
				<p id="total"><span>Total: </span>&nbsp; ${{ total.toFixed(2) }}</p>
				<small-button
					buttonText="place order"
					buttonType="submit" />
			</div>
		</div>
	</section>
</template>

<script>
import UserInput from "../components/UserInput.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import orderService from "../services/OrderService.js";
import SmallButton from "../components/SmallButton.vue";

export default {
	components: { UserInput, HorizontalHero, SmallButton },
	data() {
		return {
			cardholderName: "",
			cardNumber: "",
			expDate: "",
			cvc: "",
			address: "",
			city: "",
			state: "",
			zipCode: "",
			isDelivery: false,
			email: "",
			phoneNumber: "",
		};
	},

	methods: {
		validateInputs() {},
		placeOrder() {
			const order = {};

			order.isDelivery = this.isDelivery;
			order.address = this.address;
			order.phoneNumber = this.phoneNumber;
			order.email = this.email;
			order.menuItems = [];

			order.customPizzas = [];

			const pizzas = Object.values(this.$store.state.cart);
			for (const pizza of pizzas) {
				order.menuItems.push({
					itemId: pizza.id,
					quantity: pizza.quantity,
				});
			}

			orderService.createPendingOrder(order);
		},
	},
	beforeCreate() {
		if (!Object.keys(this.$store.state.cart).length) {
			this.$router.push({ name: "customer-menu" });
		}
	},

	computed: {
		total() {
			return this.$store.state.subtotal + this.tax;
		},

		tax() {
			return this.$store.state.subtotal * 0.08;
		},
	},
};
</script>

<style scoped>
section.input-section#checkout-section {
	width: 97%;
	margin-bottom: var(--header-footer-inside-margin);
}

@media only screen and (min-width: 600px) {
	section.input-section#checkout-section {
		max-width: min(80%, 60rem);
	}
}

.delivery > div {
	text-align: center;
}

.checkout-wrapper .form-input-group {
	padding-right: 20px;
	padding-left: 20px;
}

.checkout-wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
}

.instructions {
	height: 100px;
	width: 300px;
}

.total-payment {
	display: flex;
	align-items: flex-end;
	flex-direction: column;
	text-align: right;
	margin-right: 10%;
	margin-bottom: 20px;
	padding-top: 30px;
}

.delivery {
	display: flex;
	flex-direction: column;
	width: 100%;
	text-align: center;
}

div.delivery > div {
	padding-top: 5px;
}

.total-payment #tax {
	padding: 3px 0;
}
.total-payment #total {
	padding-bottom: 15px;
}

p span {
	font-weight: bold;
}
</style>
