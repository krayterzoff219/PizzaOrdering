<template>
	<section class="input-section">
		<horizontal-hero></horizontal-hero>
		<div class="checkout-inputs">
			<h1>Checkout</h1>
			<div class="checkout-wrapper">
				<div class="card-info">
					<label for="cardholder-name">Cardholder Name: </label>
					<user-input />
					<label for="Card-Number">Card-Number: </label>
					<user-input />
					<label for="Exp-Date">Expiration-Date:</label>
					<user-input />
					<label for="Security-Code">CVC# </label>
					<user-input />
				</div>
				<div class="customer-info">
					<label for="Address">Address: </label>
					<user-input />

					<label for="City">City: </label>
					<user-input />

					<label for="State">State: </label>
					<user-input />

					<!-- <label for ="Zip-Code">Zip Code: </label> -->
					<user-input
						label="Zip-Code"
						inputId="Zip-Code"
						inputType="text" />

					<label for="Date">Date: </label>
					<input
						id="date-label"
						type="datetime-local" />
				</div>
				<div class="delivery">
					<p>How would you like to receive your pizza?</p>
					<form>
						<input
							type="radio"
							id="Pick-up" />
						<label for="Pick-up">Pick-up</label>
						<input
							type="radio"
							id="Delivery" />
						<label for="Dilivery">Delivery</label>
					</form>
				</div>
			</div>
			<div class="total-payment">
				<p id="subtotal">Subtotal: {{ Subtotal }}</p>
				<p id="tax">Tax: {{ Tax }}</p>
				<p id="total">Total: {{ Total }}</p>
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
.card-info {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
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
	justify-content: center;
	align-items: center;
	flex-direction: column;
	margin: 30px;
}

#date-label {
	margin-bottom: 30px;
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
</style>
