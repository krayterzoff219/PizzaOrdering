<template>
	<div class="quanitity-counter-wrapper">
		<!-- prettier-ignore -->
		<div
			class="quantity-decrement"
			@click="decrementHandler">-</div>
		<div class="quantity-count">{{ quantity }}</div>
		<!--prettier-ignore -->
		<div
			class="quantity-increment"
			@click="incrementHandler">+</div>
	</div>
</template>

<script>
export default {
	name: "quantity-counter",
	props: ["quantity", "decrementHandler", "incrementHandler"],
};
</script>

<style scoped>
div.quanitity-counter-wrapper {
	display: flex;
}

div.quantity-counter-wrapper div {
	flex-grow: 1;
	flex-shrink: 1;
	flex-basis: 2rem;
}

div.quantity-increment,
div.quantity-decrement {
	cursor: pointer;
}
</style>
