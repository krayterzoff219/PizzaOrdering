<template>
	<section
		id="my-account"
		class="customer-section">
		<horizontal-hero />
		<form @submit.prevent="updateUserInfo">
			<h1>Update Account Info</h1>
			<an-alert
				v-if="alertText"
				:message="alertText" />
			<user-input
				label="Address"
				inputId="my-account-address-input"
				inputType="text"
				v-model="address"
				:defaultValue="address"
				:isRequired="true" />
			<!-- <user-input
				label="Credit Card Number"
				inputId="my-account-card-number-input"
				inputType="number"
				v-model="cardNumber"
				:isRequired="true" /> -->
			<user-input
				label="Email"
				inputId="my-account-email-input"
				inputType="email"
				v-model="email"
				:defaultValue="email"
				:isRequired="true" />
			<user-input
				label="Phone Number"
				inputId="my-account-phone-input"
				inputType="number"
				v-model="phone"
				:defaultValue="phone"
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
			address: null,
			cardNumber: "",
			dataId: -1,
			email: null,
			phone: 0,
			userId: -1,
			alertText: "",
		};
	},
	created() {
		const { address, cardNumber, dataId, email, phone, userId } =
			this.$store.state.user.userData;
		this.address = address;
		this.cardNumber = cardNumber;
		this.dataId = dataId;
		this.email = email;
		this.phone = phone;
		this.userId = userId;
	},
	methods: {
		updateUserInfo() {
			const { address, cardNumber, dataId, email, phone, userId } = this;
			const userData = { address, cardNumber, dataId, email, phone, userId };
			userDataService.update(userData).then((res) => {
				if (res.status === 200) {
					this.$router.push({ name: "home" });
				}
			});
		},
	},
	components: { UserInput, SmallButton, HorizontalHero, AnAlert },
};
</script>

<style>
section.customer-section#my-account label {
	font-weight: bold;
}
</style>
