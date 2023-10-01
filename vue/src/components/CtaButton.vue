<template>
	<button
		class="cta-button grow"
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

<style></style>
