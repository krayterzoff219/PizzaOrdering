<template>
	<section class="input-section">
		<horizontal-hero></horizontal-hero>
		<div class="checkout-inputs">
			<h1>Checkout</h1>
			<div class="checkout-wrapper">

				<div class="card-info">
					
					<user-input label="Cardholder name: "
                                inputId="Cardholder-name"
                                inputType="text"/>
					
					<user-input label="Card Number:"
                                inputId="Card-Number"
                                inputType="number"/>
					
					<user-input label="Exp Date:"
                                inputId="CVC"
                                inputType="number"/>
					
					<user-input label="CVC"
                                inputId="CVC"
                                inputType="number"/>
				</div>
				<div class="customer-info">
					
					<user-input label="Address"
                                inputId="Address"
                                inputType="text"/>

					<user-input label="City"
                                inputId="City"
                                inputType="text"/>

					<user-input label="State:"
                                inputId="State"
                                inputType="text"/>

					<user-input label="Zip-Code" 
                                inputId="Zip-Code" 
                                inputType="number"/>

					<user-input label="Date:"
                                inputId="Date"
                                inputType="datetime-local"/>

				</div>
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
				<p id="subtotal">Subtotal: {{ price }}</p>
				<p id="tax">Tax: {{ Tax }}</p>
				<p id="total">Total: {{ total }}</p>
			</div>
		</div>
	</section>
</template>

<script>
import UserInput from "../components/UserInput.vue";
import HorizontalHero from "../components/HorizontalHero.vue";



export default {
	components: { UserInput, HorizontalHero },

};



</script>

<style>

.delivery > form{
    text-align: center;
}

.card-info {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-evenly;
	width: 95%;
}

.customer-info {
	/* display: flex;
    margin: 50px auto;
    justify-content: center;
    justify-content: space-between;
    flex-direction: column; */
	display: flex;
	flex-wrap: wrap;
	justify-content: space-evenly;
	width: 95%;
}

.checkout-wrapper {
	display: flex;
	/* justify-content: center; */
	align-items: center;
	flex-direction: column;
	margin: 30px;
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

.delivery{
    display: flex;
    flex-direction: column;
}

</style>
