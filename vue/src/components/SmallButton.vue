<template>
	<button
		class="grow"
		:type="buttonType ? buttonType : 'button'"
		@click="
			(event) => {
				if (shouldStopPropagation) {
					event.stopPropagation();
				}
				handleClick();
			}
		">
		{{ buttonText }}
	</button>
</template>

<script>
export default {
	props: ["buttonText", "buttonType", "clickHandler", "shouldStopPropagation"],
	methods: {
		handleClick() {
			if (this.clickHandler) this.clickHandler();
		},
	},
};
</script>

<style scoped>
button {
	font-family: var(--loud-font-family);
	background-color: var(--dark-color);
	color: var(--white-color);
	padding: 5px 15px;
	border-radius: 5px;
	cursor: pointer;
}
</style>
