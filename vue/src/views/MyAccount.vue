<template>
	<section
		id="employee-register"
		class="employee-section">
		<horizontal-hero />
		<form @submit.prevent="updateUserInfo">
			<h1>Create Account</h1>
			<an-alert
				v-if="registrationErrors"
				:message="registrationErrorMsg" />
			<user-input
				label="Address: "
				inputId="my-account-address-input"
				inputType="text"
				v-model="userData.address"
				:isRequired="true" />
			<!-- <user-input
				label="Card Number: "
				inputId="my-account-card-number-input"
				inputType="text"
				v-model="userData.cardNumber"
				:isRequired="true" /> -->
			<user-input
				label="address: "
				inputId="my-account-address-input"
				inputType="text"
				v-model="userData.address"
				:isRequired="true" />
			<user-input
				label="address: "
				inputId="my-account-address-input"
				inputType="text"
				v-model="userData.address"
				:isRequired="true" />
			<user-input
				label="address: "
				inputId="my-account-address-input"
				inputType="text"
				v-model="userData.address"
				:isRequired="true" />
			<user-input
				label="address: "
				inputId="my-account-address-input"
				inputType="text"
				v-model="userData.address"
				:isRequired="true" />
			<small-button
				buttonText="Save Changes"
				buttonType="submit" />
		</form>
	</section>
</template>

<script>
import HorizontalHero from "../components/HorizontalHero.vue";
import AnAlert from "../components/AnAlert.vue";
import SmallButton from "../components/SmallButton.vue";
import UserInput from "../components/UserInput.vue";
import userDataService from "../services/UserDataService.js";

export default {
	data() {
		return {
			userData: {
				address: null,
				cardNumber: 0,
				dataId: -1,
				email: null,
				phone: 0,
				userId: -1,
			},
		};
	},
	created() {
		// const { address, cardNumber, dataId, email, phone, userId} = this.$store.state.user.userData;
		this.userData = { ...this.$store.state.user.userData };
	},
	methods: {
		updateUserInfo() {
			userDataService.update();
		},
	},
	components: { UserInput, SmallButton, HorizontalHero, AnAlert },
};
</script>

<style></style>
