<template>
	<div class="cart-item">
		<div class="cart-item-image-container"></div>
		<div class="cart-item-description-container"></div>
	</div>
</template>

<script>
export default { props: ["cartItem"] };
</script>

<style scoped>
div.cart-item {
	display: flex;
	width: 100%;
	margin-right: auto;
	margin-left: auto;
	padding: 15px 10px;
}

div.cart-item-image-container {
	background-image: url("https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	max-width: 150px;
	width: 100%;
	height: auto;
	aspect-ratio: 1 / 1;
	border-top-left-radius: var(--section-border-radius);
	border-bottom-left-radius: var(--section-border-radius);
}

div.cart-item-description-container {
	/* display: flex;
	flex-direction: column;
	justify-content: center; */
	max-width: 35em;
	padding: 15px;
	border-bottom: 1px solid var(--dark-color);
}
</style>
