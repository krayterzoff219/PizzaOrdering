<template>
	<div class="checkout-amount">
		<p id="subtotal">
			<span>Subtotal:</span>&nbsp; ${{ $store.state.subtotal.toFixed(2) }}
		</p>
		<p id="tax"><span>Tax:</span>&nbsp; ${{ tax.toFixed(2) }}</p>
		<p id="total"><span>Total: </span>&nbsp; ${{ total.toFixed(2) }}</p>
		<small-button
			:clickHandler="buttonClickHandler"
			:buttonText="buttonText"
			:buttonType="buttonType" />
	</div>
</template>

<script>
import SmallButton from "./SmallButton.vue";

export default {
	components: { SmallButton },
	props: ["buttonType", "buttonText", "buttonClickHandler"],
	computed: {
		tax() {
			return this.$store.state.subtotal * 0.08;
		},
		total() {
			return this.$store.state.subtotal + this.tax;
		},
	},
};
</script>

<style scoped>
div.checkout-amount {
	display: flex;
	align-items: flex-end;
	flex-direction: column;
	text-align: right;
	padding-right: 10%;
	margin-bottom: 20px;
	padding-top: 30px;
	width: 100%;
}

div.checkout-amount #tax {
	padding: 3px 0;
}
div.checkout-amount #total {
	padding-bottom: 15px;
}

p span {
	font-weight: bold;
}
</style>
