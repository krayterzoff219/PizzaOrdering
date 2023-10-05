<template>
	<form @submit.prevent="register">
		<h1>Create Account</h1>
		<an-alert
			v-if="registrationErrors"
			:message="registrationErrorMsg"
			id="customer-registration-error-message"></an-alert
		><user-input
			label="Username: "
			inputId="customer-register-username-input"
			inputType="text"
			v-model="user.username"
			:isRequired="true" />
		<user-input
			label="Password: "
			inputId="customer-register-password-input"
			inputType="password"
			v-model="user.password"
			:isRequired="true" />
		<user-input
			label="Confirm Password: "
			inputId="customer-register-confirm-password-input"
			inputType="password"
			v-model="user.confirmPassword"
			:isRequired="true" />
		<small-button
			buttonType="submit"
			buttonText="Create Account"
			:shouldStopPropagation="true" />
		<p @click="(event) => event.stopPropagation()">
			Already have an account? &nbsp;<span
				class="jump"
				@click="
					(event) => {
						event.stopPropagation();
						sendUserToLogin();
					}
				"
				>Login</span
			>
		</p>
	</form>
</template>

<script>
import SmallButton from "./SmallButton.vue";
import UserInput from "./UserInput.vue";
import authService from "../services/AuthService";
import AnAlert from "../components/AnAlert.vue";

export default {
	name: "customer-register",
	components: { UserInput, SmallButton, AnAlert },
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
		sendUserToLogin() {
			this.$store.dispatch("switchCustomerBetweenLoginAndRegisterDropDown");
		},
		register() {
			if (this.user.password != this.user.confirmPassword) {
				this.registrationErrors = true;
				this.registrationErrorMsg = "Password & Confirm Password do not match.";
			} else {
				authService
					.register(this.user)
					.then((response) => {
						if (response.status == 201) {
							this.sendUserToLogin();
						}
					})
					.catch((error) => {
						const response = error.response;
						this.registrationErrors = true;
						if (response.status === 400) {
							// this.registrationErrorMsg = "Bad Request: Validation Errors";
							this.registrationErrorMsg = error.response.data.message;
						}
					});
			}
		},
	},
};
</script>

<style>
#customer-registration-error-message {
	font-weight: bold;
	text-align: center;
}
</style>

<style scoped>
form {
	padding: 50px 25px;
	margin: 0 auto;
	max-width: 20rem;
}

form h1 {
	text-align: center;
	margin-bottom: 1.5rem;
}

form button {
	margin-right: auto;
	margin-left: auto;
	display: block;
	box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Subtle box shadow */
}

form div.form-input-group {
	margin-bottom: 0;
	padding-bottom: 1.5rem;
}

p {
	text-align: center;
	padding-top: 1.5rem;
	cursor: default;
	display: inline-block;
}

p span {
	cursor: pointer;
	text-decoration: underline;
	color: var(--secondary-color);
	display: inline-block;
}

@media (hover: hover) {
	form button:hover {
		box-shadow: 0px 6px 8px rgba(0, 0, 0, 0.2);
	}
}
</style>
