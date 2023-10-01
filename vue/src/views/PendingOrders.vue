<template>
	<section
		id="pending-orders"
		class="employee-section">
		Pending Orders
	</section>
</template>

<script>
export default {
	name: "pending-orders",
	beforeCreate() {
		if (Object.keys(this.$store.state.cart).length) {
			this.$store.commit("CLEAR_CART");
		}
	},
};
</script>
