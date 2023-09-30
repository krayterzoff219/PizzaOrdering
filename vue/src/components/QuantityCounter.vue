<template>
	<div class="quantity-counter-wrapper">
		<i
			class="fa-solid fa-minus quantity-decrement jump"
			@click="decrementHandler"></i>
		<p class="quantity-count">{{ quantity }}</p>
		<i
			class="fa-solid fa-plus quantity-increment jump"
			@click="incrementHandler"></i>
	</div>
</template>

<script>
export default {
	name: "quantity-counter",
	props: ["quantity", "decrementHandler", "incrementHandler"],
};
</script>

<style scoped>
div.quantity-counter-wrapper {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	height: 100%;
	font-size: 1rem;
	text-align: center;
	max-height: 2.5rem;
	max-width: 7.5rem;
}

i {
	cursor: pointer;
	color: var(--white-color);
	max-width: 2.5rem;
}

p,
i {
	flex: 1;
	padding: 0.5rem;
	line-height: 1;
	display: inline-block;
	max-height: 2.5rem;
	min-height: 2.25rem;
}

i::before {
	vertical-align: middle;
}

i.quantity-decrement {
	background-color: var(--primary-color);
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
}

i.quantity-increment {
	background-color: var(--dark-color);
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

p {
	border-bottom: 1px solid var(--dark-color);
	border-right: 1px solid var(--dark-color);
	border-top: 1px solid var(--dark-color);
	border-left: 1px solid var(--primary-color);
	width: 2.5rem;
}

@media only screen and (min-width: 600px) {
	div.quantity-counter-wrapper {
		font-size: 1.5rem;
	}
}
</style>
