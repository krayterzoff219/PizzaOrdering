<template>
	<div id="cta-buttons-wrapper">
		<div id="cta-buttons">
			<!-- ********************* BUTTONS ON HOMEPAGE ********************* -->
			<cta-button
				v-if="isHomePage"
				buttonText="Menu"
				routeName="customer-menu" />
			<cta-button
				v-if="isHomePage && !isCartEmpty"
				buttonText="My Order"
				routeName="my-order" />
			<!-- ********************* BUTTONS ON MENU ********************* -->
			<cta-button
				v-if="isMenuPage"
				buttonText="Home"
				routeName="home" />
			<cta-button
				v-if="isMenuPage && !isCartEmpty"
				:buttonText="`My Order (${cartItemQuantity})`"
				routeName="my-order" />
			<!-- ********************* BUTTONS ON MY ORDER ********************* -->
			<cta-button
				v-if="isOrderPage"
				buttonText="Menu"
				routeName="customer-menu" />
			<cta-button
				v-if="isOrderPage"
				buttonText="Checkout"
				routeName="checkout" />
			<!-- ********************* BUTTONS ON CHECKOUT ********************* -->
			<cta-button
				v-if="isCheckoutPage"
				:buttonText="`My Order (${cartItemQuantity})`"
				routeName="my-order" />
			<cta-button
				v-if="isCheckoutPage"
				buttonText="Place Order"
				:formSubmissionButton="true"
				routeName="doNotPushToNewRoute" />
			<!-- ********************* BUTTONS ON CONFIRMATION AND EMPLOYEE PAGES ********************* -->
			<cta-button
				v-if="isConfirmationPage || isEmployeePage"
				buttonText="Home"
				routeName="home" />
			<cta-button
				v-if="isConfirmationPage || isEmployeePage"
				buttonText="Menu"
				routeName="customer-menu" />
		</div>
	</div>
</template>

<script>
import CtaButton from "./CtaButton.vue";
export default {
	components: { CtaButton },
	props: ["formSubmissionButton"],
	computed: {
		isHomePage() {
			return this.$route.name === "home";
		},
		isMenuPage() {
			return this.$route.name === "customer-menu";
		},
		isOrderPage() {
			return this.$route.name === "my-order";
		},
		isCheckoutPage() {
			return this.$route.name === "checkout";
		},
		isConfirmationPage() {
			return this.$route.name === "confirmation";
		},
		isEmployeePage() {
			return this.$route.path.includes("employees");
		},
		isCartEmpty() {
			return !Object.keys(this.$store.state.cart).length;
		},
		cartItemQuantity() {
			return Object.values(this.$store.state.cart).reduce(
				(accumulator, item) => {
					return accumulator + item.quantity;
				},
				0
			);
		},
	},
};
</script>

<style scoped>
div#cta-buttons-wrapper {
	position: fixed;
	bottom: 0;
	right: 1.5vw; /* because the header is 97% of viewport width and centered */
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
</style>
