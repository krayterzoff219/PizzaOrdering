<template>
	<div id="cta-buttons-wrapper">
		<div id="cta-buttons">
			<button
				id="cta-button-1"
				class="cta-button grow">
				Menu
			</button>
			<button
				id="cta-button-2"
				class="cta-button hide grow">
				Order
			</button>
		</div>
	</div>
</template>

<script>
export default {};
</script>

<style scoped>
div#cta-buttons-wrapper {
	/* display: none; */
	position: fixed;
	bottom: 0;
	right: 1.5%; /* because the header is 97% of viewport width and centered */
	width: var(--header-footer-width);
	height: var(--call-to-action-bar-height);
	background-color: var(--dark-color);
	padding-top: var(--header-footer-inside-margin);
}

@media only screen and (min-width: 768px) {
	div#cta-buttons-wrapper {
		display: none;
	}
}

div#cta-buttons {
	background-color: white;
	height: 100%;
	width: 100%;
	border-top-left-radius: var(--section-border-radius);
	border-top-right-radius: var(--section-border-radius);
	--button-gap-horizontal-outer: 15px;
	--button-gap-horizontal-inner: 15px;
	--button-gap-top: 8px;
	--button-gap-bottom: 8px;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: var(--button-gap-top) var(--button-gap-horizontal-outer)
		var(--button-gap-bottom) var(--button-gap-horizontal-outer);
	gap: var(--button-gap-horizontal-inner);
}

button.cta-button {
	/* flex: 1; */
	width: 100%;
	height: 100%;
	border-radius: var(--section-border-radius);
	background-color: var(--primary-color);
	cursor: pointer;
	border-color: var(--primary-color);
	color: var(--white-color);
	font-size: 1.5rem;
	/* font-family: var(--loud-font-family); */
	font-weight: bold;
}
</style>
