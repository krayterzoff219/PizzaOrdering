<template>
	<section
		id="employee-register"
		class="text-center">
		<horizontal-hero></horizontal-hero>
		<form @submit.prevent="register">
			<h1>Create Account</h1>
			<div
				role="alert"
				v-if="registrationErrors">
				{{ registrationErrorMsg }}
			</div>

			<user-input
				label="Username: "
				inputId="employee-register-username-input"
				inputType="text"
				v-model="user.username"
				:isAutofocus="true"
				:isRequired="true"></user-input>

			<user-input
				label="Password: "
				inputId="employee-register-password-input"
				inputType="password"
				v-model="user.password"
				:isRequired="true"></user-input>

			<user-input
				label="Confirm Password: "
				inputId="employee-register-confirm-password-input"
				inputType="password"
				v-model="user.confirmPassword"
				:isRequired="true"></user-input>

			<small-button
				buttonText="Create Account"
				buttonType="submit"></small-button>
		</form>
	</section>
</template>

<script>
import UserInput from "../components/UserInput.vue";
import SmallButton from "../components/SmallButton.vue";
import authService from "../services/AuthService";
import HorizontalHero from "../components/HorizontalHero.vue";

export default {
	name: "register",
	components: { SmallButton, UserInput, HorizontalHero },
	data() {
		return {
			user: {
				username: "",
				password: "",
				confirmPassword: "",
				role: "user",
			},
			registrationErrors: false,
			registrationErrorMsg: "There were problems registering this user.",
		};
	},
	methods: {
		register() {
			if (this.user.password != this.user.confirmPassword) {
				this.registrationErrors = true;
				this.registrationErrorMsg = "Password & Confirm Password do not match.";
			} else {
				authService
					.register(this.user)
					.then((response) => {
						if (response.status == 201) {
							this.$router.push({
								path: "/employees/login",
								query: { registration: "success" },
							});
						}
					})
					.catch((error) => {
						const response = error.response;
						this.registrationErrors = true;
						if (response.status === 400) {
							this.registrationErrorMsg = "Bad Request: Validation Errors";
						}
					});
			}
		},
		clearErrors() {
			this.registrationErrors = false;
			this.registrationErrorMsg = "There were problems registering this user.";
		},
	},
	beforeCreate() {
		if (this.$store.state.token) {
			this.$router.push({ name: "pending-orders" });
		}
	},
};
</script>

<style></style>
