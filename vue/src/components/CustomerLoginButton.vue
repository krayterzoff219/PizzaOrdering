<template>
	<div id="customer-login-button-wrapper">
		<small-button
			v-if="!$store.state.token"
			buttonText="Login"
			:clickHandler="() => $store.dispatch('openDropDownLogin')" />
		<p v-else>Hello, {{$store.state.user.username}}!</p>
	</div>
</template>

<script>
import SmallButton from "./SmallButton.vue";
export default {
	components: { SmallButton },
};
</script>

<style scoped>
p {
	font-size: 0.75rem;
	color: var(--white-color);
	font-weight: bold;
}

div#customer-login-button-wrapper {
	position: absolute;
	padding-left: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 45px;
	background-color: transparent;
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
		background-color: rgba(239, 55, 62, 0.95);
		border-bottom: 2px solid var(--dark-color);
		border-right: 2px solid var(--dark-color);
	}

	p {
		font-size: 1rem;
		padding: 0 15px;
	}
}

@media only screen and (min-width: 768px) {
	div#customer-login-button-wrapper {
		border-top-left-radius: 0;
		border-top-right-radius: var(--section-border-radius);
		border-bottom-right-radius: 0;
		border-bottom: 0;
		border-right: 0;
		right: 0;
		top: 0;
		background-color: transparent;
		z-index: 2;
		justify-content: flex-end;
	}

	button {
		z-index: 2;
		margin-right: 25px;
	}

	p {
		padding-right: 25px;
	}
}
</style>
