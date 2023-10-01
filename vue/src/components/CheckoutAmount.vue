<template>
    
 <div class="checkout-amount">
				<p id="subtotal">
					<span>Subtotal:</span>&nbsp; ${{ $store.state.subtotal.toFixed(2) }}
				</p>
				<p id="tax"><span>Tax:</span>&nbsp; ${{ tax.toFixed(2) }}</p>
				<p id="total"><span>Total: </span>&nbsp; ${{ total.toFixed(2) }}</p>
				
			</div>


</template>
 


<script>


export default{


components: {},


computed: {
		total() {
			return this.$store.state.subtotal + this.tax;
		},

		tax() {
			return this.$store.state.subtotal * 0.08;
		},
	},
}


</script>

<style>

.checkout-amount {
	display: flex;
	justify-content: flex-end;
	flex-direction: column;
	text-align: right;
	margin-right: 200px;
	margin-bottom: 20px;
}




</style>