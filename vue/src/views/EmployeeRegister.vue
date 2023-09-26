<template>
	<div
		id="register"
		class="text-center">
		<form @submit.prevent="register">
			<h1>Create Account</h1>
			<div
				role="alert"
				v-if="registrationErrors">
				{{ registrationErrorMsg }}
			</div>

			<user-input
				label="Username: "
				inputId="register-username-input"
				inputType="text"
				v-model="user.username"
				required
				autofocus></user-input>

			<user-input
				label="Password: "
				inputId="register-password-input"
				inputType="password"
				v-model="user.password"
				required></user-input>

			<user-input
				label="Confirm Password: "
				inputId="register-confirm-password-input"
				inputType="password"
				v-model="user.confirmPassword"
				required></user-input>

			<submit-button buttonText="Create Account"></submit-button>

			<p>
				<router-link :to="{ name: 'Employee-Login' }"
					>Already have an account? Log in.</router-link
				>
			</p>
		</form>
	</div>
</template>

<script>
import UserInput from "../components/UserInput.vue";
import SubmitButton from "../components/SubmitButton.vue";
import authService from "../services/AuthService";

export default {
	name: "register",
	components: { SubmitButton, UserInput },
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
								path: "/login",
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
};
</script>

<style scoped>
.form-input-group {
	margin-bottom: 1rem;
}
label {
	margin-right: 0.5rem;
}
</style>
