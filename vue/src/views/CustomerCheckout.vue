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

                <user-input
					label="Phone number:"
					inputId="Phone-number"
					inputType="number"
					v-model="phoneNumber" />

                    <user-input
					label="Email"
					inputId="email"
					inputType="text"
					v-model="email" />

                    

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
			<checkout-amount/>

			<div class="place-order-button" >
				<small-button	
                    buttonText="place order"
                    :clickHandler="placeOrder"
                    />
			</div>
		</div>

		

	</section>
</template>

<script>
import UserInput from "../components/UserInput.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import orderService from "../services/OrderService.js"
import SmallButton from '../components/SmallButton.vue';

import CheckoutAmount from '../components/CheckoutAmount.vue';



export default {
	components: { UserInput, HorizontalHero, SmallButton, CheckoutAmount },
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
            phoneNumber: ""
        }
    },

    methods: {

        placeOrder(){

            const order = {}

            order.isDelivery = this.isDelivery;
            order.address = this.address;
            order.phoneNumber = this.phoneNumber;
            order.email = this.email;
            order.menuItems = [];

            order.customPizzas = [];

            const pizzas = Object.values(this.$store.state.cart)
            for(const pizza of pizzas){
                order.menuItems.push({
                    itemId: pizza.id, 
                    quantity: pizza.quantity

                })
            }

            orderService.createPendingOrder(order);

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




.delivery > form {
	text-align: center;
}

.checkout-wrapper .form-input-group {
	padding-right: 20px;
	padding-left: 20px;
}

.place-order-button{
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
