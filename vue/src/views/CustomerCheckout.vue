<template>
	<section
		class="customer-section"
		id="checkout-section">
		<horizontal-hero></horizontal-hero>
		<div class="checkout-inputs">
			<h1>Checkout</h1>
			<form
				class="checkout-wrapper"
				@submit.prevent="placeOrder">
				<user-input
					label="Cardholder Name"
					inputId="cardholder-name"
					inputType="text"
					:isRequired="true"
					v-model="cardholderName" />

				<user-input
					:isRequired="true"
					label="Card Number"
					inputId="card-number"
					inputType="number"
					v-model="cardNumber" />

				<user-input
					:isRequired="true"
					label="Expiration Date"
					inputId="exp-date"
					inputType="text"
					v-model="expDate" />

				<user-input
					:isRequired="true"
					label="Security Code (CVC)"
					inputId="cvc"
					inputType="number"
					v-model="cvc" />

				<user-input
					:isRequired="true"
					label="Address"
					inputId="address"
					inputType="text"
					v-model="address" />

				<user-input
					:isRequired="true"
					label="City"
					inputId="city"
					inputType="text"
					v-model="city" />

				<user-input
					:isRequired="true"
					label="State"
					inputId="state"
					inputType="text"
					v-model="state" />

				<user-input
					:isRequired="true"
					label="ZIP Code"
					inputId="zip-code"
					inputType="number"
					v-model="zipCode" />

				<user-input
					:isRequired="true"
					label="Phone Number"
					inputId="phone-number"
					inputType="number"
					v-model="phoneNumber" />

				<user-input
					:isRequired="true"
					label="Email"
					inputId="email"
					inputType="email"
					v-model="email" />

				<div class="delivery">
					<p>How would you like to receive your pizza?</p>
					<div>
						<input
							type="radio"
							id="pick-up"
							name="delivery"
							v-model="isDelivery"
							:value="false" />
						<label for="pick-up">Pick-up</label>
					</div>
					<div>
						<input
							type="radio"
							id="delivery"
							name="delivery"
							v-model="isDelivery"
							:value="true" />
						<label for="delivery">Delivery</label>
					</div>
				</div>

				<checkout-amount
					buttonText="Place Order"
					buttonType="submit" />
				<call-to-action-buttons :formSubmissionButton="true" />
			</form>
		</div>
	</section>
</template>

<script>
import UserInput from "../components/UserInput.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import orderService from "../services/OrderService.js";
import CheckoutAmount from "../components/CheckoutAmount.vue";
import CallToActionButtons from "../components/CallToActionButtons.vue";
import emailjs from 'emailjs-com';


export default {
	components: {
		UserInput,
		HorizontalHero,
		CheckoutAmount,
		CallToActionButtons,
	},
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

			orderService.createPendingOrder(order).then((res) => {
				if (res.status === 200) {
					this.$router.push({ name: "confirmation" });
					this.sendEmail();
				}
			});
		},

		sendEmail() {
			try {
				emailjs.send('service_tw939hk', 'template_j8669nl', {
					name: this.cardholderName,
					email: this.email,
					from_name: 'UpperCrust Pizza',
					message: 'Your order will be ready in 20-30 minutes.'
				},
				'COvpBZtnSKRZEtL4R')
			}catch (error){
				console.log({error});
			}
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
	beforeCreate() {
		if (!Object.keys(this.$store.state.cart).length) {
			this.$router.push({ name: "customer-menu" });
		}
	},
};
</script>

<style scoped>
@media only screen and (min-width: 600px) {
	section.customer-section#checkout-section {
		max-width: min(80%, 60rem);
	}
}

.delivery > div {
	padding-top: 5px;
}

.checkout-wrapper .form-input-group {
	padding-right: 20px;
	padding-left: 20px;
}

.place-order-button {
	display: block;
	text-align: right;
	margin-right: 195px;
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

.delivery {
	display: flex;
	flex-direction: column;
	width: 100%;
	text-align: center;
}
</style>
