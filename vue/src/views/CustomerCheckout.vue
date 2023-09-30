<template>
	<section
		class="input-section"
		id="checkout-section">
		<horizontal-hero></horizontal-hero>
		<div class="checkout-inputs">
			<h1>Checkout</h1>
			<div class="checkout-wrapper">
				<user-input
					label="Cardholder name: "
					inputId="Cardholder-name"
					inputType="text"
					v-model="cardholderName" />

				<user-input
					label="Card Number:"
					inputId="Card-Number"
					inputType="number"
					v-model="cardNumber" />

				<user-input
					label="Exp Date:"
					inputId="exp-date"
					inputType="number"
					v-model="expDate" />

				<user-input
					label="CVC"
					inputId="CVC"
					inputType="number"
					v-model="cvc" />

				<user-input
					label="Address"
					inputId="Address"
					inputType="text"
					v-model="address" />

				<user-input
					label="City"
					inputId="City"
					inputType="text"
					v-model="city" />

				<user-input
					label="State:"
					inputId="State"
					inputType="text"
					v-model="state" />

				<user-input
					label="Zip-Code"
					inputId="Zip-Code"
					inputType="number"
					v-model="zipCode" />

				<!-- <user-input label="Date:"
                                inputId="Date"
                                inputType="datetime-local"
                                /> -->

				<div class="delivery">
					<!-- <user-input label="Date:"
                                inputId="Date"
                                inputType="datetime-local"/> -->

					<p>How would you like to receive your pizza?</p>
					<form>
						<input
							type="radio"
							id="Pick-up" />
						<label for="Pick-up">Pick-up</label>
						<input
							type="radio"
							id="Delivery" />
						<label for="Delivery">Delivery</label>
					</form>
				</div>
			</div>
			<div class="total-payment">
				<p id="subtotal">Subtotal: ${{ $store.state.subtotal.toFixed(2) }}</p>
				<p id="tax">Tax: ${{ tax.toFixed(2) }}</p>
				<p id="total">Total: ${{ total.toFixed(2) }}</p>
			</div>
		</div>
	</section>
</template>

<script>
import UserInput from "../components/UserInput.vue";
import HorizontalHero from "../components/HorizontalHero.vue";

export default {
	components: { UserInput, HorizontalHero },
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
		};
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

.delivery > form {
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
	justify-content: flex-end;
	flex-direction: column;
	text-align: right;
	margin-right: 200px;
	margin-bottom: 20px;
}

.delivery {
	display: flex;
	flex-direction: column;
	width: 100%;
	text-align: center;
}
</style>
