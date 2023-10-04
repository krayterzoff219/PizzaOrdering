<template>
	<div id="customer-login-button-wrapper">
		<small-button
			buttonText="Login"
			:clickHandler="() => $store.dispatch('openDropDownLogin')" />
	</div>
</template>

<script>
import SmallButton from "./SmallButton.vue";
export default {
	components: { SmallButton },
};
</script>

<style scoped>
div#customer-login-button-wrapper {
	position: absolute;
	padding-left: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 45px;
}

@media only screen and (min-width: 600px) {
	div#customer-login-button-wrapper {
		position: absolute;
		padding: 0;
		min-width: 165px;
		height: 45px;
		background-color: var(--white-color);
		border-top-left-radius: var(--section-border-radius);
		border-bottom-right-radius: var(--section-border-radius);
	}
}

@media only screen and (min-width: 768px) {
	div#customer-login-button-wrapper {
		border-top-left-radius: 0;
		border-bottom-left-radius: var(--section-border-radius);
		border-top-right-radius: var(--section-border-radius);
		border-bottom-right-radius: 0;
		border-left: 2px solid var(--dark-color);
		right: 0;
		top: 0;
	}
}
</style>
