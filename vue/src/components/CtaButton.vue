<template>
	<button
		class="cta-button"
		:buttonType="formSubmissionButton ? 'submit' : 'button'"
		@click="
			() => {
				if (routeName !== 'doNotPushToNewRoute') {
					return $router.push({ name: `${routeName}` });
				}
			}
		">
		{{ buttonText }}
	</button>
</template>

<script>
export default {
	props: ["buttonText", "routeName", "formSubmissionButton"],
};
</script>

<style scoped>
button.cta-button {
	width: 100%;
	height: 100%;
	border-radius: var(--section-border-radius);
	background-color: var(--primary-color);
	cursor: pointer;
	border-color: var(--primary-color);
	color: var(--white-color);
	font-size: 1.25rem;
	font-weight: bold;
}
</style>
