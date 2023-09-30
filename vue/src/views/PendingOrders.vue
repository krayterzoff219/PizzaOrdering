<template>
	<section id="pending-orders">Pending Orders</section>
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

<style></style>
