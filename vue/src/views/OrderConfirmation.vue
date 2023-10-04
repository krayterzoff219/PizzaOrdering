<template>
	<section
		id="pending-orders"
		class="customer-section">
		<horizontal-hero></horizontal-hero>
		<div id="order-confirmation">
			Thank you for placing your order at UpperCrust Pizza. A confirmation email
			was sent to the address provided.
			<br />
			<br />
			Please dine with us again soon!
		</div>
	</section>
</template>

<script>
import HorizontalHero from "../components/HorizontalHero.vue";

export default {
	components: { HorizontalHero },
	name: "order-confirmation",

	beforeCreate() {
		if (!Object.keys(this.$store.state.cart).length) {
			this.$router.push({ name: "home" });
		}
	},
	created() {
		this.$store.commit("CLEAR_CART");
	},
};
</script>

<style scoped>
#order-confirmation {
	padding-top: 10px;
	height: 50vh;
}
</style>
