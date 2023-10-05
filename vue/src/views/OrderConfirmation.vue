<template>
	<section
		id="order-confirmation-section"
		class="customer-section">
		<horizontal-hero></horizontal-hero>
		<div id="order-confirmation">
			<h1>Order Confirmation</h1>
			<p>
				Thank you for placing your order at UpperCrust Pizza. A confirmation
				email was sent to the address provided.
			</p>
			<p>Please dine with us again soon!</p>
			<p />
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
	width: 80%;
}

h1 {
	margin-bottom: 2rem;
}

p {
	margin-bottom: 2rem;
	text-align: justify;
}

p:last-child {
	margin-bottom: 3rem;
}
</style>
