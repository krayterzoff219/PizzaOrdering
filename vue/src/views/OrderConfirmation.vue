<template>
	<section
		id="pending-orders"
		class="customer-section">
		Order Confirmation
	</section>
</template>

<script>

export default {
	name: "order-confirmation",
	
	beforeCreate() {
		if (!Object.keys(this.$store.state.cart).length) {
			this.$router.push({ name: "home" });
		}
	},
	created() {
		this.$store.commit("CLEAR_CART");
		this.$store.commit("RESET_SUBTOTAL");
	},
	
};
</script>
